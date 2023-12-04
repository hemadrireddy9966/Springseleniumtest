package com.example.VitraAi.pageactions;



import com.example.VitraAi.actions.commands.Common;
import com.example.VitraAi.pageobject.PageObjectsFactory;
import com.example.VitraAi.steps.BeforeTag;
import io.cucumber.core.gherkin.Step;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.Map;


@Slf4j
public class WebSitesTab extends Common {
    private final Map<String, String> ws = super.readPropertiesFile(PageObjectsFactory.websites);
    private final Map<String, String> glossary = super.readPropertiesFile(PageObjectsFactory.glossary);
    private final Map<String, String> wpadmin = super.readPropertiesFile(PageObjectsFactory.wpaddmin);
    public static String snippetToken=null;
    public static String glossaryToken=null;

    public WebSitesTab(WebDriver driver) {super(driver);}
    public void createNewWebSite(String websiteName, String websiteTech, String websiteType) {
        log.info("createNewWebSite Started");
        try {
            new WebDriverWait(driver,Duration.ofMillis(6000L)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='WEBSITES']")));
            boolean b=isElementVisible(retriveLocators(ws.get("createNewWebsitebtn")));
         if (!b){
             new WebDriverWait(driver,Duration.ofMillis(6000L)).until(ExpectedConditions.elementToBeClickable(retriveLocators(ws.get("initialCreateNewWebsitebtn"))));
             super.elementClick(retriveLocators(ws.get("initialCreateNewWebsitebtn")));
         }else {
             new WebDriverWait(driver,Duration.ofMillis(6000L)).until(ExpectedConditions.elementToBeClickable(retriveLocators(ws.get("createNewWebsitebtn"))));
             super.elementClick(retriveLocators(ws.get("createNewWebsitebtn")));
         }
            super.waitForTheElement(retriveLocators(ws.get("websiteCreateNametxb")),CLICKABILITY_OF_ELEMENT_LOCATED);
            super.enterText(ws.get("websiteCreateNametxb"), websiteName);
            Thread.sleep(2000);
//            super.enterText(ws.get("websitetechSelect"),websiteTech);
//            super.elementClick(retriveLocators(dynamicXpathGenerator(ws.get("websiteTypetechSelect"),websiteTech)));
            super.elementClick(retriveLocators(ws.get("websitetechSelect")));
            driver.findElement(retriveLocators(ws.get("websitetechSelect"))).sendKeys(websiteTech+Keys.ENTER);
//            super.enterText(ws.get("websiteType"),websiteType);
            super.elementClick(retriveLocators(ws.get("websiteType")));
            driver.findElement(retriveLocators(ws.get("websiteType"))).sendKeys(websiteType+Keys.ENTER);
//            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(ws.get("websiteTypetechSelect"),websiteType)),CLICKABILITY_OF_ELEMENT_LOCATED);
//            super.elementClick(retriveLocators(dynamicXpathGenerator(ws.get("websiteTypetechSelect"),websiteType)));
            super.elementClick(retriveLocators(ws.get("createNewWebsite")));


        } catch (Exception e) {

            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("createNewWebSite Completed");
    }
    public void websiteCreatedSuccessNotifi() {
        log.info("websiteCreatedSuccessNotification Started");
        try {
            super.waitForTheElement(retriveLocators(ws.get("websiteCreatedSuccessnotifi")),VISIBILITY_OF_ELEMENT_LOCATED);
          boolean check=super.isElementVisible(retriveLocators(ws.get("websiteCreatedSuccessnotifi")));
            super.assertResult(true,check);
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("websiteCreatedSuccessNotification Completed");
    }

    public void websiteNameVerifyInWebsiteTab(String websiteName) {
        log.info("websiteNameVerifyInWebsiteTab Started");
        try {
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(ws.get("websiteSelect"),websiteName)),VISIBILITY_OF_ELEMENT_LOCATED);
            super.isTextVisible(retriveLocators(dynamicXpathGenerator(ws.get("websiteSelect"),websiteName)),websiteName);
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("websiteNameVerifyInWebsiteTab Completed");
    }
    public void VerifyWebsiteNameNotExits(String websiteName) {
        log.info("VerifyWebsiteNameNotExits Started");
        try {
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(ws.get("websiteSelect"),websiteName)),VISIBILITY_OF_ELEMENT_LOCATED);
            super.isElementNotVisible(retriveLocators(dynamicXpathGenerator(ws.get("websiteSelect"),websiteName)));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("VerifyWebsiteNameNotExits Completed");
    }
    public void websiteSearchInWebsitesTab(String websiteName){
        log.info("websiteSearchInWebsitesTab Started");
        try{
            super.waitForPageToBeReady();
            super.enterText(ws.get("websiteSearchbar"),websiteName);
            driver.findElement(retriveLocators(ws.get("websiteSearchbar"))).sendKeys( Keys.ENTER);
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("websiteSearchInWebsitesTab Completed");
    }
    public void websiteOpen(String websiteName){
        log.info("websiteOpen Started");
        try{
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(ws.get("websiteSelect"),websiteName)),CLICKABILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(dynamicXpathGenerator(ws.get("websiteSelect"),websiteName)));
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("websiteOpen Completed");
    }
    public void deleteWebsite(){
        log.info("deleteWebsite Started");
        try{
            super.waitForTheElement(retriveLocators(ws.get("deleteWebSitesbtn")),CLICKABILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(ws.get("deleteWebSitesbtn")));
            super.waitForTheElement(retriveLocators(ws.get("deletebtn")),CLICKABILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(ws.get("deletebtn")));
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("deleteWebsite Completed");
    }
    public void WebsiteDeleteNotifi(){
        log.info("WebsiteDeleteNotifi Started");
        try{
            super.waitForTheElement(retriveLocators(ws.get("deleteSuccessnotifi")),VISIBILITY_OF_ELEMENT_LOCATED);
         super.isTextVisible(retriveLocators(ws.get("deleteSuccessnotifi")),"Website deleted successfully");

        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("WebsiteDeleteNotifi Completed");
    }
    public void generateSiteMap(String url){
        log.info("generateSiteMap Started");
        try{
            super.waitForTheElement(retriveLocators(ws.get("generateSitemapbtn")),CLICKABILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(ws.get("generateSitemapbtn")));
            super.waitForTheElement(retriveLocators(ws.get("generateSitemaptxb")),CLICKABILITY_OF_ELEMENT_LOCATED);
            super.enterText(ws.get("generateSitemaptxb"),url);
            super.elementClick(retriveLocators(ws.get("generateSitemap")));
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("generateSiteMap Completed");
    }
    public void generateSitemapSuccessNotifi(){
        log.info("generateSitemapSuccessNotifi Started");
        try{
            new WebDriverWait(driver,Duration.ofMillis(6000L)).until(ExpectedConditions.presenceOfElementLocated(retriveLocators(ws.get("generateSitemapSuccessnotifi"))));
            super.isTextVisible(retriveLocators(ws.get("generateSitemapSuccessnotifi")),"Sitemap generation request received");

        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("generateSitemapSuccessNotifi Completed");
    }
    public void boostTranslation(){
        log.info("boostTranslation Started");
        try{
            super.waitForTheElement(retriveLocators(ws.get("boostTranslationbtn")),CLICKABILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(ws.get("boostTranslationbtn")));
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("boostTranslation Completed");
    }
    public void boostTranslationSuccessNotifi(){
        log.info("boostTranslationSuccessNotifi Started");
        try{
            super.waitForTheElement(retriveLocators(ws.get("boostTranslationSuccessnotifi")),VISIBILITY_OF_ELEMENT_LOCATED);
            boolean check=super.isElementVisible(retriveLocators(ws.get("boostTranslationSuccessnotifi")));
            super.assertResult(true,check);
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("boostTranslationSuccessNotifi Completed");
    }
    public void websiteNameVerifyInSetUp(String websitename){
        log.info("websiteNameVerifyInSetUp Started");
        try{
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(ws.get("websitenameverify"),websitename)),VISIBILITY_OF_ELEMENT_LOCATED);
            boolean check=super.isElementVisible(retriveLocators(dynamicXpathGenerator(ws.get("websitenameverify"),websitename)));
            super.assertResult(true,check);
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("websiteNameVerifyInSetUp Completed");
    }
    public void websiteTypeVerifyInSetUp(String webType){
        log.info("websiteTypeVerifyInSetUp Started");
        try{
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(ws.get("websiteTypeverify"),webType)),VISIBILITY_OF_ELEMENT_LOCATED);
            super.isTextVisible(retriveLocators(dynamicXpathGenerator(ws.get("websiteTypeverify"),webType)),webType);

        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("websiteTypeVerifyInSetUp Completed");
    }
    public void websiteOnDemondTTVerifyInSetUp(String onDemondType){
        log.info("websiteOnDemondTTVerifyInSetUp Started");
        try{
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(ws.get("onDemend"),onDemondType)),VISIBILITY_OF_ELEMENT_LOCATED);
            super.isTextVisible(retriveLocators(dynamicXpathGenerator(ws.get("onDemend"),onDemondType)),onDemondType);
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("websiteOnDemondTTVerifyInSetUp Completed");
    }
    public void websiteDomainVerifyInWebsitesTab(String websiteName,String domainName){
        log.info("websiteDomainVerifyInWebsitesTab Started");
        try{
            String s=websiteName+","+domainName;
            super.waitForTheElement(retriveLocators(multipleDynamicValueXpathGen(ws.get("websiteDomain"),s)),VISIBILITY_OF_ELEMENT_LOCATED);
            super.isTextVisible(retriveLocators(multipleDynamicValueXpathGen(ws.get("websiteDomain"),s)),domainName);
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("websiteDomainVerifyInWebsitesTab Completed");
    }
    public void websiteSourceLanguageVerifyInWebsitesTab(String websiteName,String sourceLangName){
        log.info("websiteSourceLanguageVerifyInWebsitesTab Started");
        try{
            String s=websiteName+","+sourceLangName;
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(ws.get("websiteSource"),websiteName)),VISIBILITY_OF_ELEMENT_LOCATED);
            super.isTextVisible(retriveLocators(dynamicXpathGenerator(ws.get("websiteSource"),websiteName)),sourceLangName);
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("websiteSourceLanguageVerifyInWebsitesTab Completed");
    }
    public void enteringDomainUrl(String urlName){
        log.info("enteringDomainUrl in set config Started");
        try{
            super.waitForTheElement(retriveLocators((ws.get("Domainurl"))),CLICKABILITY_OF_ELEMENT_LOCATED);
            super.enterKeysWithString(retriveLocators(ws.get("Domainurl")),urlName);
            super.elementClick(retriveLocators(ws.get("configureSSR")));
            WebElement element = (new WebDriverWait(driver, Duration.ofMillis(20000)))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='/*']")));
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("enteringDomainUrl in set config Completed");
    }
    public void directoriesAndOnDemandLimit(String toggleType){
        log.info("directoriesAndOnDemandLimit Started");
        try{
          if (toggleType.equalsIgnoreCase("Enabled")){
              boolean check=super.isElementVisible(retriveLocators(ws.get("onDemandlimitEnabledAndDisable")));
              if (check)
                  super.elementClick(retriveLocators(ws.get("onDemondlimitTxb")));
                  driver.findElement(retriveLocators(ws.get("onDemondlimitTxb"))).clear();
                  driver.findElement(retriveLocators(ws.get("onDemondlimitTxb"))).sendKeys("5");

                 System.out.println("OnDemandTranslation limit is Enabled");
          }else {
              super.elementClick(retriveLocators(ws.get("onDemandlimitTogglebtn")));
              boolean check=super.isElementVisible(retriveLocators(ws.get("onDemandlimitEnabledAndDisable")));
              if (!check)
                 System.out.println("OnDemandTranslation limit is Disabled");
          }
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("directoriesAndOnDemandLimit Completed");
    }
    public void OnDemandTranslationToggle(String toggleType){
        log.info("OnDemandTranslationToggle Started");
        try{
//          boolean check=super.isElementVisible(retriveLocators(ws.get("onDemandlimitEnabledAndDisable")));
          if (toggleType.equalsIgnoreCase("Enabled")){
              boolean check=super.isElementVisible(retriveLocators(ws.get("onDemendTranslationEnabledAndDisable")));
              if (check)
                System.out.println("OnDemandTranslation  is Enabled");
          }else {
              super.elementClick(retriveLocators(ws.get("onDemendTranslation")));
              boolean check=super.isElementVisible(retriveLocators(ws.get("onDemendTranslationEnabledAndDisable")));
              if (!check)
                System.out.println("OnDemandTranslation  is Disabled");
          }
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("OnDemandTranslationToggle Completed");
    }
    public void showFlagToggle(String toggleType){
        log.info("showFlagToggle Started");
        try{

//          boolean check=super.isElementVisible(retriveLocators(ws.get("onDemandlimitEnabledAndDisable")));
          if (toggleType.equalsIgnoreCase("Enabled")){
              boolean check=super.isElementVisible(retriveLocators(ws.get("showFlagEnabledAndDisable")));
              if (check)
                System.out.println("showFlagToggle  is Enabled");
          }else {
              super.elementClick(retriveLocators(ws.get("showFlag")));
              boolean check=super.isElementVisible(retriveLocators(ws.get("showFlagEnabledAndDisable")));
               if (!check)
                 System.out.println("showFlagToggle  is Disabled");
          }
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("showFlagToggle Completed");
    }
    public void googleAnalyticsToggle(String toggleType){
        log.info("googleAnalyticsToggle Started");
        try{
//          boolean check=super.isElementVisible(retriveLocators(ws.get("onDemandlimitEnabledAndDisable")));
          if (toggleType.equalsIgnoreCase("Disable")){
              boolean check=super.isElementVisible(retriveLocators(ws.get("googleAnalyticsEnabledAndDisable")));
              if (check)
                System.out.println("googleAnalyticsToggle  is disabled");
          }else {
              super.elementClick(retriveLocators(ws.get("googleAnalyticstoggle")));
              boolean check=super.isElementVisible(retriveLocators(ws.get("googleAnalyticsEnabledAndDisable")));
               if (check)
                 System.out.println("googleAnalyticsToggle  is enabled");
          }
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("googleAnalyticsToggle Completed");
    }
    public void SetIntegrationConfiguration(DataTable dataTable){
        log.info("SetIntegrationConfiguration Started");
        try{
            List<Map<String, String>> requests = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> eachRequest : requests){
//                addPersona(eachRequest.get("Persona"), i);
                enteringDomainUrl(eachRequest.get("Domain url"));
                directoriesAndOnDemandLimit(eachRequest.get("OnDemand translationLimit"));
                OnDemandTranslationToggle(eachRequest.get("OnDemand translation"));
                showFlagToggle(eachRequest.get("Show Flag"));
                googleAnalyticsToggle(eachRequest.get("Google Analytics"));
            }

        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("SetIntegrationConfiguration Completed");
    }

        public  void StoreCodeFromClipboard() {
            // Get the system clipboard
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // Check if the clipboard contains string data
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                try {
                    // Get the string data from the clipboard
                    String code = (String) clipboard.getData(DataFlavor.stringFlavor);

                    // Store the code in a file
                    try (FileWriter fileWriter = new FileWriter("src/test/resources/uploadResource/stored_code.java")) {
                        fileWriter.write(code);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Code retrieved from clipboard and stored in 'stored_code.java'");
                } catch (UnsupportedFlavorException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    public void snippetCodeVerify(){
        log.info("Vitra snippetCodeVerify Started");
        try{
          waitForTheElement(retriveLocators(ws.get("vitraSnippetcheck")),VISIBILITY_OF_ELEMENT_LOCATED);
          assertResult(true,isElementVisible(retriveLocators(ws.get("vitraSnippetcheck"))));
           super.elementClick(retriveLocators(ws.get("vitraSnippetCopyButton")));
          snippetToken= super.getText(By.xpath("//span[text()='api_key']/following-sibling::span[@class='token token']"));
          glossaryToken=super.getText(By.xpath("//span[text()='glossaryId']/following-sibling::span[@class='token token']"));
          super.writeToFile(snippetToken,"src/test/resources/uploadResource/snippetToken.txt");
          super.writeToFile(glossaryToken,"src/test/resources/uploadResource/glossaryToken.txt");
//            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//
//            // Get the clipboard's contents as a Transferable object
//            Transferable transferable = clipboard.getContents(null);
//
//            // Check if the clipboard contains text data
//            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
//                // Get the text data from the clipboard as a String
//                 snippet = (String) transferable.getTransferData(DataFlavor.stringFlavor);
//
//                // Print the clipboard text
//                System.out.println("Clipboard Text: " + snippet);

                // Now you can use clipboardText as a String variable
//            } else {
//                System.out.println("Clipboard does not contain text data.");
//            }
            StoreCodeFromClipboard();
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("vitra snippetCodeVerify Completed");
    }
    public void printTargetLanguagesInConsole(String source,String target){
        log.info("printTargetLanguagesInConsole Started");
        try{
          waitForTheElement(retriveLocators(ws.get("sourcelang")),VISIBILITY_OF_ELEMENT_LOCATED);
          super.enterText(ws.get("sourcelang"),source);
          super.clickUsingAction(retriveLocators(dynamicXpathGenerator(ws.get("languageselect"),source)));
          waitForTheElement(retriveLocators(ws.get("targetlang")),VISIBILITY_OF_ELEMENT_LOCATED);
//          super.enterText(ws.get("targetlang"),target);
          super.elementClick(retriveLocators(ws.get("targetlang")));
//          super.clickUsingAction(retriveLocators(dynamicXpathGenerator(ws.get("languageselect"),target)));
//          waitForTheElement(retriveLocators(ws.get("selectGlossary")),VISIBILITY_OF_ELEMENT_LOCATED);


            List<WebElement> to = driver.findElements(By.xpath("//img/parent::div[@title]"));

             for (WebElement uo:to){
                 String i = uo.getAttribute("title");
                 System.out.println(i);
             }

        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("printTargetLanguagesInConsole Completed");
    }
    public void setUpSourceAndTargetLanguage(String source,String target){
        log.info("setUpSourceAndTargetLanguage Started");
        try{
          waitForTheElement(retriveLocators(ws.get("sourcelang")),VISIBILITY_OF_ELEMENT_LOCATED);
          super.enterText(ws.get("sourcelang"),source);
          super.clickUsingAction(retriveLocators(dynamicXpathGenerator(ws.get("languageselect"),source)));
          waitForTheElement(retriveLocators(ws.get("targetlang")),VISIBILITY_OF_ELEMENT_LOCATED);
          super.enterText(ws.get("targetlang"),target);
          super.clickUsingAction(retriveLocators(dynamicXpathGenerator(ws.get("languageselect"),target)));
          waitForTheElement(retriveLocators(ws.get("selectGlossary")),VISIBILITY_OF_ELEMENT_LOCATED);
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("setUpSourceAndTargetLanguage Completed");
    }
    public void glossarySelectInSetUp(String glossaryName){
        log.info("setUpSourceAndTargetLanguage Started");
        try{
            Thread.sleep(2000);
          waitForTheElement(retriveLocators(ws.get("selectGlossary")),CLICKABILITY_OF_ELEMENT_LOCATED);
          Thread.sleep(5000);
          driver.findElement(retriveLocators(ws.get("selectGlossary"))).click();
          driver.findElement(retriveLocators(ws.get("selectGlossary"))).sendKeys(glossaryName+Keys.ENTER);

//          super.enterText(ws.get("selectGlossary"), glossaryName);
//          super.clickUsingAction(retriveLocators(dynamicXpathGenerator(ws.get("glossaryselect"), glossaryName)));

        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("setUpSourceAndTargetLanguage Completed");
    }
    public void nextStepButton(){
        log.info("nextButton Started");
        try{
           if (!isElementVisible(retriveLocators(ws.get("nextStep")))){
               super.scroll(retriveLocators(ws.get("nextStep")));
           }

            waitForTheElement(retriveLocators(ws.get("nextStep")),CLICKABILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(ws.get("nextStep")));
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("nextButton Completed");
    }
    public void previousStepButton(){
        log.info("previousStepButton Started");
        try{
            waitForTheElement(retriveLocators(ws.get("previousBtn")),VISIBILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(ws.get("previousBtn")));
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("previousStepButton Completed");
    }
    public void OnFlayGlossaryCreateInSetup(DataTable dataTable){
        log.info("OnFlayGlossaryCreateInSetup Started");
        try{
            List<Map<String, String>> requests = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> eachRequest : requests){
            waitForTheElement(retriveLocators(ws.get("glossarycreatebutton")),VISIBILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(ws.get("glossarycreatebutton")));
            super.waitForTheElement(retriveLocators(glossary.get("createNewGlossarybtn")),"CLICKABILITY_OF_ELEMENT_LOCATED");
            super.enterText(glossary.get("glossarynametxb"),eachRequest.get("GlossaryName"));
            super.enterText(glossary.get("glossarydescription"),eachRequest.get("Glossary Description"));
            super.elementClick(retriveLocators(glossary.get("createglossarybtn")));
            waitForTheElement(retriveLocators(glossary.get("glossarysuccessnotifi")),VISIBILITY_OF_ELEMENT_LOCATED);
            waitForTheElement(retriveLocators(glossary.get("glossarysuccessnotifi")),INVISIBILITY_OF_ELEMENT);
            glossarySelectInSetUp(eachRequest.get("GlossaryName"));
            }
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("OnFlayGlossaryCreateInSetup Completed");
    }
    public void site2ReachabiltyWpLogin(String username,String password){
        log.info("site2ReachabiltyWpLogin Started");
        try{

            super.waitForTheElement(retriveLocators(wpadmin.get("userName")),VISIBILITY_OF_ELEMENT_LOCATED);
            super.enterText(wpadmin.get("userName"),username);
            super.enterText(wpadmin.get("password"),password);
            super.elementClick(retriveLocators(wpadmin.get("loginIn")));

        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("site2ReachabiltyWpLogin Completed");
    }
    public void navigatingToSnippetCode(){
        log.info("navigatingToSnippetCode Started");
        try{
            super.waitForTheElement(retriveLocators(wpadmin.get("WPCode")),VISIBILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(wpadmin.get("WPCode")));
            waitForTheElement(retriveLocators(wpadmin.get("addNew")),VISIBILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(wpadmin.get("addNew")));
//            super.elementClick(retriveLocators(wpadmin.get("addNew1")));//update snippet button click
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("navigatingToSnippetCode Completed");
    }
    public void addingSnippetCode(String title){
        log.info("addingSnippetCode Started");
        try{
            String fileName = "src/test/resources/uploadResource/stored_code.java"; // Replace with the actual file path
              String str= super.readFromFile("src/test/resources/uploadResource/snippetToken.txt");
              String glossarytoken= super.readFromFile("src/test/resources/uploadResource/glossaryToken.txt");
            // Read the code from the stored file and store it in a string
// ***********************************this commented bcz this code will not work in headless mode***********************
//            StringBuilder codeStringBuilder = new StringBuilder();
//            BufferedReader reader = null;
//            try {
//                reader = new BufferedReader(new FileReader(new File(fileName)));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    codeStringBuilder.append(line).append("\n");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            String storedCode = codeStringBuilder.toString();
//                  String snippetCode =storedCode.replace("/on-","/staging-on-").trim();
//            String snippetCode="testing";
//*******************************bcz system property's like clipboard will not access to get code and past using cntl+v in head less mode********************
            super.waitForTheElement(retriveLocators(wpadmin.get("useSnippet")),VISIBILITY_OF_ELEMENT_LOCATED);
            super.clickUsingAction(retriveLocators(wpadmin.get("useSnippet")));
            waitForTheElement(retriveLocators(wpadmin.get("snippetTitle")),VISIBILITY_OF_ELEMENT_LOCATED);
            super.enterTextUsingJS(retriveLocators(wpadmin.get("snippetTitle")),title);
            Thread.sleep(3000);
//            System.out.println("snippetcode:-"+storedCode);

            System.out.println("reddyHsnippetcode:-"+str);
            super.clickUsingJSexe(retriveLocators(wpadmin.get("codepreviewtxb")));
//            Thread.sleep(3000);
//            super.enterTextUsingJS(retriveLocators(wpadmin.get("codepreviewtxb")),snippetCode);
            super.snippetEnterText(wpadmin.get("codepreviewtxb"),fileName,str,glossarytoken);
            Thread.sleep(3000);
            super.elementClick(retriveLocators(wpadmin.get("inactive")));
            super.elementClick(retriveLocators(wpadmin.get("saveSnippet1")));
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("addingSnippetCode Completed");
    }
    public void verifyLanguageSwitchDropDownInSite(){
        log.info("verifyLanguageSwitchDropDownInSite Started");
        try{
            Thread.sleep(10000);
            new WebDriverWait(driver, Duration.ofMillis(6000L)).until(ExpectedConditions.elementToBeClickable(retriveLocators(ws.get("vitraLanguageButton"))));
            super.elementClick(retriveLocators(ws.get("vitraLanguageButton")));
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("verifyLanguageSwitchDropDownInSite Completed");
    }
    public void verifyLanguagesVitraDropDownInSite(String languageName){
        log.info("verifyLanguagesVitraDropDownInSite Started");
        try{
            String[] langName=languageName.split(",");
            if (langName.length>1) {
                for (int i = 0; i < langName.length; i++) {
                    new WebDriverWait(driver, Duration.ofMillis(6000L)).until(ExpectedConditions.visibilityOfElementLocated(retriveLocators(dynamicXpathGenerator(ws.get("languageSelect"),languageName))));
                    String s = super.getText(retriveLocators(dynamicXpathGenerator(ws.get("languageSelect"), langName[i])));
                    super.textAssertions(langName[i], s);
                }
            }else {
                new WebDriverWait(driver, Duration.ofMillis(6000L)).until(ExpectedConditions.visibilityOfElementLocated(retriveLocators(dynamicXpathGenerator(ws.get("languageSelect"),languageName))));
                String s = super.getText(retriveLocators(dynamicXpathGenerator(ws.get("languageSelect"),languageName)));
                super.textAssertions(languageName, s);
            }
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("verifyLanguagesVitraDropDownInSite Completed");
    }
    public void languageClickInSite(String languageName){
        log.info("languageClickInSite Started");
        try{
            new WebDriverWait(driver, Duration.ofMillis(6000L)).until(ExpectedConditions.elementToBeClickable(retriveLocators(dynamicXpathGenerator(ws.get("languageSelect"),languageName))));
            super.elementClick(retriveLocators(dynamicXpathGenerator(ws.get("languageSelect"),languageName)));
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
        log.info("languageClickInSite Completed");
    }
}
