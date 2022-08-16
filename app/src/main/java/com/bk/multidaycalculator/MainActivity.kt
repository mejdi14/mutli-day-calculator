package com.bk.multidaycalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize().background(Color(0xFFf3e8e6))) {

                Column(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.height(80.dp))
                    Text(
                        text = "20 Days",
                        modifier = Modifier
                            .padding(start = 20.dp),
                        color = Color(0xFF59CE8F),
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Box(modifier = Modifier.height(20.dp))
                    Text(
                        text = "On avarage you need to ride",
                        modifier = Modifier
                            .padding(start = 20.dp),
                        color = Color.Black,
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
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}