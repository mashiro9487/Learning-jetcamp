package com.example.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learning.ui.layout.Greeting
import com.example.learning.ui.theme.LearningTheme
import com.example.learning.ui.utils.SurfaceModifier
import com.example.learning.ui.utils.ColumnContainerFullSize
import com.example.learning.ui.utils.getColumnContainer

import androidx.compose.material3.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningTheme {
                Scaffold(modifier = SurfaceModifier) { innerPadding ->
//                    Greeting(
//                        text = "QQPR",
//                        modifier = Modifier.padding(innerPadding),
//                        container = { content -> ColumnContainerFullSize(content) }
//                    )
                    Greeting(container = getColumnContainer(fullSize = true)) {
                        Text("QQPR 1")
                        Text("QQPR 2")
                        Text("QQPR 3")
                    }
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
