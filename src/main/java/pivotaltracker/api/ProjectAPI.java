package pivotaltracker.api;

import io.restassured.response.Response;
import pivotaltracker.PageTransporter;
import pivotaltracker.ProjectObject;
import pivotaltracker.api.request.FactoryRequest;
import pivotaltracker.api.request.RequestManagerAbstract;
import pivotaltracker.ui.Permalink;

import static pivotaltracker.api.Endpoints.PROJECT_ENDPOINT;

/**
 * ProjectAPI class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ProjectAPI {
    private RequestManagerAbstract requestManagerAbstract;
    private Response response;
    private ProjectObject projectObject;

    /**
     * This method post a project from API.
     *
     * @param projectName - Project name.
     */
    public void postProject(final String projectName) {
        requestManagerAbstract = FactoryRequest.getRequest("POST");
        requestManagerAbstract.setEndPoint(PROJECT_ENDPOINT);
        String data = "{\"name\":\"" + projectName + "\"}";
        requestManagerAbstract.setData(data);
        response = requestManagerAbstract.makeRequest();
        int id = response.jsonPath().get("id");
        projectObject = new ProjectObject();
        projectObject.setIdProject(id);
    }

    /**
     * Deletes a project created throught API.
     */
    public void deleteProject() {
        PageTransporter.navigatePage(Permalink.DASHBOARD_PAGE);
        requestManagerAbstract = FactoryRequest.getRequest("DELETE");
        requestManagerAbstract.setEndPoint(PROJECT_ENDPOINT + "/" + ProjectObject.getIdProject());
        response = requestManagerAbstract.makeRequest();
    }
}
