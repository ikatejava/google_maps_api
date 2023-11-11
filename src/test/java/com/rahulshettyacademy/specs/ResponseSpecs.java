package com.rahulshettyacademy.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;

public class ResponseSpecs {
    public static ResponseSpecification createLocationResponseSpec200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("status", notNullValue())
            .expectBody("place_id", notNullValue())
            .expectBody("scope", notNullValue())
            .expectBody("reference", notNullValue())
            .expectBody("reference", notNullValue())
            .expectBody("id", notNullValue())
            .build();

    public static ResponseSpecification getLocationResponseSpec200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/get_place_data.json"))
            .expectBody("location", notNullValue())
            .expectBody("accuracy", notNullValue())
            .expectBody("name", notNullValue())
            .expectBody("phone_number", notNullValue())
            .expectBody("address", notNullValue())
            .expectBody("types", notNullValue())
            .expectBody("website", notNullValue())
            .expectBody("language", notNullValue())
            .build();

    public static ResponseSpecification updateLocationResponseSpec200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("msg", notNullValue())
            .build();

    public static ResponseSpecification deleteLocationResponseSpec200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("status", notNullValue())
            .build();

    public static ResponseSpecification errorResponseSpec404 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(404)
            .expectBody("msg", notNullValue())
            .build();
}
