package com.example.unaappsinmas.navegacion.pantallas.login

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unaappsinmas.R
import com.example.unaappsinmas.componentes.image
import com.example.unaappsinmas.componentes.spacer
import com.example.unaappsinmas.componentes.texto

@Composable
fun cabeceraLogin(textoIdioma: String) {
    Spacer(modifier = Modifier.size(11.dp))
    texto(
        textoIdioma,
        12.sp,
        FontWeight.Bold,
        TextAlign.Center,
        TextOverflow.Ellipsis,
        Modifier.Companion.padding(horizontal = 16.dp)
    )
    spacer(70.dp)
    image(R.drawable.logo,"logo Principal",52.dp,ContentScale.Crop)
    spacer(81.dp)
}