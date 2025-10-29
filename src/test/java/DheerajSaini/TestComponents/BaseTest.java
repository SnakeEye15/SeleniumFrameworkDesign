package DheerajSaini.TestComponents;

import DheerajSaini.pageObjects.LandingPage.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage page;

    public WebDriver initializeBrowser() throws IOException {
        //properties class

        Properties prop= new Properties();
        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//DheerajSaini//resources//GlobalData.properties");
        prop.load(fis);

        String browserName=prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();

        return driver;
    }
    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
       driver= initializeBrowser();
        page= new LandingPage(driver);
        page.goTo();
        return page;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
