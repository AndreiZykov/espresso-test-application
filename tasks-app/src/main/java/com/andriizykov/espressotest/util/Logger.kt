package com.andriizykov.espressotest.util

import android.util.Log
import javax.inject.Inject

class Logger @Inject constructor() {

    fun e(th: Throwable){
        Log.e(TAG, th.localizedMessage ?: "ERROR MESSAGE IS NULL")
    }

    companion object {
        private val TAG = "LOGGER::TASKS:APP"
    }

}