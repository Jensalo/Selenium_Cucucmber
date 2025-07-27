package steps;

import io.cucumber.java.en.*; //importa given, when, and then
import pages.PaginaGoogle;
import support.DriverManager;
import utils.Sitios;

public class PaginaGoogleSteps {
  public static PaginaGoogle paginaGoogle;

  @Given("^El usuario esta en la página de búsqueda de Google.$") // se coloca ^ al inicio y $ al final para que
                                                                  // coincida con la
                                                                  // línea completa
  public void elUsuarioAbreElNavegadorGoogle() {
    // La navegación y la inicialización de paginaGoogle se realiza en el hook
    // @Before, no aquí.
  }

  @When("^Introduce un criterio de búsqueda.$")
  public void enterSearchText() {
    paginaGoogle.enterSearchText("Udemy");// Aquí va el código para hacer la búsqueda
  }

  // @Then("^Los resultados coinciden con los criterios.$")
  // public void validateSearchResults() {
  // paginaGoogle.validateSearchResults(); // Aquí se valida que los resultados
  // coincidan con los criterios

  // }

  // @When("^No introduce ningún criterio de búsqueda.$")
  // public void noIntroduceNingunCriterioDeBusqueda() {
  // paginaGoogle.clearSearchText(); // Borra cualquier texto (si hay)
  // paginaGoogle.enterSearchText(""); // Simula envío con campo vacío
  // }

  // @Then("^Se debe mostrar un mensaje de error o no realizar búsqueda.$")
  // public void seDebeMostrarUnMensajeDeError() {
  // paginaGoogle.validateEmptySearch(); // Nueva validación
  // }
}