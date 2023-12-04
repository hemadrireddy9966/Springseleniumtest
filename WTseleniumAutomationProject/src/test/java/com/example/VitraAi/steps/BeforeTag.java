package com.example.VitraAi.steps;




import com.example.VitraAi.actions.commands.Common;
import com.example.VitraAi.actions.exception.ExceptionLogger;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assume;
import org.openqa.selenium.WebDriver;

import java.util.Map;
@Slf4j
public class BeforeTag extends ExceptionLogger {

    public static Scenario scenario;
    Common common;

    public static boolean WsTnsStatus = true;

    public BeforeTag(WebDriver driver) {
        common = new Common(driver);
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        log.debug("Scenario Name: "+"'"+scenario.getName() +"'"+" Started");
        tagNames = scenario.getSourceTagNames().toArray(new String[0]);
    }

    @After
    public void after (Scenario scenario){
        this.scenario = scenario;
        log.debug("Scenario Name: "+"'"+ scenario.getName() +"'"+" Completed");
    }

    @Before("@WsTnsRbckData or @WsTnsGlossary or @WsTnsData or @WsTnsGloData")
    public void WebsiteTnsRbckUrl() throws Exception {
        Map<String, String> envProp = common.readPropertiesFile(System.getProperty("user.dir") + "/src/test/resources/application.properties");
        common.navigate(envProp.get("aws.se"));
    }
//    @Before("@WsTnsGlossary")
//    public void WebsiteTnsGlossaryUrl() throws Exception {
//        Map<String, String> envProp = common.readPropertiesFile(System.getProperty("user.dir") + "/src/test/resources/application.properties");
//        common.navigate(envProp.get("aws.se"));
//    }
//    @Before("@WsTnsData")
//    public void NavigateWebsiteTnsUrl() throws Exception {
//        Map<String, String> envProp = common.readPropertiesFile(System.getProperty("user.dir") + "/src/test/resources/application.properties");
//        common.navigate(envProp.get("aws.se"));
//    }

    @Before("@WsSnippet")
    public void NavigateSite2Url() throws Exception {
        Map<String, String> envProp = common.readPropertiesFile(System.getProperty("user.dir") + "/src/test/resources/application.properties");
        common.navigate(envProp.get("site6"));
    }
//    @Before("@Website")
//    public void NavigateSite2() throws Exception {
//        Map<String, String> envProp = common.readPropertiesFile(System.getProperty("user.dir") + "/src/test/resources/application.properties");
//        common.navigate(envProp.get("site2url"));
//    }
//    @Before("@WsTnsGloData")
//    public void NavigateWebsiteTranslationUrl() throws Exception {
//        Map<String, String> envProp = common.readPropertiesFile(System.getProperty("user.dir") + "/src/test/resources/application.properties");
//        common.navigate(envProp.get("aws.se"));
//    }
//
//    @Before("@WsTnsScenario")
//    public void NavigateSEUrl() throws Exception {
//        Map<String, String> envProp = common.readPropertiesFile(System.getProperty("user.dir") + "/src/test/resources/application.properties");
//        common.navigate(envProp.get("aws.se"));
//    }

//    commented bcz it's captured screen shot but its not attaching with avery step at last it's attaching
    @AfterStep
    public void everyStep(Scenario scenario) throws InterruptedException {

    embedScreenshot(scenario);

     }
//    @After("@WsTnsData")
//    public void WsTnsFailureCheck() {
//        if (scenario.isFailed()) {
//            WsTnsStatus = false;
//            System.out.println("data creation status-------------------" + WsTnsStatus);
//        }
//    }
//
//    //    @Before("@RMData or @RMScenario")
//    @Before("@WsTnsData")
//    public void WsTnsScenarioFailureCheck() {
//        System.out.println("scenario status-------------------" + WsTnsStatus);
//        if (WsTnsStatus == false) {
//            Assume.assumeTrue(false);
//            System.out.println("Skip the scenario");
//        }
//    }
    // screen shot
    @After
    public void tearDown(Scenario scenario) throws InterruptedException {

            embedScreenshot(scenario);

    }

}









