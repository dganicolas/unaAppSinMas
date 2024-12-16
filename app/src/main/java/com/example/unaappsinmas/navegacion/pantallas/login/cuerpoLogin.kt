package com.example.unaappsinmas.navegacion.pantallas.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unaappsinmas.componentes.btnPrimario
import com.example.unaappsinmas.componentes.editText
import com.example.unaappsinmas.componentes.spacer
import com.example.unaappsinmas.componentes.texto

@Composable
fun cuerpoLogin(
    textousuario: String,
    textoContrasena: String,
    cambiarusuario: (String) -> Unit,
    comprobarusuario: Boolean,
    cambiarContra: (String) -> Unit,
    comprobarContra: Boolean,
    login: () -> Unit,
    registrase: Boolean,
    textoCorreo:String,
    cambiarCorreo: (String) -> Unit,
    comprobarCorreo: Boolean
) {
    editText(
        textousuario,
        { cambiarusuario(it) },
        "Nombre de usuario",
        comprobarusuario,
        15.dp,
        0.93f
    )
    spacer(8.dp)
    editText(
        textoContrasena,
        { cambiarContra(it) },
        "Contraseña",
        comprobarContra,
        15.dp,
        0.93f,
        PasswordVisualTransformation()
    )
    if(registrase){
        spacer(8.dp)
        editText(
            textoCorreo,
            { cambiarCorreo(it) },
            "correo electronico",
            comprobarCorreo,
            15.dp,
            0.93f
        )
    }
    spacer(8.dp)
    btnPrimario({ login() },if(!registrase)"Iniciar sesíon" else "registrarse",modifier = Modifier.fillMaxWidth(0.93f))
    spacer(12.dp)
    if(!registrase){
        texto(
            "¿Has olvidado la contraseña?",
            16.sp,
            FontWeight.Bold,
            TextAlign.Center,
            TextOverflow.Ellipsis,
            Modifier.Companion.padding(horizontal = 16.dp)
        )
    }
}