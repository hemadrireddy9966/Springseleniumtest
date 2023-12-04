package com.example.VitraAi.actions.drivercapabilities;


    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
import java.util.Set;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirefoxDriverOptions {
    private static final Logger log = LoggerFactory.getLogger(FirefoxDriverOptions.class);

    public FirefoxDriverOptions() {
    }

    public FirefoxOptions setOptions(String mode) {
        log.info("FirefoxDriver options are being set");
        FirefoxOptions w_options = (new FirefoxOptions()).addPreference("browser.startup.page", 1).addPreference("browser.startup.homepage", "https://www.google.com");
        Set<String> ind = w_options.getCapabilityNames();
        System.err.println(ind.size());
        log.info("Firefox Driver options are successfully set");
        return w_options;
    }
}