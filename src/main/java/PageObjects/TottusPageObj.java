package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TottusPageObj {

    WebDriver driver;

    public TottusPageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"tottusLoadingPage\"]/div[6]/div/div[3]/div[2]/button[1]")
    WebElement PopUp;

    @FindBy(xpath = "//*[@id=\"new_tottus_nav_cliente_recetas\"]")
    WebElement Btn_Recipe;

    @FindBy(xpath = "//*[@id=\"myDIV\"]/button[4]")
    WebElement Btn_Difficulty;

    public void ClickOnRecipe(){


        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Boolean PopUpDisplayed = PopUp.isEnabled();

        if (PopUpDisplayed == true) {

            PopUp.click();
            String handle = driver.getWindowHandle();
            Btn_Recipe.click();
            Set handles = driver.getWindowHandles();
            // Pass a window handle to the other window
            for (String handle1 : driver.getWindowHandles()) {
                driver.switchTo().window(handle1);
            }

        } else {

            String handle = driver.getWindowHandle();
            // System.out.println(handle);
            Btn_Recipe.click();
            Set handles = driver.getWindowHandles();
            // Pass a window handle to the other window
            for (String handle1 : driver.getWindowHandles()) {
                driver.switchTo().window(handle1);
            }
        }
    }

    public void SelectDifficulty(){

        Btn_Difficulty.click();
    }

    public void SelectRecipe(){

        try { Thread.sleep(3000);

            List<WebElement> myList = driver.findElements(By.className("card-desc"));
            List<String> all_elements_text = new ArrayList<>();

            for (int i = 0; i < myList.size(); i++) {
                all_elements_text.add(myList.get(i).getText());
            }

            for (int i = 0; i < all_elements_text.size(); i++) {
                if (all_elements_text.get(i).contains("CORONA DE ROLLITOS DE CANELA")) {
                    i++;
                    WebElement Div_Cinnammon = driver.findElement(By.xpath("(//div[@class='card-desc'])[" + i + "]"));
                    Div_Cinnammon.click();
                    i = all_elements_text.size();
                }
            }
        }
        catch (InterruptedException e) {

            System.out.println("RECETA NO ENCONTRADA");
        }
        }

        public void FindTheIngredients(){

            try { Thread.sleep(3000);

                System.out.println("Buscando Ingredientes");
                Boolean Ingredient_1 = driver.getPageSource().contains("azúcar rubia");
                Boolean Ingredient_2 = driver.getPageSource().contains("canela en polvo");

                if (Ingredient_1==true && Ingredient_2 ==true){
                    System.out.println("INGREDIENTES ENCONTRADOS");
                }
                else{
                    System.out.println("NO EXISTEN ESTOS INGREDIENTES DENTRO DE LA RECETA");
                }
           }
            catch (InterruptedException e) {
                System.out.println("UPS! ALGO SALIO MAL");
            }
        }
    }
