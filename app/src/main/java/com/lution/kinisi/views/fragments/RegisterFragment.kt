package com.lution.kinisi.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.lution.kinisi.R
import com.lution.kinisi.adapters.ExposedDropdownMenuPopupItemAdapter
import com.lution.kinisi.extensions.snackbar
import com.lution.kinisi.utils.BasicValidator
import com.lution.kinisi.utils.EmailValidator
import com.lution.kinisi.utils.PasswordValidator
import com.lution.kinisi.utils.Validator
import com.lution.kinisi.viewmodels.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private lateinit var validator: Validator
    lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerViewModel = RegisterViewModel()
        validator = Validator()
        setDropdownMenuPopupItemAdapter()

        registerButton.setOnClickListener {

            makeRegisterRequest()
        }

        registerViewModel.statusCode.observe(viewLifecycleOwner, Observer {

            if(it == 201) {

                registerScreenLayout.snackbar("User is successfully registered")
            }
            else {

                registerScreenLayout.snackbar("User failed to register")
            }
        })
    }

    private fun setDropdownMenuPopupItemAdapter() {

        exposedDropdownMenu.setAdapter(ExposedDropdownMenuPopupItemAdapter(context!!, R.layout.exposed_dropdown_menu_popup_item))
    }

    private fun makeRegisterRequest() {

        if(validateUserBasicInputs() && validateUserEmail() && validateUserPassword()) {

            registerViewModel.registerUser(
                editTextEmail.text.toString(),
                editTextFirstname.text.toString(),
                editTextLastname.text.toString(),
                exposedDropdownMenu.text.toString(),
                editTextPassword.text.toString(),
                editTextRepeatPassword.text.toString()
            )
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
