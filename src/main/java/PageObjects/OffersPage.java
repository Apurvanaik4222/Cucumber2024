package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {

    WebDriver driver;

    public OffersPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Top Deals')]")
    private WebElement topDealsLink;

    @FindBy(xpath = "//input[@id='search-field']")
    private WebElement searchBx;



    @FindBy(xpath = "//table[@class='table table-bordered']//td[1]")
    private WebElement offersPageShortName;

    public void clickonTopDealLionk(){
        topDealsLink.click();
    }

    public void enterProductName(String productName){
        searchBx.sendKeys(productName);
    }
    public  String getProductName(){
        return offersPageShortName.getText();

    }


}
