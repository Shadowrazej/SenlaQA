package pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {

    private WebDriver driver;
    private String baseUrl;

    private By loginLocator = By.id("identifierId");
    private By passwordLocator = By.name("password");
    private By loginNextButtonLocator = By.id("identifierNext");
    private By passwordNextButtonLocator = By.id("passwordNext");

    private By moreButtonLocator = By.id(":j2");

    private By spamButtonLocator = By.cssSelector("div[class='TN bzz aHS-bnv']");
    private By spamMessageLocator = By.cssSelector("div.AO div.nH div[class='BltHke nH oy8Mbf']:nth-child(2) tr.zA");
    private int countOfSpamMessages;

    private By incomingButtonLocator = By.id(":j4");
    private By incomingMessageLocator = By.cssSelector("div[class='ae4 aDM']:nth-child(1) tr.zA");
    private int countOfIncomingMessages;

    private By trashButtonLocator = By.id(":jd");
    private By cleanTrashButtonLocator = By.cssSelector("div[class='BltHke nH oy8Mbf']:nth-child(3) div.ya span");
    private By confirmTrashButtonLocator = By.cssSelector("div[class='Kj-JD']:nth-last-child(2) button[name='ok']");

    private By profileButtonLocator = By.cssSelector("div[class='gb_ib gb_nd gb_eh gb_R gb_2f gb_rb']");
    private By logoutButtonLocator = By.id("gb_71");

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        this.setBaseUrl("https://accounts.google.com/signin/v2/identifier?hl=ru&continue=https%3A%2F%2Fmail.google.com%2Fmail&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void afterTest() {
        driver.quit();
    }

    public void getPage() {
        driver.get(getBaseUrl());
    }

    public PageObject typeLogin(String login) {
        driver.findElement(loginLocator).sendKeys(login);
        return this;
    }

    public void confirmLogin() {
        driver.findElement(loginNextButtonLocator).click();
    }

    public PageObject typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public void confirmPassword() {
        driver.findElement(passwordLocator).sendKeys(Keys.ENTER);
    }

    public PageObject clickMoreButton() {
        driver.findElement(moreButtonLocator).click();
        return this;
    }

    public PageObject clickSpamButton() {
        driver.findElement(spamButtonLocator).click();
        return this;
    }

    public void checkCountOfSpamMessages() {
        countOfSpamMessages = driver.findElements(spamMessageLocator).size();
        System.out.println("Count of spam messages: " + countOfSpamMessages);
    }

    public PageObject clickIncomingButton() {
        driver.findElement(incomingButtonLocator).click();
        return this;
    }

    public void checkCountOfIncomingMessages() {
        countOfIncomingMessages = driver.findElements(incomingMessageLocator).size();
        System.out.println("Count of incoming messages: " + countOfIncomingMessages);
    }

    public PageObject clickTrashButton() {
        driver.findElement(trashButtonLocator).click();
        return this;
    }

    public PageObject clickCleanTrashButton() {
        driver.findElement(cleanTrashButtonLocator).click();
        return this;
    }

    public PageObject clickConfirmTrashButton() {
        driver.findElement(confirmTrashButtonLocator).click();
        return this;
    }

    public PageObject clickProfileButton() {
        driver.findElement(profileButtonLocator).click();
        return this;
    }

    public PageObject logout() {
        driver.findElement(logoutButtonLocator).click();
        return this;
    }

}
