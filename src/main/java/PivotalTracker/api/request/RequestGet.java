/*
 * @(#) RequestGet.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package PivotalTracker.api.request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * RequestGet class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class RequestGet extends RequestManagerAbstract {

    /**
     * Call the method initializeValue from RequestManagerAbstract class.
     */
    public RequestGet() {
        super.initializeValue();
    }

    /**
     * Makes a get request and returns its response.
     *
     * @return a Response of a get request.
     */
    public Response makeRequest() {
        return given().
                spec(super.getRequest()).
                when().
                get(super.getEndPoint());
    }
}
