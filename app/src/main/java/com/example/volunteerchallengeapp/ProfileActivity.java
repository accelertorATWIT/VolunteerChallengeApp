package com.example.volunteerchallengeapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvCompletedChallenges;
    private SharedPreferencesHelper sharedPreferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvCompletedChallenges = findViewById(R.id.tvCompletedChallenges);
        sharedPreferencesHelper = new SharedPreferencesHelper(this);

        // Retrieve and display completed challenges
        Set<String> completedChallenges = sharedPreferencesHelper.getCompletedChallenges();
        tvCompletedChallenges.setText("Completed Challenges: " + completedChallenges.size());
        Log.d("ProfileActivity", "Completed Challenges Count: " + completedChallenges.size());
    }
}
