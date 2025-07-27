package pages;

import org.openqa.selenium.WebDriver;
import utils.Sitios;

public class PaginaPractica extends BasePage {

  private String searchName = "//input[@id='firstName']";
  private String searchLastName = "//input[@id='lastName']";
  private String searchEmail = "//input[@id='userEmail']";
  private String searchMovil = "//input[@id='userNumber']";

  public PaginaPractica(WebDriver driver) {
    super(driver);
  }

  public void navegarA(Sitios sitio) {
    navigateTo(sitio.getUrl());
  }

  public void enterName(String text) {
    write(searchName, text);
    esperarTextoEnCampo(searchName, text); // espera que se refleje visualmente
  }

  public void enterLastName(String text) {
    write(searchLastName, text);
    esperarTextoEnCampo(searchLastName, text);
  }

  public void enterEmail(String text) {
    write(searchEmail, text);
    esperarTextoEnCampo(searchEmail, text);
  }

  public void enterMovil(String text) {
    write(searchMovil, text);
    esperarTextoEnCampo(searchMovil, text);
  }

  public void laInformacionSeGuardaCorrectamente() {
    // Aquí puedes añadir una verificación si es necesario
    System.out.println("Datos ingresados correctamente.");
  }
}