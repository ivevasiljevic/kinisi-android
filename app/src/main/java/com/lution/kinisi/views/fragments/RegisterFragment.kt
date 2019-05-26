package com.lution.kinisi.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lution.kinisi.R
import com.lution.kinisi.adapters.ExposedDropdownMenuPopupItemAdapter
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private val genders = arrayListOf("Male", "Female", "Other")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDropdownMenuPopupItemAdapter()
    }

    private fun setDropdownMenuPopupItemAdapter() {

        exposedDropdownMenu.setAdapter(ExposedDropdownMenuPopupItemAdapter(context!!, R.layout.exposed_dropdown_menu_popup_item, genders))
    }
}
