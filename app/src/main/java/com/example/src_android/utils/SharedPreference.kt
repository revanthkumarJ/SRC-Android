package com.example.src_android.utils

import android.content.Context

class SharedPreference(context: Context) {

    private val sharedPreference = context.getSharedPreferences("src",Context.MODE_PRIVATE)
    private val editor = sharedPreference.edit()

    fun getThemePreference() : ThemePreference{
        val isDarkMode = sharedPreference.getBoolean("mode",true)
        return ThemePreference(isDarkMode)
    }

    fun setThemePreference(mode : Boolean) {
        editor.putBoolean("mode",mode)
        editor.commit()
    }

    fun getLoginStatus() : LoginStatus{
        val isLogged = sharedPreference.getBoolean("loginStatus",false)
        return LoginStatus(isLogged)
    }
    fun setLoggedStatus(isLogged : Boolean){
        editor.putBoolean("loginStatus",isLogged)
        editor.commit()
    }

    fun getEmail() : Email{
        val email = sharedPreference.getString("email",null)
        return Email(email)
    }

    fun setEmail(email : String?){
        editor.putString("email",email)
        editor.commit()
    }

    fun getUsername() : Username{
        val username = sharedPreference.getString("username",null)
        return Username(username)
    }

    fun setUsername(username :String?){
        editor.putString("username",username)
        editor.commit()
    }

    fun getAuthToken() : AuthToken{
        val authToken = sharedPreference.getString("authToken",null)
        return AuthToken(authToken)
    }

    fun setAuthToken(authToken : String?){
        editor.putString("authToken",authToken)
        editor.commit()
    }
    fun setIsCR(isCR : Boolean){
        editor.putBoolean("isCR",isCR)
        editor.commit()
    }
    fun getIsCR() : CR{
        val isCR = sharedPreference.getBoolean("isCR",false)
        return CR(isCR)
    }

    fun setRole(role : String){
        editor.putString("role",role)
        editor.commit()
    }
    fun getRole() : Role{
        val role = sharedPreference.getString("role","user")
        return Role(role)
    }
}

data class LoginStatus(
    val isLogged : Boolean,
)
data class Email(
    val email : String?=null
)
data class Username(
    val username : String?=null
)
data class AuthToken(
    val authToken : String?=null
)
data class ThemePreference(
    val mode : Boolean
)
data class CR(
    val isCR : Boolean?=false
)

data class Role(
    val role : String?="user"
)