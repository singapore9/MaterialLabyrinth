package com.example.materiallabyrinth.app;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

/**
 * Created by andrew on 04.03.16.
 */
public class SettingsFragment extends PreferenceFragment{
    private SwitchPreference _sound_switch;
    private SwitchPreference _animation_switch;
    private SwitchPreference _accelerometr_switch;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        _sound_switch = (SwitchPreference) findPreference("sounds_switch");
        _animation_switch = (SwitchPreference) findPreference("animation_switch");
        _accelerometr_switch = (SwitchPreference) findPreference("accelerometr_switch");



        _accelerometr_switch.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                return false;
            }
        });

    }
}
