package com.lution.kinisi.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 * Created by ivasil on 5/29/2019
 */


/**
 * Shows Snackbar inside of a View. Compatible with Activity and Fragment.
 *
 * @param message Text to be shown when Snackbar appears
 * @param duration Duration of the Snackbar
 */
fun View.snackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {

    Snackbar.make(this, message, duration).show()
}