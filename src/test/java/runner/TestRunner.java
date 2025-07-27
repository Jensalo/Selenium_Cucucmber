// TestRunner.java (corregido y verificado para tu estructura)
package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import support.DriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/resources/features", glue = "steps", plugin = {
    "pretty",
    "html:build/reports/cucumber/html-report",
    "json:build/reports/cucumber/report.json",
    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:build/reports/extent/"

}, monochrome = true)

public class TestRunner {
  @AfterClass
  public static void cleanDriver() {
    DriverManager.quitDriver();
  }
}
// Este TestRunner está configurado para ejecutar las pruebas de Cucumber
// y limpiar el WebDriver después de que todas las pruebas hayan finalizado.