package org.ait.DemoWebShopVOM.fw;

import com.google.common.io.Files;
import org.ait.DemoWebShopVOM.utils.Recorder;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;

public class HelperBase {
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

//    public boolean isElementPresent(By locator){
//        try {
//            driver.findElement(locator);
//            return true;
//        } catch (NoSuchElementException ex){
//            return false;
//        }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;

    }

    public boolean isAlertPresent(){
        //class Alert = alert inizialization with expected conditions
        Alert alert = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null){
            return false;
        } else {
            // go to alert
            driver.switchTo().alert();
            alert.accept(); //click OK
            return true;
        }
    }

    public void acceptAlert(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (NoAlertPresentException ex) {

        }
    }

    public void click(By selector) {
        driver.findElement(selector).click();
    }

    public void type(By locator, String s) {
        if(s !=null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(s);
        }
    }

    public void pauseSelenium(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e + "Error pauseSelenium");
        }

    }

    public String takeScreenshot(){
       File tempFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       File screenshot = new File("screenshots/screen" +System.currentTimeMillis()/1000 + ".png");

        try {
            Files.copy(tempFile, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return screenshot.getAbsolutePath();
    }

    private ScreenRecorder screenRecorder;
    public void startRecording() throws IOException, AWTException {
        File file = new File("record");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0,0,width,height);
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new Recorder(gc,captureSize,
                new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_MJPG,
                        CompressorNameKey, ENCODING_AVI_MJPG, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null,file,"MyVideo");

        screenRecorder.start();
    }

    public void stopRecording() throws IOException {
        screenRecorder.stop();
    }

    public void deleteScreencast(){
        File directory = new File("record");

        File[] files = directory.listFiles();
        for (File file: files
             ) {
            file.delete();

        }

    }
}
