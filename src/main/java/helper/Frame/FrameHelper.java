package helper.Frame;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(FrameHelper.class);

    public void switchToFrame(int index){
        driver.switchTo().frame(index);
        log.info("switched to: " + index + " frame");
    }

    public void switchToFrame(String frameName){
        driver.switchTo().frame(frameName);
        log.info("switched to: " + frameName + " frame");
    }

    public void switchToFrame(WebElement element){
        driver.switchTo().frame(element);
        log.info("switch to frame: " + element.toString());
    }
}
