package apiTests;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoanApiTests {


public static void main(String[] args) {
    String username = "coding.challenge.login@upgrade.com";
    String password = "On$3XcgsW#9q";
    String recaptchaToken = "coding_challenge";
    String baseUrl = "https://credapi.credify.tech/api/brportorch/v2/login";

    RestAssured.baseURI = baseUrl;
    RequestSpecification request = RestAssured.given();

    //Validate that for correct credentials provided in the payload below, the API response code is a 200 (OK)

    request.header("x-cf-source-id", "coding-challenge");
    request.header("x-cf-corr-id", "8f6aab06-8dd9-4a88-a149-463780eb41db");
    request.header("Content-Type", "application/json");

    Response response = request.body("{ \"username\":\"" + username + "\", \"password\":\"" + password + "\", \"recaptchaToken\":\"" + recaptchaToken+ "\"}")
            .post(baseUrl);
    
    Assert.assertEquals(response.getStatusCode(), 200);
    
    //Validate the productType attribute has value PERSONAL_LOAN
    
    List<Map<String, String>> loantype = response.jsonPath().getList("loansInReview");
    String loanType = loantype.get(0).get("productType");
    Assert.assertEquals(loanType, "PERSONAL_LOAN");

    // Validate incorrect credential such as using wrong username in the payload, response code 401 returned
    
    String username1 = "wrong.username@upgrade.com";
    Response response1 = request.body("{ \"username\":\"" + username1 + "\", \"password\":\"" + password + "\", \"recaptchaToken\":\"" + recaptchaToken+ "\"}")
            .post(baseUrl);
    Assert.assertEquals(response1.getStatusCode(), 401);
    System.out.println("API Tests completed succesfully. No error encountered.");
    
	}
}
