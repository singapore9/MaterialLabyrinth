package com.example.materiallabyrinth.app;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

/**
 * Created by andrew on 04.03.16.
 */
public class SettingsFragment extends PreferenceFragment{
    private SwitchPreference _sound_switch;
    private SwitchPreference _animation_switch;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        _sound_switch = (SwitchPreference) findPreference("sounds_switch");
        _animation_switch = (SwitchPreference) findPreference("animation_switch");

    }
}
