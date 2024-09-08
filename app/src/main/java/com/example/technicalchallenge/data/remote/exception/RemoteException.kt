package com.example.technicalchallenge.data.remote.exception

import java.io.IOException

data class RemoteException(val code: Int, val body: String? = null) : IOException()
