package com.example.VitraAi.actions.drivercapabilities;


    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.HashMap;
import java.util.logging.Level;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeDriverOptions extends WebDriverFactory {
    private static final Logger log = LoggerFactory.getLogger(ChromeDriverOptions.class);

    public ChromeDriverOptions() {
    }

    public ChromeOptions setOptions(String mode) {
        log.info("ChromeDriver options are being set");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--no-sandbox"});
        options.addArguments(new String[]{"disable-features=NetworkService"});
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        if (mode.equalsIgnoreCase("headless")) {
            options.addArguments(new String[]{"headless"});
        }

        options.addArguments(new String[]{"window-size=1920x1080"});
        options.setAcceptInsecureCerts(true);
        options.addArguments(new String[]{"--enable-javascript"});
        options.addArguments(new String[]{"--disable-infobars"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments(new String[]{"--disable-notifications"});
        options.addArguments(new String[]{"--disable-extensions"});
        HashMap<String, Object> chromePrefs = new HashMap();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        options.addArguments(new String[]{"--test-type"});
        options.addArguments(new String[]{"start-maximized"});
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36");
//        options.addArguments(new String[]{"--user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.63 Safari/537.36"});
        options.addArguments(new String[]{"--disable-gpu"});
        options.addArguments(new String[]{"--disable-dev-shm-usage"});
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable("performance", Level.ALL);
        log.info("ChromeDriver options are successfully set");
        return options;
    }
}

