package com.example.materiallabyrinth.app;

import android.os.SystemClock;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by andrew on 28.02.16.
 */
public class Ball {
    private GameEngine _engine;
    private Map _map;
    private MapView _map_view;

    private float _x = 0;
    private float _y = 0;

    private int _targetX;
    private int _targetY;

    private int _Ux = 0;
    private int _Uy = 0;

    private static float SPEED_MULTIPLIER = 0.005f;

    private long _t1;
    private long _t2;
    private static final int DT_TARGET = 1000/25;

    private Timer _timer;

    private boolean _is_rolling = false;
    private Direction _roll_direction = Direction.NONE;

    public Ball(GameEngine engine, Map map, int init_x, int init_y) {
        _engine = engine;
        _map = map;
        _x = init_x;
        _y = init_y;
        _targetX = init_x;
        _targetY = init_y;
    }

    public void set_map_view(MapView map_view) {
        _map_view = map_view;
    }

    public void set_map(Map map) {
        _map = map;
    }

    public boolean is_rolling() {
        return _is_rolling;
    }

    private boolean is_valid_move(int x, int y, Direction dir) {
        System.out.println(x + " " + y);
        switch (dir) {
            case LEFT:
                if (x < 1) return false;
                if ((_map.get_walls(x - 1, y) & Wall.RIGHT) > 0) return false;
                break;
            case RIGHT:
                if (x > _map.get_sizeX()) return false;
                if ((_map.get_walls(x, y) & Wall.RIGHT) > 0) return false;
                break;
            case UP:
                if (y < 1) return false;
                if ((_map.get_walls(x, y - 1) & Wall.BOTTOM) > 0) return false;
                break;
            case DOWN:
                if (y > _map.get_sizeY()) return false;
                if ((_map.get_walls(x, y) & Wall.BOTTOM) > 0) return false;
                break;
        }
        return true;
    }

    public synchronized boolean roll(Direction dir) {
        if (_is_rolling) return false;

        switch (dir) {
            case LEFT: {
                _Ux = -1;
                _Uy = 0;
                break;
            }
            case RIGHT: {
                _Ux = 1;
                _Uy = 0;
                break;
            }
            case UP: {
                _Ux = 0;
                _Uy = -1;
                break;
            }
            case DOWN: {
                _Ux = 0;
                _Uy = 1;
                break;
            }
        }
        _targetX = Math.round(_x);
        _targetY = Math.round(_y);
        while (is_valid_move(_targetX, _targetY, dir)) {
            _targetX += _Ux;
            _targetY += _Uy;
        }

        if (_targetX == _x && _targetY == _y) return false;

        _is_rolling = true;
        _roll_direction = dir;

        _t1 = SystemClock.elapsedRealtime();
        TimerTask sim_task = new TimerTask() {
            public void run() {
                do_step();
            }
        };
        _timer = new Timer(true);
        _timer.schedule(sim_task, 0, DT_TARGET);

        return true;

    }

    public void stop() {
        if (!_is_rolling) return;

        _timer.cancel();
        _is_rolling = false;
        _x = _targetX;
        _y = _targetY;
        _map_view.postInvalidate();
    }

    private void do_step() {
        _t2 = SystemClock.elapsedRealtime();
        float dt = (float)(_t2 - _t1);
        _t1 = _t2;

        float xNext = _x + _Ux * SPEED_MULTIPLIER * dt;
        float yNext = _y + _Uy * SPEED_MULTIPLIER * dt;

        boolean reached_target = false;
        switch (_roll_direction) {
            case LEFT:
                if (xNext <= 1f*_targetX) {
                    xNext = _targetX;
                    reached_target = true;
                }
                break;
            case RIGHT:
                if (xNext > 1f*_targetX) {
                    xNext = _targetX;
                    reached_target = true;
                }
                break;
            case UP:
                if (yNext <= 1f*_targetY) {
                    yNext = _targetY;
                    reached_target = true;
                }
                break;
            case DOWN:
                if (yNext > 1f*_targetY) {
                    yNext = _targetY;
                    reached_target = true;
                }
                break;
        }

        _x = xNext;
        _y = yNext;

        if (_map.get_goal(Math.round(_x), Math.round(_y)) == 1) {

            _map.remove_goal(Math.round(_x), Math.round(_y));
            _engine.send_empty_message(Messages.MSG_REACHED_GOAL);
        }

        if (reached_target) {
            _roll_direction = Direction.NONE;
            _Ux = 0;
            _Uy = 0;
            _is_rolling = false;
            _timer.cancel();

            _engine.send_empty_message(Messages.MSG_REACHED_WALL);
        }

        _map_view.postInvalidate();
    }

    public Direction get_roll_direction() {
        return _roll_direction;
    }

    public float get_x() {
        return _x;
    }

    public float get_y() {
        return _y;
    }

    public void set_x(float x) {
        _x = x;
    }

    public void set_y(float y) {
        _y = y;
    }

    public void set_targetX(int x) {
        _targetX = x;
    }

    public void set_targetY(int y) {
        _targetY = y;
    }

    public float get_targetX() {
        return _targetX;
    }

    public float get_targetY() {
        return _targetY;
    }
}
