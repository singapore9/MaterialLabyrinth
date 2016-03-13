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
//    private MediaPlayer mp;
//    private Thread _music_thread = new Thread() {
//        public void run() {
//            mp = MediaPlayer.create(getActivity(), R.raw.music);
//            mp.setLooping(true);
//            mp.start();
//            mp.pause();
//        }
//    };

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        _sound_switch = (CheckBoxPreference) findPreference("sounds_switch");
//        _animation_switch = (CheckBoxPreference) findPreference("animation_switch");
        _accelerometr_switch = (CheckBoxPreference) findPreference("accelerometr_switch");

//        if (mp == null) {
//            _music_thread.start();
//        }
//        _sound_switch.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//            public boolean onPreferenceChange(Preference preference, Object newValue) {
//                if ((Boolean)newValue) {
//                    mp.start();
//                } else {
//                    mp.pause();
//                }
//                return true;
//            }
//        });


//        _animation_switch.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//            public boolean onPreferenceClick(Preference preference) {
//                return true;
//            }
//        });

        _accelerometr_switch.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                return false;
            }
        });

    }
}
