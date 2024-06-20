package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {

    WebDriver driver;

    public CheckOutPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//tbody//tr//td[2]//p")
    private WebElement productName;

    @FindBy(xpath = "//button[@class='promoBtn']")
    private WebElement promoBtn;

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    private WebElement placeOrder;








    public String verifyProductName_CheckoutPage(){
        String nameTxt = productName.getText().split("-")[0].trim();
        System.out.println(nameTxt);
        return nameTxt;

    }

    public void addToCart(){

    }

    public void proccedToCart(){
        //proceedToCart.click();
    }

    public boolean verfyPromoBtn(){
      return promoBtn.isDisplayed();
    }

    public boolean verfyPlaceOrderBtn(){
        return placeOrder.isDisplayed();
    }

}
