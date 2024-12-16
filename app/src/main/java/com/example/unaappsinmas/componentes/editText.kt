package com.example.unaappsinmas.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun editText(texto:String, cambioTexto:(String)->Unit, marcador:String,infoError:Boolean,redondearEsquinas: Dp= 0.dp,tamano:Float = 1.0f,esPrivado:VisualTransformation= VisualTransformation.None) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(tamano),
        value = texto,
        onValueChange = { cambioTexto(it)  },
        label = { texto(
            marcador,
            bold = FontWeight.Bold,
            align = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) },
        shape = RoundedCornerShape(redondearEsquinas),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = if (infoError) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
            unfocusedBorderColor = if (infoError) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
            errorBorderColor = MaterialTheme.colorScheme.error
        ),
        visualTransformation = esPrivado
    )
}