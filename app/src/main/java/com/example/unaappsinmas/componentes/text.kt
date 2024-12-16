package com.example.unaappsinmas.componentes

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun texto(
    texto: String,
    tamano: TextUnit = 18.sp,
    bold: FontWeight = FontWeight.Normal,
    align: TextAlign = TextAlign.Start,
    textoOverflow: TextOverflow= TextOverflow.Clip,
    modifier: Modifier = Modifier
) {
    Text(
        text = texto,
        fontSize = tamano,
        fontWeight = bold,
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = align,
        overflow = textoOverflow,
        modifier = modifier
    )
}