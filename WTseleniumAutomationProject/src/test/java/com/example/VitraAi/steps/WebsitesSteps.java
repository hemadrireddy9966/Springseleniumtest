package com.example.VitraAi.steps;


import com.example.VitraAi.cache.Cache;
import com.example.VitraAi.pageactions.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.An;
import io.cucumber.java8.En;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class WebsitesSteps extends Cache implements En {

    WsTnsLoginPage wst = super.getWsTns();
    WsTnsRback r = super.getWsRbck();
    WsTnsCommonMethods c=super.getWsCommon();
    WsTnsGlossary g=super.getGlossary();
    WebSitesTab website=super.getWebsite();


    public WebsitesSteps(WebDriver driver) {
        super(driver);

        When("User should be able to create a {string} with {string} and {string} in {string} Team", (String websiteName, String websiteTech,String websiteType,String teamName) -> {
            c.customTeamSelectAndNavigateToDashBoard(teamName);
            c.navigatingToWebsites();
            website.createNewWebSite(websiteName,websiteTech,websiteType);
            website.websiteCreatedSuccessNotifi();
//            website.websiteOpen(websiteName); //commented no need

        });

        When("he should be able to verify created {string} in website's Tab", (String websiteName) -> {
          website.websiteNameVerifyInWebsiteTab(websiteName);
        });

        When("he should able to open newly created {string}", (String webSiteName) -> {
            website.websiteOpen(webSiteName);
        });

        And("Verify OnDemand TT should be {string} and website type {string} and websitesName should be {string}", (String ondemondName, String websiteType, String websiteName) -> {
           website.websiteNameVerifyInSetUp(websiteName);
           website.websiteOnDemondTTVerifyInSetUp(ondemondName);
           website.websiteTypeVerifyInSetUp(websiteType);
        });
        Then("verify Domain Name should be {string} and source language Name should be {string} for the current {string} in Website's Tab", (String domainName, String sourceLang,String websiteName) -> {
           c.navigatingToWebsites();
           website.websiteSearchInWebsitesTab(websiteName);
           website.websiteDomainVerifyInWebsitesTab(websiteName,domainName);
           website.websiteSourceLanguageVerifyInWebsitesTab(websiteName,sourceLang);
        });
        And("he should able to generate Site map {string} in {string}", (String url, String websiteName) -> {
            website.websiteOpen(websiteName);
           website.generateSiteMap(url);
        });

        Then("Verify site map generated success notification", () -> {
//            website.generateSitemapSuccessNotifi();
        });
        And("he should able set {string} language and {string} language and glossary {string} for the current {string}", (String source, String target, String glossaryName, String websiteName) -> {
//            if () {
//                c.customTeamSelectAndNavigateToDashBoard("Selenium automation testing");
//                c.navigatingToWebsites();
//                website.websiteOpen(websiteName);
//                website.setUpSourceAndTargetLanguage(source, target);
//                website.glossarySelectInSetUp(glossaryName);
//                website.nextStepButton();
//            }else
                c.navigatingToWebsites();
                website.websiteOpen(websiteName);
                website.setUpSourceAndTargetLanguage(source,target);
                website.glossarySelectInSetUp(glossaryName);
                website.nextStepButton();
        });

        And("he should able to fill set Integration Configuration details", ( DataTable dataTable) -> {
               website.SetIntegrationConfiguration(dataTable);
               website.nextStepButton();
        });

        And("he should be get Vitra Snippet code", () -> {
              website.snippetCodeVerify();
        });

        Then("he should able to verify his Domain {string} and {string} language in Websites' tab for current {string}", (String domainurl, String sourcelang, String websiteName) -> {
            c.navigatingToWebsites();
            website.websiteSearchInWebsitesTab(websiteName);
            website.websiteDomainVerifyInWebsitesTab(websiteName,domainurl);
            website.websiteSourceLanguageVerifyInWebsitesTab(websiteName,sourcelang);
        });
        And("he should able set {string} language and {string} language for the current {string}", (String source,String target,String websiteName) ->{
            website.websiteOpen(websiteName);
            website.setUpSourceAndTargetLanguage(source,target);
        });
        And("he should able to create a glossary and select created glossary file in website setup", (DataTable dataTable) ->{
            website.OnFlayGlossaryCreateInSetup(dataTable);

        });
        And("he should be able to delete the website", () ->{
            website.deleteWebsite();
            website.WebsiteDeleteNotifi();
        });

        Given("User fills the wp-admin Login Page {string} and {string}", (String userName, String password) -> {
            website.site2ReachabiltyWpLogin(userName,password);
        });

        When("User should be able open snippet codes", () -> {
            website.navigatingToSnippetCode();
        });

        Then("he should be able to add snippet code with {string}", (String snippetTitle) -> {
            website.addingSnippetCode(snippetTitle);
        });
        Given("User opens site2 {string}", (String string) -> {
            website.verifyLanguageSwitchDropDownInSite();
        });

        When("User should be able to verify vitra language switch drop down", () -> {
            website.verifyLanguageSwitchDropDownInSite();

        });

        Then("he should be able to get his website with {string} language", (String languageName) -> {
            website.languageClickInSite(languageName);
        });

    }
}
