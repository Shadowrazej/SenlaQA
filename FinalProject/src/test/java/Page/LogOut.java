package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOut {

    private WebDriver driver;

    //selectors
    private String welcome = "#welcome";
    private String logOut = "#welcome-menu > ul > li:nth-child(2) a";

    public LogOut(WebDriver driver) {
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

    public void logOut() {
        getElement(welcome).click();
        getElement(logOut).click();
    }
}
