import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty" ,
                "usage:target/cucumberreport/cucumber-usage.json",
                "html:target/cucumberreport/cucumber.html" ,
                "json:target/cucumberreport/cucumber.json" ,
                "junit:target/cucumberreport/cucumber.xml"},
        features = {"src/test/resources/features"},
        glue = {"com.demo.APIAutomation"}
        )
public class RunCukesTest
{


}
