package swaglabs.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://saucedemo.com/")
public class LoginPage extends PageObject {

    private final By fieldUsername = By.id("user-name");
    private final By fieldPassword = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessages = By.cssSelector("h3[data-test='error']");

    public void inputUsername(String username) {
        getDriver().findElement(fieldUsername).sendKeys(username);
    }

    public void inputPassword(String password) {
        getDriver().findElement(fieldPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        getDriver().findElement(loginButton).click();
    }

    public String verifyStatus() {
        return getDriver().getCurrentUrl();
    }

    public String responseStatus() {
        return getDriver().findElement(errorMessages).getText();
    }

    public void reset() {
        getDriver().findElement(By.id("react-burger-menu-btn")).click();
        getDriver().findElement(By.id("reset_sidebar_link")).click();
        getDriver().findElement(By.id("logout_sidebar_link")).click();
    }
}