package com.example.VitraAi.actions.commands;

    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.example.VitraAi.actions.exception.ExceptionLogger;
import io.cucumber.java.bs.A;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.comparison.ImageDiff;
//import ru.yandex.qatools.ashot.comparison.ImageDiffer;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

    public class CommonClass extends ExceptionLogger {
        private static final Logger log = LoggerFactory.getLogger(CommonClass.class);
        private WebElement m_webElement;
        public static WebDriver m_driver;
        int m_count = 0;
        long startTime;
        long endTime;
        long duration;
        public By local_by = null;
        public String label = null;
        public String moduleName = null;
        public final String VISIBILITY_OF_ELEMENT_LOCATED = "VISIBILITY_OF_ELEMENT_LOCATED";
        public final String CLICKABILITY_OF_ELEMENT_LOCATED = "CLICKABILITY_OF_ELEMENT_LOCATED";
        public final String PRESENCE_OF_ELEMENT_LOCATED = "PRESENCE_OF_ELEMENT_LOCATED";
        public final String INVISIBILITY_OF_ELEMENT = "INVISIBILITY_OF_ELEMENT";
        public final String IS_ALERT_PRESENT = "IS_ALERT_PRESENT ";
        public final String FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT = "FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT";

        public CommonClass(WebDriver a_driver) {
            m_driver = a_driver;
        }

        /** @deprecated */
        @Deprecated
        public void launchbrowser(String a_baseUrl) throws Exception {
        }

        /** @deprecated */
        @Deprecated
        public void stopservice() throws Exception {
        }

        /** @deprecated */
        @Deprecated
        public WebElement getElement(By a_element) throws Exception {
            this.m_webElement = m_driver.findElement(a_element);
            return this.m_webElement;
        }

//        /** @deprecated */
//        @Deprecated
//        public void enterText(By a_element, String a_text) throws Exception {
//            this.waitForTheElement(a_element, "CLICKABILITY_OF_ELEMENT_LOCATED");
//            String w_elementName = this.getElement(a_element).getText();
//            if (m_driver.findElement(a_element).isDisplayed()) {
//                m_driver.findElement(a_element).clear();
//                m_driver.findElement(a_element).sendKeys(new CharSequence[]{a_text});
//                System.out.println(a_text + " is entered in " + w_elementName);
//            }
//
//        }

        /** @deprecated */
        @Deprecated
        public void elementSubmit(By a_element) throws Exception {
            this.waitForTheElement(a_element, "CLICKABILITY_OF_ELEMENT_LOCATED");
            String w_elementName = this.getElement(a_element).getText();
            if (m_driver.findElement(a_element).isDisplayed()) {
                m_driver.findElement(a_element).submit();
            } else {
                System.out.println(w_elementName + " is not found ");
            }

        }
//        in this below method will helpfull for stale element refrence exception
        public void staleElementClick(By a_element) throws Exception {
            new WebDriverWait(m_driver, Duration.ofSeconds(15L)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(a_element));
            m_driver.findElement(a_element).click();

        }
        public void elementClick(By a_element) throws Exception {
            this.waitForTheElement(a_element, "CLICKABILITY_OF_ELEMENT_LOCATED");
            String w_elementName = this.getElement(a_element).getText();
            Boolean b=m_driver.findElement(a_element).isDisplayed();
            System.out.println("element is "+b);
            if (b) {
                m_driver.findElement(a_element).click();
            } else if (this.m_count <= 5) {
                System.out.println(w_elementName + " is not found trying again ");
                this.m_count++;
                this.elementClick(a_element);
//                ++this.m_count;
                System.out.println(w_elementName + " did i clicked");
            }

        }

        public void performmoveToElement(By a_by) throws Exception {
            this.waitForTheElement(a_by, "VISIBILITY_OF_ELEMENT_LOCATED");
            WebElement w_web_Element_To_Be_Hovered = m_driver.findElement(a_by);
            Actions w_builder = new Actions(m_driver);
            w_builder.moveToElement(w_web_Element_To_Be_Hovered).build().perform();
        }

        /** @deprecated */
        @Deprecated
        public void explicitwait(By a_byclass, String a_waittype) throws Exception {
            new WebDriverWait(m_driver, Duration.ofSeconds(15L));
        }

        public boolean isElementVisible(By a_by) throws Exception {
            boolean w_visible = false;

            try {
                this.waitForTheElement(a_by, "VISIBILITY_OF_ELEMENT_LOCATED");
                if (m_driver.findElement(a_by).isDisplayed()) {
                    w_visible = true;
                }
            } catch (Exception var4) {
            }

            return w_visible;
        }

        public void waitTillLoadingImageLoaded() throws Exception {
            By e_loadingImage = By.id("loadingimg");
            this.waitForTheElement(e_loadingImage, "VISIBILITY_OF_ELEMENT_LOCATED");
        }

        public void waitTillProductLoadingImageLoaded() throws Exception {
            By e_loadingImage = By.xpath("//div[@class='loadingDiv']/img");

            try {
                this.waitForTheElement(e_loadingImage, "INVISIBILITY_OF_ELEMENT");
                m_driver.navigate().refresh();
                System.err.println("INFO ---- Loading ICON disappeared");
            } catch (NoSuchElementException var3) {
                var3.printStackTrace();
                m_driver.navigate().refresh();
                this.waitForTheElement(e_loadingImage, "INVISIBILITY_OF_ELEMENT");
            } catch (Exception var4) {
                var4.printStackTrace();
                m_driver.navigate().refresh();
                this.waitForTheElement(e_loadingImage, "INVISIBILITY_OF_ELEMENT");
            }

        }

        public void getInnerText(By a_element, String text) throws Exception {
            WebElement w_ele = m_driver.findElement(a_element);
            String w_val = w_ele.getAttribute("innerText");
        }

        public String readProp(String a_key) throws Exception {
            return null;
        }

        /** @deprecated */
        @Deprecated
        public void scroll(By a_element) throws Exception {
            JavascriptExecutor w_js = (JavascriptExecutor)m_driver;
            WebElement w_collect = this.getElement(a_element);
            w_js.executeScript("arguments[0].scrollIntoView();", new Object[]{w_collect});
        }

        /** @deprecated */
        @Deprecated
        public String getElementText(By a_element) throws Exception {
            String w_str = m_driver.findElement(a_element).getText();
            return w_str;
        }

        /** @deprecated */
        @Deprecated
        public void assertResult(String a_expected, String a_actual) throws Exception {
        }

        /** @deprecated */
        @Deprecated
        public void assertTrue(boolean a_expected) throws Exception {
            Assertions.assertTrue(a_expected);
        }

        /** @deprecated */
        @Deprecated
        public List<WebElement> getElements(By a_element) throws Exception {
            List<WebElement> w_webElements = m_driver.findElements(a_element);
            return w_webElements;
        }

        public boolean isElementNotVisible(By a_by) throws Exception {
            try {
                if (!m_driver.findElement(a_by).isDisplayed()) {
                    Assertions.assertFalse(m_driver.findElement(a_by).isDisplayed());
                } else {
                    Assertions.assertFalse(m_driver.findElement(a_by).isDisplayed());
                }
            } catch (Exception var3) {
            }

            return false;
        }

        public void compareStrings(String a_actual, String a_expected) throws Exception {
            boolean w_bool = a_actual.contains(a_expected);
            Assertions.assertTrue(w_bool);
        }

        public void isAssertEquals(String a_actual, String a_expected, String a_errorMessage) throws Exception {
        }

        public void assertElementText(By a_element, String a_expected, String a_errorMessage) throws Exception {
            String w_actual = this.getElementText(a_element);
            this.isAssertEquals(w_actual, a_expected, a_errorMessage);
        }

        public void writeToFile(String a_string) throws Exception {
        }

        public void dragDropElement(By a_source, By a_destination) throws Exception {
            WebElement w_src = this.getElement(a_source);
            WebElement w_dest = this.getElement(a_destination);
            Actions w_act = new Actions(m_driver);
            w_act.clickAndHold(w_src).moveByOffset(0, 100).moveToElement(w_dest, 0, 100).release().build().perform();
            log.debug("DragDrog is completed");
        }

        public String[] splitStringValues(String a_name) throws Exception {
            String[] w_arrOfStr = a_name.split(",", 0);
            return w_arrOfStr;
        }

        public String getText(By a_element) throws Exception {
            String w_str = m_driver.findElement(a_element).getText();
            return w_str;
        }

        public void clickUsingAction(By a_element) throws Exception {
            this.waitForTheElement(a_element, "CLICKABILITY_OF_ELEMENT_LOCATED");
            WebElement w_element1 = m_driver.findElement(a_element);
            Actions w_action = new Actions(m_driver);
            w_action.moveToElement(w_element1).click().perform();
        }

        /** @deprecated */
        @Deprecated
        public void switchFrameByIndex(int a_frame) throws Exception {
            m_driver.switchTo().frame(a_frame);
        }

        public void isElementSelected(By a_element) throws Exception {
            Boolean w_bool = m_driver.findElement(a_element).isSelected();
        }

        public String getSelectedValueFromDropDown(By a_element) throws Exception {
            WebElement w_ele = m_driver.findElement(a_element);
            Select w_select = new Select(w_ele);
            String w_value = w_select.getFirstSelectedOption().getText();
            return w_value;
        }

        public String getTextboxValue(By a_element) throws Exception {
            String w_value = m_driver.findElement(a_element).getAttribute("value");
            return w_value;
        }

        public void isTextVisible(By a_by, String a_expectedText) throws Exception {
            this.waitForTheElement(a_by, "VISIBILITY_OF_ELEMENT_LOCATED");
            System.out.println("reddyy"+a_by);
            WebElement w_extractTextEle = m_driver.findElement(a_by);

            String w_actualText = w_extractTextEle.getText();
            System.out.println("hemadrigettest"+w_actualText);
            if (containsIgnoreCase(w_actualText.trim(),a_expectedText.trim())) {
                System.out.println("INFO ---- Message displayed is same as expected" + w_actualText);
            }

        }
        public void isTextNotVisible(By a_by, String a_expectedText) throws Exception {
            this.waitForTheElement(a_by, "VISIBILITY_OF_ELEMENT_LOCATED");
            System.out.println("reddyy"+a_by);
            WebElement w_extractTextEle = m_driver.findElement(a_by);

            String w_actualText = w_extractTextEle.getText();
            System.out.println("hemadrigettest"+w_actualText);
            if (!w_actualText.trim().contains(a_expectedText.trim())) {
                System.out.println("INFO ---- Message displayed here is against expected text"+a_expectedText+" with actual text is" + w_actualText);
            }

        }

        /** @deprecated */
        @Deprecated
        public void switchFrameByWebElement(WebElement w_ele) throws Exception {
            m_driver.switchTo().defaultContent();
            m_driver.switchTo().frame(w_ele);
        }

        public String getMainWindow() throws Exception {
            String w_windowName = null;
            w_windowName = m_driver.getWindowHandle();
            return w_windowName;
        }

        public Set<String> getAllWindows() throws Exception {
            Set<String> w_windowName = null;
            w_windowName = m_driver.getWindowHandles();
            System.out.println(w_windowName.size());
            System.out.println("INFO ---- Total number of windows available : " + w_windowName.size());
            return w_windowName;
        }

        public void switchToWindow(String a_window) throws Exception {
            m_driver.switchTo().window(a_window);
        }

        public void waitForPageToBeReady() throws Exception {
            JavascriptExecutor js = (JavascriptExecutor)m_driver;

            for(int i = 0; i < 100; ++i) {
                try {
                    Thread.sleep(1000L);
                } catch (Exception var4) {
                }

                if (js.executeScript("return document.readyState", new Object[0]).toString().equals("complete")) {
                    break;
                }
            }

        }

        public static BufferedImage screenshotComparision(BufferedImage img1, BufferedImage img2) {
            int w = img1.getWidth();
            int h = img1.getHeight();
            int highlight = Color.MAGENTA.getRGB();
            int[] p1 = img1.getRGB(0, 0, w, h, (int[])null, 0, w);
            int[] p2 = img2.getRGB(0, 0, w, h, (int[])null, 0, w);

            for(int i = 0; i < p1.length; ++i) {
                if (p1[i] != p2[i]) {
                    p1[i] = highlight;
                }
            }

            BufferedImage out = new BufferedImage(w, h, 1);
            out.setRGB(0, 0, w, h, p1, 0, w);
            return out;
        }

//        public void compareImages(String a_acutualimage, String a_expectedimage) throws Exception {
//            String var10002 = System.getProperty("user.dir");
//            BufferedImage expectedImage = ImageIO.read(new File(var10002 + "\\target\\" + a_acutualimage + ".png"));
//            var10002 = System.getProperty("user.dir");
//            BufferedImage actualImage = ImageIO.read(new File(var10002 + "\\resources\\APMSnapshots\\" + a_expectedimage + ".png"));
//            ImageDiffer imgDiff = new ImageDiffer();
//            ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
//            if (diff.hasDiff()) {
//                String diff1 = "diff";
//                this.compareImage(a_acutualimage, a_expectedimage, diff1);
//                System.out.println("Images are different");
//            } else {
//                System.out.println("Images are same");
//            }
//
//        }

        public void compareImage(String actimg, String expimg, String difference) throws IOException, InterruptedException {
            Thread.sleep(5000L);
            String var10002 = System.getProperty("user.dir");
            BufferedImage var10000 = ImageIO.read(new File(var10002 + "\\target\\" + actimg + ".png"));
            String var10003 = System.getProperty("user.dir");
            var10000 = screenshotComparision(var10000, ImageIO.read(new File(var10003 + "\\resources\\APMSnapshots\\" + expimg + ".png")));
            String var10004 = System.getProperty("user.dir");
            ImageIO.write(var10000, "png", new File(var10004 + "\\target\\" + difference + ".png"));
        }

        public String getElementsAttribute(By m_element, String m_attribute) {
            String m_attributeAsText = m_driver.findElement(m_element).getAttribute(m_attribute);
            return m_attributeAsText;
        }

//        public void takeScreenShot(By a_by, String imageName) throws Exception {
//            Thread.sleep(5000L);
//            Screenshot Screenshot = (new AShot()).shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(m_driver, m_driver.findElement(a_by));
//            BufferedImage var10000 = Screenshot.getImage();
//            String var10004 = System.getProperty("user.dir");
//            ImageIO.write(var10000, "PNG", new File(var10004 + "\\target\\" + imageName + ".png"));
//        }

        public void copyFile(String inputFile, String outputFile) throws IOException {
            FileInputStream instream = null;
            FileOutputStream outstream = null;

            try {
                File infile = new File("D:/Reddy/SwiftEnterprise/Agile Program Management/agile-program-management/public/test1/" + inputFile);
                File outfile = new File("D:/Reddy/SwiftEnterprise/Agile Program Management/APM DEC/agile-program-management/public/data/" + outputFile);
                instream = new FileInputStream(infile);
                outstream = new FileOutputStream(outfile);
                byte[] buffer = new byte[1024];

                int length;
                while((length = instream.read(buffer)) > 0) {
                    outstream.write(buffer, 0, length);
                }
            } catch (Exception var12) {
                var12.printStackTrace();
            } finally {
                instream.close();
                outstream.close();
            }

            System.out.println("File copied successfully!!");
        }

        public List<String> getElementTexts(By a_texts) throws Exception {
            Thread.sleep(5000L);
            List<WebElement> m_listElements = m_driver.findElements(a_texts);
            List<String> m_elementTexts = new ArrayList();
            Iterator var4 = m_listElements.iterator();

            while(var4.hasNext()) {
                WebElement m_singleEle = (WebElement)var4.next();
                String m_elementText = m_singleEle.getText();
                m_elementTexts.add(m_elementText);
            }

            return m_elementTexts;
        }

        /** @deprecated */
        @Deprecated
        public void handleAlert() {
            m_driver.switchTo().alert().accept();
        }

        public String changeDate(String duration, Integer n) {
            return null;
        }

        public void verifyElementPresence(By a_by) throws Exception {
            this.waitForTheElement(a_by, "VISIBILITY_OF_ELEMENT_LOCATED");
            boolean isDisplayed = m_driver.findElement(a_by).isDisplayed();
            if (isDisplayed) {
            }

        }

        public void verifyListOfElementsAttributes(By a_element, List l) throws Exception {
            List<WebElement> elements = this.getElements(a_element);

            for(int i = 0; i < elements.size(); ++i) {
                System.out.println(l.get(i));
            }

        }

        public void verifyListOfElementsAttributes(By a_element, ArrayList<String> l) throws Exception {
            List<WebElement> elements = this.getElements(a_element);

            for(int i = 0; i < elements.size(); ++i) {
            }

        }

        public void selectValueByVisibleText(By a_element, String a_Value) throws Exception {
            this.waitForTheElement(a_element, "CLICKABILITY_OF_ELEMENT_LOCATED");
            boolean w_isDisplayed = m_driver.findElement(a_element).isDisplayed();
            Select w_sel = new Select(m_driver.findElement(a_element));
            w_sel.selectByVisibleText(a_Value);
        }

        public void enterTextUsingJS(By locator, String text) throws Exception {
            boolean status = true;

            try {
                if (!text.equals("")) {
                    WebElement element = m_driver.findElement(locator);
                    JavascriptExecutor jse = (JavascriptExecutor)m_driver;
                    if (element.isEnabled() && element.isDisplayed()) {
                        jse.executeScript("arguments[0].value='" + text + "';", new Object[]{element});

                    }
                }
            } catch (Exception var6) {
            }

        }

        public void mouseHoverAndMove(By by, int x_offset) throws Exception {
            Actions actions = new Actions(m_driver);
            WebElement slider = m_driver.findElement(by);
            actions.moveToElement(slider).build().perform();
            actions.clickAndHold();
            actions.dragAndDropBy(slider, x_offset, 0).build().perform();
        }

        public void enterKeys(By a_element, Keys a_key) throws Exception {
            this.waitForTheElement(a_element, "CLICKABILITY_OF_ELEMENT_LOCATED");
            String w_elementName = this.getElement(a_element).getText();
            if (m_driver.findElement(a_element).isDisplayed()) {
                m_driver.findElement(a_element).sendKeys(new CharSequence[]{a_key});
                System.out.println("" + a_key + " is entered in " + w_elementName);
            }

        }

        public void enterKeysWithoutWait(By a_element, String valueToEnter) throws Exception {
            String w_elementName = this.getElement(a_element).getText();
            if (m_driver.findElement(a_element).isDisplayed()) {
                m_driver.findElement(a_element).click();
                m_driver.findElement(a_element).sendKeys(Keys.CONTROL+"a");
                m_driver.findElement(a_element).sendKeys(Keys.BACK_SPACE);
                m_driver.findElement(a_element).sendKeys(new CharSequence[]{valueToEnter});
                System.out.println("" + valueToEnter + " is entered in " + w_elementName);
            }

        }

        /** @deprecated */
        @Deprecated
        public void appendText(By a_element, String a_text) throws Exception {
            this.waitForTheElement(a_element, "CLICKABILITY_OF_ELEMENT_LOCATED");
            String w_elementName = this.getElement(a_element).getText();
            if (m_driver.findElement(a_element).isDisplayed()) {
                m_driver.findElement(a_element).sendKeys(new CharSequence[]{a_text});
                System.out.println(a_text + " is entered in " + w_elementName);
            }

        }

        /*
         * Author : Hemadri Reddy
         * API : entering text
         * Parameters : need By type xpath and value to be enter
         * Example :this api is created for entering text in setup configuration in website traslation
         */

        public void enterKeysWithString(By a_element, String a_key) throws Exception {
            this.waitForTheElement(a_element, "CLICKABILITY_OF_ELEMENT_LOCATED");
            m_driver.findElement(a_element).click();
                m_driver.findElement(a_element).sendKeys(a_key);
                System.out.println(a_key + " is entered ");


        }

        /** @deprecated */
        @Deprecated
        public void ElementShouldNotBeVisible(By a_element) throws Exception {
            List<WebElement> w_list = m_driver.findElements(a_element);
            boolean w_actual = w_list.isEmpty();
        }

        /** @deprecated */
        @Deprecated
        public void verifyElementDisplayed(By a_element, String wait) throws Exception {
            this.waitForTheElement(a_element, "VISIBILITY_OF_ELEMENT_LOCATED");
            String w_elementName = this.getElement(a_element).getText();
            boolean w_isDisplayed = m_driver.findElement(a_element).isDisplayed();
            if (w_isDisplayed) {
            }

        }

        public void scrollByCoordinates(By a_element) throws Exception {
            Coordinates coordinate = ((Locatable)m_driver.findElement(a_element)).getCoordinates();
            coordinate.onPage();
            coordinate.inViewPort();
        }

        public boolean isEnabled(By a_element) throws Exception {
            boolean isEnabled = m_driver.findElement(a_element).isEnabled();
            return isEnabled;
        }

        public void isDisabled(By a_element) throws Exception {
            boolean w_isdisabled = m_driver.findElement(a_element).isEnabled();
        }

        /** @deprecated */
        @Deprecated
        public String getdynamicdate(int days_after) throws Exception {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            LocalDateTime now = LocalDateTime.now();
            String plannedStart = dtf.format(now.plusDays((long)days_after));
            return plannedStart;
        }

        public void navigateToTraceability() throws Exception {
        }

        public void simpleDragDrop(By a_source, By a_destination) throws Exception {
            WebElement w_src = this.getElement(a_source);
            WebElement w_dest = this.getElement(a_destination);
            Actions w_act = new Actions(m_driver);
            w_act.dragAndDrop(w_src, w_dest).build().perform();
        }

        public void elementRightClick(By a_element) throws Exception {
            this.waitForTheElement(a_element, "PRESENCE_OF_ELEMENT_LOCATED");
            Actions actions = new Actions(m_driver);
            WebElement ele = m_driver.findElement(a_element);
            actions.contextClick(ele).perform();
        }

        /** @deprecated */
        @Deprecated
        public void performAction(WebElement a_element) throws Exception {
            Actions w_actions = new Actions(m_driver);
            w_actions.contextClick(a_element).perform();
        }

        public void navigateToBacklogBoard() throws Exception {
        }

        public void switchAlert(String a_msg, String a_alertAction) throws Exception {
            if (!a_alertAction.equalsIgnoreCase("dismiss") && a_alertAction.equalsIgnoreCase("accept")) {
            }

            m_driver.switchTo().defaultContent();
        }

        public void dragDropElement(By a_source, By a_destination, int xOffset, int yOffset) throws Exception {
            WebElement w_src = this.getElement(a_source);
            WebElement w_dest = this.getElement(a_destination);
            Actions w_act = new Actions(m_driver);
            w_act.clickAndHold(w_src).moveByOffset(xOffset, yOffset).moveToElement(w_dest, xOffset, yOffset).release().build().perform();
        }

        public void moveCardusingBulkMoveTo(String a_cardName, String a_lane) throws Exception {
        }

        public void getPlannedDateText(By a_element, String firstPart, String secondPart) throws Exception {
            try {
                WebElement w_ele = m_driver.findElement(a_element);
                String w_val = w_ele.getAttribute("innerText");
                String[] Array1 = w_val.split("\\(");
                String firstPartBeforeDate = Array1[0].trim();
                String secondPartAfterDate = Array1[1];
                String[] Array2 = secondPartAfterDate.split("\\)");
                String thirdPartAfterDate = Array2[1].trim();
                this.assertTrue(firstPart.contains(firstPartBeforeDate));
                this.assertTrue(secondPart.contains(thirdPartAfterDate));
            } catch (Exception var11) {
            }

        }

        /** @deprecated */
        @Deprecated
        public void explicitWaitCustomized(By a_byclass, String a_waittype) throws Exception {
            new WebDriverWait(m_driver, Duration.ofSeconds(15L));
        }

        public void waitForTheElement(By locator, String waitType) throws Exception {
            try {
                WebDriverWait wait = new WebDriverWait(m_driver, Duration.ofSeconds(15L));
                this.startTime = System.currentTimeMillis();
                if ("CLICKABILITY_OF_ELEMENT_LOCATED".equalsIgnoreCase(waitType)) {
                    wait.until(ExpectedConditions.elementToBeClickable(locator));
                } else if ("PRESENCE_OF_ELEMENT_LOCATED".equalsIgnoreCase(waitType)) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                } else if ("FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT".equalsIgnoreCase(waitType)) {
                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
                } else if ("INVISIBILITY_OF_ELEMENT".equalsIgnoreCase(waitType)) {
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                } else if ("IS_ALERT_PRESENT ".equalsIgnoreCase(waitType)) {
                    wait.until(ExpectedConditions.alertIsPresent());
                } else {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                }
            } catch (Exception var7) {
                log.trace(String.valueOf(var7));
            } finally {
                this.endTime = System.currentTimeMillis();
                this.duration = this.endTime - this.startTime;
//                this.getInfo(locator, this.duration);
            }

        }

