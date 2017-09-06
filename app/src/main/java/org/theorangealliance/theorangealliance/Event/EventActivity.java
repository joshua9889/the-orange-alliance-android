package org.theorangealliance.theorangealliance.Event;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.theorangealliance.theorangealliance.Api.ApiRequests;
import org.theorangealliance.theorangealliance.R;

/**
 * Created by joshua9889 on 8/31/2017.
 *
 * This class is used for displaying an events information and general match data
 *
 * TODO: Figure out how matches will be layed out.
 */

public class EventActivity extends AppCompatActivity{
    public EventActivity(){}

    TextView eventName, eventDate, eventLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_main);
        Intent intent = getIntent();

        eventName = (TextView)findViewById(R.id.event_name_event);
        eventDate = (TextView)findViewById(R.id.date_event);
        eventLocation = (TextView)findViewById(R.id.event_location);

    }
}
