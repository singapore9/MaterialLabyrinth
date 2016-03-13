package com.example.materiallabyrinth.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        Button start_btn = (Button) findViewById(R.id.start_btn);
        Button select_lvl_brn = (Button) findViewById(R.id.select_lvl_btn);
        Button settings_btn = (Button) findViewById(R.id.settings_btn);
        Button about_btn = (Button) findViewById(R.id.about_btn);
        about_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog dialog = new AlertDialog.Builder(MenuActivity.this)
                        .setCancelable(true)
                        .setTitle(R.string.about_btn_label)
                        .setPositiveButton("Ой всё.", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which_button) {
                                dialog.cancel();
                        /*send_empty_message(Messages.MSG_MAP_NEXT);*/
                            }
                        })
                        .create();

                dialog.setMessage("Игра логическая. Лабиринт.\n" +
                        "Copyright © 2016, Андрей\n\n"+
                        "Цель игры: научить ребёнка двигать пальцами, ну или смартфоном.\n" +
                        "Ну или тебя, если нету ребёнка.\n" +
                        "Простая и увлекательная игра.\n\n" +
                        "Пальцем проводишь в нужном направлении (горизонталь/вертикаль) и " +
                        "мяч летит туда до первой стенки. Собираешь все ящики или находишь баг - " +
                        "проходишь на следующий уровень.\n" +
                        "Подписывайтесь на канал, ставьте лайки."
                        );

                dialog.show();
            }

        });
        Button exit_btn = (Button) findViewById(R.id.exit_btn);



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
                Toast.makeText(this, "click-click", Toast.LENGTH_LONG).show();
            } break;
        }
    }
}