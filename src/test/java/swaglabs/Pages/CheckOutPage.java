package swaglabs.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.saucedemo.com/")
public class CheckOutPage extends PageObject {

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipcode = By.id("postal-code");
    private final By contButton = By.id("continue");
    private final By coutButton = By.id("checkout");
    private final By finishBtn = By.id("finish");
    private final By roboCowboy = By.className("pony_express");

    public String verifyPage() {
        return getDriver().getCurrentUrl();
    }

    public void inputFirstName(String nameFirst) {
        getDriver().findElement(firstName).sendKeys(nameFirst);
    }

    public void inputLastName(String nameLast) {
        getDriver().findElement(lastName).sendKeys(nameLast);
    }

    public void inputZipCode(String codeZip) {
        getDriver().findElement(zipcode).sendKeys(codeZip);
    }

    public void clickContinue() {
        getDriver().findElement(contButton).click();
    }

    public void clickCheckout() {
        getDriver().findElement(coutButton).click();
    }

    public void clickFinish() {
        getDriver().findElement(finishBtn).click();
    }


}