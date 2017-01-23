package com.rev.invest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Query().execute();
    }

    private class Query extends AsyncTask<Void, Void, Void>{
        private Response resp;
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Datas dd = App.getApi();
                Log.i(TAG, "Executing...");
                resp = dd.getData().execute();
                Log.i(TAG, "Yes!!!");
                Log.i(TAG, resp.toString());
                Log.i(TAG, "Executed!");

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
