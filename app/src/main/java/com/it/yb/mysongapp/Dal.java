package com.it.yb.mysongapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Dal extends SQLiteAssetHelper {

    public Dal(Context context) {

        super(context, "dbsong.db", null, 1);
    }

    public void addSong(String songName, String singerName, int time)
    {


        SQLiteDatabase db = getWritableDatabase();
        String sql_INSERT = "INSERT INTO song_tbl (songName ,singerName ,time ) values(?,?,?)";
        SQLiteStatement statment = db.compileStatement(sql_INSERT);

        statment.bindString(1, songName);
        statment.bindString(2, singerName);
        statment.bindString(3, time+"");

        statment.execute();
    }

//    CREATE TABLE "song_tbl" (
//            "imgName"	BLOB,
//            "songName"	TEXT,
//            "singerName"	TEXT,
//            "time"	INTEGER,
//    PRIMARY KEY("songName")
//);

    public ArrayList<Song> getAllSongs() {
        ArrayList<Song> ary = new ArrayList<>();
        String st = "select * from song_tbl";
        SQLiteDatabase db = getWritableDatabase();
//        Song s = new Song("song1.png", "song1", "singer1", 3);
//        arySongs.add(s);
        Cursor cursor = db.rawQuery(st, null);
        while (cursor.moveToNext()) {
            Song s = new Song();
            s.setImgName(cursor.getString(cursor.getColumnIndex("imgName")));
            s.setSongName(cursor.getString(cursor.getColumnIndex("songName")));
            s.setSingerName(cursor.getString(cursor.getColumnIndex("singerName")));
            s.setTime(Integer.parseInt(cursor.getString(cursor.getColumnIndex("time"))));

            ary.add(s);
        }
        return ary;
    }


}
