package com.bk.multidaycalculator

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    Column (modifier = Modifier.fillMaxSize()){
        Text(text = "20 Days", modifier = Modifier
            .size(30.dp)
            .padding(start = 20.dp)
            , color = Color(0xFF59CE8F)
            , fontWeight = FontWeight.Bold)
        Box(modifier = Modifier.height(20.dp))
        Text(text = "On avarage you need to ride", modifier = Modifier
            .size(14.dp)
            .padding(start = 20.dp)
            , color = Color(0xFF000000)
            , fontWeight = FontWeight.Medium)
        Text(text = "4 hours and 33 minutes", modifier = Modifier
            .size(20.dp)
            .padding(start = 20.dp)
            , color = Color(0xFF000000)
            , fontWeight = FontWeight.Bold)
        Box(modifier = Modifier.height(20.dp))
    }
}
