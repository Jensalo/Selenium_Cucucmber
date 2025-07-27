package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import utils.Sitios;

public class PaginaGoogle extends BasePage {

  private String searchButton = "//input[@name='Buscar con Google']";
  private String searchTextField = "//*[@id='APjFqb']";
  // private String clickGoogleSearch = "*//input[@name='btnK']";

  public PaginaGoogle(WebDriver driver) {
    super(driver);
  }

  public void navegarA(Sitios sitio) {
    navigateTo(sitio.getUrl());
  }

  public void clickGoogleSearch() {
    clickElement(searchButton);
  }

  public void enterSearchText(String text) {
    writeAndEnter(searchTextField, text);
  }

  public void clearSearchText() {
    write(searchTextField, ""); // Borra el campo escribiendo una cadena vacía
  }

  // public void clearSearchText() { //explícitamente limpia el campo sin escribir
  // nada
  // find(searchTextField).clear();
  // }

  public void validateSearchResults() {
    String titulo = driver.getTitle().toLowerCase();
    System.out.println(" Título obtenido: " + titulo);
    assertTrue("El título no contiene la palabra 'udemy'", titulo.contains("udemy"));
  }

  // public void validateEmptySearch() {
  // String titulo = driver.getTitle();
  // System.out.println(" Título obtenido sin búsqueda: " + titulo);
  // assertTrue("No se esperaba una búsqueda con campo vacío",
  // titulo.equals("Google"));
  // }
}
