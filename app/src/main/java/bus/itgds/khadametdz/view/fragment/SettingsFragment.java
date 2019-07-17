package bus.itgds.khadametdz.view.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

import bus.itgds.khadametdz.R;

public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* set preferences */
        addPreferencesFromResource(R.xml.preferences);
    }

    //https://code.tutsplus.com/tutorials/how-to-code-a-settings-screen-in-an-android-app--cms-30433
    //https://guides.codepath.com/android/settings-with-preferencefragment
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        /* get preference */
        Preference preference = findPreference(key);

        /* update summary */
        if (key.equals("key_language")) {
            preference.setSummary(((ListPreference) preference).getEntry());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }
}
