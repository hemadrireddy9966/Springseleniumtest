package com.example.VitraAi.actions.commands;

// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
//import com.google.zxing.BinaryBitmap;
//import com.google.zxing.LuminanceSource;
//import com.google.zxing.MultiFormatReader;
//import com.google.zxing.Result;
//import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
//import com.google.zxing.common.HybridBinarizer;

import com.example.VitraAi.pageobject.PageObjectsFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.comparison.ImageDiff;
//import ru.yandex.qatools.ashot.comparison.ImageDiffer;

    public class Common extends CommonClass {
        private static final Logger log = LoggerFactory.getLogger(Common.class);
        public static WebDriver driver = null;
        public static ChromeDriver driver1 = null;
        public WebElement local_element = null;

        public Common(WebDriver driver) {
            super(driver);
            Common.driver = driver;
        }
        private final Map<String, String> wpadmin = readPropertiesFile(PageObjectsFactory.wpaddmin);
        public void enterText(String element, String valueToEnter) throws Exception {
            log.info("enterText Started");
            this.waitForTheElement(this.retriveLocators(element), CLICKABILITY_OF_ELEMENT_LOCATED);
            this.scroll(super.local_by);
            this.local_element = driver.findElement(super.local_by);
            elementimplicitlyWait(5);
            this.local_element.click();
            this.local_element.clear();
            this.local_element.sendKeys(new CharSequence[]{valueToEnter});
            log.info(valueToEnter + " has been entered in " + super.label);
            log.info("enterText Ended");
        }
        public void enterTextWithoutUsingClick(String element, String valueToEnter) throws Exception {
            log.info("enterTextWithoutUsingClick Started");
            this.waitForTheElement(this.retriveLocators(element), CLICKABILITY_OF_ELEMENT_LOCATED);
            this.scroll(super.local_by);
            this.local_element = driver.findElement(super.local_by);
            elementimplicitlyWait(5);
//            this.local_element.click();
//            this.local_element.clear();
            this.local_element.sendKeys(new CharSequence[]{valueToEnter});
            log.info(valueToEnter + " has been entered in " + super.label);
            log.info("enterTextWithoutUsingClick Ended");
        }
        public void snippetEnterText(String element,String filePath,String snippetT,String GlossaryT) throws Exception {
            log.info("snippetEnterText Started");
            this.waitForTheElement(this.retriveLocators(element), "VISIBILITY_OF_ELEMENT_LOCATED");
//            this.scroll(super.local_by);
            this.local_element = driver.findElement(this.retriveLocators(element));
           String s1="<script type=\"text/javascript\" src=\"https://d1wrgmw2jqph3l.cloudfront.net/web-translate/staging-on-the-fly.min.js\"></script>";
           String s2="<script>";
           String s3="document.addEventListener(\"DOMContentLoaded\", function () {";
           String s4="new VitraOnTheFly({";
           String s5="api_key: test,";
           String s6="glossaryId: demo,";
           String s7="position: \"center-right\",";
           String s8="theme: \"dark\",";
           String s9="});";
           String s10="});";
           String s11="</script>";

            Actions act = new Actions(driver);
            act.moveToElement(this.local_element);
            act.click();
            act.sendKeys(s1);
            for (int i = 0; i <=15; i++) {
                Thread.sleep(2000);
                act.sendKeys(Keys.BACK_SPACE);
            }
            for (int i=0;i<9;i++) {
                Thread.sleep(1000);
                act.sendKeys(Keys.ARROW_RIGHT);
            }
            act.sendKeys(Keys.ENTER);
            act.build().perform();
            super.elementClick(retriveLocators(wpadmin.get("saveSnippet")));
           Thread.sleep(3000);
            Actions actions = new Actions(driver);
            WebElement testing=driver.findElement(By.xpath("//span[not(@class) and @cm-text]"));
            actions.moveToElement(testing);
            actions.click();
            actions.sendKeys(s2);
            actions.sendKeys(Keys.ENTER);
            actions.sendKeys(s3);
            actions.sendKeys(Keys.ENTER);
            actions.sendKeys(s4);
            actions.sendKeys(Keys.ENTER);
            actions.sendKeys(s5.replace("test",snippetT));
            actions.sendKeys(Keys.ENTER);
            actions.sendKeys(s6.replace("demo",GlossaryT));
            actions.sendKeys(Keys.ENTER);
            actions.sendKeys(s7);
            actions.sendKeys(Keys.ENTER);
            actions.sendKeys(s8);
            actions.sendKeys(Keys.ENTER);
            actions.sendKeys(s9);
            actions.sendKeys(Keys.ENTER);
            actions.sendKeys(s10);
            actions.sendKeys(Keys.ENTER);
            actions.sendKeys(s11);
            actions.sendKeys(Keys.ENTER);
            for (int i=0;i<17;i++) {
                Thread.sleep(1000);
                actions.sendKeys(Keys.BACK_SPACE);
            }
            actions.build().perform();

            log.info("snippetEnterText Ended");
        }
        public void enterTextWithCntrlV(String element, String valueToEnter) throws Exception {
            log.info("enterTextWith key board Cntrl+V Started");
            this.waitForTheElement(this.retriveLocators(element), "VISIBILITY_OF_ELEMENT_LOCATED");
            this.scroll(super.local_by);
            this.local_element = driver.findElement(super.local_by);
            this.local_element.click();
//            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//            clipboard.setContents(new StringSelection(valueToEnter), null);
//
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            this.local_element.clear();
            this.local_element.sendKeys(new CharSequence[]{valueToEnter});
            log.info(valueToEnter + " has been entered in " + super.label);
            log.info("enterTextWith key board Cntrl+V Ended");
        }

        /** @deprecated */
        @Deprecated
        public void click(String element) throws Exception {
            this.waitForTheElement(this.retriveLocators(element), "CLICKABILITY_OF_ELEMENT_LOCATED");
            this.scroll(super.local_by);
            this.local_element = driver.findElement(super.local_by);

            try {
                this.local_element.click();
            } catch (ElementClickInterceptedException var4) {
                log.info(var4.getLocalizedMessage());
                this.local_element = driver.findElement(super.local_by);
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].click();", new Object[]{this.local_element});
            }

            log.info(super.label + " is clicked");
        }

        public void clickUsingJSexe(By a_element) throws Exception {
            log.info("clickUsingJSexe started");
            this.waitForTheElement(a_element, "VISIBILITY_OF_ELEMENT_LOCATED");
            WebElement w_element1 = m_driver.findElement(a_element);
            JavascriptExecutor w_executor = (JavascriptExecutor)m_driver;
            w_executor.executeScript("arguments[0].click();", new Object[]{w_element1});
            log.info("clickUsingJSexe completed");
        }

        public void elementDoubleClick(By a_element) throws Exception {
            log.info("elementDoubleClick started");
            Actions w_actions = new Actions(m_driver);
            this.waitForTheElement(a_element, "VISIBILITY_OF_ELEMENT_LOCATED");
            WebElement w_ele = m_driver.findElement(a_element);
            w_actions.doubleClick(w_ele).perform();
            log.info("elementDoubleClick completed");
        }

        public boolean verifyElementDisplayed(String element) throws Exception {
            this.waitForTheElement(this.retriveLocators(element), "VISIBILITY_OF_ELEMENT_LOCATED");
            this.scroll(super.local_by);
            this.local_element = driver.findElement(super.local_by);
            boolean visible = this.local_element.isDisplayed();
            if (visible) {
                log.info(super.label + " is displayed");
            } else {
                log.info(super.label + " is not displayed");
            }

            return visible;
        }
        public void uploadFile( String filepath) throws Exception {
            log.info("uploading a file Started");
//            this.waitForTheElement(this.retriveLocators(element), "VISIBILITY_OF_ELEMENT_LOCATED");
//
//             driver.findElement(super.local_by).click();
//            this.local_element.click();
//            this.local_element.clear();
//            this.local_element.sendKeys(new CharSequence[]{filepath});
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(filepath), null);
            Thread.sleep(2000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            log.info(filepath + " has been entered in " + super.label);
            log.info("uploading a file Ended");
        }
        /** @deprecated */
        @Deprecated
        public String getText(WebElement element) throws Exception {
            String elementText = element.getText();
            log.info(super.label + "  has this text : " + elementText);
            return elementText;
        }

        public String getText(String element) throws Exception {
            log.info("Get Text Started");
            this.waitForTheElement(this.retriveLocators(element), "VISIBILITY_OF_ELEMENT_LOCATED");
            this.scroll(super.local_by);
            this.local_element = driver.findElement(super.local_by);
            String elementText = this.local_element.getText();
            log.info("Text : " + elementText + " is retirved");
            return elementText;
        }

        /** @deprecated */
        @Deprecated
        public boolean assertText(String expectedString, String actualString) throws Exception {
            boolean notNull = false;
            if (expectedString.equalsIgnoreCase(actualString)) {
                notNull = true;
                log.info("Expected :" + expectedString + " And Actual : " + actualString + " are same");
            }

            this.assertResult(true, notNull);
            return notNull;
        }

        public void textAssertions(String expectedString, String actualString) throws Exception {
            boolean notNull = false;
            System.out.println("actualString is:-"+actualString+" And"+"expectedString is:-"+expectedString);
            if (expectedString.equalsIgnoreCase(actualString)) {
                notNull = true;
                log.info("Expected :" + expectedString + " And Actual : " + actualString + " are same");
            }else if(expectedString.contains(actualString)) {
                notNull = true;
                log.info("Expected :" + expectedString + " And Actual : " + actualString + " are same");
            }

            this.assertResult(true, notNull);
        }

        public void assertResult(boolean a_expected, boolean a_actual) throws Exception {
            log.info("assertResult started");
            Assertions.assertEquals(a_expected, a_actual);
            log.info("assertResult completed");
        }
        public void assertResultWithMsg(boolean a_expected, boolean a_actual,String assartMsg) throws Exception {
            log.info("assertResultWithMassage started");
            Assertions.assertEquals(a_expected, a_actual);
            System.out.println(assartMsg);
            log.info("assertResultWithMassage completed");
        }

        public void scroll(By element) throws Exception {
            log.info("Scroll to Element Started");
            JavascriptExecutor w_js = (JavascriptExecutor)driver;
            this.local_element = driver.findElement(element);
            w_js.executeScript("arguments[0].scrollIntoView();", new Object[]{this.local_element});
            log.info("Scroll to Element Completed");
        }

        public List<WebElement> getListOfElements(String elements) throws Exception {
            log.info("Get List of Elements Started");
            List<WebElement> locators = driver.findElements(this.retriveLocators(elements));
            if (locators.size() == 0) {
                throw new NoSuchElementException("ERR : Empty List is retrived");
            } else {
                log.info("Get List of Elements Completed");
                return locators;
            }
        }

        public void navigate(String url) throws Exception {

            driver.get(url);
        }

        public Map<String, String> readPropertiesFile(String propertyFile) {
            Map<String, String> map = null;

            try {
                FileReader read = new FileReader(propertyFile);
                Properties p = new Properties();
                p.load(read);
                map = new HashMap();
                Iterator var5 = p.stringPropertyNames().iterator();

                while(var5.hasNext()) {
                    String key = (String)var5.next();
                    map.put(key, p.getProperty(key));
                }
            } catch (Exception var7) {
                var7.printStackTrace();
            }

            return map;
        }

        public void appendText(String locator, String textToBeAppended) throws Exception {
            log.info("appendText Started");
            this.local_element = driver.findElement(this.retriveLocators(locator));
            this.local_element.sendKeys(new CharSequence[]{Keys.CONTROL, Keys.END});
            this.local_element.sendKeys(new CharSequence[]{" " + textToBeAppended});
            this.local_element.sendKeys(new CharSequence[]{Keys.ENTER});
            log.info("appendText completed");
        }

        /** @deprecated */
        @Deprecated
        public List<WebElement> getElements(String locator) throws Exception {
            List<WebElement> listOfElements = driver.findElements(this.retriveLocators(locator));
            return listOfElements;
        }


