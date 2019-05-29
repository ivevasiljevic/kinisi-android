package com.lution.kinisi.network.api

import com.lution.kinisi.network.model.request.RegisterUserRequest
import com.lution.kinisi.network.model.response.RegisterUserResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by ivasil on 5/29/2019
 */

interface AdiServiceUserManagement {

    @POST("users")
    fun registerUser(@Body registerUserRequest: RegisterUserRequest) : Deferred<Response<RegisterUserResponse>>
}