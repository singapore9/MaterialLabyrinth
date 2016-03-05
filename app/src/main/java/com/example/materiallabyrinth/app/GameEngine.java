package com.example.materiallabyrinth.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * Created by andrew on 28.02.16.
 */
public class GameEngine {
    private SensorManager _sensor_manager;

    private static float ACCEL_THRESHOLD = 2;
    private float _accelX = 0;
    private float _accelY = 0;

    private Handler _handler;

    private Map _map;
    private Ball _ball;
    private int _current_map = 0;
    private int _map_to_load = 0;
    private int _step_count = 0;

    public int get_current_map() {
        return _current_map;
    }
    public void set_current_map(int index) {
        if ((index >= 0) && (index < MapDesigns.designs.size())) {
            _current_map = index;
        }
    }

    private Direction _commanded_roll_direction = Direction.NONE;

    private TextView _map_name_label;
    private TextView _remaining_goals_label;
    private TextView _steps_view;
    private MapView _map_view;

    private final AlertDialog _map_solved_dialog;
    private final AlertDialog _all_maps_solved_dialog;


    private boolean _sensor_enabled = false;//true;

    private MapsDB _DB;

    private final SensorListener _sensor_accelerometer = new SensorListener() {
        @Override
        public void onSensorChanged(int sensor, float[] values) {
            if (!_sensor_enabled) return;

            _accelX = values[0];
            _accelY = values[1];

            _commanded_roll_direction = Direction.NONE;
            /*if (Math.abs(_accelX) > Math.abs(_accelY)) {
                if (_accelX < -ACCEL_THRESHOLD) _commanded_roll_direction = Direction.LEFT;
                if (_accelX > ACCEL_THRESHOLD) _commanded_roll_direction = Direction.RIGHT;
            } else {
                if (_accelY < -ACCEL_THRESHOLD) _commanded_roll_direction = Direction.DOWN;
                if (_accelY > ACCEL_THRESHOLD) _commanded_roll_direction = Direction.UP;
            }*/
            if (_commanded_roll_direction != Direction.NONE && ! _ball.is_rolling()) {
                roll_ball(_commanded_roll_direction);
            }
        }

        @Override
        public void onAccuracyChanged(int sensor, int accuracy) {

        }
    };

