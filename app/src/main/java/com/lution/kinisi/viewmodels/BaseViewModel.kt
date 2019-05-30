package com.lution.kinisi.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Created by ivasil on 5/29/2019
 */

open class BaseViewModel: ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    val statusCode: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    private val job = Job()
}