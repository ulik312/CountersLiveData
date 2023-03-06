package com.sbor.counterslivedata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() = _counter

    val _operations = MutableLiveData<ArrayList<String>>()
    val operations: ArrayList<String> = ArrayList()

    init {
        _counter.value = 0
    }

    fun increment() {
        _counter.value = (_counter.value ?: 0) + 1
        operations.add("+")
        _operations.value = operations
    }

    fun decrement() {
        _counter.value = (_counter.value ?: 0) - 1
        operations.add("-")
        _operations.value = operations
    }
}