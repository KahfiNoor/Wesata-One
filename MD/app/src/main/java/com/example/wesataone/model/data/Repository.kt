//package com.example.wesataone.model.data
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.liveData
//import com.example.wesataone.model.data.local.datastore.Preferences
//import com.example.wesataone.model.data.remote.response.ErrorResponse
//import com.example.wesataone.model.data.remote.response.RegisterResponse
//import com.example.wesataone.model.data.remote.retrofit.ApiService
//import com.google.gson.Gson
//import kotlinx.coroutines.flow.Flow
//import retrofit2.HttpException
//
//class Repository(
//    private val apiService: ApiService,
//    private val preferences: Preferences
//) {
//    fun signup(name: String, email: String, password: String): LiveData<ResultState<RegisterResponse>> = liveData{
//        emit(ResultState.Loading)
//        try {
//            val response = apiService.signup(name,email,password)
//            emit(ResultState.Success(response))
//        }catch (e: HttpException){
//            val error = e.response()?.errorBody()?.string()
//            val body = Gson().fromJson(error, ErrorResponse::class.java)
//            emit(ResultState.Error(body.message))
//        }
//    }
//
//    fun login(email: String,password: String): LiveData<ResultState<LoginRes>> = liveData{
//        emit(ResultState.Loading)
//        try {
//            val response = apiService.signin(email,password)
//            emit(ResultState.Success(response))
//        }catch (e:HttpException){
//            val error = e.response()?.errorBody()?.string()
//            val body = Gson().fromJson(error, ErrorResponse::class.java)
//            emit(ResultState.Error(body.message))
//        }
//    }
//
//    suspend fun saveSession(user: UserModel){
//        preferences.saveSession(user)
//    }
//    fun getSession(): Flow<UserModel> {
//        return preferences.getSession()
//    }
//    suspend fun logout() {
//        preferences.logout()
//    }
//    companion object {
//        private var INSTANCE: Repository? = null
//
//        fun clearInstance(){
//            INSTANCE = null
//        }
//        fun getInstance(
//            apiService: ApiService,
//            preferences: Preferences
//        ): Repository =
//            INSTANCE ?: synchronized(this){
//                INSTANCE ?: Repository(apiService, preferences)
//            }.also { INSTANCE = it }
//    }
//}