package steps;

import io.cucumber.java.en.*; //importa given, when, and then
import support.DriverManager;
import pages.PaginaPractica;
import utils.Sitios;

public class PaginaPracticaSteps {
  public static PaginaPractica paginaPractica;

  @Given("^El usuario esta en la página Practice Form.$")
  public void elUsuarioAbreElNavegadorPracticeForm() {
    // La navegación y la inicialización de paginaPractica se realiza en el hook
    // @Before, no aquí.
  }

  @When("^El usuario ingresa información en los campos requeridos.$")
  public void enterSearchText() {
    paginaPractica.enterName("Jenifer");
    paginaPractica.enterLastName("Lopez");
    paginaPractica.enterEmail("pruebas@gmail.com");
    paginaPractica.enterMovil("314121366");
  }

  @Then("^La información se guarda correctamente.$")
  public void laInformacionSeGuardaCorrectamente() {
    paginaPractica.laInformacionSeGuardaCorrectamente();
  }
}