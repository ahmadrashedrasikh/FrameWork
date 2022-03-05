package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static WebDriver webDriver;

    public static void openBrowser() {
        ConfigReader.readProperties(Constants.FILE_PATH_CONFIG);
        switch (ConfigReader.getPropValue("browser")) {
            case "chrome":
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.setHeadless(true);
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser");
        }
        webDriver.get(ConfigReader.getPropValue("url"));
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }


    public static void clickMethod(WebElement element) {
        clickAbilityWait(element);
        element.click();
    }

    public static void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", element);
    }


    public static WebDriverWait getWait() {

        return new WebDriverWait(webDriver, Constants.EXPLICIT_WAIT);
    }

    public static void clickAbilityWait(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));

    }


    public static byte[] takeScreenshot(String fileName){

        TakesScreenshot ts=(TakesScreenshot) webDriver;

        File srcFile=ts.getScreenshotAs(OutputType.FILE);

        byte[] picBytes=ts.getScreenshotAs(OutputType.BYTES);

        try {
            FileUtils.copyFile(srcFile,new File(Constants.SCREENSHOT_PATH+fileName+getTimeStamp("yyyy-mm-dd-mm-ss-ms")+".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String dateFormat){
        Date date=new Date();

        SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);

        return sdf.format(date);
    }


    public static void tearDown() {
        webDriver.quit();
    }

}
