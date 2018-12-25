package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class PIM {

    private WebDriver driver;

    //selectors
    private String menuPIM = "#menu_pim_viewPimModule";
    private String employeeInfo = "#search_form li";
    private String searchButton = "#searchBtn";
    private String resetButton = "#resetBtn";
    private String employmentStatus = "#empsearch_employee_status option";
    private String include = "#empsearch_termination option";
    private String jobTitle = "#empsearch_job_title option";
    private String subUnit = "#empsearch_sub_unit option";

    public PIM(WebDriver driver) {
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

    public void checkPIM() {
        getElement(menuPIM).click();
        fieldsIsDisplayed();
        checkForms();
    }

    /*
    test methods
     */

    private void fieldsIsDisplayed() {
        ArrayList<WebElement> list = getElements(employeeInfo);
        Assert.assertTrue("Employee Name field is not displayed", list.get(0).isDisplayed());
        Assert.assertTrue("Id field is not displayed", list.get(1).isDisplayed());
        Assert.assertTrue("Employment Status field is not displayed", list.get(2).isDisplayed());
        Assert.assertTrue("Include field is not displayed", list.get(3).isDisplayed());
        Assert.assertTrue("Supervisor Name field is not displayed", list.get(4).isDisplayed());
        Assert.assertTrue("Job Title field is not displayed", list.get(5).isDisplayed());
        Assert.assertTrue("Sub Unit field is not displayed", list.get(6).isDisplayed());
        Assert.assertTrue("Search button is not displayed", getElement(searchButton).isDisplayed());
        Assert.assertTrue("Reset button is not displayed", getElement(resetButton).isDisplayed());
    }

    private void checkForms() {
        Assert.assertEquals(7, getElements(employmentStatus).size());
        Assert.assertEquals(3, getElements(include).size());
//        Assert.assertEquals(4, getElements(jobTitle).size());
        Assert.assertEquals(5, getElements(subUnit).size());
    }


}
