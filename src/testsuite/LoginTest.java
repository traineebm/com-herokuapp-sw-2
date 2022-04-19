package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://the-internet.herokuapp.com/login";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Finding the username field element
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        // Finding the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // sending Password to password field element
        passwordField.sendKeys("SuperSecretPassword!");
        // Finding the login button and clicking on it
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        //Verify the text from the given requirements
        String expectedTextMessage = "Secure Area";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        //Getting the text by using get method
        String actualTextMessage = actualTextMessageElement.getText();
        //Validate expected and actual text message
        Assert.assertEquals("Login successful",expectedTextMessage,actualTextMessage);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        // Finding the username field element
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");
        // Finding the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // sending Password to password field element
        passwordField.sendKeys("SuperSecretPassword!");
        // Finding the login button and clicking on it
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        //Verify the text from the given requirements
        String expectedTextMessage = "Your username is invalid!";
        WebElement actualTextMessageElement = driver.findElement(By.id("flash"));
        //Getting the text by using get method
        String actualTextMessage = actualTextMessageElement.getText();
        //Using substring method
        String actualString = actualTextMessage.substring(0,25);
        //Validate expected and actual text message
        Assert.assertEquals("Login unsuccessful",expectedTextMessage,actualString);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        // Finding the username field element
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        // Finding the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // sending Password to password field element
        passwordField.sendKeys("SuperSecretPassword");
        // Finding the login button and clicking on it
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        //Verify the text from the given requirements
        String expectedTextMessage = "Your password is invalid!";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//div[@id='flash']"));
        //Getting the text by using get method
        String actualTextMessage = actualTextMessageElement.getText();
        //Using substring method
        String actualString = actualTextMessage.substring(0,25);

        //Validate expected and actual text message
        Assert.assertEquals("Login unsuccessful", expectedTextMessage,actualString);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
