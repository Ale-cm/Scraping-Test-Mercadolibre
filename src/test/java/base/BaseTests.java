package base;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
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

    public String getScreenShoot() throws IOException {
        File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path= System.getProperty("user.dir")+"/Screenshots/image.png";
        FileUtils.copyFile(source,new File(path));
        return path;
    }

    /**
     *  por que base64 en caso de que sean 1000 tests de la otra forma se haria muy pesado. Para enviarse por mail por ejemplo.
     *
     */
    private String getBase64() {
        return ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BASE64);
    }
//todo: Arreglar
    @DataProvider(name = "Authentication")
    public static Object[][] pruductos() {
        return new Object[][] { { "Zapatillas", "Test@123" }, { "Calsoncillo ", "Test@123" } };
    }


    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.ar/");
        homeMeli = new HomeMeli(driver);
        driver.manage().window().maximize();

        }


        @AfterMethod
        public synchronized void afterMethod(ITestResult result) {
            switch (result.getStatus()) {
                case ITestResult.FAILURE:
                    ExtentTestManager.getTest(result).fail("ITestResult.FAILURE, event afterMethod",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
                    break;
                case ITestResult.SKIP:
                    ExtentTestManager.getTest(result).skip("ITestResult.SKIP, event afterMethod");
                    break;
                default:
                    break;
            }
        }
    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();

    }


}
