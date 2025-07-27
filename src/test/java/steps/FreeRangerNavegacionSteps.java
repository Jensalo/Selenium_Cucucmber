package steps;

import io.cucumber.java.en.*; //importa given, when, and then
import pages.PaginaPrincipal;
import support.DriverManager;
import utils.Sitios;

public class FreeRangerNavegacionSteps {

  PaginaPrincipal paginaPrincipal;

  @Given("el usuario abre el navegador")
  public void elUsuarioAbreElNavegador() {
    paginaPrincipal = new PaginaPrincipal(DriverManager.getDriver());
    paginaPrincipal.navegarA(Sitios.FREE_RANGE); // navega a la pagina

  }

  // esta es una forma de hacerlo si solo fuera a ingresar a una opcion en el menu
  // @When("Voy a la sección usando la barra de navegación")
  // public void navigationBarUse() {
  // pagina.clickOnSectionNavigationBar(); // ← llamado correcto
  // }

  // esta es la formaque usa cuando se tiene mas de una opcion en el menu
  @When("Voy a la {string} usando la barra de navegación")
  public void voyALaSeccionUsandoLaBarraDeNavegacion(String seccion) {
    paginaPrincipal.navegarMenu(seccion);
  }

}

// @Then("el usuario cierra el navegador")
// public void cerrarNavegador() {
// if (driver != null) {
// driver.quit();//
// }
// }
