package com.daniel.engranajes3d;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Locale;
import java.util.Objects;

/**
 * Demo 3D en JavaFX: dos engranajes extruidos, iluminación y cinemática acoplada.
 * Los centros son fijos y los dientes se relacionan sin deslizamiento angular.
 */
public class Engranajes3D extends Application {
    private static final int DIENTES_GRANDE = 20;
    private static final int DIENTES_PEQUENO = 12;
    private static final double RADIO_PRIMITIVO_GRANDE = 2.20;
    private static final double RADIO_PRIMITIVO_PEQUENO = RADIO_PRIMITIVO_GRANDE
            * DIENTES_PEQUENO / DIENTES_GRANDE;
    private static final double DISTANCIA_CENTROS = RADIO_PRIMITIVO_GRANDE
            + RADIO_PRIMITIVO_PEQUENO;
    private static final double GROSOR = 0.34;
    private static final double FASE_INICIAL_PEQUENO = 180.0 / DIENTES_PEQUENO;

    private final Group mundo = new Group();
    private final Group engranajeGrande = new Group();
    private final Group engranajePequeno = new Group();
    private final PerspectiveCamera camara = new PerspectiveCamera(true);
    private final Rotate inclinacionX = new Rotate(13, Rotate.X_AXIS);
    private final Rotate inclinacionY = new Rotate(-5, Rotate.Y_AXIS);

    private AmbientLight luzAmbiente;
    private PointLight luzCalida;
    private PointLight luzFria;
    private ImageView fondo;
    private Label fpsLabel;
    private Label anguloGrandeLabel;
    private Label anguloPequenoLabel;
    private Label velocidadLabel;
    private Label estadoLabel;
    private Button pausaButton;

    private boolean pausado;
    private double anguloGrande;
    private long ultimoFrame;
    private long inicioContadorFps;
    private int frames;
    private double tiempoHastaActualizarTexto;

    @Override
    public void start(Stage stage) {
        prepararMundo3D();

        StackPane raiz = new StackPane();
        raiz.setStyle("-fx-background-color: #0a111b;");
        fondo = crearFondo();
        fondo.fitWidthProperty().bind(raiz.widthProperty());
        fondo.fitHeightProperty().bind(raiz.heightProperty());

        Region tinte = new Region();
        tinte.setStyle("-fx-background-color: rgba(4, 9, 17, 0.34);");

        SubScene vista3D = new SubScene(mundo, 1280, 800, true, SceneAntialiasing.BALANCED);
        vista3D.setFill(Color.TRANSPARENT);
        vista3D.widthProperty().bind(raiz.widthProperty());
        vista3D.heightProperty().bind(raiz.heightProperty());
        vista3D.setCamera(camara);

        BorderPane paneles = crearInterfaz();
        raiz.getChildren().addAll(fondo, tinte, vista3D, paneles);
        StackPane.setAlignment(paneles, Pos.CENTER);

        Scene escena = new Scene(raiz, 1280, 800, true);
        stage.setTitle("Engranajes 3D | JavaFX");
        stage.setMinWidth(960);
        stage.setMinHeight(650);
        stage.setScene(escena);
        stage.show();

        iniciarAnimacion();
    }

    private ImageView crearFondo() {
        URL recurso = Objects.requireNonNull(
                getClass().getResource("/factory-background.jpg"),
                "No se encontró factory-background.jpg en src/main/resources"
        );
        Image imagen = new Image(recurso.toExternalForm(), false);
        ImageView vista = new ImageView(imagen);
        vista.setPreserveRatio(false);
        vista.setSmooth(true);
        vista.setEffect(new GaussianBlur(17));
        return vista;
    }