//        @Deprecated
        public String dynamicXpathGenerator(String identifier, String inputValue) {
            log.info("dynamicXpathGenerator started");
            String str = identifier.replace("<dynamic value>", inputValue);
            log.info("dynamicXpathGenerator completed");
            return str;
        }

        public String multipleDynamicValueXpathGen(String identifier, String inputValue) {
            log.info("dynamicXpathGenerator started");
            String[] dynamicValues = inputValue.split(",");
            String finalLocator = "";

            for(int i = 0; i < dynamicValues.length; ++i) {
                identifier = identifier.replace("<dynamic value" + (i + 1) + ">", dynamicValues[i]);
            }

            log.info("dynamicXpathGenerator completed");
            return identifier;
        }

        /** @deprecated */
        @Deprecated
        public void backNavigation() {
            log.info("backNavigation started");
            driver.navigate().back();
            log.info("backNavigation completed");
        }

        public void enterChordKeys(By a_element, Keys a_key, String b_key) throws Exception {
            log.info("enterChordKeys started");
            this.waitForTheElement(a_element, "VISIBILITY_OF_ELEMENT_LOCATED");
            m_driver.findElement(a_element).click();
            m_driver.findElement(a_element).sendKeys(new CharSequence[]{a_key, Keys.chord(new CharSequence[]{b_key})});
            log.info("enterChordKeys completed");
        }

        public void tearDown() throws Exception {
            log.info("tearDown started");
            m_driver.quit();
            log.info("tearDown completed");
        }

        public void switchFrame(String a_framename) throws Exception {
            log.info("switchFrame started");
            m_driver.switchTo().frame(a_framename);
            log.info("switchFrame completed");
        }

        public void switchToDefaultFrame() throws Exception {
            log.info("switchToDefaultFrame started");
            m_driver.switchTo().defaultContent();
            log.info("switchToDefaultFrame completed");
        }

        public void switchToParentFrame() throws Exception {
            log.info("switchToParentFrame started");
            m_driver.switchTo().parentFrame();
            log.info("switchToParentFrame completed");
        }

        public void switchFrameByXpath(By w_element) throws Exception {
            log.info("switchFrameByXpath started");
            WebElement w_identifiedElement = m_driver.findElement(w_element);
            m_driver.switchTo().frame(w_identifiedElement);
            log.info("INFO ---- Switched to frame through an element identified using xpath");
            log.info("switchFrameByXpath completed");
        }

        public void pasteFromClipBoard() {
            try {
                Actions builder = new Actions(m_driver);
                builder.keyDown(Keys.CONTROL).sendKeys(new CharSequence[]{"v"}).keyUp(Keys.CONTROL).build().perform();
                Thread.sleep(4000L);
            } catch (Exception var2) {
                var2.getLocalizedMessage();
            }

        }

        public void handleAlert(String action) {
            switch (action) {
                case "Accept":
                case "accept":
                    driver.switchTo().alert().accept();
                    break;
                case "Dismiss":
                case "dismiss":
                case "Cancel":
                case "cancel":
                    driver.switchTo().alert().dismiss();
            }

        }

        public void refreshBrowser() {
            m_driver.navigate().refresh();
        }

        public void browserNavigation(String navigateType) {
            if (navigateType.equalsIgnoreCase("back")) {
                m_driver.navigate().back();
            }

            if (navigateType.equalsIgnoreCase("forward")) {
                m_driver.navigate().forward();
            }

        }

        public void elementimplicitlyWait(int timeunit) throws Exception {
            log.info("elementimplicitlyWait started");
            m_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((long)timeunit));
            log.info("elementimplicitlyWait completed");
        }

        public void selectFromDropDown(By a_element, String visibleText) throws Exception {
            this.waitForTheElement(a_element, "VISIBILITY_OF_ELEMENT_LOCATED");
            Select dropdown = new Select(driver.findElement(a_element));
            dropdown.selectByVisibleText(visibleText);
        }

        public String getDatenTime(String dateFormat, String duration, Integer amount) {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            if (!duration.equalsIgnoreCase("Today")) {
                switch (duration.toLowerCase()) {
                    case "years":
                        c.add(1, amount);
                        break;
                    case "months":
                        c.add(2, amount);
                        break;
                    case "days":
                        c.add(5, amount);
                        break;
                    case "hours":
                        c.add(10, amount);
                        break;
                    case "minutes":
                        c.add(12, amount);
                }
            }

            String date = formatter.format(c.getTime());
            return date;
        }

