package com.example.materiallabyrinth.app;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by andrew on 03.03.16.
 */
public class SettingsActivity extends AppCompatActivity{

    private Button _reset_levels_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        getFragmentManager().beginTransaction().replace(R.id.settings_content_frame, new SettingsFragment()).commit();

        _reset_levels_btn = (Button) findViewById(R.id.reset_levels_btn);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reset_levels_btn: {

                MapsDB mapsDB = new MapsDB(getApplicationContext()).open();
                mapsDB.reset();

                Snackbar.make(findViewById(R.id.reset_levels_btn), "уровни сброшены, мой капитан!",
                        Snackbar.LENGTH_SHORT).show();

            }break;
        }
    }
}