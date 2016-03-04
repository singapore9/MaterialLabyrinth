package com.example.materiallabyrinth.app;

/**
 * Created by andrew on 03.03.16.
 */

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    //protected PowerManager.WakeLock _wakeLock;
    private MapView _map_view;

    private static final int REQUEST_SELECT_MAZE = 1;

    private TextView _map_name_label;
    private TextView _remaining_goals_label;
    private TextView _steps_label;

    private FloatingActionButton _reset_fab;

    private Animation rotate_fab;

    private GestureDetector _gesture_destructor;
    private GameEngine _game_engine;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_layout);


        _game_engine = new GameEngine(GameActivity.this);

        try {
            int index = getIntent().getExtras().getInt("selected_index");
            _game_engine.set_current_map(index);
            _game_engine.send_empty_message(Messages.MSG_RESTART);
        } catch (Exception e) {}


        _reset_fab = (FloatingActionButton) findViewById(R.id.reset_fab);

        rotate_fab = AnimationUtils.loadAnimation(this, R.anim.rotate_center);

        _map_view = (MapView) findViewById(R.id.maze_view);
        _game_engine.set_maps_view(_map_view);
        _map_view.set_game_engine(_game_engine);
        _map_view.calculateUint();

        _map_name_label = (TextView) findViewById(R.id.maze_name);
        _game_engine.set_map_name_label(_map_name_label);
        _map_name_label.setText(_game_engine.get_map().get_name());
        _map_name_label.invalidate();

        _remaining_goals_label = (TextView) findViewById(R.id.remaining_goals);
        _game_engine.set_remaining_goals_label(_remaining_goals_label);

        _steps_label = (TextView) findViewById(R.id.steps);
        _game_engine.set_steps_label(_steps_label);

        _game_engine.restore_state(
                savedInstanceState,
                getPreferences(MODE_PRIVATE).getBoolean("sensorenabled", false)
        );

        _gesture_destructor = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2,
                                   float velocityX, float velocityY) {
                Direction _commanded_roll_direction = Direction.NONE;

                if (Math.abs(velocityX) > Math.abs(velocityY)) {
                    if (velocityX < 0) _commanded_roll_direction = Direction.LEFT;
                    else _commanded_roll_direction = Direction.RIGHT;
                } else {
                    if (velocityY < 0) _commanded_roll_direction = Direction.UP;
                    else _commanded_roll_direction = Direction.DOWN;
                }

                if (_commanded_roll_direction != Direction.NONE) {
                    _game_engine.roll_ball(_commanded_roll_direction);
                }

                return true;
            }
        });
        _gesture_destructor.setIsLongpressEnabled(false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return _gesture_destructor.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                _game_engine.roll_ball(Direction.LEFT);
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                _game_engine.roll_ball(Direction.RIGHT);
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                _game_engine.roll_ball(Direction.UP);
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                _game_engine.roll_ball(Direction.DOWN);
                return true;

            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle icicle) {
        super.onSaveInstanceState(icicle);
        _game_engine.save_state(icicle);
        _game_engine.unregister_listener();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        _game_engine.restore_state(
                savedInstanceState,
                getPreferences(MODE_PRIVATE).getBoolean("sensorenabled", true)
        );
    }

    @Override
    protected void onDestroy() {
        //save last current_map
        super.onDestroy();
    }

    public void Restart(View v) {
        v.startAnimation(rotate_fab);
        _game_engine.send_empty_message(Messages.MSG_RESTART);
    }


}