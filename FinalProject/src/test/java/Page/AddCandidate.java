package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCandidate {

    private WebDriver driver;

    //selectors
    private String menuRecruitment = "#menu_recruitment_viewRecruitmentModule";
    private String menuCandidates = "#menu_recruitment_viewCandidates";
    private String addButton = "#btnAdd";
    private String firstName = "#addCandidate_firstName";
    private String lastName = "#addCandidate_lastName";
    private String email = "#addCandidate_email";
    private String saveButton = "#btnSave";


    public AddCandidate(WebDriver driver) {
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

    private void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void addCandidate() {
        scrollToElement(getElement(menuRecruitment));
        getElement(menuCandidates).click();
        getElement(addButton).click();
        getElement(firstName).sendKeys("Vasya");
        getElement(lastName).sendKeys("Petrov");
        getElement(email).sendKeys("vasya@petrov.com");
        getElement(saveButton).click();
    }
}
