package pivotaltracker.api;

import com.google.gson.Gson;
import io.restassured.response.Response;
import pivotaltracker.ProjectObject;
import pivotaltracker.StoryObject;
import pivotaltracker.api.request.FactoryRequest;
import pivotaltracker.api.request.RequestManagerAbstract;

import static pivotaltracker.api.Endpoints.PROJECT_ENDPOINT;

public class StoryAPI {
    private RequestManagerAbstract requestManagerAbstract;
    private Response response;
    private ProjectObject projectObject;

    /**
     * This method gets a story data.
     */
    public void getStories() {
        requestManagerAbstract = FactoryRequest.getRequest("GET");
        requestManagerAbstract.setEndPoint(PROJECT_ENDPOINT + "/" + ProjectObject.getIdProject() + "/" + "stories");
        response = requestManagerAbstract.makeRequest();
        String json = response.jsonPath().get("$").toString();
        response.prettyPrint();
        Gson gson = new Gson();
        StoryObject storyObject = gson.fromJson(json, StoryObject.class);
        System.out.println(storyObject.toString() + " HOLAAA");
    }
}
