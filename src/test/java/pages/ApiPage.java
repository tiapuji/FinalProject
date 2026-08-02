package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import helper.ScenarioContext;

import java.io.File;
import java.security.PublicKey;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    String setURL;
    Response res;

    public void prepareUrlValidFor(String url) {
        switch (url) {

            case "CREATE_NEW_USER":
                setURL = Endpoint.CREATE_NEW_USER;
                break;

            case "GET_LIST_USER_BY_ID":
                setURL = Endpoint.GET_LIST_USER_BY_ID;
                break;

            case "UPDATE_USER":
                setURL = Endpoint.UPDATE_USER;
                break;

            case "DELETE_USER":
                setURL = Endpoint.DELETE_USER;
                break;

            case "GET_LIST_TAGS":
                setURL = Endpoint.GET_LIST_TAGS;
                break;

            default:
                System.out.println("input right url");
        }
        System.out.println("endpoint = " + setURL);

    }

    public void hitApiPostCreateNewUser () {
        res = postCreateUser(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationResponseBodyCreateUser () {
        JsonPath jsonPathEvaluator = res.jsonPath();

        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        //  String gender = jsonPathEvaluator.get("gender");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        // assertThat(gender).isIn("female", "male");

        ScenarioContext.setUserId(id);

        System.out.println("Saved ID : " + id);
        System.out.println(res.asPrettyString());
    }

    public void validationStatusCodeEquals (int status_code) {
        //assertThat(res.status_Code()).isEqualTo(status_code);
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseJsonWithJSONSchema(String filename) {

        File jsonFile = Utility.getJSONShemaFile(filename);

        System.out.println("===== VALIDATE SCHEMA =====");
        System.out.println("Status Code : " + res.statusCode());
        System.out.println("Response :");
        res.prettyPrint();

        res.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    public void hitApiGetListUserById () {

        String id = ScenarioContext.getUserId();

        System.out.println("=== HIT GET USER BY ID ===");
        System.out.println("User ID = " + id);

        res = getListUserByID(setURL, id);
    }

    public void validationResponseBodyGetListUserById () {

        System.out.println("===== RESPONSE =====");
        res.prettyPrint();

        String id = res.jsonPath().getString("id");
        String firstName = res.jsonPath().getString("firstName");
        String lastName = res.jsonPath().getString("lastName");
        String email = res.jsonPath().getString("email");
        String registerDate = res.jsonPath().getString("registerDate");
        String updatedDate = res.jsonPath().getString("updatedDate");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(registerDate).isNotNull();
        assertThat(updatedDate).isNotNull();

    }

    public void hitApiUpdateUser () {

        String id = ScenarioContext.getUserId();

        System.out.println("=== HIT UPDATE USER ===");
        System.out.println("User ID = " + id);

        res = updateUser(setURL, id);
    }

    public void validationResponseBodyUpdateUser () {

        System.out.println("===== RESPONSE =====");
        res.prettyPrint();

        String id = res.jsonPath().getString("id");
        String firstName = res.jsonPath().getString("firstName");
        String lastName = res.jsonPath().getString("lastName");
        String email = res.jsonPath().getString("email");
        String registerDate = res.jsonPath().getString("registerDate");
        String updatedDate = res.jsonPath().getString("updatedDate");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(registerDate).isNotNull();
        assertThat(updatedDate).isNotNull();
    }

   public void hitApiDeleteUser() {
       String id = ScenarioContext.getUserId();

       System.out.println("=== HIT DELETE USER ===");
       System.out.println("User ID = " + id);

       res = deleteUser(setURL, id);
    }

    public void hitApiGetListTags () {
        System.out.println("=== HIT GET LIST TAGS ===");
        res = getListTags(setURL);
    }

    public void validationResponseBodyGetListTags () {
        System.out.println("===== RESPONSE =====");
        res.prettyPrint();

        List<Object> tags = res.jsonPath().getList("data");
        assertThat(tags).isNotEmpty();
    }
}