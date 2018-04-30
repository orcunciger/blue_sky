package com.example.android.musicapp;

public class Song {
    private String mSongName;
    private String mSingerName;

    public Song(String songName, String singerName) {
        mSongName = songName;
        mSingerName = singerName;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getSingerName() {
        return mSingerName;
    }
}
