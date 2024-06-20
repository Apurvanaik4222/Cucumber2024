package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait ;


    public WebDriver getInstance() throws IOException {

        if(driver==null) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\global.properties");
            properties.load(fileInputStream);

           String browser = System.getProperty("browser")!=null?System.getProperty("browser"):properties.getProperty("browser");
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }else if(browser.equalsIgnoreCase("firefox")){

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            }


            driver.get(properties.getProperty("qa_endpoint"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        }

        return driver;


    }
}
