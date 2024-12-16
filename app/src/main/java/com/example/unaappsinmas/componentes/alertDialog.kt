package com.example.unaappsinmas.componentes

import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ventanaModal(estadoVentana: Boolean, cerrar:() -> Unit,titulo:String,mensaje:String) {
    if (estadoVentana) {
        AlertDialog(
            onDismissRequest = { cerrar() },
            title = { texto(
                titulo,
                bold = FontWeight.Bold,
                align = TextAlign.Center
            ) }, // Opcional
            text = { texto(
                mensaje,
                align = TextAlign.Center
            ) },
            confirmButton = {
                btnPrimario({cerrar()},"Aceptar")
            }
        )
    }
}