package com.stevecampos.jetpackmvvm

import com.stevecampos.jetpackmvvm.Result
import com.stevecampos.jetpackmvvm.Result.Success
import com.stevecampos.jetpackmvvm.Result.Loading
import com.stevecampos.jetpackmvvm.Result.Error
import retrofit2.Response

class TestRepository{
    var client: ApiFactory.TestService = ApiFactory.testApi
    suspend fun getUsers(): List<User> = client.getUsers()
}