package org.theorangealliance.theorangealliance;

import android.content.Intent;
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
import org.theorangealliance.theorangealliance.Event.EventActivity;
import org.theorangealliance.theorangealliance.Settings.SettingsActivity;
import org.theorangealliance.theorangealliance.Team.TeamActivity;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Intent team_intent;
    private Intent event_intent;
    private Intent settings_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        team_intent = new Intent(this, TeamActivity.class);
        event_intent = new Intent(this, EventActivity.class);
        settings_intent = new Intent(this, SettingsActivity.class);

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
                this.startActivity(team_intent);
                return true;
            case R.id.menu_event_id:
                this.startActivity(event_intent);
                return true;
            case R.id.menu_settings:
                this.startActivity(settings_intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
