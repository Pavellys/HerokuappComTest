import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SortableDataTablesTest {
    String property = "webdriver.chrome.driver";
    String getProperty = "src\\test\\resources\\chromedriver.exe";
    WebDriver driver;
    String herokuappURL = "http://the-internet.herokuapp.com/tables";
    String expectedResult_1 = "Smith";
    String expectedResult_2 = "Tim";
    String expectedResult_3 = "Bach";
    String expectedResult_4 = "Jason";
    String expectedResult_5 = "http://www.jdoe.com";
    @Test
    public void tablesTest(){
        System.setProperty(property, getProperty);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Open website http://the-internet.herokuapp.com/tables
        driver.get(herokuappURL);

        //Search and compare expected and actual results on tables
        String actualResult_1 = driver.findElement(By.xpath("//table[1]//tbody//tr[1]//td[1]")).getText();
        Assert.assertEquals(expectedResult_1, actualResult_1);
        String actualResult_2 = driver.findElement(By.xpath("//table[1]//tbody//tr[4]//td[2]")).getText();
        Assert.assertEquals(expectedResult_2, actualResult_2);
        String actualResult_3 = driver.findElement(By.xpath("//table[2]//tbody//tr[2]//td[1]")).getText();
        Assert.assertEquals(expectedResult_3, actualResult_3);
        String actualResult_4 = driver.findElement(By.xpath("//table[2]//tbody//tr[3]//td[2]")).getText();
        Assert.assertEquals(expectedResult_4, actualResult_4);
        String actualResult_5 = driver.findElement(By.xpath("//table[1]//tbody//tr[3]//td[5]")).getText();
        Assert.assertEquals(expectedResult_5, actualResult_5);

        driver.quit();
    }
}
