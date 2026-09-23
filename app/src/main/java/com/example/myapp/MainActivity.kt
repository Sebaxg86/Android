package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp.ui.theme.MyAppTheme

//Import de colores
import com.example.myapp.ui.theme.Background
import com.example.myapp.ui.theme.Surface
import com.example.myapp.ui.theme.CardColor
import com.example.myapp.ui.theme.Primary
import com.example.myapp.ui.theme.Accent
import com.example.myapp.ui.theme.Positive
import com.example.myapp.ui.theme.Negative
import com.example.myapp.ui.theme.TextPrimary
import com.example.myapp.ui.theme.TextSecondary
import com.example.myapp.ui.theme.DividerColor


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen(innerPadding = innerPadding)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen(innerPadding: PaddingValues = PaddingValues(0.dp)){
    //Columna con 3 rows, header, main, footer
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Background)
    ) {

        //========== Header ==========
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Surface)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Contenido del header

            //Imagen del logo
            Image(
                painter = painterResource(id= R.drawable.logoapp),
                contentDescription = "Logo de la app",
                modifier = Modifier.size(32.dp)
            )

            //Espaciador entre logo y nombre
            Spacer(modifier = Modifier.width(8.dp))


            Text(text = "Currency App", color = TextPrimary)
        }

        //========== Main ==========
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Background)
                .weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Contenido del main
            Text(text = "Contenido del main", color = TextPrimary)
        }

        //========== Footer ==========
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Surface)
                .height(50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Contenido del footer
            Text(text="Contenido del footer", color = TextPrimary)
        }
    }
}

