package com.example.unaappsinmas.navegacion.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unaappsinmas.componentes.btnPrimario
import com.example.unaappsinmas.componentes.spacer
import com.example.unaappsinmas.componentes.texto

data class ConfiguracionItem(
    val id: Int,
    val titulo: String,
    val descripcion: String,
    val icono: ImageVector // Usaremos un recurso de imagen como icono
)

@Composable
fun configuracion() {
    // Lista de opciones de configuración
    val configuracionItems = listOf(
        ConfiguracionItem(
            1,
            "Activar notificaciones",
            "Recibe notificaciones importantes.",
            Icons.Filled.Notifications
        ),
        ConfiguracionItem(
            2,
            "Cambiar tema",
            "Cambiar entre tema claro y oscuro.",
            Icons.Filled.Settings
        ),
        ConfiguracionItem(
            3,
            "Configurar idioma",
            "Selecciona tu idioma preferido.",
            Icons.Filled.Call
        ),
        ConfiguracionItem(
            4,
            "Acerca de la aplicación",
            "Información sobre esta app.",
            Icons.Filled.Info
        )
    )

    texto("Configuración", 24.sp, FontWeight.Bold)

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(configuracionItems) { item ->
            ConfiguracionItemView(item = item)
            spacer(16.dp) // Espacio entre opciones de configuración
        }
    }
}

@Composable
fun ConfiguracionItemView(item: ConfiguracionItem) {
    var isChecked by remember {  mutableStateOf(false)  } // Control del estado de la casilla
    var isTheme by remember {  mutableStateOf(false)  } // Control del estado de la casilla
    var isLanguage by remember {  mutableStateOf(false)  } // Control del estado de la casilla
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp) // Tamaño de cada ítem
                .background(MaterialTheme.colorScheme.background), // Fondo gris claro
        ) {
            // Icono de la opción de configuración
            Icon(
                imageVector = item.icono,
                contentDescription = item.titulo,
                modifier = Modifier.size(40.dp), // Tamaño del ícono
                tint = Color.Black
            )
            Column {
                texto(item.titulo, 16.sp, FontWeight.Bold)
                texto(item.descripcion, 14.sp)
                if (item.titulo == "Activar notificaciones") {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = !isChecked },
                        modifier = Modifier.padding(16.dp)
                    )
                }

                if (item.titulo == "Cambiar tema") {
                    btnPrimario({isTheme = !isTheme},if(isTheme)"claro" else "oscuro")

                }

                if (item.titulo == "Configurar idioma") {
                    btnPrimario({isLanguage = !isLanguage},if(isLanguage)"español" else "ingles")
                }
            }
        }


    }
}