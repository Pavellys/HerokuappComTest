import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
/*проверить, что первый чекбокс unchecked, отметить первый чекбокс, проверить что он checked.
 Проверить, что второй чекбокс checked, сделать unheck, проверить, что он unchecked
 */

public class CheckBoxesTest {
    String property = "webdriver.chrome.driver";
    String getPath = "src\\test\\resources\\chromedriver.exe";
    WebDriver driver;
    String checkBoxesURL = "http://the-internet.herokuapp.com/checkboxes";
    boolean expectedResult_1 = true;
    boolean expectedResult_2 = false;

    @Test
    public void checkBoxesTesting(){
        System.setProperty(property, getPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open website http://the-internet.herokuapp.com/checkboxes
        driver.get(checkBoxesURL);

        //Search for elements "checkbox" and check their values
        List<WebElement> listBoxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
        boolean check_1 = listBoxes.get(0).isSelected();
        boolean check_2 = listBoxes.get(1).isSelected();

        //Checking  elements and change them
        if(!check_1){
            listBoxes.get(0).click();
            if(check_2 ){
                listBoxes.get(1).click();
            }
        }else if (check_1){
            listBoxes.get(0).click();
            if(!check_2){
                listBoxes.get(1).click();
            }
        }
        //Check values after click
        List<WebElement> listBoxesChange = driver.findElements(By.xpath("//*[@type='checkbox']"));
        boolean actualResult_1 = listBoxesChange.get(0).isSelected();
        boolean actualResult_2 = listBoxesChange.get(1).isSelected();
        //Compare results
        Assert.assertEquals(expectedResult_1, actualResult_1);
        Assert.assertEquals(expectedResult_2, actualResult_2);

        driver.quit();
    }
}
