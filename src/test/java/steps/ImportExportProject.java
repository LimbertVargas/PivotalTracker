package steps;

import core.utils.CVSReader;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pivotaltracker.PageTransporter;
import pivotaltracker.ProjectObject;
import pivotaltracker.ui.pages.story.ExportProjectPage;
import pivotaltracker.ui.pages.story.ImportProjectPage;

/**
 * ImportExportProject class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ImportExportProject {
    private ImportProjectPage importProjectPage;
    private ExportProjectPage exportProjectPage;

    public ImportExportProject() {
        importProjectPage = new ImportProjectPage();
        exportProjectPage = new ExportProjectPage();
    }

    @When("I go to the Import Project page")
    public void iGoToTheImportProjectPage() {
        String endpoint = "/projects";
        PageTransporter.navigatePageThroughId(endpoint, ProjectObject.getIdProject(), "import");
    }

    @And("I load the CSV File with stories")
    public void iLoadTheCSVFileWithStories() {
        importProjectPage.importFile();
    }

    @Then("a message is shown indicated that the stories was (.*)")
    public void aMessageIsShownIndicatedThatTheStoriesWas(String message) {
        Assert.assertTrue(importProjectPage.messageCorrretImportPopUP().contains(message));
        Assert.assertTrue(importProjectPage.messageCorrectImport().contains(message));
    }

    @Then("I should see the stories created")
    public void iShouldSeeTheStoriesCreated() {
        CVSReader cvsReader;
        cvsReader = new CVSReader();
        Assert.assertEqualsNoOrder(importProjectPage.getList(), cvsReader.getIdsStory());
    }

    @When("I go to the Export Project page")
    public void iGoToTheExportProjectPage() {
        String endpoint = "/projects";
        PageTransporter.navigatePageThroughId(endpoint, ProjectObject.getIdProject(), "export");
    }

    @And("I export the stories in a CSV File")
    public void iExportTheStoriesInACSVFile() {
        exportProjectPage.exportProject();
    }

    @Then("I should see the file in the folder download")
    public void iShouldSeeTheFileInTheFolderDownload() {
    }
}