package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();

    public static FileReader fr_prop;
    public static FileReader fr_loc;

    @BeforeTest
    public void setUp() throws IOException {
        if(driver == null){
            fr_prop = new FileReader("src\\main\\resources\\configfiles\\config.properties");
            fr_loc = new FileReader("src\\main\\resources\\configfiles\\locators.properties");


            prop.load(fr_prop);
            loc.load(fr_loc);
        }

        if(prop.getProperty("chrome_browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("test_url"));
        }
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        System.out.println("TearDown successfully");
    }


}
