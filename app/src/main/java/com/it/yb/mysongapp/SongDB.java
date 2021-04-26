package com.it.yb.mysongapp;

import java.util.ArrayList;

public class SongDB {

    public static ArrayList<Song> getSongData()

    {

        ArrayList<Song> arySongs = new ArrayList<Song>();

        Song s = new Song("song1.png", "song1", "singer1", 3);
        arySongs.add(s);
        s = new Song("song1.png", "song2", "singer2", 1);
        arySongs.add(s);
        s = new Song("song1.png", "song3", "singer3", 5);
        arySongs.add(s);
        s = new Song("song1.png", "song4", "singer4", 4);
        arySongs.add(s);
        return   arySongs;

    }
}
