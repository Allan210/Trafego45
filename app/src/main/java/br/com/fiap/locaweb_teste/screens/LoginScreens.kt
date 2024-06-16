package br.com.fiap.locaweb.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.locaweb_teste.database.repository.UsuarioRepository

@Composable
fun LoginScreen(navController: NavController){

    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("")
    }


    Column(
//        modifier = Modifier.background(Color.Magenta),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier
                .size(width = 120.dp, height = 40.dp)
                .align(Alignment.End),
            shape = RoundedCornerShape(
                bottomStart = 16.dp)
        ) {

        }
        Column(
            modifier = Modifier.padding(32.dp)
        ) {
            Text(text = "Login",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC02828)
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 32.dp, start = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = emailState.value,
                onValueChange = {emailState.value =it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Email
                ),
                label = {
                    Text(text = "E-mail")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
                }

            )
            OutlinedTextField(
                value = passwordState.value,
                onValueChange = {passwordState.value = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                label = {
                    Text(text = "Digite sua senha")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Outlined.Face, contentDescription = "")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")
                }
            )
            Button(onClick = { navController.navigate("principal")},
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Entrar")
                Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription = "")
            }
            Row(
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(
                    text = "Não tem uma conta?",
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = "Cadastre-se",
                    modifier = Modifier.clickable {navController.navigate("cadastro")}
                )
            }
        }
        Card(
            modifier = Modifier
                .size(width = 120.dp, height = 40.dp)
                .align(Alignment.Start),
            shape = RoundedCornerShape(
                topEnd = 16.dp)
        ) {

        }


    }
}