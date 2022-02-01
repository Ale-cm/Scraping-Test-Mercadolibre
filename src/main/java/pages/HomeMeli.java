package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeMeli {


    private final WebDriver driver;
    private final By bottonSearch = By.xpath("//button[@type='submit']");
    private final By search = By.id("cb1-edit");
    private final  By oferta = By.xpath("//h2[contains(text(),'Ofertas')]");

    public HomeMeli(WebDriver driver) {
        this.driver= driver;
    }
    public void searched(String productName){
        driver.findElement(search).sendKeys(productName);

    }
    public String searchOferta(){
       return driver.findElement(oferta).getText();
    }

    public SearchResults clickBottonSearch(){
        driver.findElement(bottonSearch).click();
        return new SearchResults(driver);
    }

    public String homeTitulo(){
       return driver.getTitle();
    }



}
