package com.lution.kinisi.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lution.kinisi.R
import com.lution.kinisi.adapters.ExposedDropdownMenuPopupItemAdapter
import com.lution.kinisi.utils.BasicValidator
import com.lution.kinisi.utils.EmailValidator
import com.lution.kinisi.utils.PasswordValidator
import com.lution.kinisi.utils.Validator
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private val genders = arrayListOf("Male", "Female", "Other")
    private lateinit var validator: Validator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        validator = Validator()
        setDropdownMenuPopupItemAdapter()

        registerButton.setOnClickListener {

            makeRegisterRequest()
        }
    }

    private fun setDropdownMenuPopupItemAdapter() {

        exposedDropdownMenu.setAdapter(ExposedDropdownMenuPopupItemAdapter(context!!, R.layout.exposed_dropdown_menu_popup_item, genders))
    }

    private fun makeRegisterRequest() {

        if(validateUserBasicInputs() && validateUserEmail() && validateUserPassword()) {

            //do request to server
        }
    }

    private fun validateUserEmail(): Boolean {

        return validator.validate(editTextEmail, textInputEmail, arrayListOf(BasicValidator(), EmailValidator()))
    }

    private fun validateUserPassword(): Boolean {

        return validator.validate(editTextPassword, textInputPassword, arrayListOf(BasicValidator(), PasswordValidator()))
                && validator.validate(editTextRepeatPassword, textInputRepeatPassword, arrayListOf(BasicValidator(), PasswordValidator()))
    }

    private fun validateUserBasicInputs(): Boolean {

        return validator.validate(editTextFirstname, textInputFirstname, arrayListOf(BasicValidator()))
                && validator.validate(editTextLastname, textInputLastname, arrayListOf(BasicValidator()))
    }
}
