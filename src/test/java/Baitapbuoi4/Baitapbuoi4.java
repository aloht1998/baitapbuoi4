package Baitapbuoi4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Baitapbuoi4 {
    WebDriver driver;

    public void Searchtextbox(String s) {
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@data-view-id='main_search_form_input']"));
        WebElement btnSearch = driver.findElement(By.xpath("//button[@data-view-id='main_search_form_button']"));
        WebElement cancel = driver.findElement(By.xpath("//button[@id='onesignal-slidedown-cancel-button']"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        cancel.click();
        searchTextBox.sendKeys(s);
        btnSearch.click();
    }

    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://tiki.vn/");
        driver.manage().window().maximize();

    }

    @Test
    public void timKiemSanPham() {
        Searchtextbox("asus ");

        WebElement chonSanPham = driver.findElement(By.xpath("//img[@src='https://salt.tikicdn.com/cache/280x280/ts/product/39/cd/24/981a83d9343fa55f98a6f5bac1d2d312.jpg']"));
        chonSanPham.click();
        WebElement hienThiSanPham = driver.findElement(By.xpath("//div[@class='style__ProductImagesStyle-sc-1e5ea5s-0 iTTtrw']"));
        Assert.assertTrue(hienThiSanPham.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}


