package org.theorangealliance.theorangealliance.Settings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.theorangealliance.theorangealliance.R;

/**
 * Created by joshua9889 on 8/31/2017.
 */

public class SettingsActivity extends AppCompatActivity {
    public SettingsActivity(){}

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.settings_main);

    }
}
