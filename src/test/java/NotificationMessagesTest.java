import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class NotificationMessagesTest {
    String property = "webdriver.chrome.driver";
    String getProperty = "src\\test\\resources\\chromedriver.exe";
    WebDriver driver;
    String herokuappURL = "http://the-internet.herokuapp.com/notification_message_rendered";
    String expectedResult_1 = "Action successful";
    String expectedResult_2 = "Action unsuccesful, please try again";

    @Test
    public void notificationMessages(){
        System.setProperty(property, getProperty);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Open website http://the-internet.herokuapp.com/notification_message_rendered
        driver.get(herokuappURL);
        //Click to link "click here"
        driver.findElement(By.xpath("//*[@href='/notification_message']")).click();
        //Search actual result
        String actualResult = driver.findElement(By.xpath("//*[@id='flash']")).getText();
        actualResult = actualResult.substring(0,actualResult.length()-1);
        //Compare expected and actual results
        if(expectedResult_1.equals(actualResult)){
            Assert.assertEquals(actualResult, expectedResult_1, "Message doesn't match");

        }
        else if(expectedResult_2.equals(actualResult)){
            Assert.assertEquals(actualResult, expectedResult_1, "Message doesn't match");
        }
        driver.quit();
    }
}
