package org.theorangealliance.theorangealliance.Events;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.theorangealliance.theorangealliance.R;

/**
 * Created by joshua9889 on 9/15/2017.
 */

public class EventListActivity extends AppCompatActivity {

    public EventListActivity(){}

    private ListView matchlist_ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_list_main);

        matchlist_ListView = (ListView)findViewById(R.id.matchList);
    }

}
