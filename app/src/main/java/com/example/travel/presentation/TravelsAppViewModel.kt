package com.example.travel.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class TravelsAppViewModel: ViewModel() {
    fun launchCatching(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch (
            CoroutineExceptionHandler{ _, throwable ->
                Log.d("Travel app error", throwable.message.orEmpty())
            },
            block = block
        )
}