package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class JobTitles {

    private WebDriver driver;

    //selectors
    private String menuAdminView = "#menu_admin_viewAdminModule";
    private String menuAdminJob = "#menu_admin_Job";
    private String jobTitles = "#menu_admin_viewJobTitleList";
    private String jobsList = "#resultTable input[type='checkbox']";
    private String deleteButton = "#btnDelete";

    public JobTitles(WebDriver driver) {
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

    private ArrayList<WebElement> getElements(String selector) {
        waitElement(selector);
        return (ArrayList<WebElement>) driver.findElements(By.cssSelector(selector));
    }

    private void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void deleteJobTitles() {
        Boolean wait = new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers"));
        if (wait) {
            scrollToElement(getElement(menuAdminView));
            scrollToElement(getElement(menuAdminJob));
            getElement(jobTitles).click();
            getElements(jobsList).get(1).click();
//            getElements(jobsList).get(2).click();
//            getElements(jobsList).get(4).click();
            getElement(deleteButton).submit();
        }

    }
}
