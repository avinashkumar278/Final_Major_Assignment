package com.cucumberMainAssignment.stepdefinitions;
import com.cucumberMainAssignment.browsers.Browsers;
import com.cucumberMainAssignment.helper.LoggerHelper;
import com.cucumberMainAssignment.testBase.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


public class ServiceHooks {

	TestBase testBase;

	Logger log = LoggerHelper.getLogger(ServiceHooks.class);

	@Before
	public void initializeTest() {
		testBase = new TestBase();
		testBase.selectBrowser(Browsers.CHROME.name());
	}

	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png"); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info(scenario.getName() + " is pass");
				scenario.embed(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		TestBase.driver.quit();
	}
}
