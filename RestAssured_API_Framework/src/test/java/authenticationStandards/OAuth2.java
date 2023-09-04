package authenticationStandards;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth2 {

	@Test
	public void authenticationOAuth2() {

		// generate the access token
		Response resp = given()
	    .formParam("client_id", "SDET_49")
		.formParam("client_secret", "a7f0d62c6f0033243cb336de752e78cb")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")

		.when().post("http://coop.apps.symfonycasts.com/token");
		
		// get the access token
		String token = resp.jsonPath().get("access_token");
        System.out.println(token);
        
        resp.then().log().all();

        // use the token for particular api
        given()
        .auth()
        .oauth2(token)
        .pathParam("uID", 4648)
        
        .when().post("http://coop.apps.symfonycasts.com/api/{uID}/eggs-count")
        
        .then().log().all();

	}
}
