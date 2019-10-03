/*
 * @(#) StoryPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.pages.story;

import core.utils.DriverMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pivotaltracker.BasePage;

public class StoryPage extends BasePage {
    private String addBacklogStoryBtn = "//div[@class='panel c261 backlog_%S backlog items_draggable visible'] //a[@title='Add Story']";

    @FindBy(xpath = "//div[@data-type='backlog'] //div[@class='DropdownButton__icon___1qwu3upG tn-DropdownButton___nNklb3UY']")
    private WebElement actionsBtn;

    @FindBy(xpath = "//span[contains(text(),'Split Current Iteration and Backlog')]")
    private WebElement splitCurrentIterationAndBacklogMenu;

    @FindBy(css = "[aria-label='story title']")
    private WebElement storyTitleTxtBox;

    @FindBy(id = "story_type_dropdown_c235_arrow")
    private WebElement storyTypeBtn;

    @FindBy(id = "story_estimate_dropdown_c235_arrow")
    private WebElement storyPointsBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    public void createBacklogStory(final String storyTitle) {
        DriverMethods.setText(storyTitleTxtBox, storyTitle);
    }

    /**
     * Separates current of the backlog panel.
     */
    public void separateCurrentBacklog() {
        actionsBtn.click();
        String url = driver.getCurrentUrl();
        System.out.printf(url);
        splitCurrentIterationAndBacklogMenu.click();
    }
}
