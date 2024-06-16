package br.com.fiap.locaweb.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EnviarMensagem(navController: NavController) {

    var email by remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 32.dp, start = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = {email= it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Email
                ),
                label = {
                    Text(text = "Usuario")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Face, contentDescription = "")
                }
            )
            OutlinedTextField(
                value = email,
                onValueChange = {email= it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Email
                ),
                label = {
                    Text(text = "Quem vai receber")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Face, contentDescription = "")
                }
            )
            OutlinedTextField(
                value = email,
                onValueChange = {email= it},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp)
                    .padding(bottom = 16.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Email
                ),
                label = {
                    Text(text = "Escreva sua mensagem")
                },

            )
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { navController.navigate("principal") }) {
                    Text(text = "Voltar")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Enviar")
                }

            }
        }
    }
}
