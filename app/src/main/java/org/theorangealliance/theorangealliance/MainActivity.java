package org.theorangealliance.theorangealliance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.theorangealliance.theorangealliance.Api.ApiRequests;
import org.theorangealliance.theorangealliance.Event.EventActivity;
import org.theorangealliance.theorangealliance.Settings.SettingsActivity;
import org.theorangealliance.theorangealliance.Team.TeamActivity;

public class MainActivity extends AppCompatActivity {

    private Intent team_intent, event_intent, settings_intent;
    TextView output;

    ApiRequests api = new ApiRequests();
    boolean loop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences API_settings = this.getSharedPreferences("APIsettings", Context.MODE_PRIVATE);

        //Used for debugging
        output = (TextView) findViewById(R.id.Output);
        output.setMovementMethod(new ScrollingMovementMethod());
        output.setText(
            API_settings.getString("X_APP_NAME", null) + "\n" +
            API_settings.getString("X_TOA_KEY", null) + "\n" +
            API_settings.getString("Server", ""));

        team_intent = new Intent(this, TeamActivity.class);
        event_intent = new Intent(this, EventActivity.class);
        settings_intent = new Intent(this, SettingsActivity.class);

        String activityName = "MainActivity";
        team_intent.putExtra("last_page", activityName);
        event_intent.putExtra("last_page", activityName);
        settings_intent.putExtra("lasst_page", activityName);

        //TODO: Make this stuff a new Debugging activity
        //TODO: Make API calls set from the affectioned Debugging activity.
        final EditText apiextras = (EditText)findViewById(R.id.API_Request);

        Button pull = (Button)findViewById(R.id.call);

        pull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                api.pull_request(apiextras.getText().toString(), getApplicationContext());
            }
        });


        //Update loop
        //TODO: Make it not be bad. Scrolling lags because of this code
        (new Thread(new Runnable() {

            @Override
            public void run() {
                while (!Thread.interrupted())
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() // start actions in UI thread
                        {

                            @Override
                            public void run() {
                                update();
                            }
                        });
                    }
                    catch (InterruptedException e) {
                        // ooops
                    }
            }
        })).start(); // the while thread will start in BG thread

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
            case R.id.menu_team_id:
                loop = false;
                this.startActivity(team_intent);
                return true;

            case R.id.menu_event_id:
                loop = false;
                this.startActivity(event_intent);
                return true;

            case R.id.menu_settings:
                loop = false;
                this.startActivity(settings_intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void update(){
        output.setText(api.outputFromPull_request());
    }
}
