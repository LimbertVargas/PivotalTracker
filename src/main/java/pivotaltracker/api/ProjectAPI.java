/*
 * @(#) ProjectAPI.java Copyright (c) 2019 Jala Foundation.
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

import io.restassured.response.Response;
import pivotaltracker.ProjectObject;
import pivotaltracker.api.request.FactoryRequest;
import pivotaltracker.api.request.RequestManagerAbstract;
import pivotaltracker.entities.Story;
import pivotaltracker.ui.pages.story.StoryPage;

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
        requestManagerAbstract = FactoryRequest.getRequest("POST");
        requestManagerAbstract.setEndPoint(PROJECT_ENDPOINT);
        String data = "{\"name\":\"ProjectTest\"}";
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
        requestManagerAbstract = FactoryRequest.getRequest("DELETE");
        requestManagerAbstract.setEndPoint(PROJECT_ENDPOINT + "/" + ProjectObject.getIdProject());
        response = requestManagerAbstract.makeRequest();
        StoryPage storyPage = new StoryPage();
        storyPage.clickReloadBtn();
    }
}
