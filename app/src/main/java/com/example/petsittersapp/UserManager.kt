package com.example.petsittersapp

import android.content.Context
import android.content.SharedPreferences

class UserManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_USER_NAME = "userName"
        private const val KEY_USER_EMAIL = "userEmail"
        private const val KEY_USER_PASSWORD = "userPassword"
        private const val KEY_USER_BALANCE = "userBalance"
    }

    fun registerUser(name: String, email: String, password: String): Boolean {
        if (sharedPreferences.contains(KEY_USER_EMAIL)) {
            return false
        }
        sharedPreferences.edit().apply {
            putString(KEY_USER_NAME, name)
            putString(KEY_USER_EMAIL, email)
            putString(KEY_USER_PASSWORD, password)
            putFloat(KEY_USER_BALANCE, 500.0f)
            apply()
        }
        return true
    }

    fun loginUser(email: String, password: String): Boolean {
        val savedEmail = sharedPreferences.getString(KEY_USER_EMAIL, null)
        val savedPassword = sharedPreferences.getString(KEY_USER_PASSWORD, null)

        return email == savedEmail && password == savedPassword
    }

    fun getUserName(): String? {
        return sharedPreferences.getString(KEY_USER_NAME, null)
    }

    fun resetUser() {
        sharedPreferences.edit().clear().apply()
    }

    fun saveUserBalance(balance: Float) {
        sharedPreferences.edit().putFloat(KEY_USER_BALANCE, balance).apply()
    }

    fun getUserBalance(): Float {
        return sharedPreferences.getFloat(KEY_USER_BALANCE, 0.0f)
    }


}
