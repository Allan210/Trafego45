package br.com.fiap.locaweb.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PrincipalScreen(navController: NavController) {

    var studioState by remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier.fillMaxSize()
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(125.dp)
                .background(Color.Cyan),
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(modifier = Modifier,
                    text = "Calendario"
                )
                Image(
                    painter = painterResource(id = br.com.fiap.locaweb_teste.R.drawable.perfil),
                    contentDescription = "logo",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                )
                Button(onClick = { navController.navigate("login")},
                    modifier = Modifier
                        .height(60.dp)
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(20.dp))
                ) {
                    Text(text = "Sair")
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(750.dp)
                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(modifier = Modifier
                .padding(12.dp),
                text = "CAIXA DE ENTRADA")
            OutlinedTextField(
                value = studioState,
                onValueChange = {studioState = it},
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                label = {
                    Text(text = "Procure sua mensagem")
                },
                textStyle = TextStyle(color = Color.White),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Yellow,
                    focusedBorderColor = Color.Cyan
                )
            )
            MensagemList()



        Column(modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(Color.Yellow),) {
            Row(modifier = Modifier
                .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Caixa de entrada")
                }
                Button(onClick = { navController.navigate("envia_mensagem") }) {
                    Text(text = "escrever")
                }
            }
        }
    }
    }
}

@Composable
fun MensagemList() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(550.dp)
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
        for (i in 0..10){
            MensagemCard()
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun MensagemCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(2f)
            ) {
                Text(
                    text = "Titulo da mensagem",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Conteudo da mensagem",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Data",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = ""
                )
            }
        }
    }

}
