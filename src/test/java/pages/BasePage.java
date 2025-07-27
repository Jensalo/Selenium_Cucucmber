package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  protected static WebDriver driver;
  protected static WebDriverWait wait;

  public BasePage(WebDriver driver) {
    BasePage.driver = driver;
    BasePage.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void navigateTo(String url) {
    driver.get(url);
  }

  // encuentra y devuelve un webElement en la pagina utilizando un locator xpath
  // esperando que esté presente en el DOM
  protected WebElement find(String locator) {
    return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
  }

  public void clickElement(String locator) {
    find(locator).click();
  }

  public void write(String locator, String textToWrite) {
    find(locator).clear(); // limpia el campo
    find(locator).sendKeys(textToWrite); // ingresa texto en campo texto
  }

  public void selectFromDrowpdownByValue(String locator, String value) {
    Select dropdown = new Select(find(locator));
    dropdown.selectByValue(value); // seleccionar por valor
  }

  public void selectFromDrowpdownByIndex(String locator, Integer index) {
    Select dropdown = new Select(find(locator));
    dropdown.selectByIndex(index); // seleccionar por índice
  }

  public void selectFromDrowpdownByVisibleText(String locator, String text) {
    Select dropdown = new Select(find(locator));
    dropdown.selectByVisibleText(text); // seleccionar por texto visible
  }

  // validar si un elemento está visible en la página
  public boolean isElementVisible(String locator) {
    try {
      return find(locator).isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  // validar cantidad de elementos que tiene un dropdown
  // toma un objeto de tipo select y devuelve un entero size
  public int dropdownSize(String locator) {
    Select dropdown = new Select(find(locator));

    // creamos una lista que contiene objetos de tipo WebElement
    List<WebElement> dropdownOptions = dropdown.getOptions();

    // nos devuelve el tamaño, el número de objetos
    return dropdownOptions.size();
  }

  // crea una lista de los WebElements textos de los valores
  public List<String> getDropdownValues(String locator) {
    Select dropdown = new Select(find(locator));
    List<WebElement> dropdownOptions = dropdown.getOptions();

    List<String> values = new ArrayList<>();
    for (WebElement option : dropdownOptions) {
      values.add(option.getText());
    }
    return values;
  }

  public void writeAndEnter(String locator, String text) {
    WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    input.sendKeys(text + Keys.ENTER);
  }

  // espera a que el campo contenga el texto ingresado (útil para observación
  // visual o validaciones)
  public void esperarTextoEnCampo(String locator, String textoEsperado) {
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions.attributeToBe(By.xpath(locator), "value", textoEsperado));
  }
}
