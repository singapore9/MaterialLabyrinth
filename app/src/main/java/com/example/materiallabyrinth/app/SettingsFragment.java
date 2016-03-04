package com.example.materiallabyrinth.app;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by andrew on 04.03.16.
 */
public class SettingsFragment extends PreferenceFragment{
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
