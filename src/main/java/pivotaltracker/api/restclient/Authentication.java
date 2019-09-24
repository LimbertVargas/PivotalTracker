/*
 * @(#) Authentication.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.api.restclient;

import core.utils.ConfigFileReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * Authentication class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public final class Authentication {

    private static String accessToken;
    private static String apiUrl;
    private static String contentType;

    /**
     * Method that allows to build an address and then be sent to the page of sales force according to a token.
     *
     * @return RequestSpecification variable.
     */
    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(apiUrl)
                .addHeader("X-TrackerToken", accessToken)
                .setContentType(contentType)
                .build();
    }

    /**
     * Constructor.
     */
    private Authentication() {
        accessToken = ConfigFileReader.getInstance().getAccessToken();
        apiUrl = ConfigFileReader.getInstance().getUrlApi();
        contentType = ConfigFileReader.getInstance().getContentType();
    }
}