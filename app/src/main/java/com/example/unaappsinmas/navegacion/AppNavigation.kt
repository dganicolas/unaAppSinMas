package com.example.unaappsinmas.navegacion

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unaappsinmas.navegacion.pantallas.bienvenidaPantalla
import com.example.unaappsinmas.navegacion.pantallas.configuracion
import com.example.unaappsinmas.navegacion.pantallas.historial
import com.example.unaappsinmas.navegacion.pantallas.login.login
import com.example.unaappsinmas.navegacion.pantallas.menuPrincipal
import com.example.unaappsinmas.navegacion.pantallas.videos

@Composable
fun AppNavigation() {
    //este es mi modo de navegacion mediante el navhost controlo todas las pantallas de forma directa
    val navControlador = rememberNavController()

    NavHost(navController = navControlador, startDestination = "bienvenida") {
        composable("bienvenida") {
            Scaffold(modifier = Modifier.fillMaxSize()) {
                bienvenidaPantalla(Modifier.padding(it), navControlador)
            }

        }

        composable("login") {
            Scaffold(modifier = Modifier.fillMaxSize()) {
                login(Modifier.padding(it), navControlador)
            }

        }

        composable("videos") {
            Scaffold(modifier = Modifier.fillMaxSize()) {
            menuPrincipal(Modifier.padding(it),navControlador, { videos() })
                }
        }
        composable("historial") {
            Scaffold(modifier = Modifier.fillMaxSize()) {
                menuPrincipal(Modifier.padding(it), navControlador) {
                    historial()  // Aquí el contenido de la pantalla "Historial"
                }
            }
        }

        composable("configuracion") {
            Scaffold(modifier = Modifier.fillMaxSize()) {
                menuPrincipal(Modifier.padding(it), navControlador) {
                    configuracion()  // Aquí el contenido de la pantalla "Configuración"
                }
            }
        }
    }

}