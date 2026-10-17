import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Mini transpilador de un subconjunto de Java a Rust.
 *
 * Uso:
 *   javac MiniJavaToRust.java
 *   java MiniJavaToRust Programa.java Programa.rs
 *
 * Si se omite el archivo de salida, el codigo Rust se imprime en la terminal.
 * No es un compilador completo: traduce construcciones basicas y marca las
 * instrucciones que requieren conversion manual.
 */
public final class MiniJavaToRust {

    private static final Pattern MAIN_PATTERN = Pattern.compile(
            "\\bstatic\\s+void\\s+main\\s*\\(\\s*String\\s*\\[\\s*\\]\\s*[A-Za-z_$][\\w$]*\\s*\\)"
    );

    private static final Pattern VARIABLE_PATTERN = Pattern.compile(
            "^(final\\s+)?(int|long|double|float|boolean|String|char)\\s+([A-Za-z_$][\\w$]*)\\s*(?:=\\s*(.*?))?;?$"
    );

    private static final Pattern FOR_PATTERN = Pattern.compile(
            "^for\\s*\\(\\s*(?:int|long)\\s+([A-Za-z_$][\\w$]*)\\s*=\\s*(.*?)\\s*;\\s*\\1\\s*(<|<=)\\s*(.*?)\\s*;\\s*\\1\\+\\+\\s*\\)\\s*\\{$"
    );

