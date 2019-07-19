package com.stevecampos.jetpackmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

abstract class BaseViewModel : ViewModel() {

    private val _loading = MutableLiveData(false)

    /**
     * Show a progressbar loading if true
     */
    val loading: LiveData<Boolean>
        get() = _loading

    val _title = MutableLiveData("This is a message Guuuuurl!")

    val title: LiveData<String> get() = _title
    /**
     * Helper function to call a data load function with a loading spinner, errors will trigger a
     * snackbar.
     *
     * By marking `block` as `suspend` this creates a suspend lambda which can call suspend
     * functions.
     *
     * @param block lambda to actually load data. It is called in the viewModelScope. Before calling the
     *              lambda the loading spinner will display, after completion or error the loading
     *              spinner will stop
     */
    fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                _loading.value = true
                block()
            } catch (error: Exception) {
                _title.value = error.message
            } finally {
                _loading.value = false
            }
        }
    }
}