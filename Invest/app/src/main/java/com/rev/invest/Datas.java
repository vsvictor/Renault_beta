package com.rev.invest;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by victor on 19.01.17.
 */

public interface Datas {

    @POST("place/autocomplete/json?key=AIzaSyCm9WCBOg_Kg_ppJSum54T7uY5MrX66aHQ")
    Call<JsonObject> getData();
}
