package com.example.lkstest.API

import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.Date

class APIClient {
    val BASE_URL = "http://10.0.2.2:5000"

    fun ApiException(code: Int, message: String){

    }

    private fun call(method: String, path: String, token: String? = null, body: JSONObject? = null): String {
        val conn = URL(BASE_URL + path).openConnection() as HttpURLConnection
        try {
            conn.requestMethod = method
            conn.connectTimeout = 15_000
            conn.readTimeout = 15_000
            conn.setRequestProperty("Accept", "application/json")
            token?.let { conn.setRequestProperty("Authorization", "Bearer $it") }
            if (body != null) {
                conn.doOutput = true
                conn.setRequestProperty("Content-Type", "application/json")
                conn.outputStream.use { it.write(body.toString().toByteArray()) }
            }
            val code = conn.responseCode
            val stream = if (code in 200..299) conn.inputStream else conn.errorStream
            val text = stream?.bufferedReader()?.use { it.readText() }.orEmpty()
            if (code !in 200..299) {
                val msg = runCatching {
                    JSONObject(text).let { it.optString("error", it.optString("message")) }
                }.getOrNull()
                throw ApiException()
            }
            return text
        } catch (e: IOException) {
            throw ApiException()
        } finally {
            conn.disconnect()
        }
    }

    fun Login(email: String, password: String){
        val o = JSONObject(call(
            "POST",
            "/api/auth/login",
            body = JSONObject()
                .put("email", email)
                .put("password", password)))

        val l = o.optJSONObject("UserDto")

    }

    fun Categories(token: String){
        JSONArray(call(
            "GET",
            "/api/categories",
            token,
        ))
    }

    fun Summary(token: String){
        call(
            "GET",
            "/api/summary",
            token
        )
    }

    fun postClaim(title: String, description: String, claimDate: Date, categoryId: Int, item: JSONArray){
        val o = JSONObject(call(
            "POST",
            "/api/claim",
            body = JSONObject()
                .put("title", title)
                .put("description", description)
                .put("claimDate", claimDate)
                .put("categoryId", categoryId)
                .put("item", item)
        ))

        val l = o.optJSONObject("UserDto")
    }

}