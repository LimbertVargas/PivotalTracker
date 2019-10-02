/*
 * @(#) TopBar.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * TopBar class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class TopBar extends BasePage {
    @FindBy(id = "header_wrapper")
    private WebElement topBarHeader;

    @FindBy(css = "div [aria-label='Profile Dropdown']")
    private WebElement profileBtn;

    @FindBy(css = "button[data-aid=\"ProfileDropdown__signout\"]")
    private WebElement singOutBtn;

    @FindBy(linkText = "Help")
    private WebElement helpBtn;

    @FindBy(linkText = "What's New")
    private WebElement newsBtn;

    @FindBy(css = "[class='search_bar']")
    private WebElement searchTxtBox;

    @FindBy(css = "[class='tc_projects_dropdown_link tc_context_name']")
    private WebElement principalBtn;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(topBarHeader));
    }

    /**
     * Click in profile button.
     */
    private void clickProfileBtn() {
        profileBtn.click();
    }

    /**
     * Click in profile button.
     */
    private void clickSingOutBtn() {
        singOutBtn.click();
    }

    /**
     * Click in log out button.
     */
    public void logOut() {
        clickProfileBtn();
        clickSingOutBtn();
    }
}