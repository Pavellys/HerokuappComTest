import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class AddRemoveElementTest {
    String property = "webdriver.chrome.driver";
    String getProperty = "src\\test\\resources\\chromedriver.exe";
    WebDriver driver;
    String herokuappURL = "http://the-internet.herokuapp.com/add_remove_elements/";
    int expectedReasultAddElement = 2;
    int expectedResultDeleteElement = 1;

    @Test
    public void addElement(){
        System.setProperty(property,getProperty);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Open http://the-internet.herokuapp.com/add_remove_elements/
        driver.get(herokuappURL);

        //Double click on button "Add element"
        driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();
        driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();

        //Checking how many elements added
        List<WebElement> elementsAdd = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int actualResultAdd = elementsAdd.size();

        //Comparison  current result and expected result
        Assert.assertEquals("Not add element", expectedReasultAddElement, actualResultAdd);

        //Click on "Delete"
        driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();

        //Checking how many elements deleted
        List<WebElement> elementsDelete = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int actualResultDelete = elementsDelete.size();

        Assert.assertEquals(expectedResultDeleteElement, actualResultDelete);

        driver.quit();
    }
}
