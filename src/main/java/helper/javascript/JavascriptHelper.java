package helper.javascript;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptHelper {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(JavascriptHelper.class);

    public JavascriptHelper(WebDriver driver){
        this.driver = driver;
        log.info("Javascript helper has been initialised");
    }

    public Object executeScript(String script){
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script);
    }

    public Object executeScript(String script, Object... args){
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script, args);
    }

    public void scrollToElement(WebElement element){
        log.info("scroll to webElement");
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
    }

    public void scrollToElementAndClick(WebElement element){
        scrollToElement(element);
        element.click();
        log.info("Element is clicked: " + element.toString());
    }

    public void scrollIntoView(WebElement element){
        log.info("scroll till web element");
        executeScript("arguments[0].scrollIntoView()", element);
    }

    public void scrollIntoViewAndClick(WebElement element){
        scrollIntoView(element);
        element.click();
        log.info("Element is clicked: "+ element.toString());
    }

    public void scrollDownVertically(){
        executeScript("window.scrollTo(0,document.body.scrollHeight");
    }

    public void scrollUpVertically(){
        executeScript("window.scrollTo(0, - document.body.scrollHeight");
    }

    public void scrollDownByPixel(int pixel){
        executeScript("window.scrollBy(0, " +pixel+ ")");
    }

    public void scrollUpByPixel(int pixel){
        executeScript("window.scrollBy(0,- " +pixel+ ")");
    }

    public void zoomInBy100Percentage(){
        executeScript("document.body.style.zoom = '100%'");
    }

    public void zoomInBy60Percentage(){
        executeScript("document.body.style.zoom = '60%'");
    }

    public void clickElement(WebElement element){
        executeScript("arguments[0].click();", element);
    }
}
