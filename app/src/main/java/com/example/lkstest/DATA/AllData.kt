package com.example.lkstest.DATA

import java.util.Date

data class LoginResponse (
    var email: String,
    var password: String
)

data class LoginRequest (
    var token: String,
    var user: UserDto
)

data class UserDto(
    var id: Int,
    var name: String,
    var email: String,
    var departement: String
)

data class claimItem(
    var id: Int,
    var description: String,
    var amount: Double,
    var spentOn: Date,
    var reciptNumber: String
)
