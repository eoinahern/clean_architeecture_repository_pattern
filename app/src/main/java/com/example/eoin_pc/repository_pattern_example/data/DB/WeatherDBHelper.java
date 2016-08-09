package com.example.eoin_pc.repository_pattern_example.data.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class WeatherDBHelper extends SQLiteOpenHelper {



    private static WeatherDBHelper dbhelper;

    public static final String DATABASE_NAME = "weather.db";
    public static final int DATABASE_VERSION = 1;
    public static final String WEATHER_TABLE_NAME = "weather";
    public static final String WEATHER_COLUMN_ID = "_id";
    public static final String WEATHER_COL_LAT = "latitude";
    public static final String WEATHER_COL_LONG = "longitude";
    public static final String WEATHER_COLUMN_TIME = "time";


    //add all columns!!!
   /* public static final String PERSON_COLUMN_TIME = "time";
    public static final String PERSON_COLUMN_GENDER = "gender";
    public static final String PERSON_COLUMN_AGE = "age";
    public static final String PERSON_COLUMN_ID = "_id";
    public static final String PERSON_COLUMN_TIME = "time";
    public static final String PERSON_COLUMN_GENDER = "gender";
    public static final String PERSON_COLUMN_AGE = "age";public static final String PERSON_COLUMN_ID = "_id";
    public static final String PERSON_COLUMN_TIME = "time";
    public static final String PERSON_COLUMN_GENDER = "gender";
    public static final String PERSON_COLUMN_AGE = "age";
    public static final String PERSON_COLUMN_ID = "_id";
    public static final String PERSON_COLUMN_TIME = "time";
    public static final String PERSON_COLUMN_GENDER = "gender";
    public static final String PERSON_COLUMN_AGE = "age";*/


    private  WeatherDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    public static WeatherDBHelper getHelper(Context cont)
    {
        if(dbhelper == null)
        {
            dbhelper = new WeatherDBHelper(cont);
        }

        return dbhelper;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + WEATHER_TABLE_NAME + "(" +
                WEATHER_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                WEATHER_COL_LAT + " REAL, " +
                WEATHER_COL_LONG + " REAL, " +
                WEATHER_COLUMN_TIME + " INTEGER, " +
                PERSON_COLUMN_GENDER + " TEXT, " +
                PERSON_COLUMN_AGE + " INTEGER)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + WEATHER_TABLE_NAME);
        onCreate(db);
    }

    public synchronized boolean insertWeather(DailyWeatherEntity weather) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contvals = new ContentValues();
        //contvals.put(PERSON_COLUMN_TIME, );
        //contvals.put(PERSON_COLUMN_GENDER, gender);
        //contvals.put(PERSON_COLUMN_AGE, age);
        //db.insert(PERSON_TABLE_NAME, null, contvals);
        return true;
    }



    public synchronized Cursor getWeather(double lat, double longit )
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + WEATHER_TABLE_NAME + " WHERE " + WEATHER_COL_LAT + "= ?",  new String[]{Double.toString(lat)} );
        return res;
    }


    public Cursor getAllWesather()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + WEATHER_TABLE_NAME, null );
        return res;
    }
}
