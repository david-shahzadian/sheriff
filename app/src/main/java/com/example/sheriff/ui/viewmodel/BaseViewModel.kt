package com.example.sheriff.ui.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sheriff.ui.viewstate.ViewState

/**
 * Base class for all view model classes
 * @param VS view state class type
 */
abstract class BaseViewModel<VS: ViewState> : ViewModel() {

    /**
     * Local mutable live data instance to change the view state
     */
    private val _liveData: MutableLiveData<VS> = MutableLiveData()

    /**
     * Public live data instance for the view to observe state changes
     */
    val liveData: LiveData<VS> = _liveData

    /**
     * Call when the view is initialized
     */
    fun onInit() {
        onViewInit()
    }

    /**
     * Called when the view bound to this view model is initialized
     */
    @CallSuper
    protected open fun onViewInit() {
//        Override if needed
    }

    /**
     * Changes the view state
     */
    protected fun changeState(state: VS) {
        _liveData.value = state
    }
}