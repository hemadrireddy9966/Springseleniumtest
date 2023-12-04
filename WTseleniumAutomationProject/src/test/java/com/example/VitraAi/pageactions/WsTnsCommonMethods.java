package com.example.VitraAi.pageactions;



import com.example.VitraAi.actions.commands.Common;
import com.example.VitraAi.pageobject.PageObjectsFactory;
import com.example.VitraAi.steps.BeforeTag;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Map;


@Slf4j
public class WsTnsCommonMethods extends Common {
    private final Map<String, String> wsc = super.readPropertiesFile(PageObjectsFactory.wscommon);
    private final Map<String, String> rbck = super.readPropertiesFile(PageObjectsFactory.rbck);

    public WsTnsCommonMethods(WebDriver driver) {super(driver);}
    public void navigatingToTeams() {
        log.info("navigatingToTeams Started");
        try {
            Thread.sleep(3000);
            waitForTheElement(retriveLocators(wsc.get("teams")),PRESENCE_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(wsc.get("teams")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("navigatingToTeams Completed");
    }
    public void navigatingToAnalytics() {
        log.info("navigatingToAnalytics Started");
        try {
            super.elementClick(retriveLocators(wsc.get("analytics")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("navigatingToAnalytics Completed");
    }
    public void navigatingToGlossary() {
        log.info("navigatingToGlossary Started");
        try {
            super.elementClick(retriveLocators(wsc.get("glossary")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("navigatingToGlossary Completed");
    }
    public void navigatingToDashboard() {
        log.info("navigatingToDashboard Started");
        try {
            super.staleElementClick(retriveLocators(wsc.get("dashboardbtn")));
            super.waitForTheElement(By.xpath("//h2[contains(text(),'Translation breakdown')]"),VISIBILITY_OF_ELEMENT_LOCATED);
         Boolean check=super.isElementVisible(retriveLocators(wsc.get("dismiss")));
//         if (check==true){
//
//             waitForTheElement(retriveLocators(wsc.get("dismiss")),CLICKABILITY_OF_ELEMENT_LOCATED);
//             super.elementClick(retriveLocators(wsc.get("dismiss")));
//             super.elementClick(retriveLocators(wsc.get("dashboardbtn")));
//         }
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("navigatingToDashboard Completed");
    }
    public void navigatingToWebsites() {
        log.info("navigatingToWebsites Started");
        try {
            super.elementClick(retriveLocators(wsc.get("Websites")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("navigatingToWebsites Completed");
    }
    public void navigatingToBillingPage() {
        log.info("navigatingToBillingPage Started");
        try {
            super.elementClick(retriveLocators(wsc.get("billing")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("navigatingToBillingPage Completed");
    }

    public void signOut() {
        log.info("signOut from application Started");
        try {
            super.elementClick(retriveLocators(wsc.get("signoutbtn")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("signOut from application Completed");
    }
    public void teamSelectInTeamSwitch(String teamName) {
        log.info("teamSelectInTeamSwitch Started");
        try {
            super.elementClick(retriveLocators(wsc.get("teamSwitchclick")));
            super.enterText(wsc.get("teamSwitchInput"),teamName);
            super.clickUsingAction(retriveLocators(dynamicXpathGenerator(wsc.get("teamclick"),teamName)));
            Thread.sleep(3000);
            super.waitTillProductLoadingImageLoaded();
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("teamSelectInTeamSwitch Completed");
    }
    public void customTeamSelectAndNavigateToDashBoard(String teamName) {
        log.info("customTeamSelectAndNavigateToDashBoard Started");
        try {

            navigatingToTeams();
            super.waitForPageToBeReady();
            driver.findElement(retriveLocators(rbck.get("teamSearchbar"))).sendKeys(teamName+ Keys.ENTER);
            Thread.sleep(2000);
            super.elementClick(retriveLocators(dynamicXpathGenerator(rbck.get("teamSelect"),teamName)));
            isElementVisible(By.xpath("//button[text()='Team Members']"));
            navigatingToDashboard();
//            super.waitForPageToBeReady();
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("customTeamSelectAndNavigateToDashBoard Completed");
    }

    public void glossaryFileSearch(String glossaryName) {
        log.info("glossaryFileSearch in Glossary Tab Started");
        try {
            System.out.println("glossary file name"+glossaryName);
            Thread.sleep(5000);
            super.enterTextUsingJS(By.xpath("//input[@placeholder='Search By name']"),glossaryName);
            driver.findElement(By.xpath("//div[@class='inline-block cursor-pointer']")).click();

        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryFileSearch in Glossary Tab Completed");
    }

}
