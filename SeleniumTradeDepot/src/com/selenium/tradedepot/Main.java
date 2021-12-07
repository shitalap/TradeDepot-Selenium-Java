package com.selenium.tradedepot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tradedepot.co.nz/");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement KitchenTab = driver.findElement(By.xpath("//ul[@id='myNavbar']//a[normalize-space()='Kitchen']"));
        actions.moveToElement(KitchenTab, 0,0).build().perform();

        WebElement baseCabinets = driver.findElement(By.xpath("//a[text()='White Woodgrain Kitchen']/../../div[2]//*/a[text()='Base Cabinets']"));
        baseCabinets.click();

        Select sortItem = new Select(driver.findElement(By.xpath("//span[text()='Sort By:']/../div/select")));
        sortItem.selectByIndex(3);

        List<WebElement> ListItems = driver.findElements(By.xpath("//div[@id='wrapping-div']/div/.//div[@class='price-area-price']\n"));
         WebElement Item1Price = ListItems.get(0);

            String ExpectedPrice = "$109";

            if (Item1Price.getText().equals(ExpectedPrice))
                System.out.println("Test Passed");
            else
                System.out.println("Test Failed");

            //close the browser
            driver.quit();
    }
}
