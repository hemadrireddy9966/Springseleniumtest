package com.example.VitraAi.pageactions;

import com.example.VitraAi.actions.commands.Common;
import com.example.VitraAi.pageobject.PageObjectsFactory;
import com.example.VitraAi.steps.BeforeTag;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.Set;

@Slf4j
public class LoginAndSignpage extends Common {

    private final Map<String, String> google = super.readPropertiesFile(PageObjectsFactory.googlepro);

    public LoginAndSignpage(WebDriver driver) {super(driver);}

    public void continueWithGoogle() {
        log.info("continueWithGoogle Started");
        try {
            super.elementClick(retriveLocators(google.get("continueAsgoogle")));
        } catch (Exception e) {
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("continueWithGoogle Completed");
    }

    public void signinWithbtn(String email,String password) {
        log.info("signinWithGoogle Started");
        try{
            System.out.println("hem225"+retriveLocators(google.get("continueAsgoogle")));
            Set<String> s =super.getAllWindows();
           String s1=super.getMainWindow();
           log.info("hemd2566"+s1);
           for(String ss:s){

               if (s1.equals(ss)) {

               }else {


                   Thread.sleep(2000);
                   log.info("hem2256"+ss);
                   super.switchToWindow(ss);
//                   super.enterText(retriveLocators(google.get("emailOrphonetbx")),email);

                   super.enterText(google.get("emailOrphonetbx"),email);
                   super.elementClick(retriveLocators(google.get("nextbtn")));
//                   super.enterText(retriveLocators(google.get("emailpassword")),password);
                   super.enterText(google.get("emailpassword"),password);
                   super.elementClick(retriveLocators(google.get("nextbtn")));
                   super.switchToDefaultFrame();
               }

               }

//            System.out.println("hem"+retriveLocators(google.get("continueAsgoogle")));
//            super.elementClick(retriveLocators(google.get("continueAsgoogle")));
//            super.enterText(retriveLocators(google.get("emailOrphonetbx")),email);
//            super.elementClick(retriveLocators(google.get("nextbtn")));
//            super.enterText(retriveLocators(google.get("emailpassword")),password);
//            super.elementClick(retriveLocators(google.get("nextbtn")));
        }
        catch(Exception e){
            super.exceptionLogger(BeforeTag.scenario, e);
        }
        log.info("signinWithGoogle Completed");
    }
}
