package edu.paggiluis.login

import android.app.Application

class SharedApp: Application() {
    private val PREFS_NAME = "edu.paggiluis.login"
    private val SHARED_TOKEN = "token"
    private val SHARED_USERNAME = "username"

    companion object {
        lateinit var preferences: Preferences
            private set
    }

    override fun onCreate() {
        super.onCreate()
        preferences = Preferences()
    }

    inner class Preferences {
        private val prefs = applicationContext.getSharedPreferences(
            PREFS_NAME,
            MODE_PRIVATE
        )

        var username: String
            get() = prefs.getString(SHARED_USERNAME, "") ?: ""
            set(value) = prefs.edit().putString(SHARED_USERNAME, value).apply()

        var token: String
            get() = prefs.getString(SHARED_TOKEN, "") ?: ""
            set(value) = prefs.edit().putString(SHARED_TOKEN, value).apply()

        fun deleteToken() {
            prefs.edit().apply {
                remove(SHARED_TOKEN)
                apply()
            }
        }
    }
}