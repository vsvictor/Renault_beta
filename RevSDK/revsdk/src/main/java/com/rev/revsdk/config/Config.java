package com.rev.revsdk.config;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.rev.revsdk.config.serialization.ConfigListDeserialize;
import com.rev.revsdk.config.serialization.ConfigListSerialize;
import com.rev.revsdk.config.serialization.ConfigParametersSerialize;
import com.rev.revsdk.config.serialization.ListStringDeserializer;
import com.rev.revsdk.config.serialization.ListStrintgSerialize;
import com.rev.revsdk.config.serialization.OperationModeDeserialize;
import com.rev.revsdk.config.serialization.OperationModeSerialize;
import com.rev.revsdk.statistic.Phone;
import com.rev.revsdk.statistic.Statistic;
import com.rev.revsdk.statistic.serialize.PhoneSerialize;
import com.rev.revsdk.statistic.serialize.StatisticSerializer;

/**
 * Created by victor on 03.02.17.
 */
public class Config {
    @SerializedName("app_name")
    private String app_name;
    @SerializedName("os")
    private String os;
    @SerializedName("configs")
    private ConfigsList configs;


    public ConfigsList getParam(){return  configs;}

    public String getAppName() {
        return app_name;
    }

    public void save(Gson gson, SharedPreferences share) {
        String s = gson.toJson(this);
        SharedPreferences.Editor editor = share.edit();
        editor.putString("config", s);
        editor.commit();
    }
    public static Config load(Gson gson, SharedPreferences share){
        String s = share.getString("config", "");
        if(s != null && !s.isEmpty()){
            return gson.fromJson(s, Config.class);
        }
        else return  null;
    }
}
