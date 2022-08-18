package com.bk.multidaycalculator

import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.*

@Composable
fun MainScreen() {
    var angle by remember {
        mutableStateOf(0f)
    }
    var oldAngle by remember {
        mutableStateOf(0f)
    }
    val circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }
    var dragStartedAngle by remember {
        mutableStateOf(0f)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFf3e8e6))
    ) {

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
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .pointerInput(key1 = true, block = {
                        detectDragGestures(
                            onDragStart = { offset ->
                                dragStartedAngle = -atan2(
                                    y = circleCenter.x - offset.x,
                                    x = circleCenter.y - offset.y
                                ) * (180f / PI.toFloat())
                                //Log.d("TAG", "MainScreen: $dragStartedAngle")
                            },
                            onDragEnd = {
                                oldAngle = angle
                            }
                        ) { change, _ ->
                            Log.d("TAG", "angle: ${change.position} vs ${change.previousPosition}")
                            val touchAngle = -atan2(
                                y = circleCenter.x - change.position.x,
                                x = circleCenter.y - change.position.y
                            ) * (180f / PI.toFloat())
                            //angle = oldAngle + (if((touchAngle - dragStartedAngle) > 0) (touchAngle - dragStartedAngle) else -(touchAngle - dragStartedAngle))
                            if (change.position.x < change.previousPosition.x) {
                                if (change.position.y > change.previousPosition.y){
                                Log.d("TAG", "MainScreen: first first")
                                    angle++
                                }
                                else{
                                Log.d("TAG", "MainScreen: first second")
                                    angle--
                                }
                            } else {
                                if (change.position.y > change.previousPosition.y){
                                Log.d("TAG", "MainScreen: second first")

                                    angle++
                                }
                                else{
                                Log.d("TAG", "MainScreen: second second")

                                    angle++
                                }
                            }
                            //Log.d("TAG", "touchAngle: $touchAngle")
                        }
                    })
            ) {
                val canvasWidth = size.width
                val canvasHeight = size.height

                drawCircle(
                    color = Color.Black,
                    center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                    radius = size.minDimension / 2,
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
                    radius = 48F,
                )
                for (i in 1..24)
                    drawContext.canvas.nativeCanvas.apply {
                        val angleInRad = (i * (360f / 24f) * (PI.toFloat() / 180f)) - (angle / 20)
                        drawText(i.toString(),
                            ((size.minDimension - 140) / 2) * cos(angleInRad) + center.x,
                            ((canvasHeight - 140) / 2) * sin(angleInRad) + center.y + 30,
                            Paint().apply {
                                textAlign = Paint.Align.CENTER
                                textSize = 60F
                                color = Color.Black.hashCode()
                            }
                        )
                    }
            }
        }
    }
}
