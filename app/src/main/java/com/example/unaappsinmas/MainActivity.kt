package com.example.unaappsinmas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.unaappsinmas.navegacion.AppNavigation
import com.example.unaappsinmas.ui.theme.UnaAppSinMasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnaAppSinMasTheme {
                AppNavigation()
            }
        }
    }
}
