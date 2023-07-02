import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@RunWith(Cucumber.class)
public class StepDefinitions {
    //-----------------------------------------------------Scenario-1-----------------------------------------------------
    @Given("Make a GET request")
    public void make_a_get_request() {
        // No action needed as it is just a description step
    }

    @When("GET request to the API endpoint")
    public void get_request_to_the_api_endpoint() {
        // No action needed as it is just a description step
    }

    @Then("the HTTP status code of the response should be {int}")
    public void the_http_status_code_of_the_response_should_be(Integer int1) {
        given()
                .when()
                .get("https://testapi.io/api/ottplatform/media")
                .then()
                .statusCode(int1);

    }

    @Then("the response time should be below {int} milliseconds")
    public void the_response_time_should_be_below_milliseconds(Integer int2) {
        given()
                .when()
                .get("https://testapi.io/api/ottplatform/media")
                .then()
                .time(lessThan(int2.longValue()));

    }
//-----------------------------------------------------Scenario-2--------------------------------------------------

    @Then("Verify if the “id” field is never null or empty")
    public void verify_if_the_id_field_is_never_null_or_empty() {
        given()
                .when()
                .get("https://testapi.io/api/ottplatform/media")
                .then()
                .body("data.id", everyItem(notNullValue()))
                .body("data.id", everyItem(not(emptyString())));


    }

    @Then("Verify that the “segment_type” field for every track is always “music”")
    public void verify_that_the_segment_type_field_for_every_track_is_always_music() {
        given()
                .when()
                .get("https://testapi.io/api/ottplatform/media")
                .then()
                .body("data.id", everyItem(notNullValue()))
                .body("data.id", everyItem(not(emptyString())))
                .body("data.segment_type", everyItem(equalTo("music")));

    }

    //-----------------------------------------------------Scenario-3--------------------------------------------------
    @Then("Verify that the “primary” field in “title_list” is never null or empty")
    public void verify_that_the_primary_field_in_title_list_is_never_null_or_empty() {
        given()
                .when()
                .get("https://testapi.io/api/ottplatform/media")
                .then()
                .body("data.title_list.primary", everyItem(notNullValue()));


    }


    //-----------------------------------------------------Scenario-4--------------------------------------------------
    @Then("Verify that only one track in the list")
    public void verify_that_only_one_track_in_the_list() {
        given()
                .when()
                .get("https://testapi.io/api/ottplatform/media")
                .then()
                .body("data.track.findAll { it.offset.now_playing == true }.size()", equalTo(null));

    }


    //-----------------------------------------------------Scenario-5--------------------------------------------------
    @Then("In the response headers, verify the “Date” value")
    public void in_the_response_headers_verify_the_date_value() {
        given()
                .when()
                .get("https://testapi.io/api/ottplatform/media")
                .then()
                .header("Date", notNullValue());

    }


}
