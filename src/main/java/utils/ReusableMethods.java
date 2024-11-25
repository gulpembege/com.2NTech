package utils;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.function.Function;

import static org.junit.Assert.assertTrue;

public class ReusableMethods {

    private static final int TIMEOUT = 10;

    private static Actions actions = new Actions(Driver.getDriver());




    public static String takeScreenshot(String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + "_" + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }


    public static void uploadFile(String filePath, WebElement uploadElement) {

        uploadElement.sendKeys(filePath);
    }



    public static List<String> getElementTexts(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        for (WebElement el : elements) {
            if (!el.getText().isEmpty()) {
                texts.add(el.getText());
            }
        }
        return texts;
    }


    public static void waitForPageToLoad(long timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                .equals("complete"));
    }

    public static void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickWithText(String text) {

        Driver.getDriver().findElement(By.xpath("//*[text()='" + text + "']")).click();
    }





}



