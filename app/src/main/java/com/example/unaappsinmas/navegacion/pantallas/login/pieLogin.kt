package com.example.unaappsinmas.navegacion.pantallas.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unaappsinmas.R
import com.example.unaappsinmas.componentes.btnSecundario
import com.example.unaappsinmas.componentes.image
import com.example.unaappsinmas.componentes.spacer
import com.example.unaappsinmas.componentes.texto

@Composable
fun pieLogin(
    modifier: Modifier,
    registerarse:Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        //boton crear cuenta
        btnSecundario({onClick()},if(!registerarse)"Crear cuenta" else "Iniciar sesion",modifier = Modifier.fillMaxWidth(0.93f))
        spacer(13.dp)
        image(R.drawable.logo,"logo Principal",56.dp)
        Row {
            texto(
                "Información",
                12.sp,
                FontWeight.Bold,
                TextAlign.Center,
                TextOverflow.Ellipsis,
                Modifier.Companion.padding(horizontal = 16.dp)
            )
            spacer(13.dp)
            texto(
                "Ayuda",
                12.sp,
                FontWeight.Bold,
                TextAlign.Center,
                TextOverflow.Ellipsis,
                Modifier.Companion.padding(horizontal = 16.dp)
            )
            spacer(13.dp)
            texto(
                "Más",
                12.sp,
                FontWeight.Bold,
                TextAlign.Center,
                TextOverflow.Ellipsis,
                Modifier.Companion.padding(horizontal = 16.dp)
            )
        }
    }
}