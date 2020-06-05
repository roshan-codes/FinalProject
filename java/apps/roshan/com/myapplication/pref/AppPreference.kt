package apps.roshan.com.myapplication.pref

import android.content.Context
import android.content.SharedPreferences

open class AppPreference(context: Context, fileName: String) {
    var prefs: SharedPreferences =
        context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    private val KEY_IS_LOGIN = "KEY_IS_LOGIN"

    fun clearPreferences() {
        prefs.edit().clear().apply()
    }

    fun setLogin(value: Boolean) {
        prefs.edit().putBoolean(KEY_IS_LOGIN, value).apply()
    }

    fun isLogin(): Boolean {
        return prefs.getBoolean(KEY_IS_LOGIN, false)
    }

}