//        public boolean compareScreenshots(String fileName) throws Exception {
//            String file = fileName.toUpperCase();
//            String[] fileformat = file.split("\\.");
//            this.waitForPageToBeReady();
//            Screenshot screenshot = (new AShot()).takeScreenshot(driver);
//            BufferedImage var10000 = screenshot.getImage();
//            String var10001 = fileformat[1];
//            String var10004 = System.getProperty("user.dir");
//            ImageIO.write(var10000, var10001, new File(var10004 + "/src/test/resources/ActualScreenshots/" + fileName));
//            BufferedImage actualImage = screenshot.getImage();
//            String var10002 = System.getProperty("user.dir");
//            BufferedImage expectedImage = ImageIO.read(new File(var10002 + "/src/test/resources/ExpectedScreenshots/" + fileName));
//            ImageDiffer imgDiff = new ImageDiffer();
//            ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
//            if (diff.hasDiff()) {
//                log.info("Difference in pixel --->" + diff.getDiffSize());
//            }
//
//            log.info("Images have difference? --->" + diff.hasDiff());
//            return diff.hasDiff();
//        }
//
//        public boolean captureScreenshot(@NotNull String fileName) throws Exception {
//            String file = fileName.toUpperCase();
//            String[] fileformat = file.split("\\.");
//            this.waitForPageToBeReady();
//            Screenshot screenshot = (new AShot()).takeScreenshot(driver);
//            BufferedImage var10000 = screenshot.getImage();
//            String var10001 = fileformat[1];
//            String var10004 = System.getProperty("user.dir");
//            ImageIO.write(var10000, var10001, new File(var10004 + "/src/test/resources/ActualScreenshots/" + fileName));
//            return false;
//        }
//
//        public boolean compareScreenshots(String fileName, int tolerancePixel) throws Exception {
//            String file = fileName.toUpperCase();
//            String[] fileformat = file.split("\\.");
//            this.waitForPageToBeReady();
//            Screenshot screenshot = (new AShot()).takeScreenshot(driver);
//            BufferedImage var10000 = screenshot.getImage();
//            String var10001 = fileformat[1];
//            String var10004 = System.getProperty("user.dir");
//            ImageIO.write(var10000, var10001, new File(var10004 + "/src/test/resources/ActualScreenshots/" + fileName));
//            BufferedImage actualImage = screenshot.getImage();
//            String var10002 = System.getProperty("user.dir");
//            BufferedImage expectedImage = ImageIO.read(new File(var10002 + "/src/test/resources/ExpectedScreenshots/" + fileName));
//            ImageDiffer imgDiff = new ImageDiffer();
//            ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage).withDiffSizeTrigger(tolerancePixel);
//            log.info("Difference in pixel --->" + diff.getDiffSize());
//            log.info("Images have difference? --->" + diff.hasDiff());
//            return diff.hasDiff();
//        }
//
//        public String scanBarandQRCode(By locator) throws Exception {
//            String barcodeUrl = driver.findElement(locator).getAttribute("src");
//            URL url = new URL(barcodeUrl);
//            BufferedImage bufferedImage = ImageIO.read(url);
//            LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
//            BinaryBitmap binary = new BinaryBitmap(new HybridBinarizer(luminanceSource));
//            Result result = (new MultiFormatReader()).decode(binary);
//            return result.getText();
//        }

        public By belowOF(By selector, By selectorBelowOF) {
            WebElement elementBelowOF = driver.findElement(selectorBelowOF);
            By element = RelativeLocator.with(selector).below(elementBelowOF);
            return element;
        }

        public By aboveOF(By selector, By selectorAboveOF) {
            WebElement elementAboveOF = driver.findElement(selectorAboveOF);
            By element = RelativeLocator.with(selector).above(elementAboveOF);
            return element;
        }

        public By nearOF(By selector, By selectorNearOF) {
            WebElement elementNearOF = driver.findElement(selectorNearOF);
            By element = RelativeLocator.with(selector).near(elementNearOF);
            return element;
        }

        public By nearOFAtMostPixelDif(By selector, By selectorNearOF, int pixelDiff) {
            WebElement elementNearOF = driver.findElement(selectorNearOF);
            By element = RelativeLocator.with(selector).near(elementNearOF, pixelDiff);
            return element;
        }

        public By toLeftOf(By selector, By selectorLeftOF) {
            WebElement elementLeftOF = driver.findElement(selectorLeftOF);
            By element = RelativeLocator.with(selector).toLeftOf(elementLeftOF);
            return element;
        }

        public By toRightOf(By selector, By selectorRightOF) {
            WebElement elementRightOf = driver.findElement(selectorRightOF);
            By element = RelativeLocator.with(selector).toLeftOf(elementRightOf);
            return element;
        }
        public static void writeToFile(String text, String filePath) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(text);
                System.out.println("Text successfully stored in the file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static String readFromFile(String filePath) {
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }
    }
