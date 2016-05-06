package com.example.materiallabyrinth.app;

import android.content.Context;
import android.graphics.*;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by andrew on 28.02.16.
 */
public class MapView extends View {
    private static int FPS = 40;

    private boolean DEBUG = false;

    private static final float WALL_WIDTH = 10;

    private GameEngine _game_engine;

    private Ball _ball;
    private float _ballX;
    private float _ballY;

    private int _width;
    private float _minX;
    private float _minY;
    private float _maxX;
    private float _maxY;
    private float _unit;

    private int _map_width;
    private int _map_height;
    private int[][] _walls;
    private int[][] _goals;

    private int _val = 4;
    private Paint[] _paints = new Paint[2];
    private RadialGradient _goal_gradient = new RadialGradient(
            0, 0, 1,
            getResources().getColor(R.color.goal),
            getResources().getColor(R.color.goal),
            TileMode.MIRROR);
    private Matrix _matrix = new Matrix();
    private Matrix _scale_matrix = new Matrix();

    private Timer _timer;
    private long _t1 = 0;
    private long _t2 = 0;
    private int _draw_step = 0;
    private int _draw_time_history_size = 20;
    private long[] _draw_time_history = new long[_draw_time_history_size];

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);

       for (int i = 1; i >= 0; --i) {
           _paints[i] = new Paint();
           _paints[i].setAntiAlias(true);
       }

        int w = getWidth();
        int h = getHeight();
        _width = Math.min(w, h);
        _minX = WALL_WIDTH / 2;
        _minY = WALL_WIDTH / 2;
        _maxX = Math.min(w, h) - WALL_WIDTH / 2;
        _maxY = _maxX;

        if (DEBUG) {
            TimerTask redrawTask = new TimerTask() {
                public void  run() {
                    postInvalidate();
                }
            };
            _timer = new Timer(true);
            _timer.schedule(redrawTask, 0, 1000/FPS);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        _width = Math.min(w, h);
        _maxX = Math.min(w, h) - WALL_WIDTH / 2;
        _maxY = _maxX;

        calculateUint();
    }

    @Override
    protected void onMeasure(int width_measure_spec, int height_measure_spec) {
        super.onMeasure(width_measure_spec, height_measure_spec);
        _width = Math.min(getMeasuredHeight(), getMeasuredWidth());
        setMeasuredDimension(_width, _width);
    }

    @Override
    public void onDraw(Canvas canvas) {
        _t2 = SystemClock.elapsedRealtime();
        long dt = _t2 - _t1;
        _t1 = _t2;
        _draw_time_history[_draw_step % _draw_time_history_size] = dt;
        ++_draw_step;

        _ball = _game_engine.get_ball();
        _map_width = _game_engine.get_map().get_sizeX();
        _map_height = _game_engine.get_map().get_sizeY();

        drawWalls(canvas);
        drawGoals(canvas);
        drawBall(canvas);

        if (DEBUG) {
            _paints[0].setColor(Color.WHITE);
            _paints[0].setStyle(Style.STROKE);
            _paints[0].setStrokeWidth(1);
            canvas.drawText("FPS: " + getFPS(), 20, 30, _paints[0]);
        }
    }

    public void set_game_engine(GameEngine e) {_game_engine = e;}

    public void calculateUint() {
        if (_game_engine == null) return;

        float unitX = Math.abs((_maxX - _minX) / _game_engine.get_map().get_sizeX());
        float unitY = Math.abs((_maxY - _minY) / _game_engine.get_map().get_sizeY());
        _unit = Math.min(unitX, unitY);
    }

    public double getFPS() {
        double avg = 0;
        int n = 0;
        for (long t: _draw_time_history) {
            if (t > 0) {
                avg += t;
                ++n;
            }
        }
        if (n == 0) return  -1;
        return 1000*n/avg;
    }

    private void drawWalls(Canvas canvas) {
        _paints[0].setColor(getResources().getColor(R.color.wall));
        _paints[1].setColor(getResources().getColor(R.color.shadow));

        for (int i = 1; i >= 0; --i) {
            _paints[i].setStrokeWidth(WALL_WIDTH);
            _paints[i].setStrokeCap(Cap.ROUND);
        }

        _walls = _game_engine.get_map().get_walls();

       for (int i = 1; i >= 0; --i) {
           for (int y = 0; y <= _map_height; ++y) {
               for (int x = 0; x <= _map_width; ++x) {
                   if ((_walls[y][x] & Wall.BOTTOM) > 0) {
                       drawWall(canvas, x-1, y, x, y, _paints[i], i);
                   }

                   if ((_walls[y][x] & Wall.RIGHT) > 0) {
                       drawWall(canvas, x, y-1,x, y, _paints[i], i);
                   }
               }
           }
       }

        for (int i = 1; i >= 0; --i) {
            _paints[i].setShader(null);
        }
    }

    private void drawWall(Canvas canvas, float x0, float y0, float x1, float y1,
                        Paint paint, int dz) {
        canvas.drawLine(_minX + (x0) * _unit + dz*_val,
                _minY + (y0) * _unit + dz*_val,
                _minX + (x1) * _unit + dz*_val,
                _minY + (y1) * _unit + dz*_val,
                paint);
    }

    private void drawGoals(Canvas canvas) {
        _paints[0].setColor(getResources().getColor(R.color.goal));
        _paints[1].setColor(getResources().getColor(R.color.shadow));
        for (int i = 1; i >= 0; --i) {
            _paints[i].setStyle(Style.FILL);
        }

        _scale_matrix.setScale(_unit, _unit);

        _goals = _game_engine.get_map().get_goals();
        for (int i = 1; i >= 0; --i) {
            for (int y = 1; y <= _map_height; ++y) {
                for (int x = 1; x <= _map_width; ++x) {

                        if (_goals[y][x] > 0) {
                            _matrix.setTranslate(
                                    _minX + (x-1) * _unit,
                                    _minY + (y-1) * _unit
                            );
                            _matrix.setConcat(_matrix, _scale_matrix);
                            _goal_gradient.setLocalMatrix(_matrix);
                            canvas.drawRect(
                                    _minX + (x-1) * _unit + _unit / 4 + i*_val,
                                    _minY + (y-1) * _unit + _unit / 4 + i*_val,
                                    _minX + (x) * _unit - _unit / 4 + i*_val,
                                    _minY + (y) * _unit - _unit / 4 + i*_val,
                                    _paints[i]
                            );
                        }

                }
            }
        }
        for (int i = 1; i >= 0; --i) {
            _paints[i].setShader(null);
        }
    }

    private void drawBall(Canvas canvas) {
        _ballX = _ball.get_x()-1;
        _ballY = _ball.get_y()-1;

        _paints[0].setColor(getResources().getColor(R.color.ball));
        _paints[1].setColor(getResources().getColor(R.color.shadow));
        for (int i = 1; i >= 0; --i) {
            _paints[i].setStyle(Style.FILL);
        }

        for (int i = 1; i >= 0; --i) {
            canvas.drawCircle(
                    _minX + (_ballX + 0.5f) * _unit + i*_val,
                    _minY + (_ballY + 0.5f) * _unit + i*_val,
                    _unit * 0.4f,
                    _paints[i]
            );
        }
        for (int i = 1; i >= 0; --i) {
            _paints[i].setShader(null);
        }
    }

}
