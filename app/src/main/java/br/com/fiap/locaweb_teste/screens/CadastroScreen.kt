package br.com.fiap.locaweb.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import br.com.fiap.locaweb_teste.model.Usuario

@Composable
fun CadastroScreen(navController: NavController) {
    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)
    var emailState = remember {
        mutableStateOf("")
    }
    var passwordState = remember {
        mutableStateOf("")
    }

    Column() {
        Cadastro(
            navController = navController,
            email = emailState.value,
            password = passwordState.value,
            onEmailChange = {
                emailState.value = it
            },
            onPasswordChange = {
                passwordState.value = it
            }
        )
    }
}


@Composable
fun Cadastro(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    navController: NavController
) {
    val context = LocalContext.current
    val usuarioRepository =UsuarioRepository(context)
    Column(
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
            Text(text = "Cadastro",
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
                value = email,
                onValueChange = {onEmailChange(it)},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Email
                ),
                label = {
                    Text(text = "Digite seu email")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
                }

            )
            OutlinedTextField(
                value = password,
                onValueChange = { onPasswordChange(it)},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                label = {
                    Text(text = "Crie sua senha")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Outlined.Face, contentDescription = "")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")
                }
            )

            Button(onClick = {
                             val usuario = Usuario(
                                 email = email,
                                 password = password
                             )
                usuarioRepository.salvar(usuario = usuario)
                navController.navigate("principal")
            },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Cadastrar")
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
