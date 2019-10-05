package hook;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pivotaltracker.PageTransporter;
import pivotaltracker.entities.User;
import pivotaltracker.ui.Permalink;
import pivotaltracker.ui.pages.LoginPage;

public class CommonHooks {
    private User user;
    private LoginPage loginPage;

    /**
     * This method login.
     */
    @Before(value = "@Login")
    public void login() {
        PageTransporter.navigatePage(Permalink.getPermalink("Login"));
        user = new User();
        user.setUserName("Regular User1");
        loginPage = new LoginPage();
        loginPage.login("Regular User1");
    }
}
