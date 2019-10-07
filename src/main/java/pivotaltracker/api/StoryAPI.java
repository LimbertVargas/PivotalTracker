/*
 * @(#) StoryAPI.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.api;

import com.google.gson.Gson;
import io.restassured.response.Response;
import pivotaltracker.ProjectObject;
import pivotaltracker.StoryObject;
import pivotaltracker.api.request.FactoryRequest;
import pivotaltracker.api.request.RequestManagerAbstract;
import pivotaltracker.entities.Context;

import static pivotaltracker.api.Endpoints.PROJECT_ENDPOINT;

/**
 * StoryAPI class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class StoryAPI {
    private RequestManagerAbstract requestManagerAbstract;
    private Response response;
    private static StoryObject storyObject;
    private Context context;

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
        context = new Context();
        context.setStoryObject(storyObject);
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
}
