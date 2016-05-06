package com.example.materiallabyrinth.app;

/**
 * Created by andrew on 28.02.16.
 */
public class MapDesign {
    private String _name;
    private int _sizeX = 0;
    private int _sizeY = 0;
    private int[][] _walls;
    private int[][] _goals;
    private int _initial_positionX;
    private int _initial_positionY;
    private int _goal_count = 0;

    public MapDesign(String name,
                     int sizeX, int sizeY,
                     int[][] walls,
                     int[][] goals,
                     int initial_positionX,
                     int initial_positionY) {
        _name = name;
        _sizeX = sizeX;
        _sizeY = sizeY;
        _walls = walls;
        _goals = goals;
        _initial_positionX = initial_positionX;
        _initial_positionY = initial_positionY;
        for (int y = 0; y <= _sizeY; ++y) {
            for (int x = 0; x <= _sizeX; ++x) {
                _goal_count += _goals[y][x];
            }
        }
    }

    public String get_name() {
        return _name;
    }

    public int[][] get_walls() {
        return _walls;
    }

    public int get_walls(int x, int y) {
        return _walls[y][x];
    }

    public int[][] get_goals() {
        return _goals;
    }

    public int get_goal_count() {
        return _goal_count;
    }

    public int get_sizeY() {
        return _sizeY;
    }

    public int get_sizeX() {
        return _sizeX;
    }

    public int get_initial_positionX() {
        return _initial_positionX;
    }

    public int get_initial_positionY() {
        return _initial_positionY;
    }

}
