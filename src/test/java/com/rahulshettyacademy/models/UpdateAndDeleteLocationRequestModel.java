package com.rahulshettyacademy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize
public class UpdateAndDeleteLocationRequestModel {
    @JsonProperty("place_id")
    String placeId;
    String address;
    String key;

    public UpdateAndDeleteLocationRequestModel(String placeId, String address, String key) {
        this.placeId = placeId;
        this.address = address;
        this.key = key;
    }

    public UpdateAndDeleteLocationRequestModel(String placeId) {
        this.placeId = placeId;
    }
}
