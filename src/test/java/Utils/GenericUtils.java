package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    WebDriver driver;
    WebDriverWait wait;

    public GenericUtils(WebDriver driver){
        this.driver=driver;
    }



    public void switchWindow(){
        Set<String> windowHandles =driver.getWindowHandles();
        Iterator<String> itr = windowHandles.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        driver.switchTo().window(childWindow);
    }


    public void waitforEle(WebElement ele){
        wait.until(ExpectedConditions.elementToBeClickable(ele));

    }


}
