package com.example.materiallabyrinth.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andrew on 28.02.16.
 */
public class MapsDB {
    private static final String DATABASE_NAME = "maps.db";
    private static final String DATABASE_TABLE = "maps";
    private static final int DATABASE_VERSION = 4;

    public static final String KEY_ID = "_id";
    public static final int ID_COLUMN = 0;

    public static final String KEY_NAME = "name";
    public static final int NAME_COLUMN = 1;

    public static final String KEY_SOLUTION_STEPS = "solution_steps";
    public static final int SOUTION_STEPS_COLUMN = 2;

    public static final String[] COLUMNS = {
            KEY_ID,
            KEY_NAME,
            KEY_SOLUTION_STEPS,
    };

    private SQLiteDatabase _DB;
    private MapsDBOpenHelper _DBHelper;

    public MapsDB(Context context) {
        _DBHelper = new MapsDBOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public MapsDB open() throws SQLException {
        _DB = _DBHelper.getWritableDatabase();
        return this;
    }

    public MapsDB reset() throws SQLException {
        _DBHelper.onUpgrade(_DB, 3, 2);
        _DB = _DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        _DB.close();
    }

    public void updateMap(int id, int solution_steps) {
        ContentValues values = new ContentValues();
        values.put(KEY_SOLUTION_STEPS, solution_steps);

        _DB.update(
                DATABASE_TABLE,
                values,
                KEY_ID + " = ? AND ("
                + KEY_SOLUTION_STEPS + " = ? OR "
                + KEY_SOLUTION_STEPS + " > ?)",
                new String[]{"" + id, "0", "" + solution_steps}
        );
    }

    public Cursor allMaps() {
        return _DB.query(
                DATABASE_TABLE,
                COLUMNS,
				/*selection:*/ null,
				/*selectionArgs:*/ null,
				/*groupBy:*/ null,
				/*having:*/ null,
				/*orderBy:*/ KEY_ID
        );
    }

    public Cursor unsolvedMaps() {
        return _DB.query(
                DATABASE_TABLE,
				/*:columns:*/ new String[] {KEY_ID},
				/*selection:*/ KEY_SOLUTION_STEPS + " = ?",
				/*selectionArgs:*/ new String[] {"0"},
				/*groupBy:*/ null,
				/*having:*/ null,
				/*orderBy:*/ KEY_ID
        );
    }

    public int get_first_unsolved() {
        Cursor c = unsolvedMaps();

        if (!c.moveToFirst()) {
            return 0;
        }
        return c.getInt(ID_COLUMN);
    }

    private static class MapsDBOpenHelper extends SQLiteOpenHelper {
        private static final String DATABASE_CREATE =
                "create table " + DATABASE_TABLE + " ("
                + KEY_ID + " integer primary key autoincrement, "
                + KEY_NAME + " text not null, "
                + KEY_SOLUTION_STEPS + " integer"
                + ");";

        public MapsDBOpenHelper(Context context, String name,
                                CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("drop table if exists " + DATABASE_TABLE + ";");

            db.execSQL(DATABASE_CREATE);

            db.beginTransaction();
            try {
                ContentValues values = new ContentValues();
                values.put(KEY_SOLUTION_STEPS, 0);

                int id = 0;
                for (MapDesign map : MapDesigns.designs) {
                    values.put(KEY_ID, id);
                    values.put(KEY_NAME, map.get_name());
                    db.insert(DATABASE_TABLE, null, values);
                    ++id;
                }

                db.setTransactionSuccessful();
            }
            finally {
                db.endTransaction();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists " + DATABASE_TABLE + ";");
            onCreate(db);
        }

    }
}