    private void prepararMundo3D() {
        mundo.getTransforms().addAll(inclinacionX, inclinacionY);

        engranajeGrande.getChildren().addAll(
                crearCuerpoEngranaje(DIENTES_GRANDE, RADIO_PRIMITIVO_GRANDE,
                        Color.web("#347db8"), Color.web("#77c8ff")),
                crearRadios(DIENTES_GRANDE, RADIO_PRIMITIVO_GRANDE,
                        Color.web("#477fa9")),
                crearBuje(RADIO_PRIMITIVO_GRANDE * 0.16, Color.web("#9aadb8"))
        );
        engranajeGrande.setRotationAxis(Rotate.Z_AXIS);
        engranajeGrande.setTranslateX(-DISTANCIA_CENTROS / 2.0);
        engranajeGrande.setTranslateY(-0.20);

        engranajePequeno.getChildren().addAll(
                crearCuerpoEngranaje(DIENTES_PEQUENO, RADIO_PRIMITIVO_PEQUENO,
                        Color.web("#a95c2b"), Color.web("#ffc27a")),
                crearRadios(DIENTES_PEQUENO, RADIO_PRIMITIVO_PEQUENO,
                        Color.web("#a96f43")),
                crearBuje(RADIO_PRIMITIVO_PEQUENO * 0.18, Color.web("#c3b5a4"))
        );
        engranajePequeno.setRotationAxis(Rotate.Z_AXIS);
        engranajePequeno.setTranslateX(DISTANCIA_CENTROS / 2.0);
        engranajePequeno.setTranslateY(-0.20);
        engranajePequeno.setRotate(FASE_INICIAL_PEQUENO);

        mundo.getChildren().addAll(
                crearBase(),
                crearSoporte(-DISTANCIA_CENTROS / 2.0, RADIO_PRIMITIVO_GRANDE),
                crearSoporte(DISTANCIA_CENTROS / 2.0, RADIO_PRIMITIVO_PEQUENO),
                engranajeGrande,
                engranajePequeno,
                crearLucesYCamara()
        );
    }

    private Node crearCuerpoEngranaje(int dientes, double radioPrimitivo,
                                      Color colorCuerpo, Color colorBrillo) {
        double radioRaiz = radioPrimitivo - 0.12;
        double radioPunta = radioPrimitivo + 0.12;
        double radioInterior = radioPrimitivo * 0.58;
        TriangleMesh malla = crearMallaAnularDentada(dientes, radioRaiz, radioPunta,
                radioInterior, GROSOR);

        MeshView cuerpo = new MeshView(malla);
        cuerpo.setCullFace(CullFace.NONE);
        PhongMaterial metal = new PhongMaterial(colorCuerpo);
        metal.setSpecularColor(colorBrillo);
        metal.setSpecularPower(72);
        cuerpo.setMaterial(metal);
        return cuerpo;
    }

