package com.rahulshettyacademy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize
public class GetLocationResponseModel {
    LocationDataToCheck location;
    String accuracy;
    String name;
    @JsonProperty("phone_number")
    String phoneNumber;
    String address;
    String types;
    String website;
    String language;
}
