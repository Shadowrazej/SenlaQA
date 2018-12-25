package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUser {

    private WebDriver driver;

    //selectors
    private String adminMenu = "#menu_admin_viewAdminModule";
    private String addUserButton = "#btnAdd";
    private String userRole = "#systemUser_userType";
    private String employeeName = "#systemUser_employeeName_empName";
    private String userName = "#systemUser_userName";
    private String status = "#systemUser_status";
    private String password = "#systemUser_password";
    private String confirmPassword = "#systemUser_confirmPassword";
    private String saveButton = "#btnSave";
    private String passwordAlert = "li[class='passwordDiv']:nth-child(6) > span";

    //selectors for asserts
    private String invalidEmployeeName = "#frmSystemUser li:nth-child(2) > span";
    private String invalidUserName = "#frmSystemUser li:nth-child(3) > span";
    private String passwordRequired = "#frmSystemUser li:nth-child(6) > span";
    private String passwordDifficulty = "#systemUser_password_strength_meter";
    private String confirmPasswordRequired = "#frmSystemUser li:nth-child(7) > span";

    public AddUser(WebDriver driver) {
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

    private void refresh() {
        driver.navigate().refresh();
    }

    /*
    test methods
     */

    public void checkUserFields() {
        getElement(adminMenu).click();
        getElement(addUserButton).click();
        fieldsIsDisplayed();
        cleanFields();
        shortUsername();
        invalidEmployeeName();
        requiredEmployeeName();
        shortPassword();
        passwordDifficulty();
        shortConfirmPassword();
        confirmPasswordMatch();
    }

    public void addUser() {
        getElement(adminMenu).click();
        getElement(addUserButton).click();
        getElement(employeeName).sendKeys("Fiona Grace");
        getElement(userName).sendKeys("shadowrazej16");
        getElement(password).sendKeys("qwerty123");
        getElement(confirmPassword).sendKeys("qwerty123");
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector(passwordAlert)), "style", "display: none;"));
        getElement(saveButton).click();
        Assert.assertEquals("OrangeHRM", driver.getTitle());
    }

    private void fieldsIsDisplayed() {
        Assert.assertTrue("User Role field is not displayed", getElement(userRole).isDisplayed());
        Assert.assertTrue("Employee name field is not displayed", getElement(employeeName).isDisplayed());
        Assert.assertTrue("Username field is not displayed", getElement(userName).isDisplayed());
        Assert.assertTrue("Status field is not displayed", getElement(status).isDisplayed());
        Assert.assertTrue("Password field is not displayed", getElement(password).isDisplayed());
        Assert.assertTrue("Confirm Password field is not displayed", getElement(confirmPassword).isDisplayed());
        refresh();
    }

    private void cleanFields() {
        getElement(saveButton).click();
        Assert.assertEquals("Invalid", getElement(invalidEmployeeName).getText());
        Assert.assertEquals("Required", getElement(invalidUserName).getText());
        refresh();
    }

    private void requiredEmployeeName() {
        getElement(employeeName).sendKeys("asd");
        getElement(employeeName).clear();
        Assert.assertEquals("Required", getElement(invalidEmployeeName).getText());
        refresh();
    }

    private void shortUsername() {
        getElement(userName).sendKeys("asd");
        Assert.assertEquals("Should have at least 5 characters", getElement(invalidUserName).getText());
        refresh();
    }

    private void invalidEmployeeName() {
        getElement(employeeName).sendKeys("asd");
        Assert.assertEquals("Invalid", getElement(invalidEmployeeName).getText());
        refresh();
    }

    private void shortPassword() {
        getElement(password).sendKeys("asdasd");
        Assert.assertEquals("Should have at least 8 characters", getElement(passwordRequired).getText());
        refresh();
    }

    private void passwordDifficulty() {
        getElement(password).sendKeys("asdasd");
        Assert.assertEquals("Very Weak", (new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(getElement(passwordDifficulty)))).getText());
        refresh();
        getElement(password).sendKeys("фывфывфыв");
        Assert.assertEquals("Better", (new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(getElement(passwordDifficulty)))).getText());
        refresh();
    }

    private void shortConfirmPassword() {
        getElement(confirmPassword).sendKeys("asdasd");
        Assert.assertEquals("Please enter at least 8 characters.", getElement(confirmPasswordRequired).getText());
        refresh();
    }

    private void confirmPasswordMatch() {
        getElement(confirmPassword).sendKeys("asdasdasd");
        Assert.assertEquals("Passwords do not match", getElement(confirmPasswordRequired).getText());
    }
}
