package org.theorangealliance.theorangealliance.Event;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.theorangealliance.theorangealliance.R;

/**
 * Created by joshua9889 on 8/31/2017.
 */

public class EventActivity extends AppCompatActivity{
    public EventActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_main);
        Intent intent = getIntent();

    }
}
