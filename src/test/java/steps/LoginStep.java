package steps;

import PivotalTracker.PageTransporter;
import PivotalTracker.ui.pages.LoginPage;
import core.utils.CredentialsReader;
import org.junit.Assert;

public class LoginStep {
    private LoginPage loginPage;

    public void goLoginPage() {
        PageTransporter.navigatePage("signin?source=navbar");
    }

    public void putUsername() {
        loginPage = new LoginPage();
        loginPage.putCredentials("User1");
    }

    public void assertUser() {
        String actual = loginPage.profileDropDownButtonText();
        String expected = CredentialsReader.getInstance().getUserName("User1");
        Assert.assertEquals(actual, expected);
    }
}
