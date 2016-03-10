package com.example.materiallabyrinth.app;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Created by andrew on 04.03.16.
 */
public class SettingsFragment extends PreferenceFragment{
    private CheckBoxPreference _sound_switch;
    private CheckBoxPreference _animation_switch;
    private CheckBoxPreference _accelerometr_switch;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        _sound_switch = (CheckBoxPreference) findPreference("sounds_switch");
        _animation_switch = (CheckBoxPreference) findPreference("animation_switch");
        _accelerometr_switch = (CheckBoxPreference) findPreference("accelerometr_switch");

        _sound_switch.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                return true;
            }
        });

        _animation_switch.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                return true;
            }
        });

        _accelerometr_switch.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                return true;
            }
        });

    }
}
