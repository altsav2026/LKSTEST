package com.example.lkstest.DATA

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.lkstest.API.APIClient

enum class Screen {Login, ClaimList, ClaimDetail, NewClaim, EditClaim, Categories, Summary}
class AppViewModel {
    class Navigator(start: Screen) {
        private val stack = mutableStateListOf(start)
        val current: Screen get() = stack.last()
        val canPop: Boolean get() = stack.size > 1
        fun push(s: Screen) { stack.add(s) }
        fun pop() { if (canPop) stack.removeAt(stack.lastIndex) }
        fun replaceAll(s: Screen) { stack.clear(); stack.add(s) }
    }

    var loginLoading by mutableStateOf<Boolean>(false)
    var loginError by mutableStateOf<String>("")


    fun login(email: String, password: String) {
        try {
            APIClient.Login(email, password)
        }
    }
}