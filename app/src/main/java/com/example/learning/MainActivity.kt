package com.example.learning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learning.ui.layout.Greeting
import com.example.learning.ui.theme.LearningTheme
import com.example.learning.ui.utils.SurfaceModifier
import com.example.learning.ui.utils.ColumnContainerFullSize
import com.example.learning.ui.utils.getColumnContainer

import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color

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
                        Text("QQPR 4")
                        Text("QQPR 5")


                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("啟用設定") // 這就是你要加在 switch 前面的字
                            val isChecked = remember { mutableStateOf(false) }
                            Switch(
                                checked = isChecked.value,
                                onCheckedChange = {
                                    isChecked.value = it
                                    Log.d("Greeting", "Switch toggled: $it")
                                }
                            )
                        }


                        Spacer(modifier = Modifier.height(24.dp))

                        // 下拉選單（ListPreference 模擬）
                        val options = listOf("Light", "Dark", "System Default")
                        var expanded by remember { mutableStateOf(false) }
                        var selectedOption by rememberSaveable { mutableStateOf(options[0]) }

                        Text("選擇主題", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))

                        Box {
                            OutlinedButton(onClick = { expanded = true }) {
                                Text(
                                    text = selectedOption,
                                    color = Color.Black // ✅ 強制文字顯示為黑色
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
                                            Log.d("Greeting", "Theme selected: $option")
                                        },
                                        text = {
                                            Text(
                                                text = option,
                                                color = MaterialTheme.colorScheme.onSurface // 強制指定字體顏色
                                            )
                                        }
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        // ListPreference 風格 - 單選選單
                        val options2 = listOf("Light", "Dark", "System Default")
                        var selectedOption2 by rememberSaveable { mutableStateOf("Light") }

                        Text("選擇主題", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .wrapContentWidth() // 避免填滿整個 Row
                                    .align(Alignment.Center)
                            ) {
                                options2.forEach { option ->
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .widthIn(min = 120.dp, max = 240.dp) // 控制最大寬度
                                            .clickable {
                                                selectedOption2 = option
                                                Log.d("Greeting", "Selected: $option")
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
                                                Log.d("Greeting", "Selected (radio): $option")
                                            },
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }
                            }
                        }
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
