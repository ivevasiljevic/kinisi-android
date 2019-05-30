package com.lution.kinisi.repository

import com.lution.kinisi.network.api.ApiClient
import com.lution.kinisi.network.model.request.RegisterUserRequest

/**
 * Created by ivasil on 5/29/2019
 */

object UserManagementRepository {

    suspend fun registerRequest(email: String, fullname: String, gender: String,
                                password: String, repeatPassword: String): Int {

        val response = ApiClient.apiClient.registerUser(
            RegisterUserRequest(
                email = email,
                fullname = fullname,
                gender = gender,
                password = password,
                repeatPassword = repeatPassword
            )
        ).await()

        return response.code()
    }
}