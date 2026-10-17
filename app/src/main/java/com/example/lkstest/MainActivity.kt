package com.example.lkstest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lkstest.DATA.AppViewModel
import com.example.lkstest.DATA.Screen
import com.example.lkstest.ui.theme.LKSTESTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LKSTESTTheme {
                AppViewModel.Navigator(Screen.Login)
            }
        }
    }
}