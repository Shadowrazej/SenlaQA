package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class PIM {

    private WebDriver driver;

    //selectors on the PIM page
    private String menuPIM = "#menu_pim_viewPimModule";
    private String subUnitColumn = "#resultTable tr > td:nth-child(7)";
    private String employeeName = "#resultTable tr > td:nth-child(3) a";

    //selectors on the Personal Details page
    private String firstName = "#personal_txtEmpFirstName";
    private String middleName = "#personal_txtEmpMiddleName";
    private String lastName = "#personal_txtEmpLastName";
    private String employeeId = "#personal_txtEmployeeId";
    private String otherId = "#personal_txtOtherID";
    private String licenseNumber = "#personal_txtLicenNo";
    private String licenseExpire = "#personal_txtLicExpDate";
    private String maleGender = "#personal_optGender_1";
    private String femaleGender = "#personal_optGender_2";
    private String nationality = "#personal_cmbNation";
    private String maritalStatus = "#personal_cmbMarital";
    private String birthDate = "#personal_DOB";
    private String saveButton = "#btnSave";
    private String attachmentsButton = "#btnAddAttachment";

    private String firstNameRequired = "ol[class='fieldsInLine'] > li:nth-child(1) span";
    private String lastNameRequired = "ol[class='fieldsInLine'] > li:nth-child(3) span";
    private String calendar = "table[class='ui-datepicker-calendar'] a";
    private String nationalityOption = "#personal_cmbNation option";
    private String maritalStatusOption = "#personal_cmbMarital option";

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

    private void refresh() {
        driver.navigate().refresh();
    }

    public void checkPIM() {
        getElement(menuPIM).click();
        subUnitEmployee("Sales");
        isDisabledFields();
        isEnabledFields();
        requiredFields();
        checkLicenseExpire();
        checkMaritalStatus();
        checkBirthDate();
        checkNationality();
        checkGender();
    }

    /*
    Test methods Personal Details
     */

    private void subUnitEmployee(String text) {
        ArrayList<WebElement> subUnitList = getElements(subUnitColumn);
        ArrayList<WebElement> employeeList = getElements(employeeName);

        for (int i = 0; i < subUnitList.size(); i++) {
            if (subUnitList.get(i).getText().equals(text)) {
                employeeList.get(i).click();
                break;
            }
        }
    }

    private void isDisabledFields() {
        Assert.assertFalse("First Name field is enabled", getElement(firstName).isEnabled());
        Assert.assertFalse("Middle Name field is enabled", getElement(middleName).isEnabled());
        Assert.assertFalse("Last Name field is enabled", getElement(lastName).isEnabled());
        Assert.assertFalse("Employee Id field is enabled", getElement(employeeId).isEnabled());
        Assert.assertFalse("Other Id field is enabled", getElement(otherId).isEnabled());
        Assert.assertFalse("Driver's License Number field is enabled", getElement(licenseNumber).isEnabled());
        Assert.assertFalse("License Expire Date field is enabled", getElement(licenseExpire).isEnabled());
        Assert.assertFalse("Male Gender is enabled", getElement(maleGender).isEnabled());
        Assert.assertFalse("Female Gender is enabled", getElement(femaleGender).isEnabled());
        Assert.assertFalse("Marital Status field is enabled", getElement(maritalStatus).isEnabled());
        Assert.assertFalse("Nationality field is enabled", getElement(nationality).isEnabled());
        Assert.assertFalse("Date of Birth field is enabledd", getElement(birthDate).isEnabled());
    }

    private void isEnabledFields() {
        getElement(saveButton).click();
        Assert.assertTrue("First Name field is not disabled", getElement(firstName).isEnabled());
        Assert.assertTrue("Middle Name field is not disabled", getElement(middleName).isEnabled());
        Assert.assertTrue("Last Name field is not disabled", getElement(lastName).isEnabled());
        Assert.assertTrue("Employee Id field is not disabled", getElement(employeeId).isEnabled());
        Assert.assertTrue("Other Id field is not disabled", getElement(otherId).isEnabled());
        Assert.assertTrue("Driver's License Number field is not disabled", getElement(licenseNumber).isEnabled());
        Assert.assertTrue("License Expire Date field is not disabled", getElement(licenseExpire).isEnabled());
        Assert.assertTrue("Male Gender is not disabled", getElement(maleGender).isEnabled());
        Assert.assertTrue("Female Gender is not disabled", getElement(femaleGender).isEnabled());
        Assert.assertTrue("Marital Status field is not disabled", getElement(maritalStatus).isEnabled());
        Assert.assertTrue("Nationality field is not disabled", getElement(nationality).isEnabled());
        Assert.assertTrue("Date of Birth field is not disabled", getElement(birthDate).isEnabled());
        Assert.assertTrue("Edit button is not enabled", getElement(saveButton).isEnabled());
        Assert.assertTrue("Add button is not enabled", getElement(attachmentsButton).isEnabled());
        refresh();
    }

    private void requiredFields() {
        getElement(saveButton).click();
        getElement(firstName).clear();
        getElement(lastName).clear();
        getElement(firstName).sendKeys("a");
        getElement(lastName).sendKeys("a");
        getElement(firstName).sendKeys(Keys.BACK_SPACE);
        getElement(lastName).sendKeys(Keys.BACK_SPACE);
        Assert.assertEquals("Required", getElement(firstNameRequired).getText());
        Assert.assertEquals("Required", getElement(lastNameRequired).getText());
        refresh();
    }

    private void checkLicenseExpire() {
        getElement(saveButton).click();
        getElement(licenseExpire).click();
        ArrayList<WebElement> calendarList = getElements(calendar);
        calendarList.get(30).click();
        String licenseExpireExpected = "calendar editable calendar hasDatepicker valid";
        Assert.assertEquals(licenseExpireExpected, getElement(licenseExpire).getAttribute("class"));
        refresh();
    }

    private void checkMaritalStatus() {
        getElement(saveButton).click();
        getElement(maritalStatus).click();
        ArrayList<WebElement> optionList = getElements(maritalStatusOption);
        optionList.get(1).click();
        Assert.assertEquals("Single", optionList.get(1).getText());
        refresh();
    }

    private void checkBirthDate() {
        getElement(saveButton).click();
        getElement(birthDate).click();
        ArrayList<WebElement> calendarList = getElements(calendar);
        calendarList.get(5).click();
        String birthDateExpected = "editable calendar hasDatepicker valid";
        Assert.assertEquals(birthDateExpected, getElement(birthDate).getAttribute("class"));
        refresh();
    }

    private void checkNationality() {
        getElement(saveButton).click();
        getElement(nationality).click();
        ArrayList<WebElement> nationalityList = getElements(nationalityOption);
        nationalityList.get(2).click();
        Assert.assertEquals("Albanian", nationalityList.get(2).getText());
        refresh();
    }

    private void checkGender() {
        getElement(saveButton).click();
        getElement(maleGender).click();
        Assert.assertTrue(getElement(maleGender).isSelected());
        Assert.assertFalse(getElement(femaleGender).isSelected());

        getElement(femaleGender).click();
        Assert.assertTrue(getElement(femaleGender).isSelected());
        Assert.assertFalse(getElement(maleGender).isSelected());
        refresh();
    }

}
