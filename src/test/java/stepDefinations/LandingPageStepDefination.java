package stepDefinations;

import PageObjects.LandingPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.io.IOException;

public class LandingPageStepDefination {


    LandingPage landingPage;
    TestContextSetup testContextSetup;

    public LandingPageStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }


    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() throws IOException {
        Assert.assertTrue(landingPage.getlandinPageTitle().contains("GreenKart"));


    }

    @When("^user searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname(String shortName) throws InterruptedException {
        landingPage.enterProductName(shortName);
        testContextSetup.landingPageShortNametxt =landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageShortNametxt);


    }


    @When("Added {string} items of selected product of the cart")
    public void added_items_of_selected_product_of_the_cart(String quantity) throws InterruptedException {
        landingPage.addProductQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
        landingPage.clickonCartLink();
        landingPage.proccedToCart();


    }


}
