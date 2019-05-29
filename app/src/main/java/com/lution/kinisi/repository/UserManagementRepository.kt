package com.lution.kinisi.repository

import com.lution.kinisi.network.api.Api
import com.lution.kinisi.network.model.request.RegisterUserRequest

/**
 * Created by ivasil on 5/29/2019
 */

object UserManagementRepository {

    suspend fun registerRequest(email: String, firstname: String, lastname: String, gender: String,
                                password: String, repeatPassword: String): Int {

        val response = Api.apiClient.registerUser(
            RegisterUserRequest(
                email = email,
                firstname = firstname,
                lastname = lastname,
                gender = gender,
                password = password,
                repeatPassword = repeatPassword
            )
        ).await()

        return response.code()
    }
}