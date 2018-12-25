package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn {

    private WebDriver driver;
    private String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    //selectors
    private String loginInput = "#txtUsername";
    private String passwordInput = "#txtPassword";
    private String submitLogin = "#btnLogin";


    public LogIn(WebDriver driver) {
        this.driver = driver;
    }

    private void waitElement(String selector){
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

    private WebElement getElement(String selector) {
        waitElement(selector);
        return driver.findElement(By.cssSelector(selector));
    }

    private void open(String baseUrl) {
        driver.get(baseUrl);
    }

    public void logIn() {
        open(baseUrl);
        getElement(loginInput).sendKeys("Admin");
        getElement(passwordInput).sendKeys("admin123");
        getElement(submitLogin).submit();
    }
}
