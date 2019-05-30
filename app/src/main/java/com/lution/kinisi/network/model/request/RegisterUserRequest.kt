package com.lution.kinisi.network.model.request

import com.squareup.moshi.Json

/**
 * Created by ivasil on 5/29/2019
 */

data class RegisterUserRequest(@field:Json(name = "email") val email: String, @field:Json(name = "fullName") val fullname: String,
                               @field:Json(name = "gender") val gender: String, @field:Json(name = "birthday") val birthday: String = "2019-05-29T14:57:10.287Z",
                               @field:Json(name = "plainPassword") val password: String, @field:Json(name = "repeatedPassword") val repeatPassword: String)
