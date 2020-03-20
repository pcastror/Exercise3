package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleSearchPageObj {

    WebDriver driver;

    public GoogleSearchPageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='gLFyf gsfi']")
    WebElement TxtBox_GoogleSearch;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[2]/div/div[2]/div/div[4]/div[1]/div[1]/div/div/a[2]/div/div")
    WebElement Link_WebSite;

    public void GoogleSearch() {

        TxtBox_GoogleSearch.sendKeys("Tottus Sucursales");
        TxtBox_GoogleSearch.submit();
    }

    public void SelectWebSite(){

        Link_WebSite.click();
    }
}