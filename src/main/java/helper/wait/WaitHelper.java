package helper.wait;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitHelper {

    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(WaitHelper.class);
    public WaitHelper(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This is ImpicitWait method
     * @param timeout
     * @param unit
     * */
    public void setImplicitWait(long timeout, TimeUnit unit){
        log.info("Implicit wait has been set to : " + timeout);
        driver.manage().timeouts().implicitlyWait(timeout, unit);
    }
    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec){
        //tạo 1 biến tham chiếu wait và khai báo thời gian chờ tối đa để quá trình thực thi tạm dừng.
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
        //Lặp lại nếu chưa tìm thấy element đó
        webDriverWait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
        webDriverWait.ignoring(ElementNotVisibleException.class);
        webDriverWait.ignoring(NoSuchFieldException.class);
        webDriverWait.ignoring(StaleElementReferenceException.class);
        webDriverWait.ignoring(NoSuchFrameException.class);
        return webDriverWait;
    }

    public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec){
        log.info("Waiting for: " +element.toString()+ " for: " + timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        //Kiểm tra 1 phần tử trên DOM có hiển thị hay không
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element is visible now ");
    }

    public void WaitForElementToClickable(WebElement element, int timeOutInSeconds) {
        log.info("Waiting for: " + element.toString() + " for: " + timeOutInSeconds + " seconds");
        //tạo 1 biến tham chiếu wait và khai báo thời gian chờ tối đa để quá trình thực thi tạm dừng.
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        //Chờ 1 phần tử có thể click được. Element này phải được hiển diện trên màn hình và phải enable
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("Element is clickable now ");
    }
    public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds){
        log.info("Waiting for: " +element.toString()+ " for :" +timeOutInSeconds+ " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
        log.info("Element is invisibile now");
        return status;
    }

    public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds){
        log.info("Waiting for: " +element.toString()+ " for :" +timeOutInSeconds+ " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        log.info("Frame is available and switched");
    }

    private Wait<WebDriver> getFluentWait(int timeOutInSeconds, int pollingEveryInMiliSec){
        Wait<WebDriver> fWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);

        return fWait;
    }

    public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec){
        Wait<WebDriver> fWait = getFluentWait(timeOutInSeconds, pollingEveryInMiliSec);
        fWait.until(ExpectedConditions.visibilityOf(element));
        return element;
        }

        public void pageLoadTime(long timeout, TimeUnit unit){
        log.info("waiting for page to load for: " + unit);
        driver.manage().timeouts().pageLoadTimeout(timeout,unit);
        log.info("Page is loaded");
        }
}
