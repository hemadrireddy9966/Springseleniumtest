package com.example.VitraAi.pageactions;


import com.example.VitraAi.actions.commands.Common;
import com.example.VitraAi.pageobject.PageObjectsFactory;
import com.example.VitraAi.steps.BeforeTag;
import io.cucumber.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.Map;


@Slf4j
public class websiteGlossary extends Common {
    private final Map<String, String> ws = super.readPropertiesFile(PageObjectsFactory.websites);
    private final Map<String, String> glossary = super.readPropertiesFile(PageObjectsFactory.glossary);
    private final Map<String, String> wpadmin = super.readPropertiesFile(PageObjectsFactory.wpaddmin);
    private final Map<String, String> wsglossary = super.readPropertiesFile(PageObjectsFactory.wsglossary);

   String path = PageObjectsFactory.site6GlossaryPath;
    static String snippet="";
    public websiteGlossary(WebDriver driver) {super(driver);}

    public void languageSwitchAndSelectInGlossarys(String langName) {
        log.info("languageSwitchAndSelectInGlossary's Started");
        try {
            waitForTheElement(retriveLocators(wsglossary.get("languageSwitch")),CLICKABILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(wsglossary.get("languageSwitch")));
            super.enterText(wsglossary.get("languagesearchBar"),langName);
            super.elementClick(retriveLocators(dynamicXpathGenerator(wsglossary.get("languageSel"),langName)));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("languageSwitchAndSelectInGlossary's Completed");
    }
    /*
     * Author : Hemadri Reddy
     * API : importGlossaryFile(filpath,markVerifiedOrUnVerified)
     * Description : api will be import glossary file with verified and un-verified and also need
     *               keep the file in resources>>WTnsGlossaryFiles folder and it should be
     *               .csv format and add the path in pageObjectsFactory class and extract it in page actions class
     * Parameters : Scenario name from the stepdefinition
     * Example :importGlossaryFile("WTnsGLossaryFiles/site6Glossary.csv",typeofVerify);
     */
    public void importGlossaryFile(String filePath,String markVerifiedOrUnVerified) {
        log.info("importGlossaryFile Started");
        try {
            new WebDriverWait(driver,Duration.ofMillis(7000)).until(ExpectedConditions.elementToBeClickable(retriveLocators(wsglossary.get("importBtn"))));
            super.click(wsglossary.get("importBtn"));
//            super.clickUsingAction(retriveLocators(wsglossary.get("upload")));
            if (filePath.contains("site6")) {
//                super.uploadFile(path);
//                path = path.replace("\\", "/");
                super.enterTextWithoutUsingClick(wsglossary.get("upload"),path);
                if (markVerifiedOrUnVerified.equalsIgnoreCase("verified"))
                    super.elementClick(retriveLocators(wsglossary.get("toggle")));
                super.elementClick(retriveLocators(wsglossary.get("uploadFile")));
            }else {
                System.out.println("entered file path name is not listed in WTnsGlossaryFiles under resources");
            }
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("importGlossaryFile Completed");
    }

    public void glossaryImportedSuccessnotifiVerify(String langName) {
        log.info("glossaryImportedSuccessNotificationVerify Started");
        try {
            new WebDriverWait(driver,Duration.ofMillis(7000)).until(ExpectedConditions.visibilityOfElementLocated(retriveLocators(wsglossary.get(""))));

        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryImportedSuccessNotificationVerify Completed");
    }

    public void exportGlossaryFile(String markVerifiedOrUnVerified) {
        log.info("exportGlossaryFile Started");
        try {
            new WebDriverWait(driver,Duration.ofMillis(7000)).until(ExpectedConditions.elementToBeClickable(retriveLocators(wsglossary.get("exportCsvBtn"))));
            super.elementClick(retriveLocators(wsglossary.get("exportCsvBtn")));
            super.enterText(wsglossary.get("exportInputTxbBox"),"TestingExportGlossary");
            if (markVerifiedOrUnVerified.equals("verified")) {
                boolean b = isElementVisible(retriveLocators(wsglossary.get("verified")));
                System.out.println("testing bool"+b);
                if (b){
                    super.elementClick(retriveLocators(wsglossary.get("verified")));
                    Thread.sleep(5000);
                }
            }
            Thread.sleep(6000);
            super.elementClick(retriveLocators(wsglossary.get("exportbtn")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("exportGlossaryFile Completed");
    }
    public void glossaryEditWord(String actualWord,String UpdatedWord) {
        log.info("glossaryEditWord Started");
        try {
            new WebDriverWait(driver,Duration.ofMillis(7000)).until(ExpectedConditions.elementToBeClickable(retriveLocators(wsglossary.get("editBtn"))));
            super.elementClick(retriveLocators(wsglossary.get("editBtn")));
//            super.clickUsingAction(retriveLocators(dynamicXpathGenerator(wsglossary.get("targetWordEditTxb"),actualWord)));
//            super.enterText(dynamicXpathGenerator(wsglossary.get("targetWordEditTxb"),actualWord),UpdatedWord);
            super.enterKeysWithoutWait(retriveLocators(dynamicXpathGenerator(wsglossary.get("targetWordEditTxb"),actualWord)),UpdatedWord);
            Thread.sleep(3000);
            super.elementClick(retriveLocators(wsglossary.get("saveChangesBtn")));

        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryEditWord Completed");
    }
    public void glossaryTargetWordVerify(String sourceWord,String targetWord) {
        log.info("glossaryTargetWordVerify with source word text Started");
        try {
            new WebDriverWait(driver,Duration.ofMillis(7000)).until(ExpectedConditions.visibilityOfElementLocated(retriveLocators(wsglossary.get("viewBtn"))));
            String word=super.getText(retriveLocators(dynamicXpathGenerator(wsglossary.get("targetWordVerify"),sourceWord)));
              super.textAssertions(targetWord,word);
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryTargetWordVerify with source word text Completed");
    }
    public void glossaryWordsSearch(String sourceWord) {
        log.info("glossaryTargetWordSearch Started");
        try {
            new WebDriverWait(driver,Duration.ofMillis(7000)).until(ExpectedConditions.visibilityOfElementLocated(retriveLocators(wsglossary.get("viewBtn"))));
            super.enterChordKeys(retriveLocators(wsglossary.get("SearchBar")),Keys.ENTER,sourceWord);
            driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryTargetWordSearch Completed");
    }
    public void makeWordAsVerified(String word) {
        log.info("makeWordAsVerified Started");
        try {
            new WebDriverWait(driver,Duration.ofMillis(7000)).until(ExpectedConditions.visibilityOfElementLocated(retriveLocators(dynamicXpathGenerator(wsglossary.get("makeVerify"),word))));
            super.elementClick(retriveLocators(dynamicXpathGenerator(wsglossary.get("makeVerify"),word)));
            new WebDriverWait(driver,Duration.ofMillis(7000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Success']")));

        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("makeWordAsVerified Completed");
    }
    public void glossaryFilter(String filterType) {
        log.info("glossaryFilter Started");
        try {
            new WebDriverWait(driver,Duration.ofMillis(7000)).until(ExpectedConditions.visibilityOfElementLocated(retriveLocators(wsglossary.get("filterClick"))));
            super.elementClick(retriveLocators(wsglossary.get("filterClick")));
            super.elementClick(retriveLocators(dynamicXpathGenerator(wsglossary.get("setFilter"),filterType)));

        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryFilter Completed");
    }
    public void glossaryWordVerify(String word) {
        log.info("checking glossary word verified or unverified Started");
        try {
            new WebDriverWait(driver,Duration.ofMillis(7000)).until(ExpectedConditions.visibilityOfElementLocated(retriveLocators(dynamicXpathGenerator(wsglossary.get("verifiedWord"),word))));
            super.isElementVisible(retriveLocators(dynamicXpathGenerator(wsglossary.get("filterClick"),word)));

        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("checking glossary word verified or unverified Completed");
    }

    public void VerifyAllGlossaryWords(String type) {
        log.info("verifying all glossary words are verified or unverified Started");
        try {
            new WebDriverWait(driver,Duration.ofMillis(7000)).until(ExpectedConditions.visibilityOfElementLocated(retriveLocators(wsglossary.get("saveChangesBtn"))));
            if (type.equals("verified")) {
                Boolean b = super.isElementVisible(retriveLocators(wsglossary.get("verify")));
                super.assertResultWithMsg(true, b,"all the words in glossary are unVerified");
            } else if (type.contains("unverified")) {
                Boolean b = super.isElementVisible(retriveLocators(wsglossary.get("Unverify")));
                super.assertResultWithMsg(true,b,"all the words in glossary are unVerified");
            }else {
                System.out.println("please check verified type or glossary words not verified");
            }

        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("verifying all glossary words are verified or unverified Completed");
    }

}
