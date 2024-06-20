package cumber.Options;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "@target/failed_scenarios.txt",glue = {"stepDefinations"},
        monochrome = true,tags = "@PlaceOrder or @searchProduct",
        plugin = {"html:target/cucumber-reports/htmlreports.html","json:target/cucumber-reports/jsonReports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/failed_scenarios.txt"
        }

)
public class FailedTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel=true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
