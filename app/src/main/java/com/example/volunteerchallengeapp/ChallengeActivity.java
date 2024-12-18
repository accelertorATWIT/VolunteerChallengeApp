package com.example.volunteerchallengeapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ChallengeActivity extends AppCompatActivity {

    private ListView lvChallenges;
    private SharedPreferencesHelper sharedPreferencesHelper;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        lvChallenges = findViewById(R.id.lvChallenges);
        sharedPreferencesHelper = new SharedPreferencesHelper(this);

        username = getIntent().getStringExtra("USERNAME");

        // Generate 100 challenges
        ArrayList<String> challenges = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            challenges.add("Challenge " + i + ": Complete task " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, challenges);
        lvChallenges.setAdapter(adapter);

        lvChallenges.setOnItemClickListener((parent, view, position, id) -> {
            String selectedChallenge = challenges.get(position);
            List<Volunteer> challengers = sharedPreferencesHelper.getChallengers();
            Volunteer currentVolunteer = null;

            for (Volunteer volunteer : challengers) {
                if (volunteer.getName().equals(username)) {
                    currentVolunteer = volunteer;
                    break;
                }
            }

            if (currentVolunteer == null) {
                currentVolunteer = new Volunteer(username, 0);
                challengers.add(currentVolunteer);
            }

            if (position + 1 > currentVolunteer.getCompletedChallenges()) {
                currentVolunteer.setCompletedChallenges(position + 1);
                sharedPreferencesHelper.saveChallengers(challengers);
                sharedPreferencesHelper.saveCompletedChallenge(selectedChallenge);
                Toast.makeText(this, "Challenge completed: " + selectedChallenge, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Challenge already completed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
