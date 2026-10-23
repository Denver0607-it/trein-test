package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartTest {

    WebDriver driver;                     //тест

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://practice-automation.com/javascript-delays");
    }

    @Test
    void startClick() {
        driver.findElement(By.xpath("//button[@class='custom_btn btn_hover']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.id("delay"), "Liftoff!"));

        String actual = driver.findElement(By.id("delay")).getText();
        Assertions.assertEquals("Liftoff!", actual);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
