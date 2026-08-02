package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare url valid for {string}")
    public void prepareUrlValidFor(String url) {
        apiPage.prepareUrlValidFor(url);
    }

    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiPostCreateNewUser();
    }

    @Then("validation response body create user")
    public void validationResponseBodyCreateUser() {
        apiPage.validationResponseBodyCreateUser();
    }

    @Then("validation status code equals {int}")
    public void validationStatusCodeEquals(int status_code) {
        apiPage.validationStatusCodeEquals(status_code);

        System.out.println(status_code);
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationResponseJsonWithJSONSchema(filename);
    }

    @And("hit api get list user by id")
    public void hitApiGetListUserById() {
        apiPage.hitApiGetListUserById();
    }

    @Then("validation response body get list user by id")
    public void validationResponseBodyGetListUserById() {
        apiPage.validationResponseBodyGetListUserById();
    }

    @And("hit api delete user")
    public void hitApiDeleteUser() {
        apiPage.hitApiDeleteUser();
    }

    @And("hit api update user")
    public void hitApiUpdateUser() {
        apiPage.hitApiUpdateUser();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();
    }

    @And("hit api get list tags")
    public void hitApiGetListTags() {
        apiPage.hitApiGetListTags();
    }

    @Then("validation response body get list tags")
    public void validationResponseBodyGetListTags() {
        apiPage.validationResponseBodyGetListTags();
    }
}
