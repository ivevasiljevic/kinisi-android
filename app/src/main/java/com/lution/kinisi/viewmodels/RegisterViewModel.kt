package com.lution.kinisi.viewmodels

import com.lution.kinisi.repository.UserManagementRepository
import kotlinx.coroutines.launch

/**
 * Created by ivasil on 5/29/2019
 */

class RegisterViewModel: BaseViewModel() {

    fun registerUser(email: String, firstname: String, lastname: String, gender: String,
                     password: String, repeatPassword: String) {

        launch {

            statusCode.postValue(UserManagementRepository.registerRequest(
                email, firstname, lastname, gender, password, repeatPassword
            ))
        }
    }
}