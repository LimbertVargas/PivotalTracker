package hook;

import PivotalTracker.api.request.FactoryRequest;
import PivotalTracker.api.request.RequestManagerAbstract;
import core.utils.ConfigFileReader;
import io.restassured.response.Response;


public class Hooks {

    public static void main(String[] args) {

        RequestManagerAbstract requestManagerAbstract;
        String method = "get";
        String endPoint = "/me/";
        requestManagerAbstract = FactoryRequest.getRequest(method);
        requestManagerAbstract.setMethod(method);
        requestManagerAbstract.setEndPoint(endPoint);
        Response response = requestManagerAbstract.makeRequest();

        System.out.println(response.getStatusCode());


    }
}
