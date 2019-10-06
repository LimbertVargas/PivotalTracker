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
    private static StoryObject storyObject;

    /**
     * This method gets a story data.
     */
    public void getStories() {
        requestManagerAbstract = FactoryRequest.getRequest("GET");
        requestManagerAbstract.setEndPoint(PROJECT_ENDPOINT + "/" + ProjectObject.getIdProject() + "/" + "stories");
        response = requestManagerAbstract.makeRequest();
        response.jsonPath().get("$").toString();
        String json = response.asString();
        String[] storyO = json.split(",");
        String storyObjectJson = storyO[0].substring(1) + "," + storyO[1] + "," + storyO[4] + "," + storyO[5] + "," + storyO[6] + "," + storyO[10] + "}";
        Gson gson = new Gson();
        storyObject = gson.fromJson(storyObjectJson, StoryObject.class);
    }

    /**
     * This method gets a story data.
     */
    public void postStories() {
        requestManagerAbstract = FactoryRequest.getRequest("POST");
        requestManagerAbstract.setEndPoint(PROJECT_ENDPOINT + "/" + ProjectObject.getIdProject() + "/" + "stories");
        String data = "{\"name\":\"Exhaust ports are ray shielded\"}";
        requestManagerAbstract.setData(data);
        response = requestManagerAbstract.makeRequest();
    }

    public static StoryObject getStoryObject() {
        return storyObject;
    }
}
