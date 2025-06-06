package com.example.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.blockchainapp.ui.navigation.AppNavGraph
import com.example.learning.ui.layout.Greeting
import com.example.learning.ui.theme.BlockchainAppTheme
import com.example.learning.ui.utils.SurfaceModifier

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlockchainAppTheme {
                BlockchainAppTheme {
                    val navController = rememberNavController()
                    AppNavGraph(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Scaffold(modifier = SurfaceModifier) { innerPadding ->
        Greeting(
            text = "123",
            modifier = Modifier.padding(innerPadding),
        )
    }
}
