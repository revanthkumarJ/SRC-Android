package com.example.src_android.features.login.presentation.loginViewModel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.src_android.core.data.repo.UserRepo
import com.example.src_android.core.domain.models.user.User
import com.example.src_android.utils.Email
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.src_android.utils.SharedPreference
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val userRepo: UserRepo, private val application:
    Application,
    private val retrofit: Retrofit
) : ViewModel() {

    private var sharedPreference = SharedPreference(application)

    private val userLiveData = MutableLiveData<User?>()

    var email = mutableStateOf("")
    var password = mutableStateOf("")

    private var _message = MutableLiveData<String?>(null)
    private val _emailShared = MutableLiveData<String?>(sharedPreference.getEmail().email)
    private val _usernameShared = MutableLiveData<String?>(sharedPreference.getUsername().username)
    private val _authToken = MutableLiveData<String?>(sharedPreference.getAuthToken().authToken)
    private val _loginStatus = MutableLiveData(sharedPreference.getLoginStatus().isLogged)
    private val _isAdmin = MutableLiveData<String?>(sharedPreference.getRole().role)
    private val _isCr = MutableLiveData<Boolean?>(sharedPreference.getIsCR().isCR)
    private val _loginCheck = MutableLiveData(false)
    private val _btnDisable = MutableLiveData<Boolean>()

    val userLiveDataObj: LiveData<User?> get() = userLiveData
    val messageObj: LiveData<String?> get() = _message
    val emailObj: LiveData<String?> get() = _emailShared
    val usernameObj: LiveData<String?> get() = _usernameShared
    val authTokenObj: LiveData<String?> get() = _authToken
    val loginStatusObj: LiveData<Boolean> get() = _loginStatus
    val loginCheckObj: LiveData<Boolean> get() = _loginCheck
    val role : LiveData<String?> get() = _isAdmin
    val level : LiveData<Boolean?> get() = _isCr
    val btnDisable : LiveData<Boolean> get() = _btnDisable

    init {
        val initialEmail = sharedPreference.getEmail().email
        val initialUsername = sharedPreference.getUsername().username
        val initialAuthToken = sharedPreference.getAuthToken().authToken
        val initialLoginStatus = sharedPreference.getLoginStatus().isLogged
        val initialRole = sharedPreference.getRole().role
        val initialIsCr = sharedPreference.getIsCR().isCR

        _emailShared.postValue(initialEmail)
        _usernameShared.postValue(initialUsername)
        _authToken.postValue(initialAuthToken)
        _loginStatus.postValue(initialLoginStatus)
        _isAdmin.postValue(initialRole)
        _isCr.postValue(initialIsCr)

        Log.d("arjun", "Initial email: $initialEmail")
        Log.d("arjun", "Initial username: $initialUsername")
        Log.d("arjun", "Initial authToken: $initialAuthToken")
        Log.d("arjun", "Initial loginStatus: $initialLoginStatus")
        Log.d("arjun", "Initial initialRole: $initialRole")
        Log.d("arjun", "Initial initialIsCr: $initialIsCr")
    }

    fun getUserByEmail() {
        val userPayload = mapOf(
            "email" to email.value,
            "password" to password.value
        )
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = userRepo.loginUser(userPayload)
                Log.d("arjun", userPayload.toString())
                _btnDisable.postValue(false)
                if (res.isSuccessful) {
                    userLiveData.postValue(res.body())
                    Log.d("arjun", "res.body: ${res.body().toString()}")
                    userLiveData.value?.data?.let { it ->
                        val userEmail = it.user?.email
                        val userName = it.user?.name
                        val userToken = it.token
                        val role = it.user?.role
                        val level = it.user?.isCr
                        _emailShared.postValue(userEmail)
                        _usernameShared.postValue(userName)
                        _authToken.postValue(userToken)
                        _loginStatus.postValue(true)
                        _isAdmin.postValue(role)
                        _isCr.postValue(level)

                        sharedPreference.setAuthToken(userToken)
                        sharedPreference.setEmail(userEmail)
                        sharedPreference.setUsername(userName)
                        sharedPreference.setLoggedStatus(true)
                        if (role != null) {
                            sharedPreference.setRole(role)
                        }
                        if (level != null) {
                            sharedPreference.setIsCR(level)
                        }

                        Log.d("arjun", "Updated email: $userEmail")
                        Log.d("arjun", "Updated username: $userName")
                        Log.d("arjun", "Updated loginStatus: ${_loginStatus.value}")
                        Log.d("arjun", "Updated authToken: ${_authToken.value}")
                        Log.d("arjun", "Updated role: ${_isAdmin.value}")
                        Log.d("arjun", "Updated cr: ${_isCr.value}")

                    }
                    _loginCheck.postValue(true)
                    email.value = ""
                    password.value = ""
                    _message.postValue("Successfully logged in")
                    _btnDisable.postValue(true)
                } else {
                    Log.d("arjun", "error ${res.errorBody().toString()}")

                    res.errorBody()?.let { errorBody ->
                        val converter = retrofit.responseBodyConverter<User>(
                            User::class.java, arrayOfNulls(0)
                        )
                        val errorResponse = converter.convert(errorBody)
                        Log.d("arjun", "error $errorResponse")
                        _message.postValue(errorResponse?.err.toString())
                    }
                    _btnDisable.postValue(true)
                }
            } catch (e: Exception) {
                Log.d("arjun", "error at catch $e")
                _btnDisable.postValue(true)
            }
        }
    }

    fun clearSnackbarMessage() {
        _message.postValue(null)
    }


    fun updateLoginStatus() {
        viewModelScope.launch(Dispatchers.IO) {
            _loginCheck.postValue(false)
            _usernameShared.postValue("user")
            _loginStatus.postValue(false)
            _emailShared.postValue(null)
            _authToken.postValue(null)
            _isAdmin.postValue("user")
            _isCr.postValue(false)

            sharedPreference.setLoggedStatus(false)
            sharedPreference.setAuthToken(null)
            sharedPreference.setEmail(null)
            sharedPreference.setUsername(null)
            sharedPreference.setIsCR(false)
            sharedPreference.setRole("user")

        }
        _message.postValue("Successfully logged out")
    }


}
