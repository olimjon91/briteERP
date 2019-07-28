package fuctional_testing.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.TestBase;
import static utilities.ERP.*;
import static utilities.BrowserUtils.highlight;

public class CreateAndDeleteOpportunity extends TestBase {

    public void createOpportunity() throws InterruptedException {
        driver.manage().window().maximize();
        loginAs("pos_manager");
        highlight(driver.findElement(By.xpath("//span[contains(text(), 'CRM')]"))).click();
        highlight(driver.findElement(By.xpath("//button[contains(text(), 'Create')]"))).click();
        highlight(driver.findElement(By.cssSelector("input[placeholder='e.g. Customer Deal']"))).sendKeys("New Opportunity");
        highlight(driver.findElement(By.cssSelector("[name=close_dialog]"))).click();

    }
    @Test
    public void deleteOpportunity() throws InterruptedException{
        createOpportunity();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".o_form_sheet"))));
        driver.navigate().refresh();
        highlight(driver.findElement(By.xpath("//button[@data-view-type='list']"))).click();
        BrowserUtils.waitFor(4);
        highlight(driver.findElement(By.xpath("(//input[@type='checkbox'])[4]"))).click();
//        highlight(driver.findElement(By.xpath("//span[text()='New Opportunity']"))).click();
        highlight(driver.findElement(By.xpath("//button[contains(text(), 'Action')]"))).click();
        highlight(driver.findElement(By.xpath("//a[contains(text(), 'Delete')]"))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='modal-footer']/button)[1]"))));
        highlight(driver.findElement(By.xpath("(//div[@class='modal-footer']/button)[1]"))).click();
        Thread.sleep(5000);
    }
}
