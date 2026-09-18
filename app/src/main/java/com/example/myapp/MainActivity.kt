package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyAppTheme
import androidx.compose.ui.res.painterResource
import com.atom.myapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Contenido()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Contenido(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BotonNormal()
        Espacio()
        BotonNormal2()
        Espacio()
        BotonTexto()
        Espacio()
        BotonOutline()
        Espacio()
        BotonIcono()
        Espacio()
        BotonFlotante()
    }
}

@Composable
fun Espacio(){
    Spacer(modifier=Modifier.size(10.dp))
}

@Composable
fun BotonNormal(){
    Button(onClick = {}) {
        Text("Mi botón", fontSize = 30.sp)
    }
}

@Composable
fun BotonNormal2(){
    Button(onClick = {}, enabled=false){
        Text("Mi botón", fontSize = 30.sp)
    }
}

@Composable
fun BotonTexto(){
    TextButton(onClick = {}) {
        Text("Mi botón", fontSize = 30.sp)
    }
}

@Composable
fun BotonOutline(){
    OutlinedButton(onClick = {}, border= BorderStroke(5.dp, Color.Red)) {
        Text("Mi botón", fontSize = 30.sp)
    }
}

@Composable
fun BotonIcono(){
    IconButton(onClick ={} ) {
        Icon(
            painter = painterResource(R.drawable.home), "",
            modifier=Modifier.size(40.dp)
        )
    }
}

@Composable
fun BotonFlotante(){
    FloatingActionButton(onClick = {},
                         containerColor = Color.Red,
                         contentColor = Color.Blue,
                         shape = CircleShape
    ) {
        Icon(
            painter=painterResource(R.drawable.home),
            contentDescription = "",
            modifier = Modifier.size(30.dp)
        )
    }
}