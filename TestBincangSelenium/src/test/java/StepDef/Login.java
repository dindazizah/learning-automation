package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;
    @Given("Open web url {string}")
    public void openWebUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    @And("Input username {string} and password {string}")
    public void inputUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @When("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("Successfully login and redirect to homepage")
    public void successfullyLoginAndRedirectToHomepage() {
        Assert.assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
        driver.close();
        driver.quit();
    }
}
