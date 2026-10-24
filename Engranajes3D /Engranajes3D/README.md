# Engranajes 3D — JavaFX

Aplicación de escritorio Java con dos engranajes extruidos en 3D, materiales metálicos, luces cálida/fría, cámara en perspectiva, panel de control y un fondo industrial difuminado incluido como recurso.

## Requisitos

- JDK 25 (por ejemplo, Temurin 25)
- Maven 3.8 o superior
- Fedora/Linux con aceleración gráfica funcionando para JavaFX 3D

## Ejecutar en Fedora

Si todavía no tienes Maven:

```bash
sudo dnf install maven
```

Desde la carpeta `Engranajes3D`:

```bash
mvn clean javafx:run
```

En el primer inicio Maven descarga JavaFX y los plugins necesarios, así que se requiere conexión a Internet. Después, Maven reutiliza las dependencias descargadas.

## Controles

- **Velocidad:** regula la velocidad de giro de entrada.
- **Luz ambiente / Luces metálicas:** cambian la intensidad de iluminación.
- **Desenfoque fondo:** ajusta el desenfoque del fondo de fábrica.
- **Zoom:** acerca o aleja la cámara.
- **Inclinación / Órbita:** cambian la perspectiva del conjunto.
- **Pausar / Reanudar** y **Reiniciar** controlan la animación.

## Qué física simula

Los centros se mantienen a una distancia fija. La relación angular sin deslizamiento es

`ω_pequeño = -ω_grande × dientes_grande / dientes_pequeño`

Para 20 y 12 dientes, el engranaje pequeño gira en sentido opuesto y 20/12 veces más rápido. La fase inicial se desplaza media separación angular para colocar un diente frente a un valle. Esta es una simulación cinemática de engranajes acoplados; no es un solucionador industrial de contacto, deformación, fricción ni colisiones rígidas.

## Estructura

```text
Engranajes3D/
├── pom.xml
├── README.md
└── src/main/
    ├── java/com/daniel/engranajes3d/Engranajes3D.java
    └── resources/factory-background.jpg
```

El fondo es una ilustración industrial rasterizada y desenfocada que se distribuye dentro del proyecto, de modo que la aplicación no depende de una URL externa para mostrarlo.
