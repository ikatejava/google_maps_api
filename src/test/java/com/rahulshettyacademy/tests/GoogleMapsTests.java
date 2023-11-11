package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.api.GoogleMapsAPI;
import com.rahulshettyacademy.models.CreateAndDeleteLocationResponseModel;
import com.rahulshettyacademy.models.GetLocationResponseModel;
import com.rahulshettyacademy.models.ResponseWithMessageModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.rahulshettyacademy.specs.RequestSpecs.*;
import static com.rahulshettyacademy.specs.ResponseSpecs.*;
import static com.rahulshettyacademy.tests.TestData.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleMapsTests extends TestBase {
    @Test
    @Tag("post")
    @Tag("positive")
    void createNewLocationSuccessTest() {
        GoogleMapsAPI.createNewLocation(createLocationRequest);
    }

    @Test
    @Tag("get")
    @Tag("positive")
    void checkLocationDataSuccessTest() {
        GetLocationResponseModel getLocationResponse = step("Make request", () ->
                given(getLocationRequestSpec)
                        .queryParam("place_id", createLocationResponse.getPlaceID())
                        .when()
                        .get()
                        .then()
                        .spec(getLocationResponseSpec200)
                        .extract().as(GetLocationResponseModel.class));
        step("Check response 200", () -> {
            assertEquals(latitude, getLocationResponse.getLocation().getLatitude());
            assertEquals(longitude, getLocationResponse.getLocation().getLongitude());
            assertEquals(accuracyString, getLocationResponse.getAccuracy());
            assertEquals(phoneNumber, getLocationResponse.getPhoneNumber());
            assertEquals(address, getLocationResponse.getAddress());
            assertEquals(types, getLocationResponse.getTypes());
            assertEquals(website, getLocationResponse.getWebsite());
            assertEquals(language, getLocationResponse.getLanguage());
        });
    }

    @Test
    @Tag("get")
    @Tag("negative")
    void checkLocationDataFailureTest() {
        ResponseWithMessageModel responseWithMessage = step("Make request", () ->
                given(getLocationRequestSpec)
                        .queryParam("place_id", wrongPlaceId)
                        .when()
                        .get()
                        .then()
                        .spec(errorResponseSpec404)
                        .extract().as(ResponseWithMessageModel.class));
        step("Check response 404", () -> {
            assertEquals(msg404Get, responseWithMessage.getMsg());
        });
    }

    @Test
    @Tag("put")
    @Tag("positive")
    void updateLocationSuccessTest() {
        ResponseWithMessageModel responseWithMessage = step("Make request", () ->
                given(updateLocationRequestSpec)
                        .body(updateLocationRequest)
                        .when()
                        .put()
                        .then()
                        .spec(updateLocationResponseSpec200)
                        .extract().as(ResponseWithMessageModel.class));
        step("Check response 200", () -> {
            assertEquals(msg200, responseWithMessage.getMsg());
        });
    }

    @Test
    @Tag("put")
    @Tag("negative")
    void updateLocationFailureTest() {
        ResponseWithMessageModel responseWithMessage = step("Make request", () ->
                given(updateLocationRequestSpec)
                        .body(updateLocationRequestFailure)
                        .when()
                        .put()
                        .then()
                        .spec(errorResponseSpec404)
                        .extract().as(ResponseWithMessageModel.class));
        step("Check response 404", () -> {
            assertEquals(msg404Put, responseWithMessage.getMsg());
        });
    }

    @Test
    @Tag("delete")
    @Tag("positive")
    void deleteLocationSuccessTest() {
        CreateAndDeleteLocationResponseModel deleteLocationResponse = step("Make request", () ->
                given(deleteLocationRequestSpec)
                        .body(deleteLocationRequest)
                        .when()
                        .delete()
                        .then()
                        .spec(deleteLocationResponseSpec200)
                        .extract().as(CreateAndDeleteLocationResponseModel.class));
        step("Check response 200", () -> {
            assertEquals(status, deleteLocationResponse.getStatus());
        });
    }

    @Test
    @Tag("delete")
    @Tag("negative")
    void deleteLocationFailureTest() {
        ResponseWithMessageModel responseWithMessageModel = step("Make request", () ->
                given(deleteLocationRequestSpec)
                        .body(deleteLocationRequestFailure)
                        .when()
                        .delete()
                        .then()
                        .spec(errorResponseSpec404)
                        .extract().as(ResponseWithMessageModel.class));
        step("Check response 404", () -> {
            assertEquals(msg404Delete, responseWithMessageModel.getMsg());
        });
    }
}
