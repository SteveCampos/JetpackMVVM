package com.stevecampos.jetpackmvvm
/*
* Interface to the data layer
* */
interface Repository {
    suspend fun getUsers(): List<User>
}
