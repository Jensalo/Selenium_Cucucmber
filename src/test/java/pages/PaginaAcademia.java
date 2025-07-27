package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class PaginaAcademia extends BasePage {

  private String EmpezarhoyLink = "//a[normalize-space()='Empezar hoy' and @href]";
  private String planDropdown = "//select[@id='cart_cart_item_attributes_plan_with_interval']";

  public PaginaAcademia(WebDriver driver) {
    super(driver);
  }

  public void irEmpezarhoy() {

    clickElement(EmpezarhoyLink);
  }

  public List<String> returnplanDropdownValues() {
    return getDropdownValues(planDropdown);
  }
}