    private final Map<String, String> variableTypes = new HashMap<>();

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.out.println("MiniJavaToRust - transpilador Java -> Rust");
            System.out.println("Uso:");
            System.out.println("  javac MiniJavaToRust.java");
            System.out.println("  java MiniJavaToRust entrada.java [salida.rs]");
            return;
        }

        try {
            Path input = Path.of(args[0]);
            String javaSource = Files.readString(input, StandardCharsets.UTF_8);
            String rustSource = new MiniJavaToRust().transpile(javaSource);

            if (args.length == 2) {
                Path output = Path.of(args[1]);
                Files.writeString(output, rustSource, StandardCharsets.UTF_8);
                System.out.println("Rust generado en: " + output.toAbsolutePath());
            } else {
                System.out.print(rustSource);
            }
        } catch (IOException e) {
            System.err.println("Error al leer o escribir el archivo: " + e.getMessage());
            System.exit(1);
        }
    }

    private String transpile(String source) {
        String body = extractMainBody(source);
        boolean foundMain = body != null;

        if (!foundMain) {
            body = source;
        }

        List<String> statements = splitStatements(body);
        List<String> output = new ArrayList<>();
        int depth = 0;

        output.add("// Codigo Rust generado por MiniJavaToRust.");
        if (!foundMain) {
            output.add("// TODO: No se encontro main(String[] args); se intento traducir el archivo como fragmento.");
        }
        output.add("fn main() {");

        for (String raw : statements) {
            String statement = raw.trim();
            if (statement.isEmpty()) {
                continue;
            }

            if (statement.startsWith("//")) {
                output.add(indent(depth + 1) + statement);
                continue;
            }

            if (statement.equals("}")) {
                depth = Math.max(0, depth - 1);
                output.add(indent(depth + 1) + "}");
                continue;
            }

            String translated = translateStatement(statement);
            if (translated == null) {
                output.add(indent(depth + 1) + "// TODO: traduccion manual requerida: "
                        + statement.replace('\n', ' '));
                continue;
            }

            // Une una llave de cierre con else/else if para producir el estilo Rust habitual.
            if ((translated.startsWith("else {") || translated.startsWith("else if "))
                    && !output.isEmpty()
                    && output.get(output.size() - 1).trim().equals("}")) {
                output.remove(output.size() - 1);
                output.add(indent(depth + 1) + "} " + translated);
                depth++;
                continue;
            }

            output.add(indent(depth + 1) + translated);

            if (opensBlock(translated)) {
                depth++;
            } else if (translated.equals("{")) {
                depth++;
            }
        }

        output.add("}");
        return String.join(System.lineSeparator(), output) + System.lineSeparator();
    }

    /** Extrae el contenido de main, sin sus llaves exteriores. */
    private String extractMainBody(String source) {
        Matcher matcher = MAIN_PATTERN.matcher(source);
        if (!matcher.find()) {
            return null;
        }

        int openBrace = source.indexOf('{', matcher.end());
        if (openBrace < 0) {
            return null;
        }

        int closeBrace = findMatchingBrace(source, openBrace);
        if (closeBrace < 0) {
            return null;
        }

        return source.substring(openBrace + 1, closeBrace);
    }

    /** Busca la llave de cierre ignorando llaves dentro de cadenas y comentarios. */
    private int findMatchingBrace(String source, int openBrace) {
        int depth = 0;
        boolean inString = false;
        boolean inChar = false;
        boolean escaped = false;
        boolean lineComment = false;
        boolean blockComment = false;

        for (int i = openBrace; i < source.length(); i++) {
            char c = source.charAt(i);
            char next = i + 1 < source.length() ? source.charAt(i + 1) : '\0';

            if (lineComment) {
                if (c == '\n') lineComment = false;
                continue;
            }
            if (blockComment) {
                if (c == '*' && next == '/') {
                    blockComment = false;
                    i++;
                }
                continue;
            }
            if ((inString || inChar) && escaped) {
                escaped = false;
                continue;
            }
            if ((inString || inChar) && c == '\\') {
                escaped = true;
                continue;
            }
            if (!inChar && c == '"') {
                inString = !inString;
                continue;
            }
            if (!inString && c == '\'') {
                inChar = !inChar;
                continue;
            }
            if (inString || inChar) continue;

            if (c == '/' && next == '/') {
                lineComment = true;
                i++;
            } else if (c == '/' && next == '*') {
                blockComment = true;
                i++;
            } else if (c == '{') {
                depth++;
            } else if (c == '}') {
                depth--;
                if (depth == 0) return i;
            }
        }
        return -1;
    }

    /** Divide el cuerpo por ;, { y }, sin romper strings ni cabeceras de for. */
    private List<String> splitStatements(String source) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inString = false;
        boolean inChar = false;
        boolean escaped = false;
        boolean lineComment = false;
        boolean blockComment = false;
        int parentheses = 0;

        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            char next = i + 1 < source.length() ? source.charAt(i + 1) : '\0';

            if (lineComment) {
                current.append(c);
                if (c == '\n') {
                    addStatement(result, current);
                    lineComment = false;
                }
                continue;
            }

            if (blockComment) {
                if (c == '*' && next == '/') {
                    blockComment = false;
                    i++;
                    current.append(' ');
                }
                continue;
            }

            if ((inString || inChar) && escaped) {
                current.append(c);
                escaped = false;
                continue;
            }
            if ((inString || inChar) && c == '\\') {
                current.append(c);
                escaped = true;
                continue;
            }
            if (!inChar && c == '"') {
                inString = !inString;
                current.append(c);
                continue;
            }
            if (!inString && c == '\'') {
                inChar = !inChar;
                current.append(c);
                continue;
            }

            if (!inString && !inChar && c == '/' && next == '/') {
                if (!current.toString().trim().isEmpty()) addStatement(result, current);
                current.append("//");
                i++;
                lineComment = true;
                continue;
            }
            if (!inString && !inChar && c == '/' && next == '*') {
                current.append(' ');
                i++;
                blockComment = true;
                continue;
            }

            if (inString || inChar) {
                current.append(c);
                continue;
            }

            if (c == '(') parentheses++;
            if (c == ')') parentheses = Math.max(0, parentheses - 1);

            if (c == '}' && parentheses == 0) {
                if (!current.toString().trim().isEmpty()) addStatement(result, current);
                current.append('}');
                addStatement(result, current);
            } else {
                current.append(c);
                if ((c == '{' || (c == ';' && parentheses == 0))) {
                    addStatement(result, current);
                }
            }
        }

        if (!current.toString().trim().isEmpty()) addStatement(result, current);
        return result;
    }

    private void addStatement(List<String> result, StringBuilder current) {
        String value = current.toString().trim();
        if (!value.isEmpty()) result.add(value);
        current.setLength(0);
    }

    private String translateStatement(String statement) {
        String s = statement.trim();

        if (s.startsWith("//")) return s;
        if (s.equals("{")) return "{";
        if (s.equals("}")) return "}";

        Matcher matcher;

        // if / else if / else
        matcher = Pattern.compile("^else\\s+if\\s*\\((.*)\\)\\s*\\{$").matcher(s);
        if (matcher.matches()) return "else if " + translateCondition(matcher.group(1)) + " {";
        if (s.matches("^else\\s*\\{$")) return "else {";

        matcher = Pattern.compile("^if\\s*\\((.*)\\)\\s*\\{$").matcher(s);
        if (matcher.matches()) return "if " + translateCondition(matcher.group(1)) + " {";

        matcher = Pattern.compile("^while\\s*\\((.*)\\)\\s*\\{$").matcher(s);
        if (matcher.matches()) return "while " + translateCondition(matcher.group(1)) + " {";

        // for (int i = inicio; i < limite; i++)
        matcher = FOR_PATTERN.matcher(s);
        if (matcher.matches()) {
            String variable = matcher.group(1);
            String start = matcher.group(2).trim();
            String operator = matcher.group(3);
            String end = matcher.group(4).trim();
            String range = operator.equals("<=") ? start + "..=" + end : start + ".." + end;
            variableTypes.put(variable, "i32");
            return "for " + variable + " in " + range + " {";
        }

        // System.out.println(...) / System.out.print(...)
        matcher = Pattern.compile("^(?:System\\.out\\.)?(println|print)\\s*\\((.*)\\)\\s*;?$", Pattern.DOTALL).matcher(s);
        if (matcher.matches()) {
            String function = matcher.group(1).equals("println") ? "println!" : "print!";
            String expression = matcher.group(2).trim();
            if (expression.isEmpty()) return function + "();";
            List<String> parts = splitTopLevelPlus(expression);
            if (parts.size() > 1) {
                StringBuilder format = new StringBuilder("\"");
                for (int i = 0; i < parts.size(); i++) format.append("{}");
                format.append("\"");
                return function + "(" + format + ", " + String.join(", ", parts) + ");";
            }
            return function + "(\"{}\", " + expression + ");";
        }

        // Variables primitivas y String.
        matcher = VARIABLE_PATTERN.matcher(s);
        if (matcher.matches()) {
            boolean isFinal = matcher.group(1) != null;
            String javaType = matcher.group(2);
            String name = matcher.group(3);
            String initializer = matcher.group(4);
            String rustType = rustType(javaType);
            variableTypes.put(name, rustType);

            StringBuilder declaration = new StringBuilder("let ");
            if (!isFinal) declaration.append("mut ");
            declaration.append(name).append(": ").append(rustType);

            if (initializer != null && !initializer.isBlank()) {
                String value = normalizeLiteral(initializer.trim());
                if (javaType.equals("String")) {
                    List<String> parts = splitTopLevelPlus(value);
                    if (parts.size() > 1) {
                        StringBuilder fmt = new StringBuilder("format!(\"");
                        for (int i = 0; i < parts.size(); i++) fmt.append("{}");
                        fmt.append("\", ").append(String.join(", ", parts)).append(")");
                        value = fmt.toString();
                    } else {
                        value = "String::from(" + value + ")";
                    }
                }
                declaration.append(" = ").append(value);
            }
            declaration.append(';');
            return declaration.toString();
        }

        // Incrementos y decrementos simples.
        matcher = Pattern.compile("^([A-Za-z_$][\\w$]*)(\\+\\+|--);$").matcher(s);
        if (matcher.matches()) {
            return matcher.group(1) + (matcher.group(2).equals("++") ? " += 1;" : " -= 1;");
        }

        // Asignaciones a variables String previamente declaradas.
        matcher = Pattern.compile("^([A-Za-z_$][\\w$]*)\\s*=\\s*(.*);$", Pattern.DOTALL).matcher(s);
        if (matcher.matches() && "String".equals(variableTypes.get(matcher.group(1)))) {
            String name = matcher.group(1);
            String value = normalizeLiteral(matcher.group(2).trim());
            List<String> parts = splitTopLevelPlus(value);
            if (parts.size() > 1) {
                StringBuilder fmt = new StringBuilder("format!(\"");
                for (int i = 0; i < parts.size(); i++) fmt.append("{}");
                fmt.append("\", ").append(String.join(", ", parts)).append(")");
                value = fmt.toString();
            } else {
                value = "String::from(" + value + ")";
            }
            return name + " = " + value + ";";
        }

        // Instrucciones Rust que también son validas en este subconjunto de Java.
        if (s.matches("^(return|break|continue)\\s*;?$")) {
            return s.endsWith(";") ? s : s + ";";
        }
        if (s.matches("^[A-Za-z_$][\\w$]*\\s*(?:=|\\+=|-=|\\*=|/=|%=).*;$")
                || s.matches("^[A-Za-z_$][\\w$]*\\s*\\([^;]*\\)\\s*;$")) {
            if (s.contains("new ") || s.contains("System.in") || s.contains("Scanner")) return null;
            return normalizeLiteral(s);
        }

        // Ya puede ser una expresion o llamada compatible con Rust.
        if (s.endsWith(";") && !s.contains("System.out.") && !s.contains("new ")
                && !s.contains("Scanner") && !s.contains("switch") && !s.contains("catch")) {
            return normalizeLiteral(s);
        }

        return null;
    }

    private String translateCondition(String condition) {
        String result = condition.trim();
        // Conversión sencilla de variable.equals("texto") a variable == "texto".
        result = result.replaceAll("([A-Za-z_$][\\w$]*)\\.equals\\(([^()]*)\\)", "$1 == $2");
        return result;
    }

    private String rustType(String javaType) {
        return switch (javaType) {
            case "int" -> "i32";
            case "long" -> "i64";
            case "double" -> "f64";
            case "float" -> "f32";
            case "boolean" -> "bool";
            case "String" -> "String";
            case "char" -> "char";
            default -> throw new IllegalArgumentException("Tipo no soportado: " + javaType);
        };
    }

    private String normalizeLiteral(String text) {
        // Quita los sufijos numéricos típicos de Java cuando no están dentro de strings.
        StringBuilder result = new StringBuilder();
        boolean inString = false;
        boolean inChar = false;
        boolean escaped = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ((inString || inChar) && escaped) {
                result.append(c);
                escaped = false;
                continue;
            }
            if ((inString || inChar) && c == '\\') {
                result.append(c);
                escaped = true;
                continue;
            }
            if (!inChar && c == '"') inString = !inString;
            else if (!inString && c == '\'') inChar = !inChar;

            if (!inString && !inChar && (c == 'L' || c == 'l' || c == 'f' || c == 'F' || c == 'd' || c == 'D')
                    && i > 0 && (Character.isDigit(text.charAt(i - 1)) || text.charAt(i - 1) == '.')) {
                continue;
            }
            result.append(c);
        }
        return result.toString();
    }

    /** Divide una concatenación con + sin partir operadores dentro de strings o paréntesis. */
    private List<String> splitTopLevelPlus(String expression) {
        List<String> parts = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inString = false;
        boolean inChar = false;
        boolean escaped = false;
        int parentheses = 0;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if ((inString || inChar) && escaped) {
                current.append(c);
                escaped = false;
                continue;
            }
            if ((inString || inChar) && c == '\\') {
                current.append(c);
                escaped = true;
                continue;
            }
            if (!inChar && c == '"') inString = !inString;
            else if (!inString && c == '\'') inChar = !inChar;

            if (!inString && !inChar) {
                if (c == '(') parentheses++;
                else if (c == ')') parentheses = Math.max(0, parentheses - 1);
                else if (c == '+' && parentheses == 0) {
                    // No separar el + unario ni los operadores ++.
                    char previous = i > 0 ? expression.charAt(i - 1) : '\0';
                    char next = i + 1 < expression.length() ? expression.charAt(i + 1) : '\0';
                    if (previous != '+' && next != '+' && !Character.isWhitespace(previous)
                            && current.toString().trim().isEmpty()) {
                        current.append(c);
                        continue;
                    }
                    if (previous != '+' && next != '+') {
                        parts.add(current.toString().trim());
                        current.setLength(0);
                        continue;
                    }
                }
            }
            current.append(c);
        }
        parts.add(current.toString().trim());

        // Si hubo un + unario o no hubo concatenación real, no se transforma.
        if (parts.size() <= 1 || parts.stream().anyMatch(String::isEmpty)) {
            return List.of(expression.trim());
        }
        return parts;
    }

    private boolean opensBlock(String translated) {
        return translated.endsWith("{") && !translated.equals("{");
    }

    private String indent(int levels) {
        return "    ".repeat(Math.max(0, levels));
    }
}
