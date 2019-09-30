package hook;

import cucumber.api.java.Before;
import pivotaltracker.ui.pages.DashboardPage;

public class StoryHooks {
    private DashboardPage dashboardPage;

    /**
     * This method delete the last curriculum.
     */
    @Before(value = "@CreateProject")
    public void createProject() {
        dashboardPage = new DashboardPage();
        dashboardPage.createProject("Project01");
    }
}
