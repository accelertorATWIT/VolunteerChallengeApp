package com.example.volunteerchallengeapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RankingsActivity extends AppCompatActivity {

    private ListView lvRankings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);

        lvRankings = findViewById(R.id.lvRankings);

        ArrayList<String> rankings = new ArrayList<>();
        rankings.add("1. Volunteer A - 10 challenges");
        rankings.add("2. Volunteer B - 8 challenges");
        rankings.add("3. Volunteer C - 5 challenges");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rankings);
        lvRankings.setAdapter(adapter);
    }
}
