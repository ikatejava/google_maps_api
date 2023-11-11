package com.rahulshettyacademy.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import static com.rahulshettyacademy.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.http.ContentType.JSON;

public class RequestSpecs {
    private static RequestSpecification getBaseReqSpec() {
        return new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setContentType(JSON)
                .setBaseUri("https://rahulshettyacademy.com")
                .build()
                .filter(withCustomTemplates());
    }

    public static RequestSpecification addNewLocationRequestSpec = getBaseReqSpec().
            basePath("/maps/api/place/add/json").queryParam("key", "qaclick123");

    public static RequestSpecification getLocationRequestSpec = getBaseReqSpec().
            basePath("/maps/api/place/get/json").queryParam("key", "qaclick123");

    public static RequestSpecification updateLocationRequestSpec = getBaseReqSpec().
            basePath("/maps/api/place/update/json").queryParam("key", "qaclick123");

    public static RequestSpecification deleteLocationRequestSpec = getBaseReqSpec().
            basePath("/maps/api/place/delete/json").queryParam("key", "qaclick123");
}
