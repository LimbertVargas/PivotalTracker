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

package core.selenium.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * CredentialsReader class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class CredentialsReader {
    final String JSONPATH = "employees.json";
    JsonObject jsonObject;

    /**
     * Constructor class init reader json file.
     */
    public CredentialsReader() {
        reader();
    }

    /**
     * Reads json file and save the data in jsonObject.
     */
    private void reader() {
        try {
            JsonReader reader = new JsonReader(new FileReader(JSONPATH));
            jsonObject = new JsonParser().parse(reader).getAsJsonObject();
        } catch (FileNotFoundException e) {
            Log.getInstance().getLog().error(e.getMessage());
        }
    }

    /**
     * Gets user name from json object from specific user.
     *
     * @param user - Keyword with which the credential will be searched.
     * @return username - User name credential.
     */
    public String getUseName(String user) {
        String username = jsonObject.getAsJsonObject(user).get("username").getAsString();
        return username;
    }

    /**
     * Gets user password from json object from specific user.
     *
     * @param user - Keyword with which the credential will be searched.
     * @return password - User password credential.
     */
    public String getUsePassword(String user) {
        String password = jsonObject.getAsJsonObject(user).get("password").getAsString();
        return password;
    }
}
