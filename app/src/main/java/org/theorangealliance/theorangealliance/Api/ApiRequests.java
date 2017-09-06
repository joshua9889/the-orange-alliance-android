package org.theorangealliance.theorangealliance.Api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by joshua9889 on 8/31/2017.
 */

public class ApiRequests {

    private String Response;
    private boolean isFinished;

    public void pull_request(final String extras, Context context){
        isFinished = false;
        final SharedPreferences API_settings = context.getSharedPreferences("APIsettings", Context.MODE_PRIVATE);

        final String Url;

        Url = ApiConstants.betaUrl;

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                        .url(Url + extras)
                        .header("X-Application-Origin", API_settings.getString("X_APP_NAME", ""))
                        .header("X-TOA-Key", API_settings.getString("X_TOA_KEY", ""))
                        .build();

                    Response response = null;

                    try {
                        response = client.newCall(request).execute();
                        Response = response.body().string();
                        Log.println(Log.ASSERT, "RESPONSE" , Response);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Response = "Error";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                isFinished = true;
            }
        });

        thread.start();
    }

    public String outputFromPull_request(){
        return Response;
    }

}
