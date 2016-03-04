package com.example.materiallabyrinth.app;

/**
 * Created by andrew on 03.03.16.
 */

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class SelectLevelActivity extends ListActivity {
    private MapsDB _DB;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _DB = new MapsDB(getApplicationContext()).open();

        setListAdapter(new CursorAdapter(getApplicationContext(), _DB.allMaps(), true) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                final LayoutInflater inflater = LayoutInflater.from(context);
                final View rowView = inflater.inflate(R.layout.select_lvl_row_layout, parent, false);

                bindView(rowView, context, cursor);
                return rowView;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                final MapDesign m;
                MapDesign _m;
                try {
                    _m = MapDesigns.designs.get(cursor.getPosition());
                } catch (Exception e) {
                    _m = MapDesigns.designs.get(MapDesigns.designs.size() - 1);
                }
                m = _m;
                final ImageView map_solved_tickbox = (ImageView) view.findViewById(R.id.map_solved_tick);
                final TextView map_name = (TextView)view.findViewById(R.id.map_name);
                final TextView map_solution_steps = (TextView)view.findViewById(R.id.map_solution_steps);

                if (cursor.getInt(MapsDB.SOUTION_STEPS_COLUMN) == 0) {
                    map_solved_tickbox.setImageResource(R.drawable.abc_btn_check_to_on_mtrl_000);
                    map_solution_steps.setText("");
                }
                else {
                    map_solved_tickbox.setImageResource(R.drawable.abc_btn_check_to_on_mtrl_015);
                    map_solution_steps.setText(
                            "Пройдено за "
                                    + cursor.getString(MapsDB.SOUTION_STEPS_COLUMN)
                                    + " шагов");
                }

                map_name.setText(
                        cursor.getString(MapsDB.NAME_COLUMN)
                                + " (" + m.get_sizeX() + "x" + m.get_sizeY() + "), "
                                + "целей: " + m.get_goal_count()
                );
            }
        });

        setContentView(R.layout.select_lvl_layout);
        //setContentView(new GameView(this,null));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent start_from = new Intent(SelectLevelActivity.this, GameActivity.class);
        start_from.putExtra("selected_index", (int)id);
        startActivity(start_from);
        finish();

    }


}
