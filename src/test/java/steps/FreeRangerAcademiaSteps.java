package steps;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import io.cucumber.java.en.*; //importa given, when, and then
import pages.PaginaAcademia;
import pages.PaginaPrincipal;
import support.DriverManager;

public class FreeRangerAcademiaSteps {

  // Se declara como public para permitir inicialización desde el hook
  public static PaginaPrincipal paginaPrincipal;
  PaginaAcademia paginaAcademia;

  @Given("El usuario abre el navegador en la sección Academia")
  public void elUsuarioAbreElNavegadorAcademia() {
    // La navegación y la inicialización de paginaPrincipal se realiza en el hook
    // @Before, no aquí.
  }

  @When("Voy a academia usando la barra de navegación")
  public void voyAAcademiaUsandoLaBarraDeNavegacion() {
    try {
      paginaPrincipal.navegarMenu("Academia");
    } catch (Exception e) {
      // Captura manual del screenshot si ocurre error en el step
      byte[] screenshot = utils.ScreenshotUtil.captureScreenshot(support.DriverManager.getDriver());
      // Si tienes acceso al objeto Scenario, adjunta aquí el screenshot
      // scenario.attach(screenshot, "image/png", "Step Screenshot (manual)");
      System.out.println(
          "[ERROR] Captura manual de screenshot en step 'Voy a academia usando la barra de navegación'. Tamaño: "
              + (screenshot != null ? screenshot.length : 0));
      throw e;
    }
  }

  @When("^(?:Yo|El usuario|El cliente) selecciona? Empezar hoy$")
  public void seleccionoEmpezarhoy() {
    paginaAcademia = new PaginaAcademia(DriverManager.getDriver());
    paginaAcademia.irEmpezarhoy();
  }

  @When("^(?:Yo|El usuario|El cliente) valida las opciones de planes de pago$")
  public void validateCheckoutPlans() {

    // esta lista nos trae los valores reales
    List<String> list = paginaAcademia.returnplanDropdownValues();

    // esta es la lista que estoy esperando que valide
    List<String> listaEsperada = Arrays.asList(
        "Academia: $16.99/m",
        "Academia: $176/a");

    Assert.assertEquals(listaEsperada, list);

  }
}
