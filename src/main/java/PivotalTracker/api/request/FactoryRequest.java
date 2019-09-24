/*
 * @(#) FactoryRequest.java Copyright (c) 2019 Jala Foundation.
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

/**
 * FactoryRequest class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public final class FactoryRequest {
    public static final String MESSAGE_FOR_UNKNOWN_METHOD = "Unknown method type";

    /**
     * This method constructor initializes variables.
     */
    private FactoryRequest() {
    }

    /**
     * Creates an instance specific of RequestManagerAbstract.
     *
     * @param method is for validate the type of RequestManagerAbstract.
     * @return an instance RequestManagerAbstract.
     */
    public static RequestManagerAbstract getRequest(String method) {
        String nameMethod = method.toUpperCase();
        RequestMethod requestMethod = RequestMethod.valueOf(nameMethod);
        switch (requestMethod) {
            case POST:
                return new RequestPost();
            case GET:
                return new RequestGet();
            case PUT:
                return new RequestPut();
            case DELETE:
                return new RequestDelete();
            default:
                throw new RuntimeException(MESSAGE_FOR_UNKNOWN_METHOD);
        }
    }
}
