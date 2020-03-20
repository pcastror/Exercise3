package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjects.GoogleSearchPageObj;
import PageObjects.TottusPageObj;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    WebDriver driver = null;


    @Given("user is on google")
    public void user_is_on_google() {

        String Browser = "Firefox";

        if(Browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/WebDrivers/chromedriver");
            driver = new ChromeDriver();
        }
        else {
            if (Browser.equals("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/WebDrivers/geckodriver");
                driver = new FirefoxDriver();
            }
            else{
                System.out.println("Driver no encontrado");
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.cl");
    }

    @When("The user search the Tottus stores")
    public void the_user_search_the_Tottus_stores() {

        GoogleSearchPageObj Google = new GoogleSearchPageObj(driver);
        Google.GoogleSearch();

    }

    @And("find Nataniel Cox and click on Web site")
    public void find_Nataniel_Cox_and_click_on_Web_site() {

        GoogleSearchPageObj Google = new GoogleSearchPageObj(driver);
        Google.SelectWebSite();

    }

    @And("Tottus is open click on Recipe")
    public void tottus_is_open_click_on_Recipe() {

        TottusPageObj Tottus = new TottusPageObj(driver);
        Tottus.ClickOnRecipe();

    }

    @And("Select a High difficult")
    public void select_a_High_difficult() {

        TottusPageObj Tottus = new TottusPageObj(driver);
        Tottus.SelectDifficulty();

    }

    @And("Find a cinnamon rolls and click it")
    public void find_a_cinnamon_rolls_and_click_it() {

        TottusPageObj Tottus = new TottusPageObj(driver);
        Tottus.SelectRecipe();

    }

    @Then("recipe should be contain cinnamon and sugar ingredients")
    public void recipe_should_be_contain_cinnamon_and_sugar_ingredients() {

        TottusPageObj Tottus = new TottusPageObj(driver);
        Tottus.FindTheIngredients();

        driver.close();
        driver.quit();

    }
}
