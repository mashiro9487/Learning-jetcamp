package com.example.learning.ui.layout

//import androidx.compose.ui.tooling.preview.Preview
//import com.example.learning.ui.theme.LearningTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


enum class TextStyleMode {
    COPY_AND_OVERRIDE,
    USE_BODY_LARGE,
    CUSTOM
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    text: String = "",
    mode: TextStyleMode = TextStyleMode.CUSTOM,
    container: @Composable (@Composable () -> Unit) -> Unit = { innerContent ->
        Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center) {
            innerContent()
        }
    },
    content: @Composable (() -> Unit)? = null
) {
    val windowInfo = LocalWindowInfo.current
    val screenWidthDp = with(LocalDensity.current) {
        windowInfo.containerSize.width.toDp()
    }

    val fontSize = when {
        screenWidthDp < 360.dp -> 16.sp
        screenWidthDp < 600.dp -> 24.sp
        screenWidthDp < 840.dp -> 32.sp
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

/**
@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("QQPR 1")
        Text("QQPR 2")
        Text("QQPR 3")
        Text("QQPR 4")
        Text("QQPR 5")

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("啟用設定")
            val isChecked = remember { mutableStateOf(false) }
            Switch(
                checked = isChecked.value,
                onCheckedChange = {
                    isChecked.value = it
                    Log.d("SettingsScreen", "Switch toggled: $it")
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        val options = listOf("Light", "Dark", "System Default")
        var expanded by remember { mutableStateOf(false) }
        var selectedOption by rememberSaveable { mutableStateOf(options[0]) }

        Text("選擇主題", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Text(
                    text = selectedOption,
                    color = Color.Black
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOption = option
                            expanded = false
                            Log.d("SettingsScreen", "Theme selected: $option")
                        },
                        text = {
                            Text(
                                text = option,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        val options2 = listOf("Light", "Dark", "System Default")
        var selectedOption2 by rememberSaveable { mutableStateOf("Light") }

        Text("選擇主題", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            options2.forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .widthIn(min = 120.dp, max = 240.dp)
                        .clickable {
                            selectedOption2 = option
                            Log.d("SettingsScreen", "Selected: $option")
                        }
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = option,
                        modifier = Modifier.weight(1f),
                        style = if (selectedOption2 == option)
                            MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium)
                        else
                            MaterialTheme.typography.bodySmall
                    )
                    RadioButton(
                        selected = selectedOption2 == option,
                        onClick = {
                            selectedOption2 = option
                            Log.d("SettingsScreen", "Selected (radio): $option")
                        },
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}
*/
