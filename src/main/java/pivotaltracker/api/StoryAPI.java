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
        response.jsonPath().get("$").toString();
        String json = response.asString();
        response.prettyPrint();
        String[] storyO = json.split(",");
        System.out.println(storyO[0] + " / / " + storyO[1] + " / / " + storyO[2]);
//        Gson gson = new Gson();
//        StoryObject storyObject = gson.fromJson(json, StoryObject.class);
//        System.out.println(storyObject.toString() + " HOLAAA");
    }
}
