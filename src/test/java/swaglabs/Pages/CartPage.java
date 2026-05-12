package swaglabs.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;

import static net.serenitybdd.core.Serenity.getDriver;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPage {
    private final By continueShopping = By.id("continue-shopping");
    private final By cartItem = By.className("inventory_item_name");

    public void verifyCartPage() {

        Assert.assertEquals(
                "https://www.saucedemo.com/cart.html",
                getDriver().getCurrentUrl()
        );
    }

    public void contShopping() {
        getDriver().findElement(continueShopping).click();
    }

    public String verifyCartItem() {
        return getDriver().findElement(cartItem).getText();
    }
}
