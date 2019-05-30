package com.lution.kinisi.network.model.response

import com.squareup.moshi.Json

/**
 * Created by ivasil on 5/29/2019
 */

class RegisterUserResponse(@field:Json(name = "email") val email: String, @field:Json(name = "fullName") val fullname: String,
                           @field:Json(name = "gender") val gender: String, @field:Json(name = "birthday") val birthday: String)