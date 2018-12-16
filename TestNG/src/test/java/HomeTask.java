import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pattern.PageObject;


public class HomeTask {

    private PageObject pageObject;
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        pageObject = new PageObject(driver, wait);
        pageObject.beforeTest();
    }

    @Test
    public void executeTest() {
        pageObject.getPage();

        //Test checkBoxes and count
        pageObject.clickWomenCategory();
        pageObject.clickTopsCheckBox().isTopsCheckBoxChecked().countOfTops().clickTopsCheckBox();
        pageObject.clickDressesCheckBox().isDressesCheckBoxChecked().countOfDresses();

        //Make first orders
        pageObject.scrollForFirstOrder().clickFirstMoreButton().clickAddToCartButton().clickContinueShoppingButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pageObject.clickDressesCategory();
        pageObject.scrollForSecondOrder().clickSecondMoreButton().clickAddToCartButton().clickContinueShoppingButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pageObject.clickTshirtCategory();
        pageObject.scrollForThirdOrder().clickThirdMoreButton().clickAddToCartButton().clickContinueShoppingButton();

        //Check whether the order is executed correctly and delete one order
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pageObject.clickCartButton().checkOrders("Printed Summer Dress", 1);
        pageObject.deleteOrder();

        //Check deleted order
        pageObject.typeMessageInSearch("Printed Dress").submitSearch().checkDeletedOrder("Printed Dress");

        //I want to add a price check, because there are several things with the same name.
    }

    @AfterClass
    public void shutDown() {
        pageObject.afterTest();
    }
}
