package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "Application/json")
                .header("Accept", "Application/Json")
                .header("app-id", "63a804408eb0cb069b57e43a");
    }

    public static Response postCreateUser(String endpoint) {
        String firstName = "Budi";
        String lastName = "Santoso";
        String gender = "male";
        String email = generateRandomEmail();
        String dateOfBirth = "1995-01-01";
        String phone = "08123456789";
        String picture = "https://randomuser.me/api/portraits/men/1.jpg";

        String street = "Jakarta";
        String city = "Jakarta";
        String state = "Jakarta";
        String country = "Indonesia";
        String timezone = "-11:00";

        JSONObject payload = new JSONObject();
        payload.put("title", "mr");
        payload.put("firstName", "Budi");
        payload.put("lastName", "Santoso");
        payload.put("gender", "male");
        payload.put("email", email);
        payload.put("dateOfBirth", "1995-01-01");
        payload.put("phone", "08123456789");
        payload.put("picture", "https://randomuser.me/api/portraits/men/1.jpg");

        JSONObject location = new JSONObject();
        location.put("street", "Jakarta");
        location.put("city", "Jakarta");
        location.put("state", "Jakarta");
        location.put("country", "Indonesia");
        location.put("timezone", "-11:00");

        payload.put("location", location);

        setupHeaders();

        return request.body(payload.toString())
                .when()
                .post(endpoint);
    }
    public static Response getListUserByID(String endpoint, String id) {
        setupHeaders();

        String finalEndpoint = endpoint + "/" + id;
        System.out.println("Final URL = " + finalEndpoint);

        return request.when().get(finalEndpoint);
    }

    public static Response updateUser(String endpoint, String id) {
        String firstName = "Budi Update";
       /* String lastName = "Santoso";
        String gender = "male";
        String email = generateRandomEmail();
        String dateOfBirth = "1995-01-01";
        String phone = "08123456789";
        String picture = "https://randomuser.me/api/portraits/men/1.jpg";

        String street = "Jakarta";
        String city = "Jakarta";
        String state = "Jakarta";
        String country = "Indonesia";
        String timezone = "-11:00";*/


        JSONObject payload = new JSONObject();
        //payload.put("title", "mr");
        payload.put("firstName", "Budi Update");
       /* payload.put("lastName", "Santoso");
        payload.put("gender", "male");
        payload.put("email", email);
        payload.put("dateOfBirth", "1995-01-01");
        payload.put("phone", "08123456789");
        payload.put("picture", "https://randomuser.me/api/portraits/men/1.jpg");

        JSONObject location = new JSONObject();
        location.put("street", "Jakarta");
        location.put("city", "Jakarta");
        location.put("state", "Jakarta");
        location.put("country", "Indonesia");
        location.put("timezone", "-11:00");

        payload.put("location", location);*/

        setupHeaders();

        String finalEndpoint = endpoint + "/" + id;
        System.out.println("Final URL = " + finalEndpoint);

        /*return request.body(payload.toString())
                .when()
                .put(finalEndpoint);*/

        Response response = request.body(payload.toString())
                .when()
                .put(finalEndpoint);

        System.out.println("Status Code = " + response.statusCode());
        response.prettyPrint();

        return response;
    }

    public static Response deleteUser(String endpoint, String id) {
        setupHeaders();

        String finalEndpoint = endpoint + "/" + id;
        System.out.println("Final URL = " + finalEndpoint);

        return request.when().delete(finalEndpoint);
    }

    public static Response getListTags(String endpoint) {
        setupHeaders();

        System.out.println("Endpoint = " + endpoint);

        return request
                .when()
                .get(endpoint);
    }
}
