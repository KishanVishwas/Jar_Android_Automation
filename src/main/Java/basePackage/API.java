package basePackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class API {
    public static String decryptOtp(String number){

        RestAssured.baseURI = "https://dev.myjar.app";

        Response response = given()
                .header("Authorization", "Basic cGFydG5lcl9pbmNlabnRpdmVfc2VydmljZTo1OWMyNTUxZmU0YmVmYjA4OTVlN2I3ZGI5NzMzNWRhMDRiMmI0NTlmZWViZWZlZWYxMGI5YTlkZDdlMjU3MmZi")
                .queryParam("phoneNumber", number)
                .when()
                .get("/v1/api/admin/otp/decryptOTP")
                .then()
                .extract()
                .response();
        System.out.println(response.prettyPrint());
       return response.jsonPath().getString("data");
    }

}
