package com.example.VitraAi.steps;


import com.example.VitraAi.cache.Cache;
import com.example.VitraAi.pageactions.LoginAndSignpage;
import com.example.VitraAi.pageactions.WsTnsLoginPage;
import io.cucumber.java8.En;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class WsTnsLoginSteps extends Cache implements En {

    WsTnsLoginPage wst = super.getWsTns();
    LoginAndSignpage g = super.getGoogle();


    public WsTnsLoginSteps(WebDriver driver) {
        super(driver);

        Given("User fills the Login Page {string} and {string}", (String email,String otp) -> {
                  wst.loginToWebsiteTranslation(email);
            wst.enteringOtp(otp);
            wst.homepage();
        });

        Given("User opens the login page and signupwithgoogle", () -> {
            g.continueWithGoogle();
        });

        When("User enters {string} id and {string}", (String gmail, String password) -> {
            g.signinWithbtn(gmail,password);
        });

        Then("User should be able to see website translation home page", () -> {

        });
    }
}
