package com.rahulshettyacademy.api;

import com.rahulshettyacademy.models.CreateAndDeleteLocationResponseModel;
import com.rahulshettyacademy.models.CreateLocationRequestModel;

import static com.rahulshettyacademy.specs.RequestSpecs.addNewLocationRequestSpec;
import static com.rahulshettyacademy.specs.ResponseSpecs.createLocationResponseSpec200;
import static com.rahulshettyacademy.tests.TestData.scope;
import static com.rahulshettyacademy.tests.TestData.status;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleMapsAPI {
    public static CreateAndDeleteLocationResponseModel createNewLocation(CreateLocationRequestModel createLocationRequest) {
        CreateAndDeleteLocationResponseModel createLocationResponse = step("Make request", () ->
                given(addNewLocationRequestSpec)
                        .body(createLocationRequest)
                        .when()
                        .post()
                        .then()
                        .spec(createLocationResponseSpec200)
                        .extract().as(CreateAndDeleteLocationResponseModel.class));
        step("Check response 200", () -> {
            assertEquals(status, createLocationResponse.getStatus());
            assertEquals(scope, createLocationResponse.getScope());
        });
        return createLocationResponse;
    }
}
