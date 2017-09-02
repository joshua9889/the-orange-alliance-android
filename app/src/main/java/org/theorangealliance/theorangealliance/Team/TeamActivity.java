package org.theorangealliance.theorangealliance.Team;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.theorangealliance.theorangealliance.R;

/**
 * Created by joshua9889 on 8/31/2017.
 */

public class TeamActivity extends AppCompatActivity {
    public TeamActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_main);
        Intent intent = getIntent();

    }
}
