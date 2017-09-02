package org.theorangealliance.theorangealliance.Api;

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
    public void pull_request(final String extras){
        isFinished = false;
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                        .url(ApiConstants.betaUrl + extras)
                        .header("X-Application-Origin", "PyScout")
                        .header("X-TOA-Key", "dL5DVJ5oOPth7vtDJmZ1J3MetkNjcZ1PIyN0fgCxiiyx2kh7pEz13A==")
                        .build();

                    Response response = null;
                    try {
                        response = client.newCall(request).execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
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
        String out = Response;
        Response = "";
        return out;
    }

}
