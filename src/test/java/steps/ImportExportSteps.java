/*
 * @(#) ImportExportSteps.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package steps;

import core.utils.CSVReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import org.testng.Assert;
import pivotaltracker.ui.PageTransporter;
import pivotaltracker.ProjectObject;
import pivotaltracker.api.ProjectAPI;
import pivotaltracker.entities.CSVFile;
import pivotaltracker.entities.Context;
import pivotaltracker.ui.Permalink;
import pivotaltracker.ui.pages.story.ExportProjectPage;
import pivotaltracker.ui.pages.story.ImportProjectPage;

/**
 * ImportExportSteps class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ImportExportSteps {
    private ImportProjectPage importProjectPage;
    private ExportProjectPage exportProjectPage;
    private ProjectAPI projectAPI;
    private Context context;
    private CSVFile csvFile;
    private CSVReader csvReader;

    /**
     * Constructor class.
     *
     * @param context
     */
    public ImportExportSteps(Context context) {
        this.context = new Context();
        importProjectPage = new ImportProjectPage();
        exportProjectPage = new ExportProjectPage();
        csvFile = context.getCsvFile();
        csvReader = new CSVReader();

    }

    /**
     * This steps go to login page.
     */
    @When("I go to the Import Project page")
    public void goToTheImportProjectPage() {
        PageTransporter.navigatePageById(Permalink.PROJECT_PAGE, ProjectObject.getIdProject(), Permalink.PROJECT_IMPORT_PAGE);
    }

    /**
     * Loads csv file
     *
     * @param fileName - CSV file name.
     */
    @When("I load the CSV File {string} with stories")
    public void loadTheCSVFileWithStories(String fileName) {
        context.getCsvFile().setFileName(fileName);
        importProjectPage.importFile(fileName);
    }

    /**
     * Gets message for confirm the csv load.
     *
     * @param message
     */
    @Then("a message is shown saying that the stories were (.*)")
    public void getMessageIsShownIndicatedThatTheStoriesWas(String message) {
        Assert.assertTrue(importProjectPage.messageCorrretImportPopUP().contains(message));
        Assert.assertTrue(importProjectPage.messageCorrectImport().contains(message));
    }

    /**
     * Go to export project page.
     */
    @When("I go to the Export Project page")
    public void goToTheExportProjectPage() {
        PageTransporter.navigatePageById(Permalink.PROJECT_PAGE, ProjectObject.getIdProject(), Permalink.PROJECT_EXPORT_PAGE);
    }

    /**
     * Export the csv file.
     */
    @When("I export the stories in a CSV File")
    public void exportTheStoriesInACSVFile() {
        exportProjectPage.exportProject();
    }

    /**
     * Go to story page.
     */
    @When("I go to the Story page")
    public void goToTheStoryPage() {
        PageTransporter.navigatePageThroughId(Permalink.PROJECT_STORY_PAGE, ProjectObject.getIdProject());
    }

    /**
     * Create project through API.
     *
     * @param bodyFields
     */
    @Given("I had created a project with the following data")
    public void theUserCreatesAProjectWithTheFollowingData(final Map<String, String> bodyFields) {
        projectAPI = new ProjectAPI();
        String projectName = bodyFields.get("name");
        projectAPI.postProject(projectName);
    }

    /**
     * Verify the correct load of the stories.
     */
    @Then("I should see the stories created on the stories")
    public void shouldSeeTheStoriesCreatedOnTheStories() {
        csvFile.setTitlesStory(csvReader.getAttributeStory(context.getCsvFile().getFileName(), ImportProjectPage.TITLE));
        csvFile.setLabels(csvReader.getAttributeStory(context.getCsvFile().getFileName(), ImportProjectPage.LABELS));
        Assert.assertEqualsNoOrder(importProjectPage.getTitleList(), csvFile.getTitlesStory());
        Assert.assertEqualsNoOrder(importProjectPage.getLabels(), csvFile.getLabels());
    }
}
