package com.bk.multidaycalculator

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    LazyColumn(){
        Text("14 Days", modifier = Modifier.size(30.dp))
    }
}