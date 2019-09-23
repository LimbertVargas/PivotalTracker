package hook;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pivotaltracker.api.restclient.Authentication;
public class Hooks {

    public static void main(String[] args) {
        RequestSpecification req = Authentication.requestSpecification();
        Response response = req.get();
        System.out.println(response.toString());
        //response.
    }
}
