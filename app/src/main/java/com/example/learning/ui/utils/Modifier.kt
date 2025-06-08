package com.example.learning.ui.utils

import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

val SurfaceModifier = Modifier
    .padding(20.dp)
    .wrapContentSize()
    .offset(x = 30.dp, y = 30.dp)
    .clip(RoundedCornerShape(8.dp))
    .border(3.dp, Color.Black)