//        public void customWaitForElement(By locator, String waitType, int seconds) throws Exception {
//            try {
//                WebDriverWait wait = new WebDriverWait(m_driver, Duration.ofSeconds((long)seconds));
//                this.startTime = System.currentTimeMillis();
//                if ("CLICKABILITY_OF_ELEMENT_LOCATED".equalsIgnoreCase(waitType)) {
//                    wait.until(ExpectedConditions.elementToBeClickable(locator));
//                } else if ("PRESENCE_OF_ELEMENT_LOCATED".equalsIgnoreCase(waitType)) {
//                    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//                } else if ("FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT".equalsIgnoreCase(waitType)) {
//                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
//                } else if ("INVISIBILITY_OF_ELEMENT".equalsIgnoreCase(waitType)) {
//                    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//                } else if ("IS_ALERT_PRESENT ".equalsIgnoreCase(waitType)) {
//                    wait.until(ExpectedConditions.alertIsPresent());
//                } else {
//                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//                }
//            } catch (Exception var8) {
//                log.trace(String.valueOf(var8));
//            } finally {
//                this.endTime = System.currentTimeMillis();
//                this.duration = this.endTime - this.startTime;
//                this.getInfo(locator, this.duration);
//            }
//
//        }

//        public void getInfo(By locator, long duration) throws Exception {
//            String eachTagName;
//            String[] tag;
//            if (tagNames != null) {
//                String[] var4 = tagNames;
//                int var5 = var4.length;
//
//                for(int var6 = 0; var6 < var5; ++var6) {
//                    eachTagName = var4[var6];
//                    String[] splitTagName;
//                    if (eachTagName.contains("Data") || eachTagName.contains("data")) {
//                        splitTagName = eachTagName.split("@");
//                        this.moduleName = splitTagName[1];
//                        break;
//                    }
//
//                    if (eachTagName.contains("Scenario")) {
//                        splitTagName = eachTagName.split("@");
//                        tag = splitTagName[1].split("S");
//                        this.moduleName = tag[0];
//                        break;
//                    }
//                }
//            }
//
//            String currentUrl = m_driver.getCurrentUrl();
//            String baseURL = "";
//            URL url = new URL(currentUrl);
//            eachTagName = url.getProtocol();
//            String host = url.getHost();
//            eachTagName.makeConcatWithConstants<invokedynamic>(eachTagName, host);
//            tag = locator.toString().split("\\.");
//            String[] locatorElement = tag[1].split(": ");
//            String title = m_driver.getTitle();
//            log.debug("Module_Name=" + this.moduleName + ";Web_page=" + title + ";Element_business_name=" + this.label + ";Locator_strategy=" + locatorElement[0] + ";Element_locator=" + locatorElement[1] + ";WaitTime=" + duration + "ms;Current_URL=" + currentUrl);
//        }

        public By retriveLocators(String element) throws Exception {
            By locator = null;
            String[] beforeSplit = element.split(":", 2);
            this.label = beforeSplit[0];
            String[] defineLocator = beforeSplit[1].split("=", 2);
            String locatorType = defineLocator[0];
            String locatorValue = defineLocator[1];
            switch (locatorType) {
                case "id":
                    locator = By.id(locatorValue);
                    break;
                case "class":
                    locator = By.className(locatorValue);
                    break;
                case "css":
                    locator = By.cssSelector(locatorValue);
                    break;
                case "name":
                    locator = By.name(locatorValue);
                    break;
                case "xpath":
                    locator = By.xpath(locatorValue);
            }

            this.local_by = locator;
            return locator;
        }
    }

