package com.example.unaappsinmas.componentes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.unaappsinmas.utils.ente

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val ruta:String,
    val badgeCount: Int? = null
)


@Composable
fun menuHamburguesa(
    menuItems: List<NavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int, String) -> Unit,
    drawerState: DrawerState,
    navControlador: NavController,
    modifier:Modifier,
    content: @Composable () -> Unit
) {
        ModalNavigationDrawer(
            modifier = modifier,
            drawerContent = {
                ModalDrawerSheet {
                    spacer(16.dp)
                    menuItems.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = { texto(item.title) },
                            selected = index == ente.indexHamburgesa.value,
                            onClick = {
                                onItemSelected(index, item.ruta)
                                ente.indexHamburgesa.value = index
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            },
            drawerState = drawerState
        ) {
            content()
        }
}

// pruebas con el menu hambuirguesa
//val drawerState = rememberDrawerState(DrawerValue.Closed)
//                val coroutineScope = rememberCoroutineScope()
//                var selectedItemIndex by remember { mutableStateOf(0) }
//                val navControlador = rememberNavController()
//                val menuItems = listOf(
//                    NavigationItem("Mi perfil", Icons.Filled.AccountCircle, Icons.Filled.AccountCircle, "mi_perfil"),
//                    NavigationItem("Mis locales", Icons.Filled.Home, Icons.Filled.Home, "mis_locales"),
//                    NavigationItem("Mis reservas", Icons.Filled.DateRange, Icons.Filled.DateRange, "mis_reservas"),
//                    NavigationItem("Salir", Icons.Filled.ExitToApp, Icons.Filled.ExitToApp, "salir")
//                )
//
//                menuHamburguesa(
//                    menuItems = menuItems,
//                    selectedItemIndex = selectedItemIndex,
//                    onItemSelected = { index, ruta ->
//                        selectedItemIndex = index
//                        coroutineScope.launch {
//                            drawerState.close()
//                            navControlador.navigate(ruta)
//                        }
//                    },
//                    drawerState = drawerState,
//                    navControlador = navControlador,
//                    modifier = Modifier
//                )
//                {
//                    Scaffold(
//
//                        topBar = {
//                            MyTopAppBar(
//                                { coroutineScope.launch { /* Acciones del top bar */ } },
//                                { coroutineScope.launch { drawerState.open() } }
//                            )
//                        },
//                        //bottomBar = { MyBottomBar(Modifier) },
//                        snackbarHost = {
//                            SnackbarHost(
//                                hostState = remember { SnackbarHostState() },
//                                snackbar = { Snackbar(it) }
//                            )
//                        }
//                    ) {
//                        Column(Modifier.padding(it)) {
//                            // Contenido principal
//                            Text("¡Hola!")
//                        }
//                    }
//                }
//            }
