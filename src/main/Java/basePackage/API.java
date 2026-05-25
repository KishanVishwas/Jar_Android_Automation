package basePackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import utilsPackage.configReader;

import static io.restassured.RestAssured.given;

@Slf4j
public class API {

    public static String decryptOtp(String number) {
        RestAssured.baseURI = configReader.get("apiBaseUrl");

        Response response = given()
                .header("Authorization", configReader.get("apiAuthToken"))
                .queryParam("phoneNumber", number)
                .when()
                .get("/v1/api/otp/decryptOTP");

        int statusCode = response.getStatusCode();
        if (statusCode != 200) {
            throw new RuntimeException("OTP decrypt failed — HTTP " + statusCode + ": " + response.getBody().asString());
        }

        String otp = response.jsonPath().getString("data");
        log.info("OTP decrypted successfully for number ending in {}", number.substring(number.length() - 4));
        return otp;
    }
}