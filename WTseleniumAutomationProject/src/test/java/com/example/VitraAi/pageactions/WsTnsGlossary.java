package com.example.VitraAi.pageactions;



import com.example.VitraAi.actions.commands.Common;
import com.example.VitraAi.pageobject.PageObjectsFactory;
import com.example.VitraAi.steps.BeforeTag;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;


@Slf4j
public class WsTnsGlossary extends Common {
    private final Map<String, String> glossary = super.readPropertiesFile(PageObjectsFactory.glossary);
    private final Map<String, String> rbck = super.readPropertiesFile(PageObjectsFactory.rbck);

    public WsTnsGlossary(WebDriver driver) {super(driver);}

    public void navigatingToGlossaryTabWithTeamName(String teamName) {
        log.info("navigatingToGlossaryTabWithTeamName Started");
        try {
            super.elementClick(retriveLocators(dynamicXpathGenerator(rbck.get("teamSelect"),teamName)));
            super.waitForTheElement(retriveLocators(glossary.get("glossarybtn")),"CLICKABILITY_OF_ELEMENT_LOCATED");
            super.elementClick(retriveLocators(glossary.get("glossarybtn")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("navigatingToGlossaryTabWithTeamName Completed");
    }

    public void openGlossary(String glossaryName) {
        log.info("glossaryFileOpenInGlossaryTab Started");
        try {
//            super.waitTillProductLoadingImageLoaded();
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(glossary.get("glossarySelect"),glossaryName)),"CLICKABILITY_OF_ELEMENT_LOCATED");
            super.elementClick(retriveLocators(dynamicXpathGenerator(glossary.get("glossarySelect"),glossaryName)));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryFileOpenInGlossaryTab Completed");
    }
    public void CreateGlossary(String glossaryName,String glossaryDescription) {
        log.info("CreateGlossary Started");
        try {
            super.waitForTheElement(retriveLocators(glossary.get("createNewGlossarybtn")),"CLICKABILITY_OF_ELEMENT_LOCATED");
            super.elementClick(retriveLocators(glossary.get("createNewGlossarybtn")));
            super.enterText(glossary.get("glossarynametxb"),glossaryName);
            super.enterText(glossary.get("glossarydescription"),glossaryDescription);
            super.elementClick(retriveLocators(glossary.get("createglossarybtn")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("CreateGlossary Completed");
    }
    public void glossaryDelete(String glossaryName) {
        log.info("glossaryDelete Started");
        try {
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(glossary.get("glossarySelect"),glossaryName)),"CLICKABILITY_OF_ELEMENT_LOCATED");
            super.elementClick(retriveLocators(dynamicXpathGenerator(glossary.get("glossaryDeleteicon"),glossaryName)));
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(glossary.get("DeleteGlossary"),glossaryName)),VISIBILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(dynamicXpathGenerator(glossary.get("DeleteGlossary"),glossaryName)));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryDelete Completed");
    }
    public void glossaryCreatedSuccessNotificationVerify() {
        log.info("glossaryCreatedSuccessNotificationVerify Started");
        try {
            super.waitForTheElement(retriveLocators(glossary.get("glossarysuccessnotifi")),"CLICKABILITY_OF_ELEMENT_LOCATED");
            super.isElementVisible(retriveLocators(glossary.get("glossarysuccessnotifi")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryCreatedSuccessNotificationVerify Completed");
    }
    public void glossaryDeletedSuccessNotificationVerify() {
        log.info("glossaryDeletedSuccessNotificationVerify Started");
        try {
            super.waitForTheElement(retriveLocators(glossary.get("glossaryDeleteSuccessnotifi")),"CLICKABILITY_OF_ELEMENT_LOCATED");
            super.isElementVisible(retriveLocators(glossary.get("glossaryDeleteSuccessnotifi")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryDeletedSuccessNotificationVerify Completed");
    }
    public void glossaryUpdateSuccessNotificationVerify() {
        log.info("glossaryUpdateSuccessNotificationVerify Started");
        try {
            super.waitForTheElement(retriveLocators(glossary.get("glossaryupdatednotifi")),"CLICKABILITY_OF_ELEMENT_LOCATED");
            super.isElementVisible(retriveLocators(glossary.get("glossaryupdatednotifi")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryUpdateSuccessNotificationVerify Completed");
    }
    public void glossaryEdit(String glossaryName,String glosaaryupdateName) {
        log.info("glossaryEditing Started");
        try {
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(glossary.get("glossaryEditicon"),glossaryName)),"CLICKABILITY_OF_ELEMENT_LOCATED");
            super.elementClick(retriveLocators(dynamicXpathGenerator(glossary.get("glossaryEditicon"),glossaryName)));
            super.waitForTheElement(retriveLocators(glossary.get("glossarynametxb")),"CLICKABILITY_OF_ELEMENT_LOCATED");
            super.enterText(glossary.get("glossarynametxb"),glosaaryupdateName);
            super.elementClick(retriveLocators(glossary.get("updateGlossary")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryEditing Completed");
    }
    public void glossaryFileVerifyInGlossaryTab(String glossaryName) {
        log.info("glossaryFileVerifyInGlossaryTab Started");
        try {
//            super.waitTillProductLoadingImageLoaded();
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(glossary.get("glossarySelect"),glossaryName)),VISIBILITY_OF_ELEMENT_LOCATED);
            super.isTextVisible(retriveLocators(dynamicXpathGenerator(glossary.get("glossarySelect"),glossaryName)),glossaryName);

        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("glossaryFileVerifyInGlossaryTab Completed");
    }
    public void verifyGlossaryFileNotExits(String glossaryName) {
        log.info("verifyGlossaryFileNotExits Started");
        try {
            super.waitTillProductLoadingImageLoaded();
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(glossary.get("glossarySelect"),glossaryName)),VISIBILITY_OF_ELEMENT_LOCATED);
       boolean check=super.isElementVisible(retriveLocators(dynamicXpathGenerator(glossary.get("glossarySelect"),glossaryName)));
            super.assertResult(false,check);
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("verifyGlossaryFileNotExits Completed");
    }
    public void verifyGlossaryCreatedBy(String createdBy,String glossaryName) {
        log.info("verifyGlossaryCreatedBy in glossary's Tab Started");
        try {
            String actual=super.getText(retriveLocators(dynamicXpathGenerator(glossary.get("glossaryCreatedBy"),glossaryName)));
            super.textAssertions(createdBy,actual);
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("verifyGlossaryCreatedBy in glossary's Tab Started");
    }

}
