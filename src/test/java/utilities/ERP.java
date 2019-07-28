package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utilities.BrowserUtils.highlight;

public class ERP extends TestBase {
    public static void loginAs(String user) {
        String username = "";
        String password = "";
        if (user.equals("sales_manager")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        } else if (user.equals("pos_manager")) {
            username = ConfigurationReader.get("pos_manager_username");
            password = ConfigurationReader.get("pos_manager_password");
        }
        highlight(Driver.get().findElement(By.xpath("(//b)[1]"))).click();
        highlight(Driver.get().findElement(By.cssSelector("#login"))).sendKeys(username +
                Keys.TAB + password);
        highlight(Driver.get().findElement(By.cssSelector("button[type=submit]"))).click();
    }

    public static void clickOnModule(String module) {
        WebElement element = Driver.get().findElement(By.xpath("//span[contains(text(),'"+module+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


}
