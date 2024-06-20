package stepDefinations;

import PageObjects.OffersPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class OffersPageStepDefination {

    String offersPageShortNametxt;
    OffersPage offersPage;
    TestContextSetup testContextSetup;

    public OffersPageStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.offersPage = testContextSetup.pageObjectManager.getoffersPage();
    }

    @Then("^user searched for (.+) shortname in offers page$")
    public void user_searched_for_shortname_in_offers_page(String shortName) {

        offersPage.clickonTopDealLionk();
        testContextSetup.genericUtils.switchWindow();
        offersPage.enterProductName(shortName);
        offersPageShortNametxt = offersPage.getProductName();


    }

    @Then("validate product name in offer page matches with Landing Page")
    public void validate_product_name_in_offer_page_matches_with_landing_page() throws IOException {
        Assert.assertEquals(testContextSetup.landingPageShortNametxt, offersPageShortNametxt);
    }
}
