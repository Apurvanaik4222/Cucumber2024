package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[contains(@placeholder,'Search for Veg')]")
    private WebElement searchBx;

    @FindBy(xpath = "//button[@type='submit']")
   private WebElement submitBtn;


    @FindBy(xpath = "//h4[@class='product-name']")
    private WebElement landingPageShortName;

    @FindBy(xpath = "//a[@class='increment']")
    private WebElement incrementBtn;

    @FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='cart-icon']")
    private WebElement cartLink;

    @FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
    private WebElement proceedToCart;


    public void enterProductName(String productName) throws InterruptedException {
        searchBx.sendKeys(productName);
        Thread.sleep(3000);
        submitBtn.click();
    }

    public  String getProductName(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(landingPageShortName));
        return landingPageShortName.getText();

    }

    public void addProductQuantity(int quantity){

        int i=quantity-1;

        while(i>0){
            incrementBtn.click();
            i--;
        }
    }


    public void clickonCartLink(){
        cartLink.click();
    }

    public void addToCart(){
        addToCart.click();
    }

    public void proccedToCart() throws InterruptedException {
        proceedToCart.click();
        Thread.sleep(3000);
    }


    public String getlandinPageTitle(){
       return driver.getTitle();
    }
}
