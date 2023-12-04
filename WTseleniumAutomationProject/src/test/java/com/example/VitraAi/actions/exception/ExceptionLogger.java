package com.example.VitraAi.actions.exception;




import com.example.VitraAi.actions.commands.CommonClass;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.MemberSubstitution;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

@Slf4j
public class ExceptionLogger {

	public static String[] tagNames=null;

	public void exceptionLogger(Scenario scenario, Exception exception)  {
		log.error("ERROR : Logging Started --> "+ExceptionUtils.getStackTrace(exception));
		try {
			embedScreenshot(scenario);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		Assertions.fail(exception);
		log.error("ERROR : Logging Completed , please check the cucumber report for more details");
	}

	/*
	 * Author : Hemadri Reddy
	 * API : embedScreenshot(Scenario)
	 * Description : api will be takescreenshot on failure and will embed it into the report
	 * Parameters : Scenario name from the stepdefinition
	 * Example :embedScreenShot("configureCardTypesInIssueCollector");
	 */

	public  void embedScreenshot(Scenario scenario) throws InterruptedException {
		//if (scenario.isFailed()) {
		try {
			//log.error("INFO -----  Screenshot is getting captured");
			Thread.sleep(3000);
			final byte[] screenshot = ((TakesScreenshot) CommonClass.m_driver).getScreenshotAs(OutputType.BYTES);
			Thread.sleep(5000);
			scenario.attach(screenshot, "image/png", "ERR_"+scenario.getName());
			//log.error("INFO -----  Screenshot capture is completed");
		} catch (WebDriverException wde) {
			System.err.println(wde.getMessage());
		} catch (ClassCastException cce) {
			cce.printStackTrace();
		}
	}
	

	public void debug(Scenario scenario,String message) {
		log.info("INFO ----- "+message);
		try {
			embedScreenshot(scenario);
		} catch (InterruptedException e) {
			System.out.println(e.getLocalizedMessage());
		}
		log.info("INFO ----- debug is Completed");
	}
}
