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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import org.testng.Assert;
import pivotaltracker.PageTransporter;
import pivotaltracker.ProjectObject;
import pivotaltracker.api.ProjectAPI;
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

    public ImportExportSteps() {
        importProjectPage = new ImportProjectPage();
        exportProjectPage = new ExportProjectPage();
    }

    @When("I go to the Import Project page")
    public void iGoToTheImportProjectPage() {
        PageTransporter.navigatePageById(Permalink.PROJECT_PAGE, ProjectObject.getIdProject(), Permalink.PROJECT_IMPORT_PAGE);
    }

    @And("I load the CSV File {string} with stories")
    public void iLoadTheCSVFileWithStories(String fileName) {
        context = new Context();
        context.getCsvFile().setFileName(fileName);
        importProjectPage.importFile(fileName);
    }

    @Then("a message is shown indicated that the stories was (.*)")
    public void aMessageIsShownIndicatedThatTheStoriesWas(String message) {
        Assert.assertTrue(importProjectPage.messageCorrretImportPopUP().contains(message));
        Assert.assertTrue(importProjectPage.messageCorrectImport().contains(message));
    }

    @Then("I should see the stories created of the file")
    public void iShouldSeeTheStoriesCreatedOfTheFile() {
        CSVReader csvReader;
        csvReader = new CSVReader();
        Assert.assertEqualsNoOrder(importProjectPage.getList(), csvReader.getAttribute(context.getCsvFile().getFileName(), "title"));
    }

    @When("I go to the Export Project page")
    public void iGoToTheExportProjectPage() {
        PageTransporter.navigatePageById(Permalink.PROJECT_PAGE, ProjectObject.getIdProject(), Permalink.PROJECT_EXPORT_PAGE);
    }

    @When("I export the stories in a CSV File")
    public void iExportTheStoriesInACSVFile() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir"));
        exportProjectPage.exportProject();
    }

    @When("I go to the Story page")
    public void iGoToTheStoryPage() {
        PageTransporter.navigatePageThroughId(Permalink.PROJECT_STORY_PAGE, ProjectObject.getIdProject());
    }

    @Given("the user creates a project with the following data")
    public void theUserCreatesAProjectWithTheFollowingData(final Map<String, String> bodyFields) {
        projectAPI = new ProjectAPI();
        String projectName = bodyFields.get("name");
        projectAPI.postProject(projectName);
    }

    @Then("I should see the file in the folder download")
    public void iShouldSeeTheFileInTheFolderDownload() {
    }
}
