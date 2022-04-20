package com.example.assetlogin

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


object AppPreferences {
    private var sharedPreferences: SharedPreferences? = null

    // TODO step 1: call `AppPreferences.setup(applicationContext)` in your MainActivity's `onCreate` method
    fun setup(context: Context) {
        // TODO step 2: set your app name here
        sharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), MODE_PRIVATE)
    }

    // TODO step 4: replace these example attributes with your stored values
    var AppAdminLoggedIn: Boolean?
        get() = Key.APP_ADMIN_LOGGED_IN.getBoolean()
        set(value) = Key.APP_ADMIN_LOGGED_IN.setBoolean(value).apply()

    var AppGuestLoggedIn: Boolean?
        get() = Key.APP_GUEST_LOGGED_IN.getBoolean()
        set(value) = Key.APP_GUEST_LOGGED_IN.setBoolean(value).apply()

    var AppDepartmentLoggedIn: Int?
        get() = Key.DEPARTMENT_LOGIN.getInt()
        set(value) = Key.DEPARTMENT_LOGIN.setInt(value).apply()

    var AutoLogOut: Boolean?
        get() = Key.AUTO_LOG_OUT.getBoolean()
        set(value) = Key.AUTO_LOG_OUT.setBoolean(value).apply()

    //
    var LoggedInUserId: Int?
        get() = Key.LOGGED_IN_USER_ID.getInt()
        set(value) = Key.LOGGED_IN_USER_ID.setInt(value).apply()


    var unitId: Int?
        get() = Key.USER_UNITID.getInt()
        set(value) = Key.USER_UNITID.setInt(value).apply()


    var AuthToken: String?
        get() = Key.AUTH_TOKEN.getString()
        set(value) = Key.AUTH_TOKEN.setString(value).apply()

    var LoggedInGuestUserId: Int?
        get() = Key.LOGGED_IN_GUEST_USER_ID.getInt()
        set(value) = Key.LOGGED_IN_GUEST_USER_ID.setInt(value).apply()

    var timeValue: Long?
        get() = Key.RESEND_OTP_TIMER.getLong()
        set(value) = Key.RESEND_OTP_TIMER.setLong(value).apply()


    fun removeAll() = sharedPreferences!!.edit().clear().commit()

    private enum class Key {
        APP_ADMIN_LOGGED_IN, APP_GUEST_LOGGED_IN, LOGGED_IN_USER_ID, LOGGED_IN_GUEST_USER_ID, RESEND_OTP_TIMER, AUTO_LOG_OUT, AUTH_TOKEN, DEPARTMENT_LOGIN, USER_UNITID; // TODO step 3: replace these cases with your stored values keys

        fun getBoolean(): Boolean? =
            if (sharedPreferences!!.contains(name)) sharedPreferences!!.getBoolean(
                name,
                false
            ) else null

        fun getFloat(): Float? =
            if (sharedPreferences!!.contains(name)) sharedPreferences!!.getFloat(name, 0f) else null

        fun getInt(): Int? =
            if (sharedPreferences!!.contains(name)) sharedPreferences!!.getInt(name, 0) else null

        fun getLong(): Long? =
            if (sharedPreferences!!.contains(name)) sharedPreferences!!.getLong(name, 0) else null

        fun getString(): String? =
            if (sharedPreferences!!.contains(name)) sharedPreferences!!.getString(
                name,
                ""
            ) else null

        fun setBoolean(value: Boolean?) =
            value?.let { sharedPreferences!!.edit().putBoolean(name, value) } ?: remove()

        fun setFloat(value: Float?) =
            value?.let { sharedPreferences!!.edit().putFloat(name, value) } ?: remove()

        fun setInt(value: Int?) =
            value?.let { sharedPreferences!!.edit().putInt(name, value) } ?: remove()

        fun setLong(value: Long?) =
            value?.let { sharedPreferences!!.edit().putLong(name, value) } ?: remove()

        fun setString(value: String?) =
            value?.let { sharedPreferences!!.edit().putString(name, value) } ?: remove()

        fun remove() = sharedPreferences!!.edit().remove(name)


    }
}