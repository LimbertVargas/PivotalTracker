/*
 * @(#) Authentication.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package PivotalTracker.api.restclient;

import core.utils.ConfigFileReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * Authentication class.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public final class Authentication {

    private static Authentication authentication;
    private static String accessToken;
    private String apiUrl;
    private String contentType;
    private RequestSpecification request;



    /**
     * This is constructor that initializes variables.
     */
    private Authentication() {

        accessToken = ConfigFileReader.getInstance().getAccessToken();
        apiUrl = ConfigFileReader.getInstance().getUrlApi();
        contentType = ConfigFileReader.getInstance().getContentType();
        request = new RequestSpecBuilder()
                .addHeader("X-TrackerToken",accessToken)
                .setBaseUri(apiUrl)

                .build();
    }

    /**
     * Gives the class instance according Singleton pattern.
     *
     * @return an instance.
     */
    public static Authentication getInstance() {
        if (authentication == null) {
            authentication = new Authentication();
        }
        return authentication;
    }


    /**
     * Gives the request specification resultant of oauth.
     *
     * @return an request specification.
     */
    public RequestSpecification getRequestSpecification() {
        return request;
    }
}