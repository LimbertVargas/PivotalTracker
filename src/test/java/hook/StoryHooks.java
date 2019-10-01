package hook;

import cucumber.api.java.Before;
import io.restassured.response.Response;
import pivotaltracker.api.request.FactoryRequest;
import pivotaltracker.api.request.RequestManagerAbstract;
import pivotaltracker.ui.pages.DashboardPage;

import static pivotaltracker.api.Endpoints.PROJECT_ENDPOINT;

public class StoryHooks {
    private DashboardPage dashboardPage;
    private RequestManagerAbstract requestManagerAbstract;
    private Response response;

    /**
     * This method delete the last curriculum.
     */
    @Before("@CreateProject")
    public void createProject() {
        dashboardPage = new DashboardPage();
        dashboardPage.createProject("Project01");
    }

    @Before("@CreateProjectAPI")
    public void postProject() {
        requestManagerAbstract = FactoryRequest.getRequest("post");
        requestManagerAbstract.setEndPoint(PROJECT_ENDPOINT);
        String data = "{\"name\":\"Project001\",\"new_account_name\":\"Test\"}";
        requestManagerAbstract.setData(data);
        response = requestManagerAbstract.makeRequest();
        System.out.printf(response.toString() + "Holaaaa");
    }
}
