package fuctional_testing.Perchases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBase;

import static utilities.BrowserUtils.*;

public class CreateAProdactAsAManager extends TestBase {
    @Test
    public void createProduct() throws InterruptedException {
        driver.manage().window().maximize();
        highlight(driver.findElement(By.xpath("(//b)[1]"))).click();
        highlight(driver.findElement(By.cssSelector("#login"))).sendKeys(ConfigurationReader.get("posmanager")
                + Keys.TAB + ConfigurationReader.get("posmanagerpassword"));
        highlight(driver.findElement(By.cssSelector("button[type=submit]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Purchases')]")));
        highlight(driver.findElement(By.xpath("//span[contains(text(), 'Purchases')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(), 'Products')])[5]")));
        highlight(driver.findElement(By.xpath("(//span[contains(text(), 'Products')])[5]"))).click();
        wait.until(ExpectedConditions.titleContains("Products"));
        highlight(driver.findElement(By.xpath("//button[contains(text(), 'Create')]"))).click();
        wait.until(ExpectedConditions.titleContains("New"));
        highlight(driver.findElement(By.cssSelector("input[name=name]"))).sendKeys("Lap top");
        highlight(driver.findElement(By.cssSelector("button[accesskey=s]"))).click();
        wait.until(ExpectedConditions.titleContains("Lap top"));
        Assert.assertTrue(driver.getTitle().contains("Lap top"));
        Thread.sleep(2000);
    }

    @Test
    public void createVendor() throws InterruptedException {
        driver.manage().window().maximize();
        highlight(driver.findElement(By.xpath("(//b)[1]"))).click();
        highlight(driver.findElement(By.cssSelector("#login"))).sendKeys(ConfigurationReader.get("username")
                + Keys.TAB + ConfigurationReader.get("password"));
        highlight(driver.findElement(By.cssSelector("button[type=submit]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Purchases')]")));
        highlight(driver.findElement(By.xpath("//span[contains(text(), 'Purchases')]"))).click();
        highlight(driver.findElement(By.xpath("//span[contains(text(),'Vendors')]"))).click();
        wait.until(ExpectedConditions.titleContains("Vendors"));
        highlight(driver.findElement(By.xpath("//button[contains(text(), 'Create')]"))).click();

        highlight(driver.findElement(By.cssSelector("input[name=name]"))).sendKeys("Assasin Prior");
        highlight(driver.findElement(By.cssSelector("input[placeholder='Street...']"))).sendKeys("45 Alien rd");
        highlight(driver.findElement(By.cssSelector("input[placeholder='City']"))).sendKeys("Rixford"+Keys.TAB+"Maryland"+Keys.TAB+"21136");
        // highlight(driver.findElement(By.xpath("(//input[@class='o_input ui-autocomplete-input'])[2]"))).sendKeys("Maryland");
//        //driver.findElement(By.xpath("(//input[@class='o_input ui-autocomplete-input'])[2]")).submit();
//        highlight(driver.findElement(By.cssSelector("input[placeholder='ZIP']"))).sendKeys("21136");
        highlight(driver.findElement(By.cssSelector("button[accesskey=s]"))).click();
        wait.until(ExpectedConditions.titleContains("Assasin Prior"));
        Assert.assertTrue(driver.getTitle().contains("Assasin Prior"));
        Thread.sleep(2000);
    }
}
