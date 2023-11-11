package com.rahulshettyacademy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize
public class CreateAndDeleteLocationResponseModel {
    String status;
    @JsonProperty("place_id")
    String placeID;
    String scope;
    String reference;
    String id;
}
