package com.example.materiallabyrinth.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MenuActivity extends AppCompatActivity{

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        Button start_btn = (Button) findViewById(R.id.start_btn);
        Button select_lvl_brn = (Button) findViewById(R.id.select_lvl_btn);
        Button settings_btn = (Button) findViewById(R.id.settings_btn);
        Button exit_btn = (Button) findViewById(R.id.exit_btn);

        //mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

//        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(findViewById(R.id.coordinator), "I'm a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(MenuActivity.this, "Snackbar Action", Toast.LENGTH_LONG).show();
//                    }
//                }).show();
//            }
//        });
    }

    public void OnClick(View v) {
        switch(v.getId()) {
            case R.id.start_btn: {
                Intent intent = new Intent(MenuActivity.this, GameActivity.class);
                startActivity(intent);
            } break;

            case R.id.select_lvl_btn: {
                Intent intent = new Intent(MenuActivity.this, SelectLevelActivity.class);
                startActivity(intent);
            } break;

            case R.id.settings_btn: {
                Intent intent = new Intent(MenuActivity.this, SettingsActivity.class);
                startActivity(intent);
            }break;

            case R.id.exit_btn: {
                finish();
            } break;

            default: {
                Snackbar.make(findViewById(R.id.coordinator), "click-click", Snackbar.LENGTH_LONG).show();
            } break;
        }
    }
}