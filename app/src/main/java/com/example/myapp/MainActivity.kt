package com.example.myapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.KeyboardType
import java.util.Locale
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
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.example.myapp.ui.theme.Accent
import com.example.myapp.ui.theme.TextPrimary
import com.example.myapp.ui.theme.TextSecondary


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
    // Valores de monedas en pesos mexicanos
    val dolar = 18.00
    val euro = 20.00
    val dolarCanadiense = 13.00
    val libra = 23.00
    val yen = 0.12
    val francoSuizo = 21.00
    val dolarAustraliano = 12.00
    val yuan = 2.50
    val real = 3.50
    val pesoArgentino = 0.02

    var seleccion by rememberSaveable { mutableStateOf("USD") }
    var valorSeleccionado by rememberSaveable { mutableStateOf(dolar) }
    var cantidad by rememberSaveable { mutableStateOf("1") }
    val importe = cantidad.replace(',', '.').toDoubleOrNull()
    val resultado = if (importe != null) importe * valorSeleccionado else null

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
                .weight(1f)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Tarjeta izquierda
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(CardColor)
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = "Calculadora", color = TextPrimary)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "$seleccion → MXN", color = Accent)
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = cantidad,
                    onValueChange = { nuevo ->
                        if (nuevo.length <= 12 && nuevo.matches(Regex("[0-9]*([.,][0-9]*)?"))) {
                            cantidad = nuevo
                        }
                    },
                    label = { Text("Cantidad") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary,
                        focusedLabelColor = Accent,
                        unfocusedLabelColor = TextSecondary,
                        cursorColor = Accent
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "En pesos mexicanos", color = TextSecondary)
                Text(
                    text = if (resultado != null) "${numero(resultado)} MXN" else "—",
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "1 $seleccion = ${numero(valorSeleccionado)} MXN", color = TextPrimary)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Selecciona una moneda de la lista.", color = TextSecondary)
            }

            // Separación entre las dos tarjetas
            Spacer(modifier = Modifier.width(12.dp))

            // Tarjeta derecha
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(CardColor)
                    .padding(16.dp)
            ) {
                Text(text = "Monedas", color = TextPrimary)
                Spacer(modifier = Modifier.height(8.dp))

                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    item {
                        Column(
                            modifier = Modifier
                                .clickable {
                                    seleccion = "USD"
                                    valorSeleccionado = dolar
                                }
                                .padding(8.dp)
                        ) {
                            Text(text = "USD", color = TextPrimary)
                            Text(text = "${dolar} MXN", color = TextPrimary)
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .clickable {
                                    seleccion = "EUR"
                                    valorSeleccionado = euro
                                }
                                .padding(8.dp)
                        ) {
                            Text(text = "EUR", color = TextPrimary)
                            Text(text = "${euro} MXN", color = TextPrimary)
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .clickable {
                                    seleccion = "CAD"
                                    valorSeleccionado = dolarCanadiense
                                }
                                .padding(8.dp)
                        ) {
                            Text(text = "CAD", color = TextPrimary)
                            Text(text = "${dolarCanadiense} MXN", color = TextPrimary)
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .clickable {
                                    seleccion = "GBP"
                                    valorSeleccionado = libra
                                }
                                .padding(8.dp)
                        ) {
                            Text(text = "GBP", color = TextPrimary)
                            Text(text = "${libra} MXN", color = TextPrimary)
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .clickable {
                                    seleccion = "JPY"
                                    valorSeleccionado = yen
                                }
                                .padding(8.dp)
                        ) {
                            Text(text = "JPY", color = TextPrimary)
                            Text(text = "${yen} MXN", color = TextPrimary)
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .clickable {
                                    seleccion = "CHF"
                                    valorSeleccionado = francoSuizo
                                }
                                .padding(8.dp)
                        ) {
                            Text(text = "CHF", color = TextPrimary)
                            Text(text = "${francoSuizo} MXN", color = TextPrimary)
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .clickable {
                                    seleccion = "AUD"
                                    valorSeleccionado = dolarAustraliano
                                }
                                .padding(8.dp)
                        ) {
                            Text(text = "AUD", color = TextPrimary)
                            Text(text = "${dolarAustraliano} MXN", color = TextPrimary)
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .clickable {
                                    seleccion = "CNY"
                                    valorSeleccionado = yuan
                                }
                                .padding(8.dp)
                        ) {
                            Text(text = "CNY", color = TextPrimary)
                            Text(text = "${yuan} MXN", color = TextPrimary)
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .clickable {
                                    seleccion = "BRL"
                                    valorSeleccionado = real
                                }
                                .padding(8.dp)
                        ) {
                            Text(text = "BRL", color = TextPrimary)
                            Text(text = "${real} MXN", color = TextPrimary)
                        }
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .clickable {
                                    seleccion = "ARS"
                                    valorSeleccionado = pesoArgentino
                                }
                                .padding(8.dp)
                        ) {
                            Text(text = "ARS", color = TextPrimary)
                            Text(text = "${pesoArgentino} MXN", color = TextPrimary)
                        }
                    }
                }
            }
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
            Text(text="by Sebastián Chaírez", color = TextSecondary)
        }
    }
}

private fun numero(valor: Double): String = String.format(Locale.US, "%,.2f", valor)
