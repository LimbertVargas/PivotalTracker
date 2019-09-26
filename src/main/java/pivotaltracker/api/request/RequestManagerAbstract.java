/*
 * @(#) RequestManagerAbstract.java Copyright (c) 2019 Jala Foundation.
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

import core.utils.ConfigFileReader;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pivotaltracker.api.restclient.Authentication;


/**
 * RequestManagerAbstract class.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public abstract class RequestManagerAbstract {
    private String endPoint;
    private String data;
    private String method;

    /**
     * Created a protected initializeValue to define empty values.
     */
    protected void initializeValue() {
        this.endPoint = "";
        this.data = "";
        this.method = "";
    }

    /**
     * Sets endPoint attribute.
     *
     * @param endPoint is new value for set endPoint attribute.
     */
    public void setEndPoint(final String endPoint) {
        this.endPoint = ConfigFileReader.getInstance().getBaseUrl()
                + ConfigFileReader.getInstance().getApiUrl()
                + endPoint;
    }

    /**
     * Sets data attribute with a new value.
     *
     * @param data is the new value for set data attribute.
     */
    public void setData(final String data) {
        this.data = data;
    }

    /**
     * Gets data attribute of class.
     *
     * @return data attribute.
     */
    public String getData() {
        return data;
    }

    /**
     * Gets method attribute of class.
     *
     * @return method attribute.
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets method attribute with a new value.
     *
     * @param method is the new value for set method attribute.
     */
    public void setMethod(final String method) {
        this.method = method;
    }

    /**
     * Gets RequestSpecification with data for authentication.
     *
     * @return a RequestSpecification.
     */
    public RequestSpecification getRequest() {
        return Authentication.getInstance().getRequestSpecification();
    }

    /**
     * Gets endPoint attribute of class.
     *
     * @return endPoint attribute.
     */
    public String getEndPoint() {
        return endPoint;
    }

    /**
     * Makes request and returns its response.
     *
     * @return a Response of a request.
     */
    public abstract Response makeRequest();
}
