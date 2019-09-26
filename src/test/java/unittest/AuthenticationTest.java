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

package unittest;

import core.utils.ConfigFileReader;
import pivotaltracker.api.request.FactoryRequest;
import pivotaltracker.api.request.RequestManagerAbstract;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * AuthenticationTest class.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class AuthenticationTest {
    private final int successCode = 200;

    @Test
    public void authenticationTest() {
        RequestManagerAbstract requestManagerAbstract = FactoryRequest.getRequest("get");
        requestManagerAbstract.setEndPoint("me/");
        Response response = requestManagerAbstract.makeRequest();
        Assert.assertEquals(response.getStatusCode(), successCode);

    }
}
