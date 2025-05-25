package com.example.learning.ui.layout

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import com.example.learning.ui.theme.LearningTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.*
import androidx.compose.runtime.*
import androidx.compose.material3.*



enum class TextStyleMode {
    COPY_AND_OVERRIDE,
    USE_BODY_LARGE,
    CUSTOM
}

@Composable
fun Greeting(
    text: String = "",
    modifier: Modifier = Modifier,
    mode: TextStyleMode = TextStyleMode.CUSTOM,
    container: @Composable (@Composable () -> Unit) -> Unit = { content ->
        Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center) {
            content()
        }
    },
    content: @Composable (() -> Unit)? = null
) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp

    val fontSize: TextUnit = when {
        screenWidthDp < 360 -> 16.sp
        screenWidthDp < 600 -> 24.sp
        screenWidthDp < 840 -> 32.sp
        else -> 40.sp
    }

    val textStyle = when (mode) {
        TextStyleMode.COPY_AND_OVERRIDE -> MaterialTheme.typography.bodyLarge.copy(
            fontSize = fontSize,
            fontStyle = FontStyle.Italic
        )
        TextStyleMode.USE_BODY_LARGE -> MaterialTheme.typography.bodyLarge
        TextStyleMode.CUSTOM -> TextStyle(
            fontSize = fontSize,
            fontStyle = FontStyle.Italic
        )
    }

    Surface(color = MaterialTheme.colorScheme.primary, modifier = modifier) {
        container {
            CompositionLocalProvider(
                LocalTextStyle provides textStyle,
                LocalContentColor provides MaterialTheme.colorScheme.onPrimary
            ) {
                content?.invoke() ?: Text(text) // 預設用 text
            }
        }
    }
}
