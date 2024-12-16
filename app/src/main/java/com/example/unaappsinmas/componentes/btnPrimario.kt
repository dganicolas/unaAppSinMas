package com.example.unaappsinmas.componentes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//funcion que me permite reutilizar codigo, asi ahorrandome unas cuantas lineas
//el parametro on click hara el boton lo que se le pase por parametro
@Composable
fun btnPrimario(
    onClick: () -> Unit,
    text: String,
    tamanoTexto: TextUnit = 20.sp,
    modifier: Modifier = Modifier,
    roundedCornerShape: RoundedCornerShape = RoundedCornerShape(8.dp),
){
    Button(

        onClick = {
            onClick()
        },
        modifier = modifier,
        shape = roundedCornerShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ){
        Text(text = text,fontSize = tamanoTexto)
    }
}

@Composable
fun btnSecundario(
    onClick: () -> Unit,
    text: String,
    tamanoTexto: TextUnit = 20.sp,
    modifier: Modifier = Modifier,
    roundedCornerShape: RoundedCornerShape = RoundedCornerShape(8.dp),
){
    Button(

        onClick = {
            onClick()
        },
        modifier = modifier,
        shape = roundedCornerShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        )
    ){
        Text(text = text,fontSize = tamanoTexto)
    }
}
