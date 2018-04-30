package com.example.android.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //Find the buttons in song_list.xml with their ID.
        Button home = (Button) findViewById(R.id.goHome);
        Button nowPlaying = (Button) findViewById(R.id.goPlaying);

        // Set a click listener to open the MainActivity with Home Screen button.
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeIntent);
                            }
        });
        // Set a click listener to open the PlayingActivity with NowPlaying Screen button.
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nowPlayingIntent = new Intent(getApplicationContext(), PlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });

        // To set the ArrayList of the Song.
        final ArrayList<Song> songs = new ArrayList<Song>();
        //Adding new songs to the ArrayList.
        songs.add(new Song("Hit the road Jack", "Ray Charles"));
        songs.add(new Song("Namus belası", "Cem Karaca"));
        songs.add(new Song("Tükeneceğiz", "Sezen Aksu"));
        songs.add(new Song("Dance me to the end of love", "Leonard Norman Cohen"));
        songs.add(new Song("My lady D'Arbanville", "Cat Stevens"));
        songs.add(new Song("Smooth Criminal", "Michael Jackson"));
        songs.add(new Song("Sorma ne haldeyim", "Zeki Müren"));
        songs.add(new Song("Gül Pembe", "Barış Manço"));
        songs.add(new Song("Böyle ayrılık olmaz", "Nilüfer"));
        songs.add(new Song("Counting stars", "One Republic"));
        songs.add(new Song("Zahide", "Neşet Ertaş"));
        songs.add(new Song("Güzelim", "Atiye"));
        songs.add(new Song("Smooth", "Carlos Santana"));
        songs.add(new Song("Hasretinle yandı gönlüm", "Edip Akbayram"));
        songs.add(new Song("Alla beni pulla beni", "Barış Manço"));
        songs.add(new Song("Ayrılamayız biz", "Pamela"));
        songs.add(new Song("Bailando", "Enrique Iglesias"));
        songs.add(new Song("Fikrimin ince gülü", "Müzeyyen Senar"));
        songs.add(new Song("Öyle kolaysa", "Mabel Matiz "));

        //Set the adapter for the list.
        final SongAdapter adapter = new SongAdapter(this, songs);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        //When click an item of the song list in Song Library Activity, then open Now Playing Activity
        // and to send  position variable of the song to the PlayingActivity.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //   Intent playingIntent = new Intent(LibraryActivity.this, PlayingActivity.class);
                // startActivity(playingIntent);
                Intent intent = new Intent(getApplicationContext(), PlayingActivity.class);
                intent.putExtra("Variable name", l);
                startActivity(intent);


                    Toast.makeText(getApplicationContext(), "Click the play button for playing the song which is chosen. ",Toast.LENGTH_LONG).show();


            }
            //Nowplayin yerine yenisi????
            // Intent playingIntent = new Intent(LibraryActivity.this, MainActivity.class);
            // startActivity(playingIntent);
            // Toast.makeText(LibraryActivity.this,  "Song is playing",Toast.LENGTH_LONG).show();           }
        });

    }
}
