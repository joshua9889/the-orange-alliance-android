package org.theorangealliance.theorangealliance;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.theorangealliance.theorangealliance.Api.ApiConstants;
import org.theorangealliance.theorangealliance.Api.ApiRequests;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TEAM_ACTIVITY = "org.theorangealliance.theorangealliance.Team.TEAMACTIVITY";
    public TextView output;

    ApiRequests api = new ApiRequests();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        output  = (TextView)findViewById(R.id.Output);

        final EditText apiRequestCode = (EditText) findViewById(R.id.API_Request);
        apiRequestCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiRequestCode.setText("");
            }
        });

        FloatingActionButton star = (FloatingActionButton) findViewById(R.id.str_button);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Starred", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
            }
        });

        final Button call = (Button) findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String api_extras = apiRequestCode.getText().toString();
                api.pull_request(api_extras, output);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        switch (item.getItemId()) {
            case R.id.team_search_button:
                if(output.getText() != "Hello"){
                    output.setText("Hello");
                }else {
                    output.setText("Hello World!");
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
