package pages;

import org.openqa.selenium.WebDriver;

public class ProductMeli {

    private final WebDriver driver;

    public ProductMeli(WebDriver driver) {
        this.driver = driver;
    }
    public SearchResults searchResults(){
        return new SearchResults(driver);
    }





}
