package com.example.VitraAi.actions.drivercapabilities;

    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class WebDriverFactory {
    private static final Logger log = LoggerFactory.getLogger(WebDriverFactory.class);
    private WebDriver driver;
    private ChromeDriver driver1;
    @Value("${aws.env:http://localhost:3000/}")
    private String env;
    @Value("${browser.mode:non-headless}")
    private String browserMode;

    public WebDriverFactory() {
    }

    @Bean(
            name = {"firefoxDriver"}
    )
    @ConditionalOnProperty(
            prefix = "driver",
            name = {"type"},
            havingValue = "firefox",
            matchIfMissing = true
    )
    public WebDriver firefoxDriver() {
        log.info("Instantiating Firefox Driver");
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriverOptions options = new FirefoxDriverOptions();
        this.driver = new FirefoxDriver(options.setOptions(this.browserMode));
        this.driver.manage().window().maximize();
        this.driver.get(this.env);
        return this.driver;
    }

    @Bean(
            name = {"chromeDriver"}
    )
    @ConditionalOnProperty(
            prefix = "driver",
            name = {"type"},
            havingValue = "chrome"
    )
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeDriverOptions options = new ChromeDriverOptions();
        this.driver = new ChromeDriver(options.setOptions(this.browserMode));
        this.driver.get(this.env);
        return this.driver;
    }

    @Bean(
            name = {"chromeDriverLog"}
    )
    @ConditionalOnProperty(
            prefix = "driver",
            name = {"type"},
            havingValue = "chromelog"
    )
    public WebDriver chromeDriverLog() {
        WebDriverManager.chromedriver().setup();
        ChromeDriverOptions options = new ChromeDriverOptions();
        this.driver1 = new ChromeDriver(options.setOptions(this.browserMode));
        DevTools dev = this.driver1.getDevTools();
        this.driver1.get(this.env);
        return this.driver1;
    }

    @Bean(
            name = {"edgeDriver"}
    )
    @ConditionalOnProperty(
            prefix = "driver",
            name = {"type"},
            havingValue = "edge"
    )
    public WebDriver edgeDriver() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        this.driver.get(this.env);
        return this.driver;
    }
}


