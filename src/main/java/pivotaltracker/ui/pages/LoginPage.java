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
 * LoginPage class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class LoginPage extends BasePage {

    @FindBy(id = "credentials_username")
    private WebElement userNameTextField;

    @FindBy(id = "credentials_password")
    private WebElement passwordTextField;

    @FindBy(name = "action")
    private WebElement nextButtonLogin;

    @FindBy(xpath = "//div[@class=\"Dropdown__content\"] //button[@aria-label=\"Profile Dropdown\"]\n")
    private WebElement profileDropDownButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(userNameTextField));
    }

    /**
     * Sets credentials and login on the page.
     * @param user - User from where obtains the credentials.
     */
    public void setCredentials(final String user) {
        String username = CredentialsReader.getInstance().getUserName(user);
        String password = CredentialsReader.getInstance().getUserPassword(user);
        PivotalTrackerUtils.setText(userNameTextField, username);
        nextButtonLogin.click();
        PivotalTrackerUtils.setText(passwordTextField, password);
        nextButtonLogin.click();
    }
}