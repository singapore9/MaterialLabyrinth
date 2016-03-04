package com.example.materiallabyrinth.app;

/**
 * Created by andrew on 28.02.16.
 */
public class Map {
    private MapDesign _design;

    private int[][] _goals;
    private int _goal_count;

    public Map(MapDesign design) {
        _design = design;
        init();
    }

    public void init() {
        if (_goals == null) {
            _goals = new int[_design.get_sizeY()][_design.get_sizeX()];
        }

        int [][] goals = _design.get_goals();
        for (int y = 0; y < _design.get_sizeY(); ++y) {
            for (int x = 0; x < _design.get_sizeX(); ++x) {
                _goals[y][x] = goals[y][x];
            }
        }
        _goal_count = _design.get_goal_count();
    }

    public String get_name() {
        return _design.get_name();
    }

    public int[][] get_walls() {
        return _design.get_walls();
    }

    public int get_walls(int x, int y) {
        return _design.get_walls(x, y);
    }

    public int[][] get_goals() {
        return _goals;
    }

    public int get_goal(int x, int y) {
        return _goals[y][x];
    }

    public void remove_goal(int x, int y) {
        _goal_count -= _goals[y][x];
        _goals[y][x] = 0;
    }

    public void set_goal(int x, int y, int value) {
        _goal_count -= (_goals[y][x] - value);
        _goals[y][x] = value;
    }

    public int get_sizeX() {
        return _design.get_sizeX();
    }

    public int get_sizeY() {
        return _design.get_sizeY();
    }

    public int get_initial_positionX() {
        return _design.get_initial_positionX();
    }

    public int get_initial_positionY() {
        return _design.get_initial_positionY();
    }

    public int get_goal_count() {
        return _goal_count;
    }
}
