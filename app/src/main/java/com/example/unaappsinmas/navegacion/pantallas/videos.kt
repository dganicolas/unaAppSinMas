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

data class Video(
    val id: Int,
    val titulo: String,
    val descripcion: String,
    val miniatura: Int // Se usará un recurso de imagen como miniatura
)

@Composable
fun videos() {
    val videos = listOf(
        Video(
            1,
            "Aprende Kotlin en 30 Minutos",
            "Una guía rápida para programar en Kotlin.",
            R.drawable.ic_video
        ), // Usamos un ícono predeterminado
        Video(
            2,
            "Los 10 Mejores Consejos para Android",
            "Aprende consejos y trucos para desarrollar en Android.",
            R.drawable.ic_video
        ),
        Video(
            3,
            "Fundamentos de Jetpack Compose",
            "Una guía para principiantes sobre Jetpack Compose.",
            R.drawable.ic_video
        ),
        Video(
            4,
            "Patrones de Diseño en UI para Android",
            "Domina los patrones de diseño de interfaces en Android.",
            R.drawable.ic_video
        )
    )
    texto("Tus Videos:",24.sp, FontWeight.Bold)
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(videos) { video ->
            VideoItem(video = video)
            spacer(16.dp) // Espacio entre videos
        }
    }
}

@Composable
fun VideoItem(video: Video) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Establecemos el tamaño de la miniatura
                .background(MaterialTheme.colorScheme.background), // Fondo gris como simulación de miniatura
            contentAlignment = Alignment.Center
        ) {
            // Icono de video dentro de la miniatura
            Icon(
                painter = painterResource(id = video.miniatura),
                contentDescription = video.titulo,
                modifier = Modifier.size(80.dp), // Tamaño del ícono
                tint = MaterialTheme.colorScheme.primary
            )
        }
        spacer(8.dp)
        texto(video.titulo,16.sp, FontWeight.Bold)
        texto(video.descripcion,14.sp)
    }
}
