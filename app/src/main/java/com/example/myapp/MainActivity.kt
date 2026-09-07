package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Formulario()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Formulario(){

    //Variables de los contadores
    var contadorLocal by remember { mutableStateOf(0) }
    var contadorVisitante by remember { mutableStateOf(0) }

    //Columna que contiene todo
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        //Fila que contenga las dos columnas
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            //Columna del equipo local
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                //Caja del contador local
                Box(
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .size(150.dp)
                        .background(color=Color.Blue,
                            shape = CircleShape),
                    contentAlignment = Alignment.Center

                ){
                    Text(text="$contadorLocal",
                        fontSize = 70.sp,
                        color=Color.White)
                }



                //Botón de sumar
                Button(
                    onClick = {
                        contadorLocal++
                    },
                    modifier = Modifier
                        .width(250.dp)
                ){
                    Text("Sumar",
                        fontSize = 30.sp)
                }

                Spacer(modifier= Modifier.padding(8.dp))

                //Botón de restar
                Button(
                    onClick = {
                        if (contadorLocal>0){
                            contadorLocal--
                        }

                    },
                    modifier = Modifier
                        .width(250.dp)
                ){
                    Text("Restar",
                        fontSize = 30.sp)
                }
            }

            //Columna del equipo visitante
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                //Caja con el contador
                Box(
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .size(150.dp)
                        .background(color=Color.Blue,
                            shape = CircleShape),
                    contentAlignment = Alignment.Center

                ){
                    Text(text="$contadorVisitante",
                        fontSize = 70.sp,
                        color=Color.White)
                }

                //Botón de Sumar
                Button(
                    onClick = {
                        contadorVisitante++
                    },
                    modifier = Modifier
                        .width(250.dp)
                ){
                    Text("Sumar",
                        fontSize = 30.sp)
                }

                Spacer(modifier= Modifier.padding(8.dp))

                //Botón de Restar
                Button(
                    onClick = {
                        if(contadorVisitante>0){
                            contadorVisitante--
                        }
                    },
                    modifier = Modifier
                        .width(250.dp)
                ){
                    Text("Restar",
                        fontSize = 30.sp)
                }
            }
        }

        //Botón de Reiniciar
        Button(
            onClick = {
                contadorVisitante=0
                contadorLocal=0
            },
            modifier = Modifier
                .width(250.dp)
                .padding(bottom = 50.dp)
        ){
            Text("Reiniciar",
                fontSize = 30.sp)
        }
    }

}

