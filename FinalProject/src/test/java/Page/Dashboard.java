package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private String menuPIM = "#menu_pim_viewPimModule";
    private String subUnitColumn = "#resultTable tr > td:nth-child(7)";


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
        getElement(menuPIM).click();
        int[] subunitPercent = subunitPercent();
        getElement(menuDashboard).click();
//        quickLaunch();
        firstPanel(subunitPercent);
        secondPanel(subunitPercent);
        thirdPanel();
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

    private void firstPanel(int[] subunitPercent) {
        Assert.assertEquals("Employee Distribution by Subunit", getElement(firstPanel).getText());
        ArrayList<WebElement> list = getElements(firstPanelElements);
        for (int i = 0; i < subunitPercent.length; i++) {
            if (subunitPercent[i] == 0) {
                continue;
            }
            Assert.assertEquals(subunitPercent[i] + "%", list.get(i).getText());
        }
    }

    private void secondPanel(int[] subunitPercent) {
        String[] subunitTitles = {"Not assigned to Subunits", "Administration", "Finance", "IT", "Sales"};
        Assert.assertEquals("Legend", getElement(secondPanel).getText());
        ArrayList<WebElement> list = getElements(secondPanelElements);
        for (int i = 0; i < subunitPercent.length; i++) {
            if (subunitPercent[i] == 0) {
                continue;
            }
            Assert.assertEquals(subunitTitles[i], list.get(i).getText());
        }
    }

    private void thirdPanel() {
        Assert.assertEquals("Pending Leave Requests", getElement(thirdPanel).getText());
        ArrayList<WebElement> list = getElements(thirdPanelElements);
        Assert.assertEquals("No Records are Available", list.get(0).getText());

        ArrayList<WebElement> listTotal = getElements(thirdPanelTotal);
        Assert.assertEquals("3 month(s)", listTotal.get(0).getText());
        Assert.assertEquals("Total : 0 / 0", listTotal.get(1).getText());
    }

    private int[] subunitPercent() {
        ArrayList<WebElement> list = getElements(subUnitColumn);
        int countSales = 0;
        int countAdministration = 0;
        int countIT = 0;
        int countFinance = 0;
        int countOther = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals("Sales")){
                countSales++;
                continue;
            } else if (list.get(i).getText().equals("Administration")) {
                countAdministration++;
                continue;
            } else if (list.get(i).getText().equals("IT")) {
                countIT++;
                continue;
            } else if (list.get(i).getText().equals("Finance")) {
                countFinance++;
                continue;
            } else {
                countOther++;
                continue;
            }
        }
        return percent(countOther, countAdministration, countFinance, countIT, countSales);
    }

    private int[] percent(int countOther, int countAdministration, int countFinance, int countIT, int countSales) {
        int sum = countSales + countAdministration + countIT + countFinance + countOther;
        int[] percentOfSubunits = {countOther * 100 / sum, countAdministration * 100 / sum, countFinance * 100 / sum, countIT * 100 / sum, countSales * 100 / sum};
        return percentOfSubunits;
    }
}
