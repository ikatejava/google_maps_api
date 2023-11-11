package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.api.GoogleMapsAPI;
import com.rahulshettyacademy.models.CreateAndDeleteLocationResponseModel;
import com.rahulshettyacademy.models.CreateLocationRequestModel;
import com.rahulshettyacademy.models.LocationDataToCreate;
import com.rahulshettyacademy.models.UpdateAndDeleteLocationRequestModel;

import static com.rahulshettyacademy.tests.TestData.*;

public class TestBase {

    CreateLocationRequestModel createLocationRequest = new CreateLocationRequestModel(
            new LocationDataToCreate(lat, lng), accuracy, name, phoneNumber, address,
            new String[]{"shoe park", "shop"}, website, language);

    CreateAndDeleteLocationResponseModel createLocationResponse =
            GoogleMapsAPI.createNewLocation(createLocationRequest);

    UpdateAndDeleteLocationRequestModel updateLocationRequest =
            new UpdateAndDeleteLocationRequestModel(createLocationResponse.getPlaceID(), newAddress, key);

    UpdateAndDeleteLocationRequestModel updateLocationRequestFailure =
            new UpdateAndDeleteLocationRequestModel(wrongPlaceId, newAddress, key);

    UpdateAndDeleteLocationRequestModel deleteLocationRequest =
            new UpdateAndDeleteLocationRequestModel(createLocationResponse.getPlaceID());

    UpdateAndDeleteLocationRequestModel deleteLocationRequestFailure =
            new UpdateAndDeleteLocationRequestModel(wrongPlaceId);
}
