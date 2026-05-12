package swaglabs.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import swaglabs.Pages.CartPage;
import swaglabs.Pages.InventoryPage;
import swaglabs.Pages.LoginPage;

public class Cart {
    InventoryPage inv;
    CartPage cart;
    LoginPage login;

    @Given("estoy logueada con usuario {string} y clave {string}")
    public void estoyLogueada(String username, String password) {
        login.open();
        login.inputUsername(username);
        login.inputPassword(password);
        login.clickLoginButton();
    }

    @And("se redirige a la pagina Inventory Page")
    public void seRedirigeALaPaginaInventoryPage() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", inv.verifyLoggedIn());
    }

    @When("hago click en el boton Add to Cart de {string}")
    public void hagoClickEnElBotonAddToCart(String item){
        inv.addToCart(item);
    }

    @Then("aparece el boton {string} en {string}")
    public void apareceBoton(String button, String item) {
        inv.verifyButton(button, item);
        login.reset();
    }

    @Given("tengo un item agregado {string}")
    public void tengoItemagregado(String item) {
        login.reset();
        login.open();
        login.inputUsername("standard_user");
        login.inputPassword("secret_sauce");
        login.clickLoginButton();
        inv.addToCart(item);
    }

    @When("hago click en cart button")
    public void hagoClickCartButton() {
        inv.clickCart();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", inv.verifyCart());
    }
}
