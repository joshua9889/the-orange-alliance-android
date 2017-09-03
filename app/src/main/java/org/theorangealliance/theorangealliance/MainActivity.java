package org.theorangealliance.theorangealliance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.theorangealliance.theorangealliance.Event.EventActivity;
import org.theorangealliance.theorangealliance.Settings.SettingsActivity;
import org.theorangealliance.theorangealliance.Team.TeamActivity;

public class MainActivity extends AppCompatActivity {

    private Intent team_intent;
    private Intent event_intent;
    private Intent settings_intent;
    private TextView output;
    private SharedPreferences API_settings;
    private String activityName = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        output = (TextView)findViewById(R.id.Output);
        API_settings = this.getSharedPreferences("APIsettings" , Context.MODE_PRIVATE);
        output.setText(
            API_settings.getString("X_APP_NAME", null) + "\n" +
            API_settings.getString("X_TOA_KEY", null) + "\n" +
            API_settings.getString("Server", ""));

        team_intent = new Intent(this, TeamActivity.class);
        event_intent = new Intent(this, EventActivity.class);
        settings_intent = new Intent(this, SettingsActivity.class);
        team_intent.putExtra("last_page", this.activityName);
        event_intent.putExtra("last_page", this.activityName);
        settings_intent.putExtra("lasst_page", this.activityName);
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
