package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Dashboard {

    private WebDriver driver;

    //selectors
    private String menuDashboard = "#menu_dashboard_index";
    private String quickLaunch = "#panel_resizable_0_0 > legend";
    private String quickLaunchElements = "div[class='quickLaunge'] span";
    private String firstPanel = "#panel_resizable_1_0 > legend";
    private String firstPanelElements = "#panel_resizable_1_0 span";
    private String secondPanel = "#panel_resizable_1_1 > legend";
    private String secondPanelElements = "#div_legend_pim_employee_distribution_legend tr";
    private String thirdPanel = "#panel_resizable_1_2 > legend";
    private String thirdPanelElements = "#task-list-group-panel-menu_holder tr";
    private String thirdPanelTotal = "#total td";


    public Dashboard(WebDriver driver) {
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

    public void checkDashboard() {
        getElement(menuDashboard).click();
        quickLaunch();
//        firstPanel();
        secondPanel();
        thirdPanel();
        panelMatch();
    }

    /*
    test methods
     */

    private void quickLaunch() {
        Assert.assertEquals("Quick Launch", getElement(quickLaunch).getText());
        ArrayList<WebElement> list = getElements(quickLaunchElements);
        Assert.assertEquals("Assign Leave", list.get(0).getText());
        Assert.assertEquals("Leave List", list.get(1).getText());
        Assert.assertEquals("Timesheets", list.get(2).getText());
    }

    private void firstPanel() {
        Assert.assertEquals("Employee Distribution by Subunit", getElement(firstPanel).getText());
        ArrayList<WebElement> list = getElements(firstPanelElements);
        Assert.assertEquals("11%", list.get(0).getText());
        Assert.assertEquals("33%", list.get(1).getText());
        Assert.assertEquals("11%", list.get(2).getText());
        Assert.assertEquals("22%", list.get(3).getText());
        Assert.assertEquals("22%", list.get(4).getText());
    }

    private void secondPanel() {
        Assert.assertEquals("Legend", getElement(secondPanel).getText());
        ArrayList<WebElement> list = getElements(secondPanelElements);
        Assert.assertEquals("Not assigned to Subunits", list.get(0).getText());
        Assert.assertEquals("Administration", list.get(1).getText());
        Assert.assertEquals("Finance", list.get(2).getText());
        Assert.assertEquals("IT", list.get(3).getText());
        Assert.assertEquals("Sales", list.get(4).getText());
    }

    private void thirdPanel() {
        Assert.assertEquals("Pending Leave Requests", getElement(thirdPanel).getText());
        ArrayList<WebElement> list = getElements(thirdPanelElements);
        Assert.assertEquals("No Records are Available", list.get(0).getText());

        ArrayList<WebElement> listTotal = getElements(thirdPanelTotal);
        Assert.assertEquals("3 month(s)", listTotal.get(0).getText());
        Assert.assertEquals("Total : 0 / 0", listTotal.get(1).getText());
    }

    private void panelMatch() {
        int countElementsFirstPanel = getElements(firstPanelElements).size();
        int countElementsSecondPanel = getElements(secondPanelElements).size();
        Assert.assertEquals(countElementsFirstPanel, countElementsSecondPanel);
    }
}
