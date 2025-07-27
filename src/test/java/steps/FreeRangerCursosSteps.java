package steps;

import io.cucumber.java.en.*; //importa given, when, and then
import pages.PaginaCursos;
import pages.PaginaPrincipal;
import support.DriverManager;
import utils.Sitios;

public class FreeRangerCursosSteps {

  PaginaPrincipal paginaPrincipal;
  PaginaCursos paginaCursos;

  @Given("El usuario abre el navegador en la sección Cursos")
  public void elUsuarioAbreElNavegadorCursos() {
    paginaPrincipal = new PaginaPrincipal(DriverManager.getDriver());
    paginaPrincipal.navegarA(Sitios.FREE_RANGE);

  }

  @When("Voy a cursos usando la barra de navegación")
  public void voyACursosUsandoLaBarraDeNavegacion() {
    paginaPrincipal.navegarMenu("Cursos");
  }

  @When("Selecciono Introducción al Testing de Software")
  public void seleccionoIntroduccionAlTestingDeSoftware() {
    paginaCursos = new PaginaCursos(DriverManager.getDriver());
    paginaCursos.irIntroduccionTesting();
  }
}
