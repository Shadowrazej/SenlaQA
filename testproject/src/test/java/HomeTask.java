import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pattern.PageObject;
import org.junit.Before;

public class HomeTask {

    private PageObject pageObject;
    private WebDriver driver;
    private String login = "eviseviscerate@gmail.com";
    private String password = "eviscerate_rogue";

    @Before
    public void setUp() {
        pageObject = new PageObject(driver);
        pageObject.beforeTest();
    }

    @Test
    public void gmailTest() {
        // Login
        pageObject.getPage();
        pageObject.typeLogin(login).confirmLogin();
        pageObject.typePassword(password).confirmPassword();

        //Check spam messages
        pageObject.clickMoreButton().clickSpamButton().checkCountOfSpamMessages();

        //Check incoming messages
        pageObject.clickIncomingButton().checkCountOfIncomingMessages();

        //Clean trash
        try {
            pageObject.clickMoreButton().clickTrashButton().clickCleanTrashButton().clickConfirmTrashButton();
        } catch (NoSuchElementException e) {
            System.out.println("Trash is empty");
        }


        //Logout
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pageObject.clickProfileButton().logout();

    }

    @After
    public void shutDown() {
        pageObject.afterTest();
    }

    /*
            About my Thread.sleep. I know that it's bad practice, but I could not do with WAIT.Until.

            I think it is possible to divide the pageObject class into smaller classes, such as: login, spam check,
        incoming message check, clean trash, logout.
     */

}
