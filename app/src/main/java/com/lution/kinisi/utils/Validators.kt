package com.lution.kinisi.utils

import android.util.Patterns
import android.widget.EditText
import androidx.core.view.get
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.lang.reflect.TypeVariable

/**
 * Created by ivasil on 5/26/2019
 */

interface ValidatorType {

    fun isUserInputValid(editText: TextInputEditText, textInputLayout: TextInputLayout): Boolean
}

class BasicValidator:ValidatorType {
    override fun isUserInputValid(editText: TextInputEditText, textInputLayout: TextInputLayout): Boolean {

        return if(editText.text!!.isEmpty()) {

           textInputLayout.error = "Field can't be empty"
           false
        }
        else {

            textInputLayout.error = null
            true
        }
    }
}

class EmailValidator: ValidatorType {
    override fun isUserInputValid(editText: TextInputEditText, textInputLayout: TextInputLayout): Boolean {

        return if(!Patterns.EMAIL_ADDRESS.matcher(editText.text).matches()) {

            textInputLayout.error = "Please enter a proper email"
            false
        } else {

            textInputLayout.error = null
            true
        }
    }
}

class PasswordValidator: ValidatorType {
    override fun isUserInputValid(editText: TextInputEditText, textInputLayout: TextInputLayout): Boolean {

        return if(editText.text!!.length < 6) {

            textInputLayout.error = "Password must be longer"
            false
        }
        else {
            textInputLayout.error = null
            true
        }
    }
}

class Validator {

    fun validate(userInput: TextInputEditText, userTextBox: TextInputLayout, validatorType: ArrayList<ValidatorType>): Boolean {

        val isValid = true
        for(validator in validatorType) {

             if(!validator.isUserInputValid(userInput, userTextBox)) {

                 return false
             }
        }

        return isValid
    }
}