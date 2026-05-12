package swaglabs.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import swaglabs.Pages.CartPage;
import swaglabs.Pages.CheckOutPage;

public class CheckoutStep {
    CartPage cart;
    CheckOutPage cout1;

    @And("hago click en checkout button")
    public void clickBotonCheckout(){
        cout1.clickCheckout();
    }

    @And("se redirige a la pagina checkout-step-one")
    public void seRedirigeAPaginaCheckoutStepOnePage() {
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html", cout1.verifyPage());
    }

    @When("ingreso {string} como first name")
    public void ingresoFirstName(String nameFirst) {
        cout1.inputFirstName(nameFirst);
    }

    @And("ingreso {string} como last name")
    public void ingresoLastName(String nameLast) {
        cout1.inputLastName(nameLast);
    }

    @And("ingreso {string} como Postal Code")
    public void ingresoCodigoPostal(String codeZip) {
        cout1.inputZipCode(codeZip);
    }

    @And("hago click en boton continue")
    public void hagoClickEnBotonContinue() {
        cout1.clickContinue();
    }

    @Then("se redirige a la pagina checkout-step-two")
    public void seRedirigeAPaginaCheckoutStepTwo() {
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", cout1.verifyPage());
    }

    @When("hago click en boton Finish")
    public void hagoClickEnBotonFinish() {
        cout1.clickFinish();
    }

    @Then("se redirige a la pagina checkout-complete")
    public void seRedirigeAPaginaCheckoutComplete() {
        Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", cout1.verifyPage());
    }

}
