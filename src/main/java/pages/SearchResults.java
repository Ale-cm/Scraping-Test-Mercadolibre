package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResults {
    private final WebDriver driver;
    private final By productNameResult= By.xpath("//div/h1");
    private final By products = By.xpath("//ol/li/div/div/a[starts-with(@href,'https://')]");
    public SearchResults(WebDriver driver) {
        this.driver=driver;
    }






}
