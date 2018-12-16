import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class HomeTaskTestNG {

    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testOrders() {
        // add 3 items with some checkBoxes
        driver.get(baseUrl);
        WebElement womenCategory = driver.findElement(By.cssSelector("a[title='Women']"));
        womenCategory.click();

        WebElement topsCheckBox = driver.findElement(By.id("layered_category_4"));
        topsCheckBox.click();
        WebElement topsCheckedBox = driver.findElement(By.cssSelector("#uniform-layered_category_4 span[class='checked']"));
        if (topsCheckedBox.isEnabled()) {
            System.out.println("Tops check box is checked");
        }

        int countOfTops = driver.findElements(By.cssSelector("ul[class='product_list grid row'] > li")).size();
        System.out.println(countOfTops);

        topsCheckBox.click();
        WebElement dressesCheckBox = driver.findElement(By.id("uniform-layered_category_8"));
        dressesCheckBox.click();
        WebElement dressesCheckedBox = driver.findElement(By.cssSelector("#uniform-layered_category_8 span[class='checked']"));
        if (dressesCheckedBox.isEnabled()) {
            System.out.println("Dresses check box is checked");
        }

        int countOfDresses = driver.findElements(By.cssSelector("ul[class='product_list grid row'] > li")).size();
        System.out.println(countOfDresses);
        dressesCheckBox.click();

        WebElement moreButton = driver.findElement(By.cssSelector("ul[class='product_list grid row'] > li:nth-child(6) a[title='View'] span"));
        WebElement scrollForOrder = driver.findElement(By.cssSelector("ul[class='product_list grid row'] > li:nth-child(6) div[class='product-image-container']"));
        scrollToElement(scrollForOrder);
        moreButton.click();
        WebElement addToCart = driver.findElement(By.cssSelector("button[class='exclusive']"));
        addToCart.click();
        WebElement continueShopping = driver.findElement(By.cssSelector("span[title='Continue shopping']"));
        continueShopping.click();

        //Second order
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        WebElement dressesCategory = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a"));
        dressesCategory.click();
//        WebElement scrollForSecondOrder = driver.findElement(By.cssSelector("ul[class='product_list grid row'] > li:nth-child(2) div[class='product-image-container']"));
//        scrollToElement(scrollForSecondOrder);
//        WebElement secondMoreButton = driver.findElement(By.cssSelector("ul[class='product_list grid row'] > li:nth-child(2) a[title='View'] span"));
//        secondMoreButton.click();
//        WebElement secondAddToCart = driver.findElement(By.cssSelector("button[class='exclusive']"));
//        secondAddToCart.click();
//        WebElement secondContinueShopping = driver.findElement(By.cssSelector("span[title='Continue shopping']"));
//        secondContinueShopping.click();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        //Third order
//        WebElement tshirtCategory = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a"));
//        tshirtCategory.click();
//        WebElement scrollForThirdOrder = driver.findElement(By.cssSelector("ul[class='product_list grid row'] > li:nth-child(1) div[class='product-image-container']"));
//        scrollToElement(scrollForThirdOrder);
//        WebElement thirdMoreButton = driver.findElement(By.cssSelector("ul[class='product_list grid row'] > li:nth-child(1) a[title='View'] span"));
//        thirdMoreButton.click();
//        WebElement thirdAddToCart = driver.findElement(By.cssSelector("button[class='exclusive']"));
//        thirdAddToCart.click();
//        WebElement thirdContinueShopping = driver.findElement(By.cssSelector("span[title='Continue shopping']"));
//        thirdContinueShopping.click();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        //Check orders in the cart
//        WebElement cartButton = driver.findElement(By.cssSelector("a[title='View my shopping cart']"));
//        cartButton.click();
////        WebElement checkFirstOrder = driver.findElement(By.cssSelector("tbody tr:nth-child(1) p[class='product-name']"));
////        System.out.println(checkFirstOrder.getText());
//
//        List<WebElement> listOfOrders = driver.findElements(By.cssSelector("tbody tr p[class='product-name'] a"));
//        if (listOfOrders.get(0).getText().equals("Printed Summer Dress")) {
//            System.out.println("Order is correct");
//        } else {
//            System.out.println("Order is incorrect");
//        }
//
//        if (listOfOrders.get(1).getText().equals("Printed Dress")) {
//            System.out.println("Order is correct");
//        } else {
//            System.out.println("Order is incorrect");
//        }
//
//        if (listOfOrders.get(2).getText().equals("Faded Short Sleeve T-shirts")) {
//            System.out.println("Order is correct");
//        } else {
//            System.out.println("Order is incorrect");
//        }
//
//        //Delete the order
//        WebElement deleteOrder = driver.findElement(By.cssSelector("tbody tr:nth-child(2) a[title='Delete']"));
//        deleteOrder.click();
//
//        //Check deleted order in search field
//        WebElement searchField = driver.findElement(By.id("search_query_top"));
//        searchField.click();
//        searchField.sendKeys("Printed Dress");
//        searchField.sendKeys(Keys.ENTER);
//
//
////        WebElement continueShopping = driver.findElement(By.cssSelector("span[title='Continue shopping']"));
////        continueShopping.click();
////
////        WebElement dressesCategory = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2)"));
////        dressesCategory.click();


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

    private WebElement waitForClickable(WebElement element) {
        return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    private Boolean waitForStaleness(WebElement element) {
        return getWebDriverWait().until(ExpectedConditions.stalenessOf(element));
    }
}
