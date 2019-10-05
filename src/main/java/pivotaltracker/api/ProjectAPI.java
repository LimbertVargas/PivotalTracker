package pivotaltracker.api;

import io.restassured.response.Response;
import pivotaltracker.ProjectObject;
import pivotaltracker.api.request.FactoryRequest;
import pivotaltracker.api.request.RequestManagerAbstract;

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
     */
    public void postProject() {
        projectObject = new ProjectObject();
        requestManagerAbstract = FactoryRequest.getRequest("POST");
        requestManagerAbstract.setEndPoint(PROJECT_ENDPOINT);
        String data = "{\"name\":\"Project02\"}";
        requestManagerAbstract.setData(data);
        response = requestManagerAbstract.makeRequest();
        int id =Integer.parseInt(response.jsonPath().get("id").toString());
        projectObject.setIdProject(id);
    }
}
