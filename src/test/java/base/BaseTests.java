package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomeMeli;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;

public class BaseTests  {
    private WebDriver driver;
    protected HomeMeli homeMeli;
    protected  ExtentReports extent ;
    protected ExtentSparkReporter spark;

    public String getScreenShoot() throws IOException {
        File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path= System.getProperty("user.dir")+"/Screenshots/image.png";
        FileUtils.copyFile(source,new File(path));
        return path;
    }

    //por que base64 en caso de que sean 1000 tests de la otra forma se haria muy pesado. Para enviarse por mail por ejemplo.
    public String getBase64() {
        return ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BASE64);
    }

    @BeforeSuite
    public void setUpSuite(){
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark/MeliReport.html");
        extent.attachReporter(spark);

    }



    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        // Exercise
        driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.ar/");
        homeMeli = new HomeMeli(driver);
        driver.manage().window().maximize();

        }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();

    }

    @AfterSuite
    public void TearDownSuite(){
        extent.flush();
    }
}
