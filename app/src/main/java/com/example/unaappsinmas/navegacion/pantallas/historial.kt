package com.example.unaappsinmas.navegacion.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unaappsinmas.R
import com.example.unaappsinmas.componentes.spacer
import com.example.unaappsinmas.componentes.texto

data class HistorialItem(
    val id: Int,
    val titulo: String,
    val descripcion: String,
    val miniatura: Int // Se usará un recurso de imagen como miniatura
)

@Composable
fun historial() {
    // Lista de elementos del historial
    val historialItems = listOf(
        HistorialItem(
            1,
            "Video de Kotlin",
            "Visto el 15 de diciembre de 2024.",
            R.drawable.ic_video
        ),
        HistorialItem(
            2,
            "Consejos para Android",
            "Visto el 14 de diciembre de 2024.",
            R.drawable.ic_video
        ),
        HistorialItem(
            3,
            "Fundamentos de Jetpack Compose",
            "Visto el 13 de diciembre de 2024.",
            R.drawable.ic_video
        ),
        HistorialItem(
            4,
            "Patrones de Diseño UI",
            "Visto el 12 de diciembre de 2024.",
            R.drawable.ic_video
        )
    )
    texto("Historial:",24.sp, FontWeight.Bold)
    // Usamos LazyColumn para mostrar los elementos
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(historialItems) { item ->
            HistorialItemView(item = item)
            spacer(16.dp) // Espacio entre items del historial
        }
    }
}

@Composable
fun HistorialItemView(item: HistorialItem) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Tamaño de la miniatura
                .background(MaterialTheme.colorScheme.background), // Fondo gris como simulación de miniatura
            contentAlignment = Alignment.Center
        ) {
            // Icono de historial dentro de la miniatura
            Icon(
                painter = painterResource(id = item.miniatura),
                contentDescription = item.titulo,
                modifier = Modifier.size(80.dp), // Tamaño del ícono
                tint = MaterialTheme.colorScheme.primary
            )
        }
        spacer(8.dp)
        texto(item.titulo, 16.sp, FontWeight.Bold) // Título del historial
        texto(item.descripcion, 14.sp) // Descripción del historial (fecha o estado)
    }
}