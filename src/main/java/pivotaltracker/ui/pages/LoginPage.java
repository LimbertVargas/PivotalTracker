/*
 * @(#) LoginPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.pages;

import pivotaltracker.BasePage;
import core.utils.CredentialsReader;
import core.utils.PivotalTrackerUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * LoginPage class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class LoginPage extends BasePage {

    @FindBy(id = "login_type_check_form")
    private WebElement loginForm;

    @FindBy(id = "credentials_username")
    private WebElement userNameTxtBox;

    @FindBy(id = "credentials_password")
    private WebElement passwordTxtBox;

    @FindBy(css = "input[class='app_signin_action_button']")
    private WebElement nextLoginBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginForm));
    }

    /**
     * Sets credentials and login on the page.
     *
     * @param user - User from where obtains the credentials.
     */
    public void setCredentials(final String user) {
        String username = CredentialsReader.getInstance().getUserName(user);
        String password = CredentialsReader.getInstance().getUserPassword(user);
        PivotalTrackerUtils.setText(userNameTxtBox, username);
        nextLoginBtn.click();
        PivotalTrackerUtils.setText(passwordTxtBox, password);
        nextLoginBtn.click();
    }
}
