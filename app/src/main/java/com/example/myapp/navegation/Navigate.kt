package com.example.myapp.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.uiapp.Home
import com.example.myapp.uiapp.Detail

@Composable
fun Navigate(){
    //Variable para Recordar donde estamos
    val navController= rememberNavController()

    //Donde va a inicializar la navegación
    NavHost(
        navController= navController, startDestination = "Home"
    ){
        //Rutas
        composable("Home"){
            Home(navController)
        }

        composable("Detail"){
            Detail(navController)
        }
    }
}