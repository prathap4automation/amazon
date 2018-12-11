package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={
//				"src\\test\\resources\\features\\TestOneUsernamePage.feature",
//				"src\\test\\resources\\features\\TestTwoPasswordPage.feature",
				"src\\test\\resources\\features\\AddToCart.feature"
			}
		,monochrome=true
		,dryRun=false
		,tags={}
		,glue=""
		,plugin={
				"pretty"
				,"html:target/htmlReport.html"
				,"json:target/jsonReport.json"
				,"junit:target/xmlReport.xml"
				,"rerun:target/failedTests.txt"
			}
		)
public class Runner {

}
