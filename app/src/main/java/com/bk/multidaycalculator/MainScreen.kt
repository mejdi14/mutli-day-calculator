package com.bk.multidaycalculator

import android.graphics.Paint
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
    var angle by remember { mutableStateOf(0f) }
    var oldAngle by remember { mutableStateOf(0f) }
    var circleCenter by remember { mutableStateOf(Offset.Zero) }
    var dragStartedAngle by remember { mutableStateOf(0f) }
    var currentDay by remember { mutableStateOf(8) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFf3e8e6))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.height(60.dp))

            // Update the text based on currentDay
            Text(
                text = "${if (currentDay > 5) currentDay - 5 else currentDay + 15} Days",
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
                                oldAngle = -angle
                            },
                            onDragEnd = {
                                oldAngle = angle
                            }
                        ) { change, _ ->
                            val touchAngle = -atan2(
                                y = circleCenter.x - change.position.x,
                                x = circleCenter.y - change.position.y
                            ) * (180f / PI.toFloat())
                            angle = -(oldAngle + (touchAngle - dragStartedAngle))

                        }
                    })
            )
            {
                val canvasWidth = this.size.width
                val canvasHeight = this.size.height
                circleCenter = Offset(x = canvasWidth / 2, y = canvasHeight / 2)
                val circleRadius = this.size.minDimension / 2 - 70

                drawCircle(
                    color = Color.Black,
                    center = circleCenter,
                    radius = size.minDimension / 2,
                    style = Stroke(10F)
                )

                drawCircle(
                    color = Color.Black,
                    center = circleCenter,
                    radius = 15F,
                )
                drawCircle(
                    color = Color(0xFF7DCE13),
                    center = Offset(x = canvasWidth / 4, y = canvasHeight / 2),
                    radius = 48F,
                )
                for (i in 1..20) {
                    val angleInRad = ((i - 1) * (360f / 20f) - angle + 54f) * (PI.toFloat() / 180f)

                    val x = circleCenter.x + (size.minDimension / 2 - 70) * cos(angleInRad)
                    val y = circleCenter.y + (size.minDimension / 2 - 70) * sin(angleInRad)

                    drawContext.canvas.nativeCanvas.apply {
                        drawText(i.toString(),
                            x,
                            y + 30,
                            Paint().apply {
                                textAlign = Paint.Align.CENTER
                                textSize = 60F
                                color = Color.Black.hashCode()
                            }
                        )
                    }
                    val greenDotX = circleCenter.x + circleRadius * cos(PI.toFloat() / 2)
                    val greenDotY = circleCenter.y - circleRadius * sin(PI.toFloat() / 2)
                    val distanceToGreenDot = sqrt((x - greenDotX).pow(2) + (y - greenDotY).pow(2))
                    if (distanceToGreenDot <= 50) {
                        currentDay = i
                    }
                }
            }
        }
    }
}
