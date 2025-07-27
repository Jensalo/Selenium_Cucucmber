# Curso Selenium 2025

Proyecto de automatización de pruebas web usando Selenium, Java, Cucumber y Gradle.

## Estructura principal
- **src/test/java/**: Código fuente de pruebas, páginas, hooks y steps.
- **src/resources/**: Archivos de configuración y features de Cucumber.
- **build.gradle**: Configuración de Gradle.
- **test-output/**, **build/**, **bin/**: Carpetas generadas automáticamente.

## Tecnologías utilizadas
- Java
- Selenium WebDriver
- Cucumber & Gherkin
- Gradle
- JUnit

## Ejecución

1. Instala dependencias:
   ```
   gradlew.bat build
   ```
2. Ejecuta las pruebas:
   ```
   gradlew.bat test
   ```

## Notas
- Los archivos de configuración y reportes se encuentran en la carpeta `src/resources` y `build/reports`.
- No subas archivos generados automáticamente ni configuraciones locales de IDE.
