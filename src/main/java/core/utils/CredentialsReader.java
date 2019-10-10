/*
 * @(#) CredentialsReader.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package core.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.log4j.spi.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import pivotaltracker.entities.User;

/**
 * CredentialsReader class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public final class CredentialsReader {
    private static CredentialsReader instance;
    private static JsonObject credentials;
    private static final String USER_CONFIG_FILE = "credentials.json";
    private static final Logger  LOGGER = LoggerFactory.getLogger(CredentialsReader.class);
    private static final String LOGGER_MESSAGE = "Specified resource file not found!!!";

    /**
     * Constructor class.
     */
    public CredentialsReader() {
        initialize();
    }

    /**
     * Returns the same and only instance of this class.
     *
     * @return the same instance of CredentialDeserializer class.
     */
    public static CredentialsReader getInstance() {
        if ((instance == null) || (credentials == null)) {
            instance = new CredentialsReader();
        }
        return instance;
    }

    /**
     * Deserializes the credentials information provided as a json file to a POJO entity class.
     *
     * @param user a String containing the type of user to retrieve.
     * @return entity instance according to the value.
     */
    public static User getUser(final String user) {
        JsonElement jsonUser = credentials.getAsJsonObject(user);
        Gson gson = new Gson();
        User userObject = gson.fromJson(jsonUser, User.class);
        return userObject;
    }

    /**
     * Sets the initial value of credentials attribute of this class.
     */
    private void initialize() {
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = null;
        String jsonDirectory = USER_CONFIG_FILE;
        try {
            jsonElement = parser.parse(new FileReader(jsonDirectory));
        } catch (FileNotFoundException fnfex) {
            LOGGER.error(LOGGER_MESSAGE, fnfex, ErrorCode.FILE_OPEN_FAILURE);
            throw new RuntimeException(LOGGER_MESSAGE);
        }
        credentials = jsonElement.getAsJsonObject();
    }
}
