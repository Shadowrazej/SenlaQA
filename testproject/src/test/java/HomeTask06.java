import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomeTask06 {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://accounts.google.com/signin/v2/identifier?hl=ru&continue=https%3A%2F%2Fmail.google.com%2Fmail&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void emailTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get(baseUrl);
        WebElement login = driver.findElement(By.id("identifierId"));
        login.sendKeys("eviseviscerate@gmail.com");
        WebElement buttonLoginNext = driver.findElement(By.id("identifierNext"));
        buttonLoginNext.click();
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("eviscerate_rogue");


        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement buttonPasswordNext = driver.findElement(By.id("passwordNext"));

        buttonPasswordNext.click();
         */

        password.sendKeys(Keys.ENTER);



        //Enter to spam

        try {
        Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement moreButton = driver.findElement(By.cssSelector("div[class='n6'] span[class='J-Ke n4 ah9']"));
        moreButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement spamButton = driver.findElement(By.cssSelector("div[class='TN bzz aHS-bnv']"));
        spamButton.click();

        //Check count messages in Spam

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        int countOfSpamMessages = driver.findElements(By.cssSelector("div.AO div.nH div[class='BltHke nH oy8Mbf']:nth-child(2) tr.zA")).size();
        System.out.println(countOfSpamMessages);

        //Check incoming messages

        WebElement incomingButton = driver.findElement(By.id(":j4"));
        incomingButton.click();
        int countOfIncomingMessages = driver.findElements(By.cssSelector("div[class='ae4 aDM']:nth-child(1) tr.zA")).size();
        System.out.println(countOfIncomingMessages);

        //clean the basket

        moreButton.click();
        WebElement trashButton = driver.findElement(By.id(":jd"));
        trashButton.click();
        WebElement cleanTrash = driver.findElement(By.cssSelector("div[class='BltHke nH oy8Mbf']:nth-child(3) div.ya span"));
        cleanTrash.click();
        WebElement okTrashButton = driver.findElement(By.cssSelector("div[class='Kj-JD']:nth-last-child(2) button[name='ok']"));
        okTrashButton.click();

        //Logout

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement profileButton = driver.findElement(By.cssSelector("div[class='gb_ib gb_nd gb_eh gb_R gb_2f gb_rb']"));
        profileButton.click();
        WebElement logout = driver.findElement(By.id("gb_71"));
        logout.click();


    }

    //@After
    //public void shutDown() {
    //    driver.quit();
    //} div[class='HwgYue']

}
