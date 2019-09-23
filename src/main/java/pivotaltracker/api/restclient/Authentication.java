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

package pivotaltracker.api.restclient;

import core.utils.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * Authentication class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public final class Authentication {

    private static Authentication authentication;
    private static String accessToken;
    private static String apiUrl;
    private static String contentType;
    private RequestSpecification request;



    /**
     * This is constructor that initializes variables.
     */
    private Authentication() {

        accessToken = ConfigFileReader.getInstance().getAccessToken();
        apiUrl = ConfigFileReader.getInstance().getUrlApi();
        contentType = ConfigFileReader.getInstance().getContentType();
        ConfigFileReader reader = ConfigFileReader.getInstance();
        String token = reader.getAccessToken();
        String baseUrl = reader.getUrlApi();
        request = new RequestSpecBuilder()
                .setBaseUri(baseUrl).build();
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
     * Method that allows to build an address and then be sent to the page of sales force according to a token.
     *
     * @return RequestSpecification variable.
     */
    public static RequestSpecification requestSpecification() {

        RequestSpecification request;
        accessToken = ConfigFileReader.getInstance().getAccessToken();
        apiUrl = ConfigFileReader.getInstance().getUrlApi();
        request = new RequestSpecBuilder()
                .addHeader("X-TrackerToken",accessToken)
                .setBaseUri(apiUrl)
                .build();

        return request;

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