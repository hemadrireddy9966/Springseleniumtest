package com.example.VitraAi.steps;


import com.example.VitraAi.cache.Cache;
import com.example.VitraAi.pageactions.*;
import io.cucumber.java8.En;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class WsTnsGlossarySteps extends Cache implements En {

    WsTnsLoginPage wst = super.getWsTns();
    WsTnsRback r = super.getWsRbck();
    WsTnsCommonMethods c=super.getWsCommon();
    WsTnsGlossary g=super.getGlossary();

    websiteGlossary wg=super.getWebsiteGlossary();


    public WsTnsGlossarySteps(WebDriver driver) {
        super(driver);
        When("User should be to verify default glossary created with {string} name", (String teamName) -> {
            c.customTeamSelectAndNavigateToDashBoard(teamName);
            c.navigatingToGlossary();
            c.glossaryFileSearch(teamName);
            g.glossaryFileVerifyInGlossaryTab(teamName);
        });

        When("user should be able create a new {string} with {string}", (String glossaryName, String description) -> {
            g.CreateGlossary(glossaryName,description);
            g.glossaryCreatedSuccessNotificationVerify();
            g.glossaryFileVerifyInGlossaryTab(glossaryName);
        });

        When("user should able to open newly created {string}", (String glossaryName) -> {
            g.openGlossary(glossaryName);
        });

        Then("{string} and {string} and lamguages should be disabled", (String importbtn, String export) -> {

        });

        When("user should be able create a new {string} with {string} in {string} Team", (String glossaryName, String description, String teamName) -> {
            c.customTeamSelectAndNavigateToDashBoard(teamName);
            c.navigatingToGlossary();
            g.CreateGlossary(glossaryName,description);
            g.glossaryCreatedSuccessNotificationVerify();
            g.glossaryFileVerifyInGlossaryTab(glossaryName);
        });
        When("user should be able create a new {string} with {string} in Owner {string}", (String glossaryName, String description, String teamName) -> {
            c.customTeamSelectAndNavigateToDashBoard(teamName);
            c.navigatingToGlossary();
            g.CreateGlossary(glossaryName,description);
            g.glossaryCreatedSuccessNotificationVerify();
            g.glossaryFileVerifyInGlossaryTab(glossaryName);
        });
        And("{string} created by should be team member name {string}", (String glossaryName,String createdByName ) -> {
            g.verifyGlossaryCreatedBy(createdByName,glossaryName);
        });

        When("user should able to Edit {string} and update glossary {string}", (String glossaryName,String updateName) -> {
            g.glossaryEdit(glossaryName,updateName);
            g.glossaryUpdateSuccessNotificationVerify();
        });

        Then("he should be able to verify edited glossary file {string} in glossary's Tab", (String glossaryUpdateName) -> {
           g.glossaryFileVerifyInGlossaryTab(glossaryUpdateName);
        });
        When("user should be able to delete a {string} file in {string} Team", (String glossaryName, String teamName) -> {
            c.customTeamSelectAndNavigateToDashBoard(teamName);
            c.navigatingToGlossary();
            c.glossaryFileSearch(glossaryName);
            g.glossaryDelete(glossaryName);
            g.glossaryDeletedSuccessNotificationVerify();
        });

        Then("deleted {string} file should not exits in glossary's Tab", (String glossaryName) -> {
           g.verifyGlossaryFileNotExits(glossaryName);
        });
        When("user should be able to select {string} in {string} file in {string} Team", (String langName, String glossaryName, String teamName) -> {
            c.customTeamSelectAndNavigateToDashBoard(teamName);
            c.navigatingToGlossary();
            Thread.sleep(2000);
            c.glossaryFileSearch(glossaryName);
            Thread.sleep(2000);
            g.openGlossary(glossaryName);
            wg.languageSwitchAndSelectInGlossarys(langName);
        });

        When("user should be able to import a glossary {string} with all glossary words should be {string}", (String filepath,String verify) -> {
           wg.importGlossaryFile(filepath,verify);
        });

        Then("he should be to verify his all glossary words should be {string}", (String type) -> {
           wg.VerifyAllGlossaryWords(type);
        });
        Then("user should be able to export a glossary file with {string} and {string}", (String type,String type2) -> {
          wg.exportGlossaryFile(type2);
          Thread.sleep(5000);
          wg.exportGlossaryFile(type);


        });
        And("user should be able to edit a {string} with {string} glossary file", (String actualWord,String updatedWord) -> {
          wg.glossaryWordsSearch(actualWord);
           wg.glossaryEditWord(actualWord,updatedWord);

        });

        Then("he should get his updated {string} in View tab", (String updatedWord) -> {
           String[] s= updatedWord.split(",");
           wg.glossaryTargetWordVerify(s[0],s[1]);
        });

        And("user should be able to make a glossary {string} verified", (String word) -> {
          wg.makeWordAsVerified(word);
        });
        And("user should be able to see his verified {string} after making a glossary filter {string}", (String word,String filter) -> {
           wg.glossaryFilter(filter);
           wg.glossaryWordVerify(word);
        });

    }
}
