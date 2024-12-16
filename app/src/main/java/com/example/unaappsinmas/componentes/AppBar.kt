package com.example.unaappsinmas.componentes

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unaappsinmas.R
import com.example.unaappsinmas.utils.ente
import kotlinx.coroutines.Job

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(function: (String) -> Job, function1: () -> Job) {
    TopAppBar(
        title = { Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            //imagen y nombre de la app
            image(R.drawable.logo, "logo de la app", 45.dp, colorFilter = ColorFilter.tint(Color.White))
            spacer(5.dp)
            Text(text = "OurTube", fontSize = 16.sp)
        } },
        navigationIcon = {
            IconButton(onClick = { function("abriendo menu"); function1() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    contentDescription = "menu"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {function("has pulsado buscar")}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search"
                )
            }
            IconButton(onClick = {function("has pulsado ir a mi perfil")}) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Clear"
                )
            }
        }

    )
}

@Composable
fun MyBottomBar() {

    NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
        NavigationBarItem(
            selected = ente.indexDonwBar.value == 0,
            onClick = { ente.indexDonwBar.value = 0 },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Red,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.Gray,
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray
            ),
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "home"
                )
            },
            label = {
                Text(text = "home")
            }
        )
    }
}