    /** Construye el aro frontal/trasero, los dientes y las paredes laterales en 3D. */
    private TriangleMesh crearMallaAnularDentada(int dientes, double radioRaiz,
                                                  double radioPunta, double radioInterior,
                                                  double grosor) {
        final int muestrasPorDiente = 7;
        final int n = dientes * muestrasPorDiente;
        final double[] fraccionesAngulo = {-0.50, -0.375, -0.25, -0.125, 0.125, 0.25, 0.375};
        final double[] factoresRadio = {0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0};
        float medioGrosor = (float) (grosor / 2.0);

        TriangleMesh mesh = new TriangleMesh();
        mesh.getTexCoords().addAll(0, 0);

        // Cuatro contornos: exterior frontal/trasero e interior frontal/trasero.
        for (int lado = 0; lado < 4; lado++) {
            double z = (lado == 0 || lado == 2) ? -medioGrosor : medioGrosor;
            boolean esInterior = lado >= 2;
            for (int i = 0; i < n; i++) {
                int diente = i / muestrasPorDiente;
                int muestra = i % muestrasPorDiente;
                double angulo = (diente + fraccionesAngulo[muestra])
                        * (Math.PI * 2.0 / dientes);
                double radio;
                if (esInterior) {
                    radio = radioInterior;
                } else {
                    radio = radioRaiz + (radioPunta - radioRaiz) * factoresRadio[muestra];
                }
                mesh.getPoints().addAll(
                        (float) (Math.cos(angulo) * radio),
                        (float) (Math.sin(angulo) * radio),
                        (float) z
                );
            }
        }

        // Superficies frontal y posterior del aro (se conserva abierto el centro).
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            int exteriorFrenteI = i;
            int exteriorFrenteJ = j;
            int exteriorAtrasI = n + i;
            int exteriorAtrasJ = n + j;
            int interiorFrenteI = 2 * n + i;
            int interiorFrenteJ = 2 * n + j;
            int interiorAtrasI = 3 * n + i;
            int interiorAtrasJ = 3 * n + j;

            // Frente, mirando hacia la cámara (-Z).
            cara(mesh, exteriorFrenteI, interiorFrenteJ, exteriorFrenteJ);
            cara(mesh, exteriorFrenteI, interiorFrenteI, interiorFrenteJ);
            // Parte trasera (+Z).
            cara(mesh, exteriorAtrasI, exteriorAtrasJ, interiorAtrasJ);
            cara(mesh, exteriorAtrasI, interiorAtrasJ, interiorAtrasI);
            // Borde exterior extruido.
            cara(mesh, exteriorFrenteI, exteriorAtrasJ, exteriorAtrasI);
            cara(mesh, exteriorFrenteI, exteriorFrenteJ, exteriorAtrasJ);
            // Pared interior del agujero.
            cara(mesh, interiorFrenteI, interiorAtrasI, interiorAtrasJ);
            cara(mesh, interiorFrenteI, interiorAtrasJ, interiorFrenteJ);
        }
        return mesh;
    }

    private void cara(TriangleMesh mesh, int a, int b, int c) {
        mesh.getFaces().addAll(a, 0, b, 0, c, 0);
    }

    private Group crearRadios(int dientes, double radioPrimitivo, Color color) {
        Group radios = new Group();
        double radioInterior = radioPrimitivo * 0.58;
        double radioBuje = radioPrimitivo * (dientes == DIENTES_GRANDE ? 0.16 : 0.18);
        double longitud = radioInterior - radioBuje + 0.10;
        double centro = (radioInterior + radioBuje) / 2.0;
        PhongMaterial metalRadios = new PhongMaterial(color);
        metalRadios.setSpecularColor(Color.web("#d5e8f2"));
        metalRadios.setSpecularPower(44);

        int cantidadRadios = 5;
        for (int i = 0; i < cantidadRadios; i++) {
            Box radio = new Box(longitud, Math.max(0.12, radioPrimitivo * 0.075), GROSOR * 0.72);
            radio.setMaterial(metalRadios);
            radio.setTranslateX(centro);
            radio.setTranslateZ(-GROSOR * 0.52);
            radio.setRotationAxis(Rotate.Z_AXIS);
            radio.setRotate(i * 360.0 / cantidadRadios);
            radios.getChildren().add(radio);
        }
        return radios;
    }

    private Group crearBuje(double radioBuje, Color color) {
        Group conjunto = new Group();
        PhongMaterial materialBuje = new PhongMaterial(color);
        materialBuje.setSpecularColor(Color.WHITE);
        materialBuje.setSpecularPower(90);

        Cylinder eje = new Cylinder(radioBuje * 0.38, GROSOR + 0.62, 32);
        orientarCilindroEnZ(eje);
        eje.setMaterial(new PhongMaterial(Color.web("#303a43")));
        eje.setTranslateZ(0.02);

        Cylinder buje = new Cylinder(radioBuje, 0.42, 48);
        orientarCilindroEnZ(buje);
        buje.setMaterial(materialBuje);
        buje.setTranslateZ(-GROSOR / 2.0 - 0.13);

        Cylinder anilloFrontal = new Cylinder(radioBuje * 0.66, 0.08, 48);
        orientarCilindroEnZ(anilloFrontal);
        anilloFrontal.setMaterial(new PhongMaterial(Color.web("#586975")));
        anilloFrontal.setTranslateZ(-GROSOR / 2.0 - 0.36);

        conjunto.getChildren().addAll(eje, buje, anilloFrontal);
        return conjunto;
    }

    private void orientarCilindroEnZ(Cylinder cilindro) {
        cilindro.setRotationAxis(Rotate.X_AXIS);
        cilindro.setRotate(90);
    }

    private Group crearBase() {
        Group base = new Group();
        PhongMaterial aceroOscuro = material(Color.web("#202a33"), Color.web("#91a9b9"), 55);
        PhongMaterial aceroClaro = material(Color.web("#495660"), Color.web("#cedce4"), 70);
        PhongMaterial amarillo = material(Color.web("#d28a27"), Color.web("#ffd58b"), 30);

        Box placaInferior = new Box(8.65, 0.42, 2.55);
        placaInferior.setMaterial(aceroOscuro);
        placaInferior.setTranslateY(2.83);

        Box placaSuperior = new Box(8.15, 0.12, 2.28);
        placaSuperior.setMaterial(aceroClaro);
        placaSuperior.setTranslateY(2.56);

        Box bandaAmarillaFrontal = new Box(7.80, 0.055, 0.045);
        bandaAmarillaFrontal.setMaterial(amarillo);
        bandaAmarillaFrontal.setTranslateY(2.75);
        bandaAmarillaFrontal.setTranslateZ(-1.08);

        base.getChildren().addAll(placaInferior, placaSuperior, bandaAmarillaFrontal);
        // Pernos frontales, con su eje orientado hacia la cámara.
        for (double x : new double[]{-3.85, -2.25, 2.25, 3.85}) {
            Cylinder perno = new Cylinder(0.105, 0.075, 6);
            orientarCilindroEnZ(perno);
            perno.setMaterial(new PhongMaterial(Color.web("#aab8c0")));
            perno.setTranslateX(x);
            perno.setTranslateY(2.55);
            perno.setTranslateZ(-1.19);
            base.getChildren().add(perno);
        }
        return base;
    }

    private Node crearSoporte(double x, double radioPrimitivo) {
        Group soporte = new Group();
        PhongMaterial material = material(Color.web("#27333d"), Color.web("#6f8798"), 38);

        Box columna = new Box(Math.max(0.28, radioPrimitivo * 0.18), 1.35, 0.48);
        columna.setMaterial(material);
        columna.setTranslateX(x);
        columna.setTranslateY(2.03);
        columna.setTranslateZ(0.50);

        Box baseColumna = new Box(Math.max(0.60, radioPrimitivo * 0.40), 0.14, 0.74);
        baseColumna.setMaterial(new PhongMaterial(Color.web("#687782")));
        baseColumna.setTranslateX(x);
        baseColumna.setTranslateY(2.67);
        baseColumna.setTranslateZ(0.50);
        soporte.getChildren().addAll(columna, baseColumna);
        return soporte;
    }

    private Node crearLucesYCamara() {
        luzAmbiente = new AmbientLight(Color.color(0.38, 0.40, 0.43));
        luzCalida = new PointLight(Color.color(1.00, 0.68, 0.40));
        luzCalida.setTranslateX(-4.5);
        luzCalida.setTranslateY(-4.5);
        luzCalida.setTranslateZ(-5.5);

        luzFria = new PointLight(Color.color(0.35, 0.62, 1.00));
        luzFria.setTranslateX(5.0);
        luzFria.setTranslateY(-1.0);
        luzFria.setTranslateZ(-2.5);

        camara.setNearClip(0.1);
        camara.setFarClip(100);
        camara.setFieldOfView(36);
        camara.setTranslateZ(-14.3);
        return new Group(luzAmbiente, luzCalida, luzFria);
    }

    private PhongMaterial material(Color difuso, Color especular, double potencia) {
        PhongMaterial material = new PhongMaterial(difuso);
        material.setSpecularColor(especular);
        material.setSpecularPower(potencia);
        return material;
    }

    private BorderPane crearInterfaz() {
        BorderPane paneles = new BorderPane();
        paneles.setPadding(new Insets(20));
        paneles.setMouseTransparent(false);

        VBox estado = new VBox(8);
        estado.setPadding(new Insets(16));
        estado.setMaxWidth(330);
        estado.setStyle(estiloPanel());
        Label titulo = titulo("SIMULACIÓN MECÁNICA", 15);
        fpsLabel = etiqueta("FPS: calculando…");
        anguloGrandeLabel = etiqueta("Engranaje grande: 0.0°");
        anguloPequenoLabel = etiqueta("Engranaje pequeño: 15.0°");
        velocidadLabel = etiqueta("Relación: 20 / 12 = 1.67:1");
        estadoLabel = etiqueta("Cinemática acoplada · sin deslizamiento");
        estado.getChildren().addAll(titulo, separador(), fpsLabel, anguloGrandeLabel,
                anguloPequenoLabel, velocidadLabel, estadoLabel);
        paneles.setTop(estado);
        BorderPane.setAlignment(estado, Pos.TOP_LEFT);

        VBox controles = new VBox(13);
        controles.setPadding(new Insets(17));
        controles.setPrefWidth(300);
        controles.setMaxWidth(300);
        controles.setStyle(estiloPanel());
        Label controlesTitulo = titulo("PANEL DE CONTROL", 15);

        Slider velocidad = slider(0, 200, 65);
        Label velocidadValor = etiqueta("0.65×");
        velocidad.valueProperty().addListener((obs, oldV, newV) -> {
            velocidadCompartida = newV.doubleValue() / 100.0;
            velocidadValor.setText(String.format(Locale.US, "%.2f×", velocidadCompartida));
        });

        Slider ambiente = slider(10, 75, 38);
        Slider luces = slider(15, 100, 85);
        Slider desenfoque = slider(0, 30, 17);
        Slider zoom = slider(0, 100, 70);
        Slider tilt = slider(-20, 35, 13);
        Slider orbit = slider(-35, 35, -5);

        ambiente.valueProperty().addListener((obs, oldV, newV) -> {
            double v = newV.doubleValue() / 100.0;
            luzAmbiente.setColor(Color.color(v, v * 1.02, v * 1.08));
        });
        luces.valueProperty().addListener((obs, oldV, newV) -> {
            double factor = newV.doubleValue() / 100.0;
            luzCalida.setColor(Color.color(factor, factor * 0.68, factor * 0.40));
            luzFria.setColor(Color.color(factor * 0.35, factor * 0.62, factor));
        });
        desenfoque.valueProperty().addListener((obs, oldV, newV) ->
                fondo.setEffect(new GaussianBlur(newV.doubleValue())));
        zoom.valueProperty().addListener((obs, oldV, newV) ->
                camara.setTranslateZ(-22 + newV.doubleValue() * 0.11));
        tilt.valueProperty().addListener((obs, oldV, newV) ->
                inclinacionX.setAngle(newV.doubleValue()));
        orbit.valueProperty().addListener((obs, oldV, newV) ->
                inclinacionY.setAngle(newV.doubleValue()));

        controles.getChildren().addAll(
                controlesTitulo, separador(),
                filaControl("Velocidad", velocidad, velocidadValor),
                filaControl("Luz ambiente", ambiente, etiqueta("")),
                filaControl("Luces metálicas", luces, etiqueta("")),
                filaControl("Desenfoque fondo", desenfoque, etiqueta("")),
                filaControl("Zoom", zoom, etiqueta("")),
                filaControl("Inclinación", tilt, etiqueta("")),
                filaControl("Órbita", orbit, etiqueta(""))
        );

        HBox botones = new HBox(9);
        botones.setAlignment(Pos.CENTER_LEFT);
        pausaButton = new Button("Ⅱ  Pausar");
        pausaButton.setMaxWidth(Double.MAX_VALUE);
        pausaButton.setStyle(estiloBoton());
        pausaButton.setOnAction(evento -> {
            pausado = !pausado;
            pausaButton.setText(pausado ? "▶  Reanudar" : "Ⅱ  Pausar");
            estadoLabel.setText(pausado ? "Simulación pausada" : "Cinemática acoplada · sin deslizamiento");
        });

        Button reiniciar = new Button("↺  Reiniciar");
        reiniciar.setStyle(estiloBoton());
        reiniciar.setOnAction(evento -> {
            anguloGrande = 0;
            engranajeGrande.setRotate(0);
            engranajePequeno.setRotate(FASE_INICIAL_PEQUENO);
            velocidad.setValue(65);
            zoom.setValue(70);
            tilt.setValue(13);
            orbit.setValue(-5);
            estadoLabel.setText("Ángulos reiniciados");
        });
        HBox.setHgrow(pausaButton, javafx.scene.layout.Priority.ALWAYS);
        botones.getChildren().addAll(pausaButton, reiniciar);
        controles.getChildren().add(botones);
        paneles.setRight(controles);
        BorderPane.setAlignment(controles, Pos.TOP_RIGHT);

        VBox nota = new VBox(4);
        nota.setPadding(new Insets(10, 14, 10, 14));
        nota.setStyle(estiloPanel());
        Label nota1 = etiqueta("ENGRANAJES DE ACERO · 3D CON PERSPECTIVA");
        Label nota2 = etiqueta("La rueda pequeña gira en sentido contrario y 20/12 veces más rápido.");
        nota.getChildren().addAll(nota1, nota2);
        paneles.setBottom(nota);
        BorderPane.setAlignment(nota, Pos.BOTTOM_CENTER);

        return paneles;
    }

    private Slider slider(double minimo, double maximo, double inicial) {
        Slider control = new Slider(minimo, maximo, inicial);
        control.setBlockIncrement((maximo - minimo) / 100.0);
        control.setMajorTickUnit((maximo - minimo) / 4.0);
        control.setFocusTraversable(false);
        return control;
    }

    private HBox filaControl(String nombre, Slider control, Label valor) {
        VBox caja = new VBox(5);
        caja.setPrefWidth(260);
        caja.setMaxWidth(Double.MAX_VALUE);
        HBox encabezado = new HBox();
        encabezado.setAlignment(Pos.CENTER_LEFT);
        Label etiqueta = etiqueta(nombre);
        encabezado.getChildren().addAll(etiqueta, new Region());
        HBox.setHgrow(encabezado.getChildren().get(1), javafx.scene.layout.Priority.ALWAYS);
        encabezado.getChildren().add(valor);
        control.setMaxWidth(Double.MAX_VALUE);
        control.setShowTickMarks(false);
        control.setShowTickLabels(false);
        caja.getChildren().addAll(encabezado, control);
        HBox fila = new HBox(caja);
        fila.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(caja, javafx.scene.layout.Priority.ALWAYS);
        return fila;
    }

    private void iniciarAnimacion() {
        AnimationTimer temporizador = new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                if (ultimoFrame == 0) {
                    ultimoFrame = ahora;
                    inicioContadorFps = ahora;
                    return;
                }
                double dt = Math.min((ahora - ultimoFrame) / 1_000_000_000.0, 0.05);
                ultimoFrame = ahora;
                frames++;

                if (!pausado) {
                    // Velocidad de entrada y relación cinemática sin deslizamiento.
                    double velocidadGradosPorSegundo = 58.5;
                    // El control se lee del slider visible para no mantener estado duplicado.
                    double multiplicador = obtenerMultiplicadorVelocidad();
                    // Conservamos el ángulo acumulado para que el engranaje pequeño
                    // no dé saltos cuando la rueda grande completa una vuelta.
                    anguloGrande += velocidadGradosPorSegundo * multiplicador * dt;
                    engranajeGrande.setRotate(anguloGrande);
                    engranajePequeno.setRotate(FASE_INICIAL_PEQUENO
                            - anguloGrande * DIENTES_GRANDE / DIENTES_PEQUENO);
                }

                if (ahora - inicioContadorFps >= 500_000_000L) {
                    double segundos = (ahora - inicioContadorFps) / 1_000_000_000.0;
                    fpsLabel.setText(String.format(Locale.US, "FPS: %.0f", frames / segundos));
                    frames = 0;
                    inicioContadorFps = ahora;
                }

                tiempoHastaActualizarTexto += dt;
                if (tiempoHastaActualizarTexto >= 0.10) {
                    tiempoHastaActualizarTexto = 0;
                    anguloGrandeLabel.setText(String.format(Locale.US,
                            "Engranaje grande: %.1f°", normalizar(anguloGrande)));
                    anguloPequenoLabel.setText(String.format(Locale.US,
                            "Engranaje pequeño: %.1f°", normalizar(FASE_INICIAL_PEQUENO
                                    - anguloGrande * DIENTES_GRANDE / DIENTES_PEQUENO)));
                }
            }
        };
        temporizador.start();
    }

    private double obtenerMultiplicadorVelocidad() {
        return velocidadCompartida;
    }

    private Double velocidadCompartida = 0.65;

    private double normalizar(double angulo) {
        double resultado = angulo % 360.0;
        return resultado < 0 ? resultado + 360.0 : resultado;
    }

    private Label etiqueta(String texto) {
        Label label = new Label(texto);
        label.setStyle("-fx-text-fill: #d9e5ef; -fx-font-size: 12px; -fx-font-family: 'Monospace';");
        label.setWrapText(true);
        return label;
    }

    private Label titulo(String texto, int tamano) {
        Label label = new Label(texto);
        label.setStyle("-fx-text-fill: #f0f6fc; -fx-font-size: " + tamano
                + "px; -fx-font-weight: bold; -fx-font-family: 'Monospace';");
        return label;
    }

    private Region separador() {
        Region linea = new Region();
        linea.setMinHeight(1);
        linea.setPrefHeight(1);
        linea.setMaxHeight(1);
        linea.setStyle("-fx-background-color: rgba(165, 191, 210, 0.28);");
        return linea;
    }

    private String estiloPanel() {
        return "-fx-background-color: rgba(9, 17, 28, 0.84);"
                + "-fx-border-color: rgba(160, 194, 220, 0.26);"
                + "-fx-border-radius: 10; -fx-background-radius: 10;";
    }

    private String estiloBoton() {
        return "-fx-background-color: #1b3348; -fx-text-fill: #edf6ff;"
                + "-fx-border-color: #557b9b; -fx-background-radius: 7; -fx-border-radius: 7;"
                + "-fx-padding: 8 12 8 12; -fx-font-weight: bold;";
    }

    public static void main(String[] args) {
        launch(args);
    }
}
