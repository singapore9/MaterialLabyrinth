package com.example.materiallabyrinth.app;

import java.util.LinkedList;
import java.util.List;
import static com.example.materiallabyrinth.app.Wall.*;

/**
 * Created by andrew on 28.02.16.
 */
public class MapDesigns {
    public static final List<MapDesign> designs = new LinkedList<MapDesign>();

    static {
        /*
		// This is the icon (flipped horizontally!)
		designList.add(new MapDesign(
			    "№ ",
			    3, 3,
			    new int[][] {
			            {0, BOTTOM, BOTTOM, BOTTOM},
			            {RIGHT, RIGHT, 0, RIGHT},
			            {RIGHT, BOTTOM, 0, RIGHT|BOTTOM},
			            {RIGHT, BOTTOM, BOTTOM, RIGHT|BOTTOM}
			    },
			    new int[][] {
			            {0, 0, 0, 0},
			            {0, 0, 0, 0},
			            {0, 0, 0, 0},
			            {0, 0, 0, 1}
			    },
			    1, 1
		));
		*/

        designs.add(new MapDesign(
                "№ 1",
                5, 5,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, BOTTOM, RIGHT, 0, RIGHT},
                        {RIGHT, 0, 0, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, RIGHT, 0, BOTTOM, 0, RIGHT},
                        {RIGHT, 0, BOTTOM, 0, 0, RIGHT|BOTTOM},
                        {RIGHT|BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, RIGHT|BOTTOM}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1}
                },
                1, 1
        ));

        designs.add(new MapDesign(
                "№ 2",
                6, 6,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, RIGHT, 0, BOTTOM, 0, RIGHT, RIGHT},
                        {RIGHT, 0, 0, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, RIGHT, RIGHT, RIGHT|BOTTOM, BOTTOM, 0, RIGHT|BOTTOM},
                        {RIGHT, BOTTOM, 0, RIGHT, RIGHT, 0, RIGHT},
                        {RIGHT, 0, 0, 0, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT, BOTTOM, BOTTOM, RIGHT|BOTTOM}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0}
                },
                3, 3
        ));

        designs.add(new MapDesign(
                "№ 3",
                6, 6,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, 0, RIGHT|BOTTOM, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, BOTTOM, 0, BOTTOM, 0, 0, RIGHT},
                        {RIGHT, 0, 0, 0, 0, RIGHT, RIGHT|BOTTOM},
                        {RIGHT, 0, 0, RIGHT, BOTTOM, 0, RIGHT},
                        {RIGHT, RIGHT|BOTTOM, 0, 0, 0, 0, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0}
                },
                1, 4
        ));

        designs.add(new MapDesign(
                "№ 4",
                7, 7,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, 0, 0, BOTTOM, RIGHT, 0, RIGHT},
                        {RIGHT, BOTTOM, RIGHT, 0, 0, BOTTOM, 0, RIGHT|BOTTOM},
                        {RIGHT, BOTTOM, 0, RIGHT, 0, 0, 0, RIGHT},
                        {RIGHT, 0, 0, 0, 0, RIGHT|BOTTOM, 0, RIGHT|BOTTOM},
                        {RIGHT, 0, BOTTOM, RIGHT, 0, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, BOTTOM, RIGHT, 0, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}
                },
                1, 3
        ));

        designs.add(new MapDesign(
                "№ 5",
                7, 7,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, RIGHT, 0, BOTTOM, RIGHT, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, 0, 0, 0, 0, 0, 0, RIGHT},
                        {RIGHT, 0, BOTTOM, RIGHT, 0, 0, RIGHT, RIGHT},
                        {RIGHT, 0, 0, 0, RIGHT|BOTTOM, RIGHT, 0, RIGHT|BOTTOM},
                        {RIGHT, BOTTOM, 0, 0, 0, BOTTOM, 0,  RIGHT},
                        {RIGHT, 0, RIGHT, RIGHT|BOTTOM, 0, 0, 0, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}
                },
                5, 2
        ));

        designs.add(new MapDesign(
                "№ 6",
                7, 7,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, RIGHT, BOTTOM, RIGHT, 0, 0, RIGHT, RIGHT},
                        {RIGHT, BOTTOM, 0, 0, 0, RIGHT|BOTTOM, 0, RIGHT},
                        {RIGHT, 0, BOTTOM, 0, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, 0, RIGHT, RIGHT, 0, 0, RIGHT},
                        {RIGHT, 0, RIGHT, BOTTOM, 0, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, 0, 0, BOTTOM|RIGHT, BOTTOM, 0, RIGHT},
                        {RIGHT, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1}
                },
                1, 1
        ));

        designs.add(new MapDesign(
                "№ 7",
                8, 8,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, RIGHT, BOTTOM, 0, 0, BOTTOM, RIGHT, RIGHT},
                        {RIGHT, BOTTOM, 0, 0, RIGHT|BOTTOM, 0, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, BOTTOM, 0, 0, 0, RIGHT, RIGHT, BOTTOM, RIGHT},
                        {RIGHT, 0, 0, RIGHT, 0, 0, 0, 0, RIGHT},
                        {RIGHT, 0, BOTTOM, 0, 0, 0, 0, RIGHT, BOTTOM|RIGHT},
                        {RIGHT, 0, 0, BOTTOM, 0, BOTTOM|RIGHT, 0, 0, RIGHT},
                        {RIGHT, RIGHT, 0, 0, 0, BOTTOM, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0}
                },
                1, 3
        ));

        designs.add(new MapDesign(
                "№ 8",
                9, 9,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, BOTTOM, 0, RIGHT, 0, 0, BOTTOM, RIGHT, 0, RIGHT|BOTTOM},
                        {RIGHT, 0, RIGHT|BOTTOM, 0, 0, BOTTOM, 0, 0, RIGHT, RIGHT},
                        {RIGHT, 0, 0, 0, 0, 0, RIGHT, RIGHT, 0, RIGHT},
                        {RIGHT, BOTTOM, RIGHT, 0, BOTTOM, RIGHT, BOTTOM, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, 0, 0, 0, BOTTOM, 0, BOTTOM, RIGHT, 0, RIGHT},
                        {RIGHT, 0, BOTTOM, 0, RIGHT, RIGHT, 0, BOTTOM, 0, BOTTOM|RIGHT},
                        {RIGHT, RIGHT, 0, BOTTOM, 0, BOTTOM, 0, 0, 0, RIGHT},
                        {RIGHT, BOTTOM, 0, 0, BOTTOM, RIGHT, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                },
                6, 4
        ));

        designs.add(new MapDesign(
                "№ 9",
                9, 9,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, RIGHT, 0, RIGHT, BOTTOM, 0, 0, RIGHT, 0, RIGHT|BOTTOM},
                        {RIGHT, 0, BOTTOM, 0, BOTTOM, BOTTOM, RIGHT, BOTTOM, 0, RIGHT},
                        {RIGHT, BOTTOM, RIGHT, 0, RIGHT, 0, 0, 0, RIGHT, RIGHT},
                        {RIGHT, 0, 0, BOTTOM, 0, 0, BOTTOM|RIGHT, 0, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, 0, RIGHT, RIGHT, BOTTOM, 0, 0, 0, RIGHT},
                        {RIGHT, 0, 0, 0, RIGHT, 0, BOTTOM, 0, RIGHT, BOTTOM|RIGHT},
                        {RIGHT, RIGHT, RIGHT, 0, BOTTOM, 0, 0, 0, 0, RIGHT},
                        {RIGHT, 0, BOTTOM, 0, 0, RIGHT, 0, RIGHT, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
                },
                2, 9
        ));

        designs.add(new MapDesign(
                "№ 10",
                10, 10,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, RIGHT, 0, 0, 0, 0, BOTTOM, RIGHT, 0, RIGHT, RIGHT},
                        {RIGHT, 0, RIGHT, 0, 0, 0, 0, 0, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, BOTTOM, 0, 0, BOTTOM|RIGHT, 0, 0, BOTTOM|RIGHT, BOTTOM, 0, RIGHT},
                        {RIGHT, 0, 0, BOTTOM|RIGHT, 0, 0, 0, RIGHT, 0, 0, RIGHT},
                        {RIGHT, BOTTOM, 0, BOTTOM, RIGHT, 0, 0, BOTTOM, 0, BOTTOM|RIGHT, RIGHT},
                        {RIGHT, 0, BOTTOM, 0, 0, RIGHT, 0, 0, BOTTOM, RIGHT, RIGHT},
                        {RIGHT, 0, 0, BOTTOM|RIGHT, BOTTOM, 0, 0, BOTTOM|RIGHT, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, BOTTOM, 0, RIGHT, 0, 0, BOTTOM|RIGHT, 0, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, 0, BOTTOM, 0, 0, 0, RIGHT, BOTTOM, 0, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
                },
                1, 1
        ));

        designs.add(new MapDesign(
                "№ 11",
                10, 10,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, RIGHT, BOTTOM, 0, RIGHT, 0, 0, RIGHT, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, 0, RIGHT, 0, 0, 0, 0, BOTTOM, 0, BOTTOM|RIGHT, RIGHT},
                        {RIGHT, RIGHT, 0, BOTTOM|RIGHT, 0, RIGHT, 0, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, 0, 0, RIGHT, 0, 0, 0, RIGHT, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, BOTTOM, 0, 0, 0, BOTTOM|RIGHT, BOTTOM, 0, 0, RIGHT, RIGHT},
                        {RIGHT, RIGHT, RIGHT, 0, BOTTOM, RIGHT, 0, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, 0, BOTTOM, 0, 0, 0, 0, 0, BOTTOM, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, BOTTOM, BOTTOM, RIGHT, RIGHT, BOTTOM, 0, 0, 0, RIGHT},
                        {RIGHT, BOTTOM|RIGHT, 0, 0, 0, 0, BOTTOM, RIGHT, RIGHT, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
                },
                1, 1
        ));

        designs.add(new MapDesign(
                "№ 12",
                10, 10,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, RIGHT, BOTTOM, 0, 0, RIGHT, 0, 0, BOTTOM, RIGHT, RIGHT},
                        {RIGHT, 0, 0, RIGHT, 0, 0, 0, 0, 0, 0, RIGHT},
                        {RIGHT, 0, 0, 0, 0, BOTTOM, 0, BOTTOM|RIGHT, 0, BOTTOM, RIGHT},
                        {RIGHT, RIGHT, 0, BOTTOM, 0, BOTTOM, 0, 0, 0, RIGHT, RIGHT},
                        {RIGHT, BOTTOM, 0, 0, 0, RIGHT, RIGHT, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, RIGHT, RIGHT, 0, 0, 0, BOTTOM, 0, BOTTOM, 0, RIGHT},
                        {RIGHT, 0, 0, 0, BOTTOM, 0, BOTTOM, 0, 0, RIGHT, RIGHT},
                        {RIGHT, RIGHT, 0, 0, RIGHT, BOTTOM, 0, 0, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, BOTTOM, 0, 0, 0, RIGHT, 0, BOTTOM, RIGHT, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
                },
                2, 1
        ));

        designs.add(new MapDesign(
                "№ 13",
                10, 10,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, RIGHT, RIGHT, 0, 0, RIGHT, 0, RIGHT, BOTTOM, 0, RIGHT},
                        {RIGHT, RIGHT, 0, BOTTOM, 0, 0, 0, 0, 0, 0, RIGHT},
                        {RIGHT, 0, 0, 0, RIGHT, RIGHT, 0, 0, RIGHT, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, RIGHT, 0, 0, 0, 0, BOTTOM, 0, 0, RIGHT},
                        {RIGHT, BOTTOM, 0, BOTTOM, 0, BOTTOM|RIGHT, BOTTOM, 0, BOTTOM|RIGHT, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, 0, BOTTOM, 0, RIGHT, 0, 0, BOTTOM, 0, RIGHT},
                        {RIGHT, BOTTOM, 0, BOTTOM, 0, 0, RIGHT, BOTTOM, 0, RIGHT, RIGHT},
                        {RIGHT, 0, RIGHT, 0, BOTTOM, RIGHT, RIGHT, 0, 0, RIGHT, RIGHT},
                        {RIGHT, RIGHT, 0, 0, 0, 0, 0, 0, RIGHT, 0, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
                },
                1, 1
        ));

        designs.add(new MapDesign(
                "№ 14",
                10, 10,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, RIGHT, 0, 0, 0, RIGHT, 0, BOTTOM, RIGHT, RIGHT},
                        {RIGHT, 0, BOTTOM|RIGHT, BOTTOM, 0, BOTTOM, 0, RIGHT, 0, 0, RIGHT},
                        {RIGHT, RIGHT, 0, 0, 0, 0, BOTTOM, 0, RIGHT, 0, RIGHT},
                        {RIGHT, 0, 0, BOTTOM, RIGHT, 0, 0, BOTTOM, 0, 0, RIGHT},
                        {RIGHT, BOTTOM, 0, 0, 0, BOTTOM, RIGHT, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, 0, 0, RIGHT, BOTTOM, RIGHT, 0, RIGHT, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, BOTTOM|RIGHT, 0, BOTTOM, 0, 0, BOTTOM, 0, 0, RIGHT},
                        {RIGHT, BOTTOM, 0, 0, RIGHT, 0, 0, 0, 0, BOTTOM|RIGHT, RIGHT},
                        {RIGHT, 0, 0, 0, BOTTOM, 0, BOTTOM, 0, RIGHT, 0, RIGHT},
                        {RIGHT, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                },
                2, 2
        ));

        designs.add(new MapDesign(
                "№ 15",
                5, 5,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, BOTTOM, RIGHT, 0, BOTTOM, RIGHT},
                        {RIGHT, 0, 0, 0, RIGHT, RIGHT},
                        {RIGHT, RIGHT, RIGHT, BOTTOM, 0, RIGHT},
                        {RIGHT, 0, 0, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, BOTTOM|RIGHT, BOTTOM, RIGHT|BOTTOM, BOTTOM, RIGHT|BOTTOM}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 1}
                },
                3, 4
        ));

        designs.add(new MapDesign(
                "№ 16",
                5, 5,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, BOTTOM, 0, BOTTOM, RIGHT, RIGHT},
                        {RIGHT, 0, 0, RIGHT, 0, RIGHT},
                        {RIGHT, RIGHT, 0, BOTTOM, 0, BOTTOM|RIGHT},
                        {RIGHT, BOTTOM, RIGHT, 0, BOTTOM, RIGHT|BOTTOM},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM, RIGHT|BOTTOM}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 1, 0},
                        {0, 1, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 1},
                        {0, 0, 1, 0, 1, 0}
                },
                3, 3
        ));

        designs.add(new MapDesign(
                "№ 17",
                5, 5,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, BOTTOM, RIGHT, 0, BOTTOM, RIGHT|BOTTOM},
                        {RIGHT, RIGHT, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, 0, BOTTOM, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, 0, RIGHT, RIGHT, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, RIGHT|BOTTOM}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 1},
                        {0, 0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 1, 0},
                        {0, 1, 0, 0, 0, 1}
                },
                3, 3
        ));

        designs.add(new MapDesign(
                "№ 18",
                6, 6,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, RIGHT, 0, RIGHT, 0, 0, RIGHT},
                        {RIGHT, BOTTOM, 0, BOTTOM, RIGHT, 0, BOTTOM|RIGHT},
                        {RIGHT, RIGHT, 0, 0, 0, 0, RIGHT},
                        {RIGHT, BOTTOM, 0, RIGHT, BOTTOM, RIGHT, BOTTOM|RIGHT},
                        {RIGHT, 0, 0, BOTTOM, 0, 0, RIGHT},
                        {RIGHT, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1},
                        {0, 1, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0}
                },
                1, 3
        ));

        designs.add(new MapDesign(
                "№ 19",
                6, 6,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, BOTTOM, RIGHT, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, 0, 0, BOTTOM|RIGHT, 0, RIGHT, RIGHT},
                        {RIGHT, BOTTOM|RIGHT, RIGHT, 0, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, 0, 0, BOTTOM, BOTTOM, RIGHT},
                        {RIGHT, RIGHT, BOTTOM, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0, 0, 1},
                        {0, 1, 0, 0, 1, 0, 0}
                },
                5, 2
        ));

        designs.add(new MapDesign(
                "№ 20",
                6, 6,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, RIGHT, 0, RIGHT, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, 0, BOTTOM, 0, BOTTOM|RIGHT, RIGHT, RIGHT},
                        {RIGHT, BOTTOM, RIGHT, 0, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, 0, BOTTOM, RIGHT, 0, RIGHT},
                        {RIGHT, BOTTOM|RIGHT, RIGHT, BOTTOM, 0, BOTTOM|RIGHT, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0},
                        {0, 1, 0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 1}
                },
                2, 2
        ));

        designs.add(new MapDesign(
                "№ 21",
                7, 7,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, RIGHT, 0, RIGHT, 0, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, 0, 0, BOTTOM, 0, 0, RIGHT},
                        {RIGHT, 0, BOTTOM, 0, RIGHT, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, 0, BOTTOM|RIGHT, 0, BOTTOM, 0, RIGHT|BOTTOM},
                        {RIGHT, BOTTOM, 0, 0, 0, RIGHT, 0, RIGHT},
                        {RIGHT, RIGHT, 0, 0, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 1, 0, 1, 0}
                },
                7, 5
        ));

        designs.add(new MapDesign(
                "№ 22",
                7, 7,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, RIGHT, BOTTOM, 0, RIGHT, 0, RIGHT},
                        {RIGHT, RIGHT, 0, 0, 0, 0, RIGHT, RIGHT},
                        {RIGHT, BOTTOM, 0, BOTTOM|RIGHT, RIGHT, 0, BOTTOM, RIGHT},
                        {RIGHT, 0, 0, 0, RIGHT, BOTTOM, 0, RIGHT|BOTTOM},
                        {RIGHT, RIGHT, RIGHT, 0, BOTTOM, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, 0, BOTTOM, 0, 0, RIGHT, 0, RIGHT},
                        {RIGHT, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 1, 0, 0, 0, 0}
                },
                4, 2
        ));

        designs.add(new MapDesign(
                "№ 23",
                8, 8,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, BOTTOM, BOTTOM, 0, BOTTOM, RIGHT, 0, RIGHT},
                        {RIGHT, 0, 0, 0, RIGHT, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, 0, RIGHT, 0, BOTTOM, 0, 0, RIGHT, RIGHT},
                        {RIGHT, 0, 0, BOTTOM, 0, RIGHT, BOTTOM, 0, RIGHT},
                        {RIGHT, 0, RIGHT, 0, 0, BOTTOM, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, RIGHT|BOTTOM, 0, 0, BOTTOM, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, 0, 0, 0, 0, 0, BOTTOM|RIGHT, 0, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0},
                        {0, 1, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 1, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0},
                        {0, 0, 1, 0, 1, 0, 0, 0, 1}
                },
                5, 6
        ));

        designs.add(new MapDesign(
                "№ 24",
                8, 8,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, BOTTOM, 0, 0, RIGHT, BOTTOM, 0, RIGHT},
                        {RIGHT, 0, 0, BOTTOM|RIGHT, 0, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, 0, 0, 0, RIGHT, 0, 0, RIGHT},
                        {RIGHT, 0, 0, RIGHT, BOTTOM, 0, 0, 0, RIGHT},
                        {RIGHT, 0, 0, 0, 0, 0, RIGHT, RIGHT, RIGHT|BOTTOM},
                        {RIGHT, 0, RIGHT, BOTTOM, 0, 0, 0, 0, RIGHT},
                        {RIGHT, RIGHT, BOTTOM, 0, 0, 0, BOTTOM, RIGHT, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 1, 0, 0, 1, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 1, 0}
                },
                4, 6
        ));

        designs.add(new MapDesign(
                "№ 25",
                8, 8,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, BOTTOM, RIGHT, 0, 0, 0, RIGHT|BOTTOM, RIGHT},
                        {RIGHT, 0, 0, 0, 0, RIGHT, 0, 0, RIGHT},
                        {RIGHT, 0, 0, BOTTOM, 0, 0, 0, RIGHT|BOTTOM, RIGHT},
                        {RIGHT, BOTTOM|RIGHT, RIGHT, 0, 0, 0, 0, 0, RIGHT|BOTTOM},
                        {RIGHT, 0, 0, 0, BOTTOM|RIGHT, 0, RIGHT, 0, RIGHT},
                        {RIGHT, 0, 0, 0, 0, BOTTOM, 0, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, 0, BOTTOM, 0, BOTTOM, 0, 0, RIGHT},
                        {RIGHT, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 1, 0, 1, 0, 0, 0, 1, 0}
                },
                5, 5
        ));

        designs.add(new MapDesign(
                "№ 26",
                10, 10,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, 0, 0, 0, BOTTOM, RIGHT, 0, RIGHT, 0, RIGHT},
                        {RIGHT, BOTTOM, RIGHT, BOTTOM, 0, 0, 0, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, RIGHT, 0, 0, 0, BOTTOM|RIGHT, 0, 0, BOTTOM, 0, RIGHT},
                        {RIGHT, 0, 0, 0, BOTTOM, 0, BOTTOM, 0, RIGHT, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, BOTTOM|RIGHT, 0, 0, 0, 0, RIGHT, 0, 0, RIGHT},
                        {RIGHT, 0, 0, BOTTOM, 0, RIGHT, 0, BOTTOM, 0, 0, RIGHT},
                        {RIGHT, RIGHT, 0, 0, 0, 0, 0, 0, RIGHT, 0, BOTTOM|RIGHT},
                        {RIGHT, 0, BOTTOM, 0, RIGHT, BOTTOM, 0, 0, 0, 0, RIGHT},
                        {RIGHT, BOTTOM, RIGHT, 0, BOTTOM, 0, RIGHT, 0, RIGHT, BOTTOM, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM, RIGHT|BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                        {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1}
                },
                6, 7
        ));

        designs.add(new MapDesign(
                "№ 27",
                10, 10,
                new int[][] {
                        {0, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM},
                        {RIGHT, 0, RIGHT, 0, RIGHT, 0, BOTTOM, 0, RIGHT, 0, RIGHT},
                        {RIGHT, 0, BOTTOM, RIGHT, 0, 0, BOTTOM, 0, BOTTOM, 0, RIGHT},
                        {RIGHT, BOTTOM, RIGHT, 0, 0, 0, RIGHT, 0, 0, BOTTOM|RIGHT, RIGHT},
                        {RIGHT, 0, 0, BOTTOM|RIGHT, 0, 0, 0, RIGHT, 0, 0, RIGHT},
                        {RIGHT, RIGHT, 0, 0, 0, BOTTOM|RIGHT, 0, 0, BOTTOM, RIGHT, RIGHT},
                        {RIGHT, 0, RIGHT, RIGHT, BOTTOM, 0, RIGHT, 0, BOTTOM, 0, BOTTOM|RIGHT},
                        {RIGHT, BOTTOM, 0, 0, 0, 0, BOTTOM, 0, RIGHT, RIGHT, RIGHT},
                        {RIGHT, 0, 0, RIGHT, 0, 0, 0, 0, 0, BOTTOM, RIGHT},
                        {RIGHT, 0, BOTTOM, 0, 0, BOTTOM|RIGHT, RIGHT, BOTTOM, 0, RIGHT, RIGHT},
                        {RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM, BOTTOM|RIGHT}
                },
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
                        {0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                        {0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}
                },
                6, 5
        ));

    }
}
