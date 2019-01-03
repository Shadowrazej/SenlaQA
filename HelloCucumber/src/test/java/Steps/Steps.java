package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pattern.PageObject;

import java.util.concurrent.TimeUnit;

public class Steps {

    private WebDriver driver;
    private String baseUrl;
    private PageObject pageObject;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageObject = new PageObject(driver);
    }

    @Given("^open the page$")
    public void openThePage() {
        pageObject.openPage(baseUrl);
    }

    @When("^click the Women category$")
    public void clickTheWomenCategory() {
        pageObject.clickWomenCategory();
    }

    @When("^click the Tops checkbox$")
    public void clickTheTopsCheckbox() {
        pageObject.clickTopsCheckBox();
    }

    @Then("^I see count of Tops$")
    public void iSeeCountOfTops() {
        pageObject.isTopsCheckBoxChecked().countOfTops();
    }

    @When("^I click Tops checkbox$")
    public void iClickTopsCheckbox() {
        pageObject.clickTopsCheckBox();
    }

    @When("^click Dresses checkbox$")
    public void clickDressesCheckbox() {
        pageObject.clickDressesCheckBox();
    }

    @Then("^I see count of Dresses$")
    public void iSeeCountOfDresses() {
        pageObject.isDressesCheckBoxChecked().countOfDresses();
    }

    @When("^I make first order$")
    public void iMakeFirstOrder() {
        pageObject.scrollForFirstOrder().clickFirstMoreButton().clickAddToCartButton().clickContinueShoppingButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^I make second order$")
    public void iMakeSecondOrder() {
        pageObject.clickDressesCategory();
        pageObject.scrollForSecondOrder().clickSecondMoreButton().clickAddToCartButton().clickContinueShoppingButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^I make third order$")
    public void iMakeThirdOrder() {
        pageObject.clickTshirtCategory();
        pageObject.scrollForThirdOrder().clickThirdMoreButton().clickAddToCartButton().clickContinueShoppingButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I see orders in the cart$")
    public void iSeeOrdersInTheCart() {
        pageObject.clickCartButton().checkOrders("Printed Summer Dress", 1);
    }

    @When("^I delete one order$")
    public void iDeleteOneOrder() {
        pageObject.deleteOrder();
    }

    @Then("^I can find deleted order in search$")
    public void iCanFindDeletedOrderInSearch() {
        pageObject.typeMessageInSearch("Printed Dress").submitSearch().checkDeletedOrder("Printed Dress");
    }

}
