package pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class PageObject {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    private By womenCategoryLocator = By.cssSelector("a[title='Women']");
    private By dressesCategory = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");
    private By tshirtCategory = By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a");

    private By topsCheckBoxLocator = By.id("layered_category_4");
    private By topsCheckBoxCheckedLocator = By.cssSelector("#uniform-layered_category_4 span[class='checked']");
    private By countTopsLocator = By.cssSelector("label[for='layered_category_4'] span");

    private By dressesCheckBoxLocator = By.id("uniform-layered_category_8");
    private By dressesCheckBoxCheckedLocator = By.cssSelector("#uniform-layered_category_8 span[class='checked']");
    private By countOfDressesLocator = By.cssSelector("label[for='layered_category_8'] span");

    private By addToCartButtonLocator = By.cssSelector("button[class='exclusive']");
    private By continueShoppingButtonLocator = By.cssSelector("span[title='Continue shopping']");

    private By firstScrollForOrderLocator = By.cssSelector("ul[class='product_list grid row'] > li:nth-child(6) div[class='product-image-container']");
    private By firstMoreButtonLocator = By.cssSelector("ul[class='product_list grid row'] > li:nth-child(6) a[title='View'] span");

    private By secondScrollForOrderLocator = By.cssSelector("ul[class='product_list grid row'] > li:nth-child(2) div[class='product-image-container']");
    private By secondMoreButtonLocator = By.cssSelector("ul[class='product_list grid row'] > li:nth-child(2) a[title='View'] span");

    private By thirdScrollForOrderLocator = By.cssSelector("ul[class='product_list grid row'] > li:nth-child(1) div[class='product-image-container']");
    private By thirdMoreButtonLocator = By.cssSelector("ul[class='product_list grid row'] > li:nth-child(1) a[title='View'] span");

    private By cartButtonLocator = By.cssSelector("a[title='View my shopping cart']");
    private By listOfOrdersLocator = By.cssSelector("tbody tr p[class='product-name'] a");
    private By deleteOrderButtonLocator = By.cssSelector("tbody tr:nth-child(2) a[title='Delete']");

    private By searchFieldLocator = By.id("search_query_top");
    private By submitSearchButtonLocator = By.name("submit_search");
    private By deletedOrderLocator = By.cssSelector("ul[class='product_list grid row'] h5 a");

    public PageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void getPage() {
        driver.get(baseUrl);
    }

    public PageObject clickWomenCategory() {
        driver.findElement(womenCategoryLocator).click();
        return this;
    }

    public PageObject clickDressesCategory() {
        driver.findElement(dressesCategory).click();
        return this;
    }

    public PageObject clickTshirtCategory() {
        driver.findElement(tshirtCategory).click();
        return this;
    }

    public PageObject clickTopsCheckBox() {
        driver.findElement(topsCheckBoxLocator).click();
        return this;
    }

    public PageObject isTopsCheckBoxChecked() {
        if (driver.findElement(topsCheckBoxCheckedLocator).isEnabled()) {
            System.out.println("Tops check box is checked");
        } else {
            System.out.println("Tops check box is not checked");
        }
        return this;
    }

    public PageObject countOfTops() {
        String[] count = driver.findElement(countTopsLocator).getText().split("");
        System.out.println("Count of tops: " + count[1]);
        return this;
    }

    public PageObject clickDressesCheckBox() {
        driver.findElement(dressesCheckBoxLocator).click();
        return this;
    }

    public PageObject isDressesCheckBoxChecked() {
        if (driver.findElement(dressesCheckBoxCheckedLocator).isEnabled()) {
            System.out.println("Dresses check box is checked");
        } else {
            System.out.println("Dresses check box is not checked");
        }
        return this;
    }

    public PageObject countOfDresses() {
        String[] count = driver.findElement(countOfDressesLocator).getText().split("");
        System.out.println("Count of dresses: " + count[1]);
        return this;
    }

    public PageObject scrollForFirstOrder() {
        scrollToElement(driver.findElement(firstScrollForOrderLocator));
        return this;
    }

    public PageObject clickFirstMoreButton() {
        driver.findElement(firstMoreButtonLocator).click();
        return this;
    }

    public PageObject clickAddToCartButton() {
        driver.findElement(addToCartButtonLocator).click();
        return this;
    }

    public PageObject clickContinueShoppingButton() {
        driver.findElement(continueShoppingButtonLocator).click();
        return this;
    }

    public PageObject scrollForSecondOrder() {
        scrollToElement(driver.findElement(secondScrollForOrderLocator));
        return this;
    }

    public PageObject clickSecondMoreButton() {
        driver.findElement(secondMoreButtonLocator).click();
        return this;
    }

    public PageObject scrollForThirdOrder() {
        scrollToElement(driver.findElement(thirdScrollForOrderLocator));
        return this;
    }

    public PageObject clickThirdMoreButton() {
        driver.findElement(thirdMoreButtonLocator).click();
        return this;
    }

    public PageObject clickCartButton() {
        driver.findElement(cartButtonLocator).click();
        return this;
    }

    public void checkOrders(String orderName, int orderNumber) {
        List<WebElement> listOfOrders = driver.findElements(listOfOrdersLocator);
        switch (orderNumber) {
            case 1: if (listOfOrders.get(0).getText().equals(orderName)) {
                System.out.println("Order is correct");
            } else {
                System.out.println("Order is incorrect");
            }
            break;
            case 2: if (listOfOrders.get(1).getText().equals(orderName)) {
                System.out.println("Order is correct");
            } else {
                System.out.println("Order is incorrect");
            }
            break;
            case 3: if (listOfOrders.get(2).getText().equals(orderName)) {
                System.out.println("Order is correct");
            } else {
                System.out.println("Order is incorrect");
            }
            break;
        }
    }

    public PageObject deleteOrder() {
        driver.findElement(deleteOrderButtonLocator).click();
        return this;
    }

    public PageObject typeMessageInSearch(String message) {
        driver.findElement(searchFieldLocator).sendKeys(message);
        return this;
    }

    public PageObject submitSearch() {
        driver.findElement(submitSearchButtonLocator).click();
        return this;
    }

    public void checkDeletedOrder(String deletedOrder) {
        List<WebElement> searchList = driver.findElements(deletedOrderLocator);
        for (int i = 0; i < searchList.size(); i++) {
            if (searchList.get(i).getText().equals(deletedOrder)) {
                System.out.println("Deleted order found");
            }
        }
    }

    private void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    private Wait<WebDriver> getWebDriverWait() {
        return (Wait<WebDriver>) new FluentWait<>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(250, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

}
