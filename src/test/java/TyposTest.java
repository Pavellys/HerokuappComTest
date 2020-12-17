import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




import java.util.List;


public class TyposTest {
    String property = "webdriver.chrome.driver";
    String getPath = "src\\test\\resources\\chromedriver.exe";
    WebDriver driver;
    String typosURL = "http://the-internet.herokuapp.com/typos";
    String expectedResult = "Sometimes you'll see a typo, other times you won,t.";
    String bug = "Misspelling of the paragraph";
    @Test
    public void typosTest() {
        System.setProperty(property, getPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Open website http://the-internet.herokuapp.com/typos
        driver.get(typosURL);
        //Search for text elements
        List<WebElement> textList = driver.findElements(By.tagName("p"));
        //Receiving actual result
        String actualResult = textList.get(1).getText();
        //Compare expected result and actual
        Assert.assertEquals(bug,expectedResult, actualResult);
        driver.quit();
    }
}
