package com.example.volunteerchallengeapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    private Button btnChallenges, btnProfile, btnRankings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable vector compatibility
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        setContentView(R.layout.activity_main);

        btnChallenges = findViewById(R.id.btnChallenges);
        btnProfile = findViewById(R.id.btnProfile);
        btnRankings = findViewById(R.id.btnRankings);

        btnChallenges.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ChallengeActivity.class)));
        btnProfile.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProfileActivity.class)));
        btnRankings.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RankingsActivity.class)));
    }
}
