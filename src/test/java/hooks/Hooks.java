package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

import org.openqa.selenium.WebDriver;

import pages.PaginaPrincipal;
import support.DriverManager;
import utils.ScreenshotUtil;
import utils.Sitios;

/**
 * Hooks de Cucumber para inicialización, cierre y captura de screenshots en
 * errores.
 * - Navega a la URL deseada según el tag.
 * - Captura screenshot en cada paso fallido (@AfterStep).
 * - Captura screenshot al final del escenario si falla (@After).
 * - Adjunta la imagen al reporte Extent (spark.html).
 */
public class Hooks {

  // Se elimina iniciarNavegacion. Cada hook navega solo con la instancia de la
  // página específica.

  /**
   * Hook para escenarios con tag @FreeRange
   */
  @Before("@FreeRange")
  public void setUpFreeRange() {
    PaginaPrincipal paginaPrincipal = new PaginaPrincipal(DriverManager.getDriver());
    paginaPrincipal.navegarA(utils.Sitios.FREE_RANGE);
  }

  /**
   * Hook para escenarios con tag @Academia
   */
  @Before("@Academia")
  public void setUpAcademia() {
    // Inicializa paginaPrincipal para que esté disponible en todos los steps de
    // Academia
    steps.FreeRangerAcademiaSteps.paginaPrincipal = new pages.PaginaPrincipal(support.DriverManager.getDriver());
    steps.FreeRangerAcademiaSteps.paginaPrincipal.navegarA(utils.Sitios.FREE_RANGE);
  }

  /**
   * Hook para escenarios con tag @Google
   */
  @Before("@Google")
  public void setUpGoogle() {
    // Inicializa paginaGoogle y navega solo a Google
    steps.PaginaGoogleSteps.paginaGoogle = new pages.PaginaGoogle(support.DriverManager.getDriver());
    steps.PaginaGoogleSteps.paginaGoogle.navegarA(utils.Sitios.GOOGLE);
  }

  /**
   * Hook para escenarios con tag @Practica
   */
  @Before("@Practica")
  public void setUpPractica() {
    // Inicializa paginaPractica y navega solo a Practice Form
    steps.PaginaPracticaSteps.paginaPractica = new pages.PaginaPractica(support.DriverManager.getDriver());
    steps.PaginaPracticaSteps.paginaPractica.navegarA(utils.Sitios.PRACTICE_FORM);
  }

  /**
   * Captura screenshot en cada paso fallido y lo adjunta al reporte.
   * Esto permite ver el estado de la aplicación en el momento exacto del error.
   */
  @AfterStep
  public void captureStepScreenshot(Scenario scenario) {
    if (scenario.isFailed()) {
      try {
        WebDriver driver = DriverManager.getDriver();
        byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);
        System.out.println("[DEBUG] Screenshot (AfterStep) size: " + (screenshot != null ? screenshot.length : 0));
        scenario.attach(screenshot, "image/png", "Step Screenshot");
      } catch (Exception e) {
        System.out.println("[ERROR] No se pudo capturar el screenshot en AfterStep: " + e.getMessage());
      }
    }
  }

  /**
   * Hook de cierre: captura screenshot si el escenario falla y cierra el driver.
   */
  @After
  public void tearDown(Scenario scenario) {
    WebDriver driver = DriverManager.getDriver();

    if (scenario.isFailed()) {
      scenario.log("En caso de falla del escenario, consulte la imagen adjunta a este informe.");
      byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);
      System.out.println("[DEBUG] Screenshot (After) size: " + (screenshot != null ? screenshot.length : 0));
      scenario.attach(screenshot, "image/png", "Screenshot on Failure");
    }

    DriverManager.quitDriver();
  }
}

// NOTA: Esta es la única definición válida de la clase Hooks.
// Si vuelves a ver errores de compilación, asegúrate de que no haya otra clase
// Hooks en este archivo.
