/*
 * @(#) LoginPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.pages;

import core.utils.CredentialsReader;
import core.utils.DriverMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

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
     * Click on login button.
     */
    private void clickLogin() {
        nextLoginBtn.click();
    }

    /**
     * Sets credentials
     *
     * @param element - Element where will write the credentials.
     * @param user    - Text for the credentials.
     */
    private void setCredential(final WebElement element, final String user) {
        DriverMethods.setText(element, user);
    }

    /**
     * Sets credentials and login on the page.
     *
     * @param user - User from where obtains the credentials.
     */
    public void login(final String user) {
        String username = CredentialsReader.getInstance().getUserName(user);
        String password = CredentialsReader.getInstance().getUserPassword(user);
        setCredential(userNameTxtBox, username);
        clickLogin();
        setCredential(passwordTxtBox, password);
        clickLogin();
    }
}
