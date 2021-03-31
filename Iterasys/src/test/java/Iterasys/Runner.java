package Iterasys;

//import java.text.SimpleDateFormat;
//import java.util.Date;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
		jsonReport = "target/cucumber.json",
		retryCount = 1,
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		coverageReport = true,
		jsonUsageReport = "target/cucumber-usage.json",
		usageReport = true,
		includeCoverageTags = {"@Teste"},
		outputFolder = "target")





@CucumberOptions(
		features = "src//test//resources//",
		glue = {"Iterasys"},
		monochrome=true,
		//dryRun = true,
		plugin = {"pretty", "html:target/cucumber",
				"json:target/cucumber.json",
				"junit:target/cucumber-results.xml",
				"rerun:target/rerun.txt"},
		tags="@Teste")

        //plugin = {"pretty","info.cukes.formatter.xls.XLSOutputFormatter"})
		//plugin = {"xls:target/cucumber-reports/info.cukes.formatter.xls.XLSOutputFormatter"})
	

public class Runner {
	
	
/*public static void beforeClass() {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
	System.setProperty("currentdate", dateFormat.format(new Date()));*/
	
	
}