    public GameEngine (Context context) {
        _DB = new MapsDB(context).open();
        _current_map = _DB.get_first_unsolved();

        _sensor_manager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        _sensor_manager.registerListener(_sensor_accelerometer, SensorManager.SENSOR_ACCELEROMETER,
                SensorManager.SENSOR_DELAY_GAME);

        _map = new Map(MapDesigns.designs.get(_current_map));

        _ball = new Ball(this, _map,
                _map.get_initial_positionX(),
                _map.get_initial_positionY());

        _map_solved_dialog = new AlertDialog.Builder(context)
                .setCancelable(true)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle(R.string.level_solved_tytle)
                .setPositiveButton(R.string.level_solved_btn, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which_button) {
                        dialog.cancel();
                       /* send_empty_message(Messages.MSG_MAP_NEXT);*/
                    }
                })
                .create();

        _all_maps_solved_dialog = new AlertDialog.Builder(context)
                .setCancelable(true)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.all_levels_solved_tytle)
                .setPositiveButton(R.string.ok_btn, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which_button) {
                        dialog.cancel();
                        /*send_empty_message(Messages.MSG_MAP_NEXT);*/
                    }
                })
                .create();

        _handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case Messages.MSG_INVALIDATE:
                        _map_view.invalidate();
                        return;
                    case Messages.MSG_REACHED_GOAL:
                        _remaining_goals_label.setText("" + _map.get_goal_count());
                        _remaining_goals_label.invalidate();
                        if (_map.get_goal_count() == 0) {

                            _DB.updateMap(_current_map, _step_count);
                            if (_DB.unsolvedMaps().getCount() == 0) {
                                _all_maps_solved_dialog.setMessage(
                                        "Ты прошел все лабиринты!\n" +
                                        "Слабо побить свои же рекорды?\nДерзай! :)"
                                );
                                _all_maps_solved_dialog.show();
                            } else {
                                _map_solved_dialog.setMessage(
                                        "Ты прошел лабиринт '" + _map.get_name() +
                                                "' за " + _step_count + " шагов."
                                );
                                _map_solved_dialog.show();
                            }
                            sendEmptyMessage(Messages.MSG_MAP_NEXT);

                        }
                        return;

                    case Messages.MSG_REACHED_WALL:
                        return;

                    case Messages.MSG_RESTART:
                        load_map(_current_map);
                        return;

                    case Messages.MSG_MAP_PREVIOUS:
                    case Messages.MSG_MAP_NEXT:
                        switch (msg.what) {
                        case (Messages.MSG_MAP_PREVIOUS):
                            if (_current_map == 0) {
                                _map_to_load = MapDesigns.designs.size() - 1;

                            } else {
                                _map_to_load = (_current_map - 1) % MapDesigns.designs.size();
                            }
                            break;
                        case (Messages.MSG_MAP_NEXT):
                            _map_to_load = (_current_map + 1) % MapDesigns.designs.size();
                            break;
                        }

                        load_map(_map_to_load);
                            return;
                }
                super.handleMessage(msg);
            }
        };
    }

    public void load_map(int mapID) {
        _current_map = mapID;
        _ball.stop();
        _map = new Map(MapDesigns.designs.get(_current_map));
        _ball.set_map(_map);
        _ball.set_x(_map.get_initial_positionX());
        _ball.set_y(_map.get_initial_positionY());
        _map.init();

        _step_count = 0;

        _map_name_label.setText(_map.get_name());
        _map_name_label.invalidate();

        _remaining_goals_label.setText("" + _map.get_goal_count());
        _remaining_goals_label.invalidate();

        _steps_view.setText("" + _step_count);
        _steps_view.invalidate();

        _map_view.calculateUint();
        _map_view.invalidate();
    }

    public void set_map_name_label(TextView map_name_label) {
        _map_name_label = map_name_label;
    }

    public  void set_remaining_goals_label(TextView remaining_goals_label) {
        _remaining_goals_label = remaining_goals_label;
    }

    public void set_maps_view(MapView map_view) {
        _map_view = map_view;
        _ball.set_map_view(map_view);
    }

    public void set_steps_label(TextView steps_view) {
        _steps_view = steps_view;
    }

    public void send_empty_message(int msg) {
        _handler.sendEmptyMessage(msg);
    }

    public void send_message(Message msg) {
        _handler.sendMessage(msg);
    }

    public void register_listener() {
        _sensor_manager.registerListener(_sensor_accelerometer, SensorManager.SENSOR_ACCELEROMETER,
                SensorManager.SENSOR_DELAY_GAME);
    }

    public void unregister_listener() {
        _sensor_manager.unregisterListener(_sensor_accelerometer);
    }

    public void roll_ball(Direction dir) {
        if (_ball.roll(dir)) ++_step_count;
        _steps_view.setText("" + _step_count);
        _steps_view.invalidate();
    }

    public Ball get_ball() {
        return _ball;
    }

    public Map get_map() {
        return _map;
    }

    public boolean is_sensor_enabled() {
        return _sensor_enabled;
    }

    public void toggle_sensor_enabled() {
        _sensor_enabled = false;//!_sensor_enabled;
    }

    public void save_state(Bundle icicle) {
        _ball.stop();

        icicle.putInt("map.id", _current_map);

        int[][] goals = _map.get_goals();
        int sizeX = _map.get_sizeX();
        int sizeY = _map.get_sizeY();
        int[] goals_to_save = new int[sizeX * sizeY];
        for (int y = 0; y < sizeY; ++y)
            for (int x = 0; x < sizeX; ++x)
                goals_to_save[y + x*sizeX] = goals[y][x];
        icicle.putIntArray("map.goals", goals_to_save);
        icicle.putInt("stepcount", _step_count);
        icicle.putInt("ball.x", Math.round(_ball.get_x()));
        icicle.putInt("ball.y", Math.round(_ball.get_y()));
    }

    public void restore_state(Bundle icicle, boolean sensor_enabled) {
        if (icicle != null) {
            int mapID = icicle.getInt("map.id", -1);
            if (mapID == -1) return;;
            load_map(mapID);

            int[] goals = icicle.getIntArray("map.goals");
            if (goals == null) return;

            int sizeX = _map.get_sizeX();
            int sizeY = _map.get_sizeY();
            for (int y = 0; y < sizeY;++y)
                for (int x = 0; x < sizeX; ++x)
                    _map.set_goal(x, y, goals[y + x*sizeX]);

            _ball.set_x(icicle.getInt("ball.x"));
            _ball.set_y(icicle.getInt("ball.y"));

            _map_view.invalidate();

            _step_count = icicle.getInt("stepcount", 0);
        }

        _remaining_goals_label.setText("" + _map.get_goal_count());
        _remaining_goals_label.invalidate();

        _steps_view.setText("" + _step_count);
        _steps_view.invalidate();

        _sensor_enabled = false;//sensor_enabled;
    }

    public void reset_all() {
        _DB.reset();
    }
}
