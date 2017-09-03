package org.theorangealliance.theorangealliance.Settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import org.theorangealliance.theorangealliance.MainActivity;
import org.theorangealliance.theorangealliance.R;

/**
 * Created by joshua9889 on 8/31/2017.
 *
 * What's happening here?
 * X_APP and X_Key are the given by the TOA
 *
 * Radio Buttons modify which server to use. Default is Regular.
 */

public class SettingsActivity extends AppCompatActivity {
    public SettingsActivity(){}

    private EditText X_App, X_Key;
    private RadioButton Dev, Beta, Regular;
    private SharedPreferences API_settings;
    private Intent main_intent;
    private AppCompatActivity activity = this;
    private String server = "Regular";

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.settings_main);

        API_settings = this.getSharedPreferences("APIsettings" , Context.MODE_PRIVATE);

        X_App = (EditText)findViewById(R.id.X_App);
        X_Key = (EditText)findViewById(R.id.X_TOA_Key);
        Dev = (RadioButton)findViewById(R.id.useDev);
        Beta = (RadioButton)findViewById(R.id.useBeta);
        Regular = (RadioButton)findViewById(R.id.useRegular);
        Button saveChanges = (Button) findViewById(R.id.Save_Button);

        //Saved Values
        X_App.setText(API_settings.getString("X_APP_NAME", "PyScout"));
        X_Key.setText(API_settings.getString("X_TOA_KEY", "dL5DVJ5oOPth7vtDJmZ1J3MetkNjcZ1PIyN0fgCxiiyx2kh7pEz13A=="));

        switch (API_settings.getString("Server", "")){
            case "Dev":
                Dev.setChecked(true);
                return;
            case "Beta":
                Beta.setChecked(true);
                return;
            case "Regular":
                Regular.setChecked(true);
                return;
        }

        //Used when the Button "Save" is pressed
        main_intent = new Intent(this, MainActivity.class);

        Dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Beta.setChecked(false);
                Regular.setChecked(false);
                server = "Dev";
            }
        });

        Beta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dev.setChecked(false);
                Regular.setChecked(false);
                server = "Beta";
            }
        });

        Regular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dev.setChecked(false);
                Beta.setChecked(false);
                server = "Regular";
            }
        });

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = API_settings.edit();
                editor.putString("X_APP_NAME", X_App.getText().toString());
                editor.putString("X_TOA_KEY", X_Key.getText().toString());
                editor.putString("Server", server);
                editor.apply();
                activity.startActivity(main_intent);
            }
        });
    }
}
