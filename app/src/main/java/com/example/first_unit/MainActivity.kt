package com.example.first_unit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.first_unit.ui.theme.First_UnitTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            First_UnitTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor  = Color(0xFF073042)
                ) {innerPadding ->
                    BusinessCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier=Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF073042)),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image, contentDescription = null, Modifier.fillMaxWidth(0.3f)
        )
        Text(text = "Ilnaz Gilmanov", fontSize = 50.sp, color = Color.White)
        Text(text = "professional lazy dude", fontSize = 25.sp, color = Green)
        Spacer(modifier = Modifier.padding(bottom = 200.dp))
        HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
        ContactRow(
            text = "+ 8 800 555 35 35",
            icon = Icons.Rounded.Phone
        )
        HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
        ContactRow(
            text = "@ohmygodnoway", icon = Icons.Rounded.Share
        )
        HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
        ContactRow(
            text = "thatsnottrue@gmail.com", icon = Icons.Rounded.Email
        )
    }
}

@Composable
fun ContactRow(
    text: String, icon: ImageVector, textBlur: Dp = 0.dp
) {
    Row(
        horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Green,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = text, color = Color.White, modifier = Modifier
                .weight(3f)
                .blur(textBlur)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    First_UnitTheme {
        //GreetingText(message = "Happy Birthday Sam!", from = "From Emma")
        BusinessCard()
    }
}