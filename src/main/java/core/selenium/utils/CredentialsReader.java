package core.selenium.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CredentialsReader {
    final String JSONPATH = "employees.json";
    JsonObject jsonObject;

    public CredentialsReader() {
        reader();
    }

    private void reader() {
        try {
            JsonReader reader = new JsonReader(new FileReader(JSONPATH));
            jsonObject = new JsonParser().parse(reader).getAsJsonObject();
        } catch (FileNotFoundException e) {
        }
    }

    public String getUseName(String value) {
        String username = jsonObject.getAsJsonObject(value).get("username").getAsString();
        System.out.println(username);
        return username;
    }

    public static void main(String[] args) {
        CredentialsReader credentialsReader = new CredentialsReader();
        credentialsReader.getUseName("User1");
    }
}
