package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static utilities.BrowserUtils.highlight;

public class ERP extends TestBase {
    public static void login(WebDriver driver){
        highlight(driver.findElement(By.xpath("(//b)[1]"))).click();
        highlight(driver.findElement(By.cssSelector("#login"))).sendKeys(ConfigurationReader.get("username")
                + Keys.TAB + ConfigurationReader.get("password"));
        highlight(driver.findElement(By.cssSelector("button[type=submit]"))).click();
    }
}
