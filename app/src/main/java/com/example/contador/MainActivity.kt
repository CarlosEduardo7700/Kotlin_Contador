package com.example.contador

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.contador.ui.theme.ContadorTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstantState: Bundle?) {
        super.onCreate(savedInstantState)
        // var contador = mutableStateOf(0)
        setContent {
            Contador( )
        }
    }
}

// @Preview(showBackground = true)
@Composable
fun Contador() {
    var contador = rememberSaveable() {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador", fontSize = 36.sp)
        Row {
            Button(onClick = {
                contador.value -= 1
                Log.d("Contador", "Valor do contador: ${contador.value}")
            }) {
                Text("-", fontSize = 24.sp)
            }
            Text(" ${contador.value} ", fontSize = 36.sp)
            Button(onClick = {
                contador.value += 1
                Log.d("Contador", "Valor do contador: ${contador.value}")
            }) {
                Text("+", fontSize = 24.sp)
            }
        }
    }
 }

@Preview(showBackground = true)
@Composable
fun Agenda() {
    var nome by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var telefone by remember {
        mutableStateOf("")
    }
    Column (modifier = Modifier.fillMaxSize()) {
        Text("Agenda de Contato")
        OutlinedTextField(value = "", onValueChange = { nome = it },
            placeholder = { Text("Nome Completo") }
        )
        OutlinedTextField(value = "", onValueChange = { email = it },
            placeholder = { Text("Email") }
        )
        OutlinedTextField(value = "", onValueChange = { telefone = it},
            placeholder = { Text("Telefone") }
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Gravar")
            
        }
    }
}