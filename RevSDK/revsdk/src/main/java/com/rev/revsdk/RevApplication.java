package com.rev.revsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.rev.revsdk.config.Config;
import com.rev.revsdk.config.ConfigParamenetrs;
import com.rev.revsdk.config.ConfigsList;
import com.rev.revsdk.config.ListString;
import com.rev.revsdk.config.OperationMode;
import com.rev.revsdk.config.serialization.ConfigListDeserialize;
import com.rev.revsdk.config.serialization.ConfigListSerialize;
import com.rev.revsdk.config.serialization.ConfigParametersSerialize;
import com.rev.revsdk.config.serialization.ListStringDeserializer;
import com.rev.revsdk.config.serialization.ListStrintgSerialize;
import com.rev.revsdk.config.serialization.OperationModeDeserialize;
import com.rev.revsdk.config.serialization.OperationModeSerialize;
import com.rev.revsdk.listeners.NetListener;
import com.rev.revsdk.statistic.Phone;
import com.rev.revsdk.statistic.Statistic;
import com.rev.revsdk.statistic.serialize.PhoneSerialize;
import com.rev.revsdk.statistic.serialize.StatisticSerializer;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by victor on 05.02.17.
 */

public class RevApplication extends Application {
    private static final String TAG = RevApplication.class.getSimpleName();
    private  String sdkKey;
    private  String version;
    private  Config config;
    protected Statistic statistic;
    private boolean firstActivity;
    private GsonBuilder gsonBuilder;
    private Gson gson;
    private SharedPreferences share;

    private volatile int configRefreshInterval = 0;

    private String transportMonitorURL;

    @Override
    public void onCreate() {
        super.onCreate();
        firstActivity = true;
        share = getSharedPreferences("RevSDK", MODE_PRIVATE);

        gsonBuilder = new GsonBuilder().registerTypeAdapter(ConfigsList.class, new ConfigListDeserialize()).registerTypeAdapter(ConfigsList.class, new ConfigListSerialize())
                .registerTypeAdapter(ConfigParamenetrs.class, new ConfigListDeserialize()).registerTypeAdapter(ConfigParamenetrs.class, new ConfigParametersSerialize())
                .registerTypeAdapter(ListString.class, new ListStringDeserializer()).registerTypeAdapter(ListString.class, new ListStrintgSerialize())
                .registerTypeAdapter(OperationMode.class, new OperationModeDeserialize()).registerTypeAdapter(OperationMode.class, new OperationModeSerialize())
                .registerTypeAdapter(Phone.class, new PhoneSerialize()).registerTypeAdapter(Statistic.class, new StatisticSerializer());
        gson = gsonBuilder.create();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                if (firstActivity) {
                    RequestUserPermission permission = new RequestUserPermission(activity);
                    permission.verifyStoragePermissions(new PostPermissionGranted() {
                        @Override
                        public void onPermissionGranted() {
                            init();
                            firstActivity = false;
                        }

                        @Override
                        public void onPermissionDenied() {
                            firstActivity = true;
                            Toast.makeText(RevApplication.this, RevApplication.this.getResources().getString(R.string.permission_denied), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    private String getKeyFromManifest() {
        String result = "key";
        try {
            ApplicationInfo app = this.getPackageManager().getApplicationInfo(this.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = app.metaData;
            for (String key : bundle.keySet()) {
                if (key.equals("com.revsdk.key")) {
                    result = bundle.getString(Constants.keyTag);
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void init() {
        firstActivity = true;

        try {
            version = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException ex) {
            version = "1.0";
        }
        sdkKey = getKeyFromManifest();

        config = Config.load(gson, share);
        try{
            configRefreshInterval = config.getParam().get(0).getConfiguration_refresh_interval_sec();
        }catch (NullPointerException ex){
            configRefreshInterval = 0;
        }


    }

    private class Getter extends AsyncTask<Context, Void, Response> {
        private String result;
        private Context context;

        @Override
        protected Response doInBackground(Context... params) {
            this.context = params[0];
            OkHttpClient client = new OkHttpClient();
            Request req = new Request.Builder().url(Constants.baseURL + sdkKey).build();
            Response response = null;
            try {
                response = client.newCall(req).execute();
            } catch (IOException e) {
                response = null;
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(Response response) {
            try {
                result = response.body().string();

                gson = gsonBuilder.create();

                config = gson.fromJson(result, Config.class);
                config.save(gson, share);

                if (config != null) {
                    transportMonitorURL = config.getParam().get(0).getTransport_monitoring_url();
                    configRefreshInterval = config.getParam().get(0).getConfiguration_refresh_interval_sec();

                    statistic = new Statistic(this.context, config);
                    statistic.setSDKKey(sdkKey);
                    statistic.setVersion(version);

/*
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            //String str = gson.toJson(statistic);
                            //Log.i(TAG, str);
                        }
                    }, 1000, 1000);
*/
                }
                else{
                    //TODO No config!!!!!!!!!!!!!!!!!!!!
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
