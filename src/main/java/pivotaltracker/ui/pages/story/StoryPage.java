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

import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;
import pivotaltracker.entities.Context;

/**
 * StoryPage class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
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

    @FindBy(xpath = "//span[@class='meta'] //span")
    private WebElement estimateTxt;

    @FindBy(css = "[class='tracker_markup']")
    private WebElement storyTitleTxt;

    @FindBy(css = "[class='std label']")
    private WebElement labelTxt;

    @FindBy(css = "[class='SMkCk__Button QbMBD__Button--primary']")
    private WebElement reloadPopUPBtn;

    private static final String ADDSTORYBTN = "//div[@id='panel_backlog_%S'] //a[@title='Add Story']";
    private static final String BACKLOGFOCUS = "panel_backlog_%S";
    private static final String STORYTYPE = "//a[@class='item_%s ']";
    private static final String STARTSTORY = "//div[@aria-label='%s'] //label[@data-aid='StateButton']";
    private static final String ACCEPTSTORY = "//div[@aria-label='%s'] //label[text()='Accept']";
    private static final String ESTIMATESTORY = "//div[@data-id='%s'] //span[@class='meta'] //span";

    /**
     * Wait for a WebElement.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(actionsBtn));
    }

    /**
     * Separates current of the backlog panel.
     */
    public void separateCurrentBacklog() {
        actionsBtn.click();
        splitCurrentIterationAndBacklogMenu.click();
    }

    /**
     * Sets backlog story title.
     *
     * @param storyTitle - Story title
     */
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

    /**
     * Focus backlog form.
     */
    private void backlogFocusForm() {
        driver.findElement(By.id(backlogFormFocus())).click();
    }

    /**
     * Click on backlog menu button.
     */
    public void clickBacklogMenuBtn() {
        backlogFocusForm();
        driver.findElement(By.xpath(addIdAddStoryBtn())).click();
    }

    /**
     * Builds button locator.
     *
     * @return Locator story button
     */
    private String addIdAddStoryBtn() {
        return String.format(ADDSTORYBTN, getIdProject());
    }

    /**
     * Builds back form focus locator.
     *
     * @return Locator Backlog form
     */
    private String backlogFormFocus() {
        return String.format(BACKLOGFOCUS, getIdProject());
    }

    /**
     * Click on story tipe menu.
     */
    private void storyTypeMenuClick() {
        storyTypeMenu.click();
    }

    /**
     * Click on story type.
     */
    private void storyTypeClick() {
        storyTypeMenuClick();
    }

    /**
     * Build story type locator.
     *
     * @param storyType - Story type.
     * @return story type locator
     */
    private String storyType(final String storyType) {
        return String.format(STORYTYPE, storyType);
    }

    /**
     * Click story type.
     *
     * @param storyType - Story type.
     */
    public void selectStoryType(final String storyType) {
        storyTypeClick();
        driver.findElement(By.xpath(storyType(storyType))).click();
    }

    /**
     * Click story estimate.
     */
    private void storyEstimateClick() {
        storyEstimate.click();
    }

    /**
     * Click story type estimate.
     *
     * @param estimate - Story estimate
     */
    public void selectStoryEstimate(final String estimate) {
        storyEstimateClick();
        driver.findElement(By.xpath(storyType(estimate))).click();
    }

    /**
     * This methods create label in the story.
     *
     * @param label - Story label
     */
    public void putLabel(final String label) {
        DriverMethods.setText(labelTxtBox, label);
    }

    /**
     * This method creates story.
     *
     * @param storyName     Story name
     * @param storyType     Story type
     * @param storyEstimate Story estimate
     * @param label         Label
     */
    public void createStory(final String storyName,
                            final String storyType, final String storyEstimate,
                            final String label) {
        context = new Context();
        separateCurrentBacklog();
        clickBacklogMenuBtn();
        createBacklogStory(storyName);
        selectStoryType(storyType);
        selectStoryEstimate(storyEstimate);
        putLabel(label);
        labelTxtBox.sendKeys(Keys.ENTER);
        saveStoryBtn.click();
    }

    /**
     * Builds story start button locator.
     *
     * @param storyType - Story type.
     * @return Locator
     */
    public String storyStart(final String storyType) {
        return String.format(STARTSTORY, storyType);
    }

    /**
     * Builds accept story button locator.
     *
     * @param storyType - Story type
     * @return Locator
     */
    public String buildAcceptStoryLocator(final String storyType) {
        return String.format(ACCEPTSTORY, storyType);
    }

    /**
     * Complete the flow for finish the story.
     *
     * @param storyName - Story name
     */
    public void finishStoryFlow(final String storyName) {
        driver.findElement(By.xpath(storyStart(storyName))).click();
        driver.findElement(By.xpath(storyStart(storyName))).click();
        driver.findElement(By.xpath(storyStart(storyName))).click();
        driver.findElement(By.xpath(buildAcceptStoryLocator(storyName))).click();
    }

    /**
     * Gets story title.
     *
     * @return storyTitleTxt
     */
    public String getStoryTitleTxt() {
        return storyTitleTxt.getText();
    }

    /**
     * Gets label.
     *
     * @return label
     */
    public String getLabelTxt() {
        return labelTxt.getText();
    }

    /**
     * Click on reload popup button.
     */
    public void clickReloadBtn() {
        reloadPopUPBtn.click();
    }
}
