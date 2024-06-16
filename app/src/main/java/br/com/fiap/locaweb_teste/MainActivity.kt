package br.com.fiap.locaweb_teste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.locaweb.screens.CadastroScreen
import br.com.fiap.locaweb.screens.EnviarMensagem
import br.com.fiap.locaweb.screens.LoginScreen
import br.com.fiap.locaweb.screens.PrincipalScreen
import br.com.fiap.locaweb_teste.ui.theme.LocaWeb_testeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LocaWeb_testeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login")
                    {
                        composable(route = "login"){ LoginScreen(navController) }
                        composable(route = "principal"){ PrincipalScreen(navController) }
                        composable(route = "cadastro"){ CadastroScreen(navController) }
                        composable(route = "envia_mensagem"){ EnviarMensagem(navController) }

                    }
                }
            }
        }
    }
}
