package swaglabs.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class InventoryPage extends PageObject {

    private final By availParam = By.className("product_sort_container");
    private final By activeParam = By.className("active_option");
    private final By cartbutton = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private final By cartVal = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

    public int countItem() {
        List<WebElement> amountItem =
                getDriver().findElements(By.xpath("//*[contains(@id,'remove-')]"));

        return amountItem.size();
    }

    public String verifyLoggedIn() {
        return getDriver().getCurrentUrl();
    }

    public void selectParam(String parameter) {
        Select se = new Select(getDriver().findElement(availParam));
        se.selectByVisibleText(parameter);
    }

    public String getParam() {
        return getDriver().findElement(activeParam).getText();
    }

    public void addToCart(String item) {

        String str = item.toLowerCase()
                .replace(" ", "-")
                .replace("#", "");

        String idButton = "add-to-cart-" + str;

        getDriver().findElement(By.id(idButton)).click();
    }

    public void verifyButton(String button, String item) {

        String str = item.toLowerCase()
                .replace(" ", "-")
                .replace("#", "");

        String btn = button.toLowerCase().replace(" ", "-");

        String idButton = btn + "-" + str;

        getDriver().findElement(By.id(idButton)).isDisplayed();
    }

    public void removeCart(String item) {

        String str = item.toLowerCase()
                .replace(" ", "-");

        String idButton = "remove-" + str;

        getDriver().findElement(By.id(idButton)).click();
    }

    public int getCartVal() {
        return countItem();
    }

    public void clickCart() {
        getDriver().findElement(cartbutton).click();
    }

    public String verifyCart() {
        return getDriver().getCurrentUrl();
    }

    public void reset() {

        getDriver().findElement(By.id("react-burger-menu-btn")).click();
        getDriver().findElement(By.id("reset_sidebar_link")).click();
        getDriver().findElement(By.id("logout_sidebar_link")).click();
    }
}