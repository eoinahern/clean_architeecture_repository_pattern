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
    public static final String WEATHER_COLUMN_TIME = "time";
    public static final String WEATHER_COLUMN_SUMMARY = "summary";
    public static final String WEATHER_COLUMN_ICON = "icon";
    public static final String WEATHER_COLUMN_SUNRISETIME = "sunrisetime";
    public static final String WEATHER_COLUMN_SUNSETTIME = "sunsettime";
    public static final String WEATHER_COLUMN_MOONPHASE = "moonphase";
    public static final String WEATHER_COLUMN_PRECIPINTENSITY = "precipintensity";
    public static final String WEATHER_COLUMN_PRECIPINTENSITYMAXTIME = "precipintensitymaxtime";
    public static final String WEATHER_COLUMN_PRECIPPROBABILITY = "precipprobability";
    public static final String WEATHER_COLUMN_PRECIPTYPE = "preciptype";
    public static final String WEATHER_COLUMN_HUMIDITY = "humidity";
    public static final String WEATHER_COLUMN_PRESSURE = "pressure";
    public static final String WEATHER_COLUMN_APPARENTTEMPMAX = "apparenttemperaturemax";
    public static final String WEATHER_COLUMN_TEMPERATUREMAXTIME = "temperaturemaxtime";



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
                WEATHER_COLUMN_TIME + " INTEGER, " +
                WEATHER_COLUMN_SUMMARY + " TEXT, " +
                WEATHER_COLUMN_ICON + " TEXT, " +
                WEATHER_COLUMN_SUNRISETIME + " INTEGER, " +
                WEATHER_COLUMN_SUNSETTIME + " INTEGER, " +
                WEATHER_COLUMN_MOONPHASE + " REAL, " +
                WEATHER_COLUMN_PRECIPINTENSITY + " REAL, " +
                WEATHER_COLUMN_PRECIPINTENSITYMAXTIME + " INTEGER, " +
                WEATHER_COLUMN_PRECIPPROBABILITY + " REAL, " +
                WEATHER_COLUMN_PRECIPTYPE + " TEXT, " +
                WEATHER_COLUMN_HUMIDITY +  " REAL, " +
                WEATHER_COLUMN_PRESSURE +  " REAL, " +
                WEATHER_COLUMN_APPARENTTEMPMAX +  " REAL, " +
                WEATHER_COLUMN_TEMPERATUREMAXTIME + " INTEGER)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + WEATHER_TABLE_NAME);
        onCreate(db);
    }

    public synchronized boolean insertWeather(DailyWeatherEntity weather) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contvals = createContentVals(weather);
        db.insert(WEATHER_TABLE_NAME, null, contvals);
        return true;
    }


    private ContentValues createContentVals(DailyWeatherEntity dailyw)
    {

        ContentValues contvals = new ContentValues();
        contvals.put(WEATHER_COLUMN_TIME, dailyw.getTime());
        contvals.put(WEATHER_COLUMN_SUMMARY, dailyw.getSummary() );
        contvals.put(WEATHER_COLUMN_SUNRISETIME, dailyw.getSunriseTime());
        contvals.put(WEATHER_COLUMN_SUNSETTIME, dailyw.getSunsetTime());
        contvals.put( WEATHER_COLUMN_MOONPHASE, dailyw.getMoonPhase());
        contvals.put(WEATHER_COLUMN_PRECIPINTENSITY , dailyw.getPrecipIntensity());
        contvals.put(WEATHER_COLUMN_PRECIPINTENSITYMAXTIME, dailyw.getPrecipIntensityMaxTime() );
        contvals.put(WEATHER_COLUMN_PRECIPPROBABILITY, dailyw.getPrecipProbability());
        contvals.put( WEATHER_COLUMN_PRECIPTYPE, dailyw.getPrecipType());
        contvals.put( WEATHER_COLUMN_HUMIDITY, dailyw.getHumidity());
        contvals.put(WEATHER_COLUMN_PRESSURE, dailyw.getPressure());
        contvals.put(WEATHER_COLUMN_APPARENTTEMPMAX, dailyw.getApparentTempertureMax());
        contvals.put( WEATHER_COLUMN_TEMPERATUREMAXTIME, dailyw.getTemperatureMaxTime());

        return contvals;
    }

    //for demo purposes i wont use latlong!!!
    /*public synchronized Cursor getWeather(double lat, double longit)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + WEATHER_TABLE_NAME + " WHERE " + WEATHER_COL_LAT + "= ?" + " AND " + WEATHER_COL_LONG + "= ?" ,
                new String[]{Double.toString(lat), Double.toString(longit) });
        return res;
    }*/


    public Cursor getAllWeather()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + WEATHER_TABLE_NAME, null );
        return res;
    }

    public boolean deleteAll()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.rawQuery( "DELETE * FROM " + WEATHER_TABLE_NAME, null );
        return true;
    }
}
