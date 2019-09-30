/*
 * @(#) RequestDelete.java Copyright (c) 2019 Jala Foundation.
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

/**
 * RequestDelete class.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class RequestDelete extends RequestManagerAbstract {

    /**
     * Call the method initializeValue from RequestManagerAbstract class.
     */
    public RequestDelete() {
        super.initializeValue();
    }

    /**
     * Makes a delete request and returns its response.
     *
     * @return a Response of a delete request.
     */
    public Response makeRequest() {
        return given().
                spec(super.getRequest()).
                when().
                delete(super.getEndPoint());
    }
}
