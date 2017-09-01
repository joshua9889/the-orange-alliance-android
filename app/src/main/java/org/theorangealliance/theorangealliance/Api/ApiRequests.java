package org.theorangealliance.theorangealliance.Api;

import android.util.Log;
import android.widget.TextView;

import org.theorangealliance.theorangealliance.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by joshua9889 on 8/31/2017.
 */

public class ApiRequests {
    String Response;
    public void pull_request(final String url, final TextView output){
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                        .url(ApiConstants.api + url)
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
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        Response = response.body().string();
                        Log.println(Log.ASSERT, "RESPONSE" , Response);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Response = "Error";
                    }
                                        output.setText(Response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

}
