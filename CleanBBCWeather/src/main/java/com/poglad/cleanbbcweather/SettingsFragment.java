package com.poglad.cleanbbcweather;

import android.preference.PreferenceFragment;
import android.os.Bundle;

/**
 * Created by Paul on 28/12/13.
 */
public class SettingsFragment extends PreferenceFragment
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	// Load the preferences from an XML resource
	addPreferencesFromResource(R.xml.preferences);
    }
}