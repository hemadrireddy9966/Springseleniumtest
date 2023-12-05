package com.example.VitraAi.pageactions;



import com.example.VitraAi.actions.commands.Common;
import com.example.VitraAi.pageobject.PageObjectsFactory;
import com.example.VitraAi.steps.BeforeTag;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Map;


@Slf4j
public class WsTnsLoginPage extends Common {
    private final Map<String, String> webTrs = super.readPropertiesFile(PageObjectsFactory.WTlogin);

    public WsTnsLoginPage(WebDriver driver) {super(driver);}
    public void loginToWebsiteTranslation(String emailid) {
        log.info("loginToWebsiteTranslation Started");
        try {
            super.enterText(webTrs.get("loginID"),emailid);
            super.elementClick(retriveLocators(webTrs.get("signinbtn")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("loginToWebsiteTranslation Completed");
    }
    public void enteringOtp(String otp) {
        log.info("loginToWebsiteTranslation Started");
        try {
            Thread.sleep(4000);
//            super.elementClick(retriveLocators(webTrs.get("otpEnter")));
            super.enterTextWithCntrlV(webTrs.get("otpEnter"),otp);
            Thread.sleep(1000);
            super.elementClick(retriveLocators(webTrs.get("otpConformbtn")));

        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("loginToWebsiteTranslation Completed");
    }
    public void homepage() {
        log.info("homepage Started");
        try {
            Thread.sleep(2000);
            super.waitForTheElement(retriveLocators(webTrs.get("homepage")),VISIBILITY_OF_ELEMENT_LOCATED);
            // Zoom in (increase the zoom level)

        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("homepage Completed");
    }

}
