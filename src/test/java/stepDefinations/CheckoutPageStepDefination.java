package stepDefinations;

import PageObjects.CheckOutPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutPageStepDefination {


    CheckOutPage checkoutPage;
    TestContextSetup testContextSetup;

    public CheckoutPageStepDefination(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
       this.checkoutPage = testContextSetup.pageObjectManager.getCheckOutPage();
    }


    @Then("^User proceeds to checkout and validate the (.+) items in the checkout$")
    public void user_proceeds_to_checkout_and_validate_the_items_in_the_checkout(String productName) {
        System.out.println(productName +"------------------");
        Assert.assertTrue(checkoutPage.verifyProductName_CheckoutPage().contains(productName));

    }


    @When("verify user has the ability to enter promo code and place the order")
    public void verify_user_has_the_ability_to_enter_promo_code_and_place_the_order() {
        Assert.assertTrue(checkoutPage.verfyPromoBtn());
        Assert.assertTrue(checkoutPage.verfyPlaceOrderBtn());


    }



}
