/*
 * @(#) WorkspaceHook.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import pivotaltracker.api.request.FactoryRequest;
import pivotaltracker.api.request.RequestManagerAbstract;
import pivotaltracker.entities.Context;

/**
 * WorkspaceHook class.
 *
 * @author Andres Burgos
 * @version 1.0
 */


public class WorkspaceHook {
    private Context context;
    private Response response;
    private RequestManagerAbstract requestManager;
    /**
     * Makes a request for delete a Workspace by id.
     */
    @After("@delete-workspace")
    public void afterScenario() {
        String id = context.getMapIds().containsKey("idBoard")
                ? context.getMapIds().get("idBoard") : context.getMapIds().get("id");
        String endPoint = "/boards/".concat(id);
        String method = "delete";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        response = requestManager.makeRequest();
    }

    /**
     * Makes a request for create a Workspace.
     */
    @Before("@create-workspace")
    public void beforeScenario() {
        String endPoint = "/boards/";
        String method = "post";
        String name = NamesGenerator.newName();
        String data = "{ \"name\":\"" + name + "\"}";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
        context.getMapIds().put("idBoard", response.jsonPath().get("id"));
        context.getMapIds().put("idBoardNotValid", "5d5157ebc6ea6c0553aa6900");
    }
}
