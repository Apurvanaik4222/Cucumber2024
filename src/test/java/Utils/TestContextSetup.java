package Utils;

import PageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class TestContextSetup {

    public WebDriver driver;
    public WebDriverWait wait;
    public String landingPageShortNametxt;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
        testBase =new TestBase();
        pageObjectManager =new PageObjectManager(testBase.getInstance());
        genericUtils =new GenericUtils(testBase.getInstance());

    }


}
