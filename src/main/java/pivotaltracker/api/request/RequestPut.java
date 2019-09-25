/*
 * @(#) RequestPut.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.api.request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * RequestPut class.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class RequestPut extends RequestManagerAbstract {

    /**
     * Call the method initializeValue from RequestManagerAbstract class.
     */
    public RequestPut() {
        super.initializeValue();
    }

    /**
     * Makes a put request and returns its response.
     *
     * @return a Response of a put request.
     */
    public Response makeRequest() {
        return given().
                spec(getRequest()).
                contentType(JSON).
                body(getData()).
                when().
                put(getEndPoint());
    }
}
