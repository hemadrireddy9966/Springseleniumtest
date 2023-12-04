package com.example.VitraAi.pageactions;



import com.example.VitraAi.actions.commands.Common;
import com.example.VitraAi.pageobject.PageObjectsFactory;
import com.example.VitraAi.steps.BeforeTag;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;


@Slf4j
public class WsTnsRback extends Common {
    private final Map<String, String> rbck = super.readPropertiesFile(PageObjectsFactory.rbck);

    public WsTnsRback(WebDriver driver) {super(driver);}
    public void createNewTeamIfNotExits(String teamName,String description) {
        log.info("createNewTeamIfNotExits Started");
        try {
           teamSearchInTeamsTab(teamName);
           Thread.sleep(5000);
          Boolean check=super.isElementVisible(retriveLocators(dynamicXpathGenerator(rbck.get("teamSelect"),teamName)));
          if(check==false){
              super.elementClick(retriveLocators(rbck.get("createteambtn")));
              super.waitForTheElement(retriveLocators(rbck.get("teamnametxb")),CLICKABILITY_OF_ELEMENT_LOCATED);
              super.enterText(rbck.get("teamnametxb"),teamName);
              super.enterText(rbck.get("teamdescription"),description);
              super.elementClick(retriveLocators(rbck.get("createNewteambtn")));
              super.waitForTheElement(retriveLocators(rbck.get("teamCreatedsuccessnotifi")),VISIBILITY_OF_ELEMENT_LOCATED);
              isElementVisible(retriveLocators(rbck.get("teamCreatedsuccessnotifi")));
          }else{
              System.out.println("team is already exits");
            }
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("createNewTeamIfNotExits Completed");
    }
    public void TeamVerifyInTeamsTab(String teamName) {
        log.info("TeamVerifyInTeamsTab Started");
        try {
          Boolean check=super.isElementVisible(retriveLocators(dynamicXpathGenerator(rbck.get("teamSelect"),teamName)));
          if(check==true){
              System.out.println("team"+teamName+"is exits");
          }else{
              driver.findElement(retriveLocators(rbck.get("teamSearchbar"))).sendKeys(teamName+ Keys.ENTER);
              Boolean check1=super.isElementVisible(retriveLocators(dynamicXpathGenerator(rbck.get("teamSelect"),teamName)));
              if (check1==true){
                  System.out.println("team"+teamName+"is exits");
              }else{
                  System.out.println("team was not found");
              }
            }
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("TeamVerifyInTeamsTab Completed");
    }
    public void emailVerifyInTeamMembersTab(String email) {
        log.info("emailVerifyInTeamMembersTab Started");
        try {
            String[] s=email.split(",");
            int a=s.length;
            if (a>1) {
                for (int i = 0; i < s.length; i++) {
                    super.waitForTheElement(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), s[i])), VISIBILITY_OF_ELEMENT_LOCATED);
                    Boolean check = super.isElementVisible(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), s[i])));
                    super.assertResult(true, check);
                }
            }else {
                super.waitForTheElement(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), email)), VISIBILITY_OF_ELEMENT_LOCATED);
                Boolean check = super.isElementVisible(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), email)));
                super.assertResult(true, check);
            }
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("emailVerifyInTeamMembersTab Completed");
    }
    public void emailVerifyAgainstInTeamMembersTab(String email) {
        log.info("emailVerifyAgainstInTeamMembersTab Started");
        try {
            String[] s=email.split(",");
            int a=s.length;
            if (a>1) {
                for (int i = 0; i < s.length; i++) {
                    super.waitForTheElement(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), s[i])), VISIBILITY_OF_ELEMENT_LOCATED);
                    Boolean check = super.isElementVisible(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), s[i])));
                    super.assertResult(false, check);

                }
            }else {
                super.waitForTheElement(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), email)), VISIBILITY_OF_ELEMENT_LOCATED);
                Boolean check = super.isElementVisible(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), email)));
                super.assertResult(false, check);
            }
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("emailVerifyAgainstInTeamMembersTab Completed");
    }
    public void openTeam(String teamName) {
        log.info("emailVerifyInTeamMembersTab Started");
        try {
            super.elementClick(retriveLocators(dynamicXpathGenerator(rbck.get("teamSelect"),teamName)));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("emailVerifyInTeamMembersTab Completed");
    }
    public void inviteByVerifyInTeamMembersTab(String emails, String invitedBy) {
        log.info("inviteByVerifyInTeamMembersTab Started");
        try {
            String[] s= emails.split(",");
            int a=s.length;
            if (a>1) {
                for (int i = 0; i < s.length; i++) {
                    String s1 = s[i] + "," + invitedBy; //combing two strings values with ,(coma) bcz of multidynamicxpath
                    super.waitForTheElement(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), s[i])), VISIBILITY_OF_ELEMENT_LOCATED);
                    super.isTextVisible(retriveLocators(multipleDynamicValueXpathGen(rbck.get("invitedBy"), s1)), invitedBy);
                }
            }else {
                String s1 = emails + "," + invitedBy; //combing two strings values with ,(coma) bcz of multidynamicxpath
                System.out.println("mailWithInvite"+s1);
                super.waitForTheElement(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), emails)), VISIBILITY_OF_ELEMENT_LOCATED);
                System.out.println("reedypath"+retriveLocators(multipleDynamicValueXpathGen(rbck.get("invitedBy"), s1)));
                super.isTextVisible(retriveLocators(multipleDynamicValueXpathGen(rbck.get("invitedBy"), s1)), invitedBy);
            }
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("inviteByVerifyInTeamMembersTab Completed");
    }
    public void nameVerifyInTeamMembersTab(String email,String tMemberName) {
        log.info("nameVerifyInTeamMembersTab Started");
        try {
            String[] s= email.split(",");
            int a=s.length;
            if (a>1) {
                for (int i = 0; i < s.length; i++) {
//                    String s1 = s[i] + "," + tMemberName; //combing two strings values with ,(coma) bcz of multidynamicxpath
                    super.waitForTheElement(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), email)), VISIBILITY_OF_ELEMENT_LOCATED);
                    String actualText=super.getText(retriveLocators(dynamicXpathGenerator(rbck.get("teamMemberName1"),s[i])));
                    super.textAssertions(tMemberName,actualText);
//                    super.isTextVisible(retriveLocators(multipleDynamicValueXpathGen(rbck.get("teamMemberName"), s1)), tMemberName);
                }
            }else {
//                String s1 = email + "," + tMemberName; //combing two strings values with ,(coma) bcz of multidynamicxpath
                super.waitForTheElement(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), email)), VISIBILITY_OF_ELEMENT_LOCATED);
                String actualText=super.getText(retriveLocators(dynamicXpathGenerator(rbck.get("teamMemberName1"),email)));
                super.textAssertions(tMemberName,actualText);            }
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("nameVerifyInTeamMembersTab Completed");
    }public void nameVerifyAgainstNotRecievedInTeamMembersTab(String email,String tMemberName) {
        log.info("nameVerifyAgainstNotRecievedInTeamMembersTab Started");
        try {
            String[] s= email.split(",");
            int a=s.length;
            if (a>1) {
                for (int i = 0; i < s.length; i++) {
                    String s1 = s[i] + "," + tMemberName; //combing two strings values with ,(coma) bcz of multidynamicxpath
                    super.waitForTheElement(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), email)), VISIBILITY_OF_ELEMENT_LOCATED);
                    super.isTextNotVisible(retriveLocators(dynamicXpathGenerator(rbck.get("teamMemberName1"),s[i])),tMemberName);
                }
            }else {
                String s1 = email + "," + tMemberName; //combing two strings values with ,(coma) bcz of multidynamicxpath
                super.waitForTheElement(retriveLocators(dynamicXpathGenerator(rbck.get("emailid"), email)), VISIBILITY_OF_ELEMENT_LOCATED);
                super.isTextNotVisible(retriveLocators(dynamicXpathGenerator(rbck.get("teamMemberName1"),email)),tMemberName);
                            }
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("nameVerifyAgainstNotRecievedInTeamMembersTab Completed");
    }
    public void teamMemberDeleteNotifi() {
        log.info("teamMemberDelete success notification verification  Started");
        try {
            super.waitForTheElement(retriveLocators(rbck.get("teammemberdeletenotifi")),VISIBILITY_OF_ELEMENT_LOCATED);
            Boolean check =super.isElementVisible(retriveLocators(rbck.get("teammemberdeletenotifi")));
            super.assertResult(true,check);
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("teamMemberDelete success notification verification Completed");
    }
    public void teamMemberRestoreNotifi() {
        log.info("teamMemberRestore success notification verification  Started");
        try {
            super.waitForTheElement(retriveLocators(rbck.get("teammemberrestorenotifi")),VISIBILITY_OF_ELEMENT_LOCATED);
            Boolean check =super.isElementVisible(retriveLocators(rbck.get("teammemberrestorenotifi")));
            super.assertResult(true,check);
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("teamMemberRestore success notification verification Completed");
    }
    public void teamMemberAddedNotifi() {
        log.info("New TeamMemberAdded success notification verification  Started");
        try {
            super.waitForTheElement(retriveLocators(rbck.get("teammembersuccessnotifi")),VISIBILITY_OF_ELEMENT_LOCATED);
            Boolean check =super.isElementVisible(retriveLocators(rbck.get("teammembersuccessnotifi")));
            super.assertResult(true,check);
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("New TeamMemberAdded success notification verification Completed");
    }
    public void teamMemberDelete(String email) {
        log.info("teamMemberDelete  Started");
        try {
            super.waitForTheElement(retriveLocators(dynamicXpathGenerator(rbck.get("deleteicon"),email)),VISIBILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(dynamicXpathGenerator(rbck.get("deleteicon"),email)));
            super.waitForTheElement(retriveLocators(rbck.get("teammemberdeletebtn")),VISIBILITY_OF_ELEMENT_LOCATED);
            super.elementClick(retriveLocators(rbck.get("teammemberdeletebtn")));

        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("teamMemberDelete Completed");
    }
    public void teamMemberInvite(String email) {
        log.info("teamMemberInvite  Started");
        try {
          String[] s=email.split(",");
          int a=s.length;
          if (a>1){
              for (int i=0;i<s.length;i++){
                  super.waitForTheElement(retriveLocators(rbck.get("addnewmember")),VISIBILITY_OF_ELEMENT_LOCATED);
                  super.elementClick(retriveLocators(rbck.get("addnewmember")));
                  super.enterText(rbck.get("addteammenbertxb"),s[i]);
                  Thread.sleep(2000);
                  super.elementClick(retriveLocators(rbck.get("sendInvite")));
                  Thread.sleep(2000);
//                  super.waitForTheElement(retriveLocators(rbck.get("success")),VISIBILITY_OF_ELEMENT_LOCATED);
                  (new WebDriverWait(driver, Duration.ofMillis(9000))).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Success']")));

                  emailVerifyInTeamMembersTab(s[i]);
              }
          }else {
              super.waitForTheElement(retriveLocators(rbck.get("addnewmember")),VISIBILITY_OF_ELEMENT_LOCATED);
              super.elementClick(retriveLocators(rbck.get("addnewmember")));
              super.enterText(rbck.get("addteammenbertxb"),s[0]);
              super.elementClick(retriveLocators(rbck.get("sendInvite")));
              super.waitForTheElement(retriveLocators(rbck.get("success")),VISIBILITY_OF_ELEMENT_LOCATED);
              emailVerifyInTeamMembersTab(email);
          }
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("teamMemberInvite Completed");
    }
    public void teamSearchInTeamsTab(String teamName){
        try{
            super.waitForPageToBeReady();
            driver.findElement(retriveLocators(rbck.get("teamSearchbar"))).sendKeys(teamName+ Keys.ENTER);

        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
    }
    public void teamNameVerifyInTeammembersAndGlossary(String teamName){
        try{
           super.isElementVisible(retriveLocators(dynamicXpathGenerator(rbck.get("teamNameverify"),teamName)));
           super.elementClick(retriveLocators(rbck.get("glossarytab")));
           super.isElementVisible(retriveLocators(dynamicXpathGenerator(rbck.get("teamNameverify"),teamName)));
           super.elementClick(retriveLocators(rbck.get("teamMembersTab")));
        }catch (Exception e){
            super.exceptionLogger(BeforeTag.scenario,e);
        }
    }
}
