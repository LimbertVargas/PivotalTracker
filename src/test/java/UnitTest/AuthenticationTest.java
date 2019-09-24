/*
 * @(#) AuthenticationTest.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package UnitTest;

import PivotalTracker.api.request.FactoryRequest;
import PivotalTracker.api.request.RequestManagerAbstract;
import core.utils.ConfigFileReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * AuthenticationTest class
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class AuthenticationTest {

    @Test
    public void authenticationTest() {
        RequestManagerAbstract requestManagerAbstract;
        String method = "get";
        String endPoint = "/me/";
        requestManagerAbstract = FactoryRequest.getRequest(method);
        requestManagerAbstract.setMethod(method);
        requestManagerAbstract.setEndPoint(endPoint);
        Response response = requestManagerAbstract.makeRequest();

        Assert.assertEquals(response.getStatusCode(),200);

    }
}