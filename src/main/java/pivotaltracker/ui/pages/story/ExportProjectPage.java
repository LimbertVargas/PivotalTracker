package pivotaltracker.ui.pages.story;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotaltracker.BasePage;

public class ExportProjectPage extends BasePage {
    @FindBy(id = "csv_import_file")
    private WebElement exportBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Click on export button.
     */
    private void clickExportBtn() {
        exportBtn.click();
    }

    /**
     * Exports project to csv.
     */
    public void exportProject() {
        clickExportBtn();
    }
}
