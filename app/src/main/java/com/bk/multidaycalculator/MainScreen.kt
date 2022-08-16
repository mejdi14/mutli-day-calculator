package com.bk.multidaycalculator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    Column {
        Text(text = "20 Days", modifier = Modifier
            .size(30.dp)
            .padding(start = 20.dp)
            , color = Color(0xFF59CE8F)
            , fontWeight = FontWeight.Bold)
        Box(modifier = Modifier.height(20.dp))
    }
}