package cyber.app.xsapp;

import android.app.Application;
import android.content.SharedPreferences;

public class Preferences extends Application {
	// Preferences Constants
	private final String PREFERENCES_NAME = "preferences";
	private final String LANGUAGE = "language";

	private SharedPreferences preferences;
	private static Preferences pre;

	@Override
	public void onCreate() {
		super.onCreate();
		pre = this;
		preferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
	}

	/**
	 * Get an instance of Preferences
	 * 
	 * @return
	 */
	public static Preferences getInstance() {
		return pre;
	}

	/**
	 * Save default language to preference
	 * 
	 * @param lan
	 *            language
	 */
	public void saveLanguage(String lan) {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString(LANGUAGE, lan);
		editor.commit();
	}

	/**
	 * Get server default language info from preference
	 * 
	 * @return null if not exist
	 */
	public String getLanguage() {
		return preferences.getString(LANGUAGE, null);
	}

	/**
	 * Remove all store info
	 */
	public void removeAll() {
		Thread.setDefaultUncaughtExceptionHandler(null);
		System.gc();
	}
}
