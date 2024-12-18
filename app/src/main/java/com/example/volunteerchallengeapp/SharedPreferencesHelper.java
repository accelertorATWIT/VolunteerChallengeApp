package com.example.volunteerchallengeapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedPreferencesHelper {

    private static final String PREF_NAME = "VolunteerAppPrefs";
    private static final String COMPLETED_CHALLENGES_KEY = "CompletedChallenges";
    private static final String CHALLENGERS_KEY = "Challengers";

    private SharedPreferences sharedPreferences;

    public SharedPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    // Retrieve completed challenges
    public Set<String> getCompletedChallenges() {
        Set<String> challenges = sharedPreferences.getStringSet(COMPLETED_CHALLENGES_KEY, new HashSet<>());
        Log.d("SharedPreferencesHelper", "Retrieved completed challenges: " + challenges);
        return challenges;
    }

    // Save a completed challenge
    public void saveCompletedChallenge(String challenge) {
        Set<String> completedChallenges = getCompletedChallenges();
        completedChallenges.add(challenge);
        sharedPreferences.edit().putStringSet(COMPLETED_CHALLENGES_KEY, completedChallenges).apply();
        Log.d("SharedPreferencesHelper", "Saved completed challenge: " + challenge);
    }

    // Retrieve challengers
    public List<Volunteer> getChallengers() {
        List<Volunteer> challengers = new ArrayList<>();
        String json = sharedPreferences.getString(CHALLENGERS_KEY, "[]");
        Log.d("SharedPreferencesHelper", "Retrieved challengers JSON: " + json);
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                int completedChallenges = jsonObject.getInt("completedChallenges");
                challengers.add(new Volunteer(name, completedChallenges));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return challengers;
    }

    // Save challengers
    public void saveChallengers(List<Volunteer> challengers) {
        JSONArray jsonArray = new JSONArray();
        for (Volunteer volunteer : challengers) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("name", volunteer.getName());
                jsonObject.put("completedChallenges", volunteer.getCompletedChallenges());
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        sharedPreferences.edit().putString(CHALLENGERS_KEY, jsonArray.toString()).apply();
        Log.d("SharedPreferencesHelper", "Saved challengers: " + jsonArray.toString());
    }
}
