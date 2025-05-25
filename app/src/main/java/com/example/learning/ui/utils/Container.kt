package com.example.learning.ui.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize


@Composable
fun ColumnContainer(fullSize: Boolean = false, content: @Composable () -> Unit) {
    val modifier = if (fullSize) {
        Modifier
            .padding(24.dp)
            .fillMaxSize()
    } else {
        Modifier.padding(24.dp)
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}

@Composable
fun ColumnContainerNoFullSize(content: @Composable () -> Unit) {
    ColumnContainer(fullSize = false, content = content)
}

@Composable
fun ColumnContainerFullSize(content: @Composable () -> Unit) {
    ColumnContainer(fullSize = true, content = content)
}

fun getColumnContainer(fullSize: Boolean = false): @Composable (content: @Composable () -> Unit) -> Unit {
    return { content ->
        val modifier = if (fullSize) {
            Modifier
                .padding(24.dp)
                .fillMaxSize()
        } else {
            Modifier.padding(24.dp)
        }

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}
