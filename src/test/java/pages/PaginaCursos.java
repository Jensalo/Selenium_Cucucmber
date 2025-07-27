package pages;

import org.openqa.selenium.WebDriver;

public class PaginaCursos extends BasePage {

  private String introduccionTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";

  public PaginaCursos(WebDriver driver) {
    super(driver);
  }

  public void irIntroduccionTesting() {
    clickElement(introduccionTestingLink);
  }
}
