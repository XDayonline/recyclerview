package com.ynov.myapplication.network;

import com.ynov.myapplication.model.City;
import com.ynov.myapplication.model.ForecastList;
import com.ynov.myapplication.model.ForecastResult;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


public interface ErpInterventionApiService {

//    // region GETTER ALL
//    @GET("/forecast/City/list")
//    Call<ForecastList> city();
//    // endregion GETTER ALL

    // region GET BY ID
    @GET("/data/2.5/forecast?cnt=30&units=metric")
    Call<ForecastResult> getForeCastById(
            @Query("id") String cityId,
            @Query("APPID") String ApiKey
    );
    // endregion GET BY ID
}
