package swaglabs.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import swaglabs.Pages.LoginPage;

public class Login {
    LoginPage login;

    @Given("ingreso a Login Page")
    public void ingresoALoginPage() {
        login.open();

    }

    @When("ingreso {string} como username")
    public void ingresoUsuario(String username) {
        login.inputUsername(username);
    }

    @And("ingreso {string} como password")
    public void ingresoPassword(String password) {
        login.inputPassword(password);
    }

    @And("hago click en login button")
    public void hagoClickEnLoginButton() {
        login.clickLoginButton();
    }

    @Then("obtengo {string}")
    public void obtengoRespuesta(String response) {
        if (response.matches("redirected(.*)")) {
            Assert.assertEquals(login.verifyStatus(), "https://www.saucedemo.com/inventory.html");
        } else if (response.matches("Epic sadface: (.*)")) {
            Assert.assertEquals(login.responseStatus(), response);
        }
    }
}
