package base;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.ConfigReader;




public class ApiFunctions  extends Ab_Api {

    private Response response ;
    RequestSpecification httpsRequest = null;
    String requestJson = "{ \\\"name\\\": \\\"John\\\" }";
  //  public static String baseURl = "https://fakestoreapi.com/";

   public static String baseURl = ConfigReader.selectBaseUrl();


    public ApiFunctions() {
RestAssured.baseURI = baseURl;
        // Change this to your API base URL
        httpsRequest = RestAssured.given();
//                .relaxedHTTPSValidation();

    }
    @Override
    public void endPointUrl(String endPoint){

        baseURl = baseURl + endPoint;
        System.out.println("endpoint = " + baseURl);
    }

    @Override
    public void hitRequestApi(String hitRequest){
        switch (hitRequest.toUpperCase()){
            case "GET":
                httpsRequest = httpsRequest.baseUri(baseURl);
                httpsRequest = httpsRequest.header("Content-Type", "application/json");
                 response = httpsRequest.request(Method.GET);
                 System.out.println(response.toString());
                System.out.println(response.getStatusCode());
            break;

            case "POST":
                httpsRequest   =  httpsRequest.header("Content-Type", "application/json");
                httpsRequest.body(requestJson);
                 response =  httpsRequest.request(Method.POST);
                 System.out.println(response.body());

        }

    }



    @Override
    public void validateResponseCode(String responseCode) {
        try {
        int code = response.getStatusCode();
        String temp = Integer.toString(code);
            System.out.println("Response code is -"+ code);

        if (temp.equals(responseCode)) {
       System.out.println("Response code is -"+ code);
        } else {
            System.out.println("Response code is -"+ code);
        }
        }catch (Exception e) {
            System.err.println("General Exception: " + e.getMessage());}
    }
    }



