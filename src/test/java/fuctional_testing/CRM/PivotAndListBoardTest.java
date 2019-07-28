package fuctional_testing.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.*;

import java.util.*;


public class PivotAndListBoardTest extends TestBase {
    @Test
    public void verifyingTableInListAndPivotView() {
        ERP.loginAs("sales_manager");
        ERP.clickOnModule("CRM");
        WebElement pivot = driver.findElement(By.xpath("//button[@aria-label='pivot']"));
        BrowserUtils.waitForClickablility(pivot, 5);
        pivot.click();
        WebElement total = driver.findElement(By.xpath("//td[text()='Total']"));
        BrowserUtils.waitForClickablility(total, 5);
        total.click();
        total = driver.findElement(By.xpath("//td[text()='Total']"));
        BrowserUtils.waitForClickablility(total, 5);
        total.click();
        double totalPricePivot = Double.parseDouble(driver.findElement(By.xpath("//table//tr[1]/td[2][@class='o_pivot_cell_value text-right']")).getText().replace(",",""));
        driver.findElement(By.xpath("//a[.='Opportunity']")).click();
        List<Opportunity> opportunities = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[2]/td[2]")));
        int size = driver.findElements(By.xpath("//table/tbody/tr/td[3]")).size();
        for (int i = 2; i <= size; i++) {
            String one = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]")).getText();
            String two = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText();
            opportunities.add(new Opportunity(one, new Double(two.replace(",", ""))));
        }
        driver.findElement(By.xpath("//button[@type='button' and @accesskey='l']")).click();
        List<Opportunity> opportunitiesList = new ArrayList<>();
        BrowserUtils.waitFor(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr/td[3]")));
        size = driver.findElements(By.xpath("//table/tbody/tr/td[3]")).size();
        for (int i = 1; i <= size; i++) {
            try {
                String one = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]")).getText();
                String two = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[9]")).getText();
                opportunitiesList.add(new Opportunity(one, new Double(two.replace(",", ""))));
            } catch (RuntimeException e) {
                break;
            }
        }
        Collections.sort(opportunities);
        Collections.sort(opportunitiesList);
        double totalPriceList = Double.parseDouble(driver.findElement(By.xpath("(//table//td[@class='o_list_number'])[1]")).getText().replace(",",""));
        double totalPrice1 = 0;
        double totalPrice2 = 0;
        for (int i = 0; i < opportunities.size(); i++){
            totalPrice1 += opportunities.get(i).revenue;
            totalPrice2 += opportunitiesList.get(i).revenue;
        }
        Assert.assertEquals(opportunities, opportunitiesList);
        Assert.assertEquals(totalPricePivot, totalPriceList);
        Assert.assertEquals(totalPrice1, totalPrice2);
        Assert.assertEquals(totalPricePivot, totalPrice1);
        Assert.assertEquals(totalPriceList, totalPrice2);


    }
}
