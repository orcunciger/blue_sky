package com.example.android.musicapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayingActivity extends AppCompatActivity {

    private long value;
    private MediaPlayer mediaPlayer;
    int pausePosition;
    private String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        //Getting the chosen song's position number.
        final long songPosition = getIntent().getLongExtra("Variable name", 1);

        // Defining the buttons.
        Button play, stop;
        //Defining the mediaplayer.
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];

        //Find the butttons in the activity_playing.xml with the ID's.
        play = (Button) findViewById(R.id.button_play);
        stop = (Button) findViewById(R.id.button_stop);

        TextView returnLibrary = (TextView) findViewById(R.id.library_back);

        //set a click listener to the play button.
        // Determine the song which is chosen using if, else if statements and play it with mediaplayer.
        // There are 19 songs inthe array list but only two of them loaded to the R.raw. directory.
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (songPosition == 0) {
                    mediaPlayer[0] = MediaPlayer.create(getApplicationContext(), R.raw.hittheroadjack);
                    mediaPlayer[0].start();

                } else if (songPosition == 1) {
                    mediaPlayer[0] = MediaPlayer.create(getApplicationContext(), R.raw.namusbelasi);
                    mediaPlayer[0].start();
                }
            }
        });
        //set a click listener to the stop button.
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer[0] != null) {
                    mediaPlayer[0].stop();
                    mediaPlayer[0] = null;
                }
            }

        });
        returnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent libraryIntent = new Intent(PlayingActivity.this, LibraryActivity.class);
                startActivity(libraryIntent);
            }
        });
    }
}