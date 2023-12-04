package com.example.VitraAi.steps;

import com.example.VitraAi.actions.drivercapabilities.WebDriverFactory;
import com.example.VitraAi.cache.Cache;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@SpringJUnitConfig
@CucumberContextConfiguration
@TestPropertySource(locations = "/application.properties")
@ContextConfiguration(classes = WebDriverFactory.class, loader = AnnotationConfigContextLoader.class)
public class Base {

    @Autowired
    private WebDriverFactory driver;

    public WebDriver driverBean;

    Cache cache ;

    public Base(WebDriver driver){
        this.driverBean = driver;
        cache = new Cache(driverBean);
    }
}