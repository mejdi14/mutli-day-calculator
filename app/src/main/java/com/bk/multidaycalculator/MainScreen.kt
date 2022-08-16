package com.bk.multidaycalculator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFf3e8e6))) {

        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.height(60.dp))
            Text(
                text = "20 Days",
                modifier = Modifier
                    .padding(start = 20.dp),
                color = Color(0xFF7DCE13),
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
            Box(modifier = Modifier.height(20.dp))
            Text(
                text = "On avarage you need to ride",
                modifier = Modifier
                    .padding(start = 20.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            Text(
                text = "4 hours and 33 minutes",
                modifier = Modifier
                    .padding(start = 20.dp),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Box(modifier = Modifier.height(20.dp))
            Text(
                text = "On some days, you'll have to climb over",
                modifier = Modifier
                    .padding(start = 20.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            Text(
                text = "466 meters",
                modifier = Modifier
                    .padding(start = 20.dp),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Box(modifier = Modifier.height(20.dp))
            Text(
                text = "The overall difficulty is",
                modifier = Modifier
                    .padding(start = 20.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            Text(
                text = "Intermediate",
                modifier = Modifier
                    .padding(start = 20.dp),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Canvas(modifier = Modifier.fillMaxSize().padding(20.dp)) {
                val canvasWidth = size.width
                val canvasHeight = size.height

                drawCircle(
                    color = Color.Black,
                    center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                    radius = size.minDimension/2,
                    style = Stroke(10F)
                )

                drawCircle(
                    color = Color.Black,
                    center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                    radius = 15F,
                )
                drawCircle(
                    color = Color(0xFF7DCE13),
                    center = Offset(x = canvasWidth / 4, y = canvasHeight / 2),
                    radius = 48F ,
                )
            }

        }
    }
}
