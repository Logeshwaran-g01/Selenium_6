package Project_Sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class datePicker {
    WebDriver date;
    String url ="https://jqueryui.com/datepicker/";

    @BeforeTest
    public void setUp(){
        date = new ChromeDriver();
        date.get(url);
        date.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        date.manage().window().maximize();
    }
    @AfterTest
    public void tearDown(){
        //date.close();
    }

    @Test
    public void test1(){
        //Using Frame
        date.switchTo().frame(0);
        //Using Explicit wait to data picker table
        date.findElement(By.xpath("//input[@id='datepicker']")).click();
        WebDriverWait wait = new WebDriverWait(date,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='ui-datepicker-calendar']")));
        //Selecting Month
        date.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        //Selecting date and print the attributes
        date.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[4]/td[7]/a")).click();
        String str = date.findElement(By.xpath("//input[@id='datepicker']")).getAttribute("value");
        System.out.println(str);


    }
}
