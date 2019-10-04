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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pivotaltracker.BasePage;
import pivotaltracker.entities.Context;

public class StoryPage extends BasePage {
    private Context context;
    private Integer idProject;

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

    @FindBy(css = "[class='dropdown story_type']")
    private WebElement storyTypeMenu;

    @FindBy(css = "[class='dropdown story_estimate']")
    private WebElement storyEstimate;

    @FindBy(css = "[class='item_feature']")
    private WebElement featureStoryType;

    @FindBy(css = "[class='dropdown_menu search hover']")
    private WebElement dropDownStoryTypeMenu;

    @FindBy(css = "[data-aid='LabelsSearch__input']")
    private WebElement labelTxtBox;

    @FindBy(css = "[class='autosaves button std save']")
    private WebElement saveStoryBtn;

    private static final String ADDSTORYBTN = "//div[@id='panel_backlog_%S'] //a[@title='Add Story']";
    private static final String BACKLOGFOCUS = "panel_backlog_%S";
    private static final String STORYTYPE = "//a[@class='item_%s ']";
    private static final String STARTSTORY = "//div [@aria-label='%s'] //label[@data-aid='StateButton']";
    private static final String ACCEPTSTORY = "//div [@aria-label='%s'] //label[text()='Accept']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Separates current of the backlog panel.
     */
    public void separateCurrentBacklog() {
        actionsBtn.click();
        splitCurrentIterationAndBacklogMenu.click();
    }

    public void createBacklogStory(final String storyTitle) {
        DriverMethods.setText(storyTitleTxtBox, storyTitle);
    }

    /**
     * Gets id project.
     *
     * @return idProject
     */
    private String getIdProject() {
        String url = driver.getCurrentUrl();
        String[] idProject = url.split("/");
        return idProject[idProject.length - 1];
    }

    private void backlogFocusForm() {
        driver.findElement(By.id(backlogFormFocus())).click();
    }

    /**
     *
     */
    public void clickBacklogMenuBtn() {
        System.out.println(getIdProject());
        System.out.println(addIdAddStoryBtn());
        System.out.println(backlogFormFocus());
        backlogFocusForm();
        driver.findElement(By.xpath(addIdAddStoryBtn())).click();
    }

    private String addIdAddStoryBtn() {
        return String.format(ADDSTORYBTN, getIdProject());
    }

    private String backlogFormFocus() {
        return String.format(BACKLOGFOCUS, getIdProject());
    }

    private void storyTypeMenuClick() {
        storyTypeMenu.click();
    }

    private void storyTypeClick() {
        storyTypeMenuClick();
    }

    private String storyType(final String storyType) {
        return String.format(STORYTYPE, storyType);
    }

    public void selectStoryType(final String storyType) {
        storyTypeClick();
        driver.findElement(By.xpath(storyType(storyType))).click();
    }

    private void storyEstimateClick() {
        storyEstimate.click();
    }

    public void selectStoryEstimate(final String estimate) {
        storyEstimateClick();
        driver.findElement(By.xpath(storyType(estimate))).click();
    }

    public void putLabel(final String label) {
        DriverMethods.setText(labelTxtBox, label);
    }

    public void createStory(final String storyName,
                            final String storyType, final String storyEstimate,
                            final String label) {
        separateCurrentBacklog();
        clickBacklogMenuBtn();
        createBacklogStory(storyName);
        selectStoryType(storyType);
        selectStoryEstimate(storyEstimate);
        putLabel(label);
        labelTxtBox.sendKeys(Keys.ENTER);
        saveStoryBtn.click();
    }

    public String storyStart(final String storyType) {
        return String.format(STARTSTORY, storyType);
    }

    public String buildAcceptStoryLocator(final String storyType) {
        return String.format(ACCEPTSTORY, storyType);
    }

    public void finishStoryFlow(final String storyType) {
        driver.findElement(By.xpath(storyStart(storyType)));
        driver.findElement(By.xpath(storyStart(storyType)));
        driver.findElement(By.xpath(storyStart(storyType)));
        driver.findElement(By.xpath(buildAcceptStoryLocator(storyType)));
    }
}
