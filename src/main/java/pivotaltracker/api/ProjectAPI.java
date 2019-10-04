package pivotaltracker.api;

import io.restassured.response.Response;
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

    /**
     * This method post a project from API.
     */
    public void postProject() {
        requestManagerAbstract = FactoryRequest.getRequest("POST");
        requestManagerAbstract.setEndPoint(PROJECT_ENDPOINT);
        String data = "{\"name\":\"Project0002\"}";
        requestManagerAbstract.setData(data);
        response = requestManagerAbstract.makeRequest();
    }
}
