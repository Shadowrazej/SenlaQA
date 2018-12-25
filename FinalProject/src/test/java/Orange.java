import Page.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Orange {

    private WebDriver driver;
    private LogIn logIn;
    private AddUser addUser;
    private JobTitles jobTitles;
    private AddCandidate addCandidate;
    private Dashboard dashboard;
    private PIM pim;
    private LogOut logOut;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        logIn = new LogIn(driver);
        addUser = new AddUser(driver);
        jobTitles = new JobTitles(driver);
        addCandidate = new AddCandidate(driver);
        dashboard = new Dashboard(driver);
        pim = new PIM(driver);
        logOut = new LogOut(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void executeTest() {
        logIn.logIn();
        addUser.checkUserFields();
        addUser.addUser();
        jobTitles.deleteJobTitles();
        addCandidate.addCandidate();
        dashboard.checkDashboard();
        pim.checkPIM();
        logOut.logOut();
    }

    @After
    public void shutDown() {
        driver.quit();
    }
}
