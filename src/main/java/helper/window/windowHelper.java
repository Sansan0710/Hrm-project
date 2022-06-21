package helper.window;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class windowHelper {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(windowHelper.class);

    public windowHelper(WebDriver driver){
        this.driver = driver;
    }

    public void switchToParentWindow(){
        log.info("switching to parent window....");
        driver.switchTo().defaultContent();
    }

    public void switchToWindow(int index){
        Set<String> windows = driver.getWindowHandles();
        int i = 1;
        for(String window: windows){
            if(i == index){
                log.info("Switch to: " + index + " window");
                driver.switchTo().window(window);
            }else {
                i++;
            }
        }
    }

    public void closeAllTabsAndSwitchToMainWindow(){
        Set<String> windows = driver.getWindowHandles();
        String mainwindow = driver.getWindowHandle();

        for(String window: windows){
            if(!window.equalsIgnoreCase(mainwindow)){
                driver.close();
            }
        }
        log.info("Switched to main window");
        driver.switchTo().window(mainwindow);
    }

    public void navigateBack(){
        log.info("Navigating back");
        driver.navigate().back();
    }

    public void navigateForward(){
        log.info("Navigating forward");
        driver.navigate().forward();
    }
}
