package com.example.unaappsinmas.navegacion.pantallas.login

import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.unaappsinmas.componentes.ventanaModal

@Composable
fun login(
    modifier: Modifier,
    navControlador: NavHostController
) {
    var textoUsuario by remember { mutableStateOf("") }
    var textoContraseña by remember { mutableStateOf("") }
    var textoCorreo by remember { mutableStateOf("") }
    var estadoVentana by remember { mutableStateOf(false) }
    var mensajeVentana by remember { mutableStateOf("Credenciales Incorrectas") }
    var tituloVentana by remember { mutableStateOf("Credenciales Incorrectas") }
    var registrarse by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ventanaModal(estadoVentana, {
            estadoVentana = false
            if (comprobaciones(
                    registrarse,
                    textoContraseña,
                    textoUsuario,
                    textoCorreo
                )
            ) {
                navControlador.navigate("videos")
            }
        },tituloVentana, mensajeVentana)
        cabeceraLogin("español")
        cuerpoLogin(
            textousuario = textoUsuario,
            textoContrasena = textoContraseña,
            cambiarusuario = { textoUsuario = it },
            comprobarusuario = textoUsuario.isNotBlank(),
            cambiarContra = { textoContraseña = it },
            comprobarContra = textoContraseña.length > 5,
            login = {
                val (titulo, mensaje) = mostrarVentana(
                    registrarse,
                    textoContraseña,
                    textoUsuario,
                    textoCorreo
                )
                // Asignamos los valores a las variables correspondientes
                tituloVentana = titulo
                mensajeVentana = mensaje
                estadoVentana = true
            },
            registrase = registrarse,
            textoCorreo = textoCorreo,
            comprobarCorreo = Patterns.EMAIL_ADDRESS.matcher(textoCorreo).matches(),
            cambiarCorreo = { textoCorreo = it }
        )
        pieLogin(Modifier.weight(1f), registrarse) { registrarse = !registrarse }
    }
}

fun mostrarVentana(
    registrarse: Boolean,
    textoContraseña: String,
    textoUsuario: String,
    textoCorreo: String) : Pair<String, String> {
    if (comprobaciones(
            registrarse,
            textoContraseña,
            textoUsuario,
            textoCorreo
        )
    ) {
        if(registrarse){
            return Pair("Sesion iniciada", "bienvenido $textoUsuario")
        }else{
            return Pair("Registro completado", "bienvenido $textoUsuario")
        }
    }else{
        if(!registrarse){
            return Pair("ERROR", "El inicio de sesión debe de tener un usuario y una contraseña válida.")
        }else{
            return Pair("ERROR", "Por favor, complete todos los campos correctamente.")
        }

    }
}

fun comprobaciones(
    registrarse: Boolean,
    textoContraseña: String,
    textoUsuario: String,
    textoCorreo: String
): Boolean {
    if (!registrarse && textoContraseña.length > 5 && textoUsuario.isNotBlank()) {
        return true
    }
    if (registrarse &&
        textoContraseña.length > 5 &&
        textoUsuario.isNotBlank() &&
        Patterns.EMAIL_ADDRESS.matcher(
            textoCorreo
        ).matches()
    ) {
        return true
    }
    return false

}

@Preview
@Composable
fun previewLogin() {
    login(Modifier, rememberNavController())
}