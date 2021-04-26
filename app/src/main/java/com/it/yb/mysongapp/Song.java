package com.it.yb.mysongapp;

public class Song {
    private String imgName;
    private String songName;
    private String singerName;
    private int time;

    public Song(String imgName, String songName, String singerName, int time) {
        this.imgName = imgName;
        this.songName = songName;
        this.singerName = singerName;
        this.time = time;
    }

    public Song() {
        this.imgName = imgName;
        this.songName = songName;
        this.singerName = singerName;
        this.time = time;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Song{" +
                "imgName='" + imgName + '\'' +
                ", songName='" + songName + '\'' +
                ", singerName='" + singerName + '\'' +
                ", time=" + time +
                '}';
    }
}
