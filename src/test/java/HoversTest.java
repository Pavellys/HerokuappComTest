import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoversTest {
    String property = "webdriver.chrome.driver";
    String getProperty = "src\\test\\resources\\chromedriver.exe";
    Actions action ;
    WebDriver driver;
    WebElement avatar;
    String herokuappURL = "http://the-internet.herokuapp.com/hovers";
    String expectedResult = "Not Found";

    @Test
    public void firstUserTest(){
        System.setProperty(property, getProperty);
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        //Open website http://the-internet.herokuapp.com/hovers
        driver.get(herokuappURL);
        //Search first avatar
        avatar = driver.findElements(By.xpath("//img[@src='/img/avatar-blank.jpg']")).get(0);
        //Hover over the avatar and click on the link
        action.moveToElement(avatar).moveToElement(driver.findElement(By.xpath("//*[@href='/users/1']")))
                .click().build().perform();
        //get actual result
        String actualResult = driver.findElement(By.xpath("//h1")).getText();
        //Compare expected result ans actual
        Assert.assertEquals("not the correct result", expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void secondUserTest(){
        System.setProperty(property, getProperty);
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        //Open website http://the-internet.herokuapp.com/hovers
        driver.get(herokuappURL);
        //Search second avatar
        avatar = driver.findElements(By.xpath("//img[@src='/img/avatar-blank.jpg']")).get(1);
        //Hover over the avatar and click on the link
        action.moveToElement(avatar).moveToElement(driver.findElement(By.xpath("//*[@href='/users/2']")))
                .click().build().perform();
        //get actual result
        String actualResult = driver.findElement(By.xpath("//h1")).getText();
        //Compare expected result ans actual
        Assert.assertEquals("not the correct result", expectedResult, actualResult);
        driver.quit();
    }
    @Test
    public void thirdUserTest(){
        System.setProperty(property, getProperty);
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        //Open website http://the-internet.herokuapp.com/hovers
        driver.get(herokuappURL);
        //Search third avatar
        avatar = driver.findElements(By.xpath("//img[@src='/img/avatar-blank.jpg']")).get(2);
        //Hover over the avatar and click on the link
        action.moveToElement(avatar).moveToElement(driver.findElement(By.xpath("//*[@href='/users/3']")))
                .click().build().perform();
        //get actual result
        String actualResult = driver.findElement(By.xpath("//h1")).getText();
        //Compare expected result ans actual
        Assert.assertEquals("not the correct result", expectedResult, actualResult);
        driver.quit();
    }
}
