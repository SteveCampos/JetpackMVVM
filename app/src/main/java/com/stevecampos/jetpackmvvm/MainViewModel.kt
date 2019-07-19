package com.stevecampos.jetpackmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel : BaseViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users

    val repository: TestRepository = TestRepository()
    fun onRefreshData() {
        launchDataLoad {
            _users.value = repository.getUsers();
        }
    }
}