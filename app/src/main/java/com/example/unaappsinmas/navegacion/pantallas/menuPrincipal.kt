package com.example.unaappsinmas.navegacion.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.unaappsinmas.componentes.MyBottomBar
import com.example.unaappsinmas.componentes.MyTopAppBar
import com.example.unaappsinmas.componentes.NavigationItem
import com.example.unaappsinmas.componentes.menuHamburguesa
import com.example.unaappsinmas.componentes.texto
import com.example.unaappsinmas.utils.ente
import kotlinx.coroutines.launch


@Composable
fun menuPrincipal(modifier:Modifier,navControlador: NavHostController,content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    var selectedItemIndex by remember { mutableStateOf(0) }
    val menuItems = listOf(
        NavigationItem(
            "Videos",
            Icons.Filled.AccountCircle,
            Icons.Filled.AccountCircle,
            "videos"
        ),
        NavigationItem(
            "Historial",
            Icons.Filled.DateRange,
            Icons.Filled.DateRange,
            "historial"
        ),
        NavigationItem(
            "Configuracion",
            Icons.Filled.DateRange,
            Icons.Filled.DateRange,
            "configuracion"
        ),
        NavigationItem("Salir", Icons.Filled.ExitToApp, Icons.Filled.ExitToApp, "login")
    )
    val snackbarHostState = remember { SnackbarHostState() }

       menuHamburguesa(
           menuItems = menuItems,
           selectedItemIndex = selectedItemIndex,
           onItemSelected = { index, ruta ->
               selectedItemIndex = ente.indexHamburgesa.value
               coroutineScope.launch {
                   drawerState.close()
                   navControlador.navigate(ruta)
               }
           },
           drawerState = drawerState,
           navControlador = navControlador,
           modifier = modifier.fillMaxSize()
       )
       {
           Scaffold(
               topBar = {
                   MyTopAppBar(
                       { coroutineScope.launch { snackbarHostState.showSnackbar(it) } },
                       { coroutineScope.launch { drawerState.open() } },
                   )
               },
               bottomBar = { MyBottomBar() },
               snackbarHost = {
                   SnackbarHost(
                       hostState = snackbarHostState,
                       snackbar = { Snackbar(it) }
                   )
               }
           ) {
               Column(Modifier.padding(it)) {
                   content()
               }
           }
       }
   }


@Composable
@Preview(showBackground = true)
fun MenuPrincipalPreview() {
    val navControlador = rememberNavController()
    menuPrincipal(
        modifier = Modifier.fillMaxSize(),
        navControlador = navControlador
    ) {
        texto("Contenido de la pantalla")
    }
}