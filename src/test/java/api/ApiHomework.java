package api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.User;

public class ApiHomework {
	
	@Test(priority=1)
	public void assertGetEmail() {
		RestAssured.baseURI = "https://reqres.in";
		when()
			.get("/api/users?id=2")
		.then()
			.assertThat()
			.body("data.email", equalTo("janet.weaver@reqres.in"));
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority=2)
	public void assertPostToken() {
		RestAssured.baseURI = "https://reqres.in";
		JSONObject login = new JSONObject();
		login.put("email", "eve.holt@reqres.in");
		login.put("password", "cityslicka");
		String jsonString = login.toJSONString();
		given()
			.contentType("application/json")
			.body(jsonString)
		.when()
			.post("/api/login")
		.then()
			.contentType("application/json")
			.body("token", equalTo("QpwL5tke4Pnpja7X4"));
	}
	
	@Test(priority=3)
	public void assertDeleteStatusCode() {
		// Status Code 204 means No Content and is a success status response code
		RestAssured.baseURI = "https://reqres.in";
		given()
		.when()
			.delete("/api/users/2")
		.then()
			.assertThat()
			.statusCode(204);
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority=4)
	public void assertPatchTimestamp() {
		RestAssured.baseURI = "https://reqres.in";
		JSONObject patch = new JSONObject();
		patch.put("name", "Morpheus2");
		String updatedAt =
			given()
				.contentType("application/json")
				.body(patch.toJSONString())
			.when()
				.patch("/api/users/2")
			.then()
				.contentType("application/json")
				.body("name", equalTo("Morpheus2"))
			.extract()
				.path("updatedAt")
				.toString();
		System.out.println(updatedAt);
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority=5)
	public void assertPutTimestamp() {
		RestAssured.baseURI = "https://reqres.in";
		JSONObject json = new JSONObject();
		json.put("name", "Morpheus2");
		String updatedAt =
			given()
				.contentType("application/json")
				.body(json.toJSONString())
			.when()
				.put("/api/users/2")
			.then()
				.contentType("application/json")
				.body("name", equalTo("Morpheus2"))
			.extract()
				.path("updatedAt")
				.toString();
		System.out.println(updatedAt);
	}
	
	@Test(priority=6)
	public void deserializeGetSingleUser() {
		RestAssured.baseURI = "https://reqres.in";
		JsonPath json =
			given()
			.when()
				.get("/api/users/2")
			.then()
				.contentType("application/json")
			.extract()
				.jsonPath();
		
		String id = json.getString("data.id").toString();
		String email = json.getString("data.email").toString();
		String first_name = json.getString("data.first_name").toString();
		String last_name = json.getString("data.last_name").toString();
		String avatar = json.getString("data.avatar").toString();
		User user = new User(id, email, first_name, last_name, avatar);
		user.printUser();
	}
	
	// Could not figure this one out
	@Test(priority=7)
	public void deserializeGetListUsers() {
		RestAssured.baseURI = "https://reqres.in";
	}

}
