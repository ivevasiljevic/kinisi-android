package com.lution.kinisi.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.lution.kinisi.R

/**
 * Created by ivasil on 5/26/2019
 */

class ExposedDropdownMenuPopupItemAdapter(context: Context, viewId: Int, genders: ArrayList<String> = arrayListOf("Male", "Female", "Other")) :
    ArrayAdapter<String>(context, viewId, genders)