package heal.com.healdoctor.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * This class is used to read and write data to shared preferences file of the app
 */
public class SharedPreferenceHelper {
    private static SharedPreferenceHelper sharedPreferenceHelper;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferencesEditor;

    private SharedPreferenceHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("com.healpatient.healPreferences", Context.MODE_PRIVATE);
    }

    /**
     * Creates single instance of SharedPreferenceHelper
     *
     * @param context context of Activity or Service
     * @return Returns instance of SharedPreferenceHelper
     */
    public static synchronized SharedPreferenceHelper getInstance(Context context) {

        if (sharedPreferenceHelper == null) {
            sharedPreferenceHelper = new SharedPreferenceHelper(context.getApplicationContext());
        }
        return sharedPreferenceHelper;
    }

    /**
     * Stores String value in preference
     *
     * @param key   key of preference
     * @param value value for that key
     */
    public void setValue(String key, String value) {
        sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putString(key, value);
        sharedPreferencesEditor.apply();
    }

    /**
     * Stores int value in preference
     *
     * @param key   key of preference
     * @param value value for that key
     */
    public void setValue(String key, int value) {
        sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putInt(key, value);
        sharedPreferencesEditor.apply();
    }

    /**
     * Stores Double value in String format in preference
     *
     * @param key   key of preference
     * @param value value for that key
     */
    public void setValue(String key, double value) {
        setValue(key, Double.toString(value));
    }

    /**
     * Stores long value in preference
     *
     * @param key   key of preference
     * @param value value for that key
     */
    public void setValue(String key, long value) {
        sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putLong(key, value);
        sharedPreferencesEditor.apply();
    }

    /**
     * Stores boolean value in preference
     *
     * @param key   key of preference
     * @param value value for that key
     */
    public void setValue(String key, boolean value) {
        sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putBoolean(key, value);
        sharedPreferencesEditor.apply();
    }

    /**
     * Retrieves String value from preference
     *
     * @param key          key of preference
     * @param defaultValue default value if no key found
     */
    public String getStringValue(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    /**
     * Retrieves int value from preference
     *
     * @param key          key of preference
     * @param defaultValue default value if no key found
     */
    public int getIntValue(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    /**
     * Retrieves long value from preference
     *
     * @param key          key of preference
     * @param defaultValue default value if no key found
     */
    public long getLongValue(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    /**
     * Retrieves boolean value from preference
     *
     * @param keyFlag      key of preference
     * @param defaultValue default value if no key found
     */
    public boolean getBooleanValue(String keyFlag, boolean defaultValue) {
        return sharedPreferences.getBoolean(keyFlag, defaultValue);
    }

    /**
     * Removes key from preference
     *
     * @param key key of preference that is to be deleted
     */
    public void removeKey(String key) {
        if (sharedPreferencesEditor != null) {
            sharedPreferencesEditor.remove(key);
            sharedPreferencesEditor.commit();
        }
    }


    /**
     * Clears all the preferences stored
     */
    public void clear() {
        sharedPreferencesEditor.clear().commit();
    }

    public interface Keys {
        String PREF_MOBILE_NUMBER = "PREF_MOBILE_NUMBER";
        String PREF_IS_FIRST_LAUNCH = "PREF_IS_FIRST_LAUNCH";
        String AUTH_TOKEN = "AUTH_TOKEN";
        String KEY_LOGIN = "KEY_LOGIN";
        String STATUS_INACTIVE = "STATUS_INACTIVE";
        String KEY_MOBILE_MODEL = "KEY_MOBILE_MODEL";
        String PATIENT_ID = "KEY_PATIENT_ID";
    }
}