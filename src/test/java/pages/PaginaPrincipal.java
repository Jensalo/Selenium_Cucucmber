package pages;

import org.openqa.selenium.WebDriver;
import utils.Sitios;

public class PaginaPrincipal extends BasePage {

  // esta es una forma de hacerlo si solo fuera a ingresar a una opcion en el menu
  // private String sectionLink = "//a[@class='sc-hORkcV khhKqW sc-fAomSb
  // sc-ijEwUV ibWYYr urOie'][normalize-space()='Academia']";

  // asi se usa el localizador para mas de una opcion
  private String sectionLink = "//a[normalize-space()='%s' and @href]"; // '%s'
  // significa que se pasa un string @href
  // significa que debe seguir buscando

  public PaginaPrincipal(WebDriver driver) {
    super(driver);
  }

  public void navegarMenu(String seccion) {
    String xpathSection = String.format(sectionLink, seccion);
    clickElement(xpathSection);
  }

  public void navegarA(Sitios sitio) {
    navigateTo(sitio.getUrl());
  }

  // este es cuando es solo un localizador
  // public void clickOnSectionNavigationBar() {
  // clickElement(sectionLink); // este es el método que usas desde el step
  // }

  // este es cuando se tiene mas de un localizador
  public void clickOnSectionNavigationBar(String seccion) {
    // reemplazar el marcador de posicion en sectionlink con el nombre
    String xpathSection = String.format(sectionLink, seccion);
    clickElement(xpathSection); // este es el método que usas desde el step

  }
}
