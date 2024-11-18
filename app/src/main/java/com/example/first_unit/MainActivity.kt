package com.example.first_unit

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import java.text.NumberFormat
import androidx.compose.runtime.setValue
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import com.example.first_unit.ui.theme.First_UnitTheme
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.Switch
import androidx.compose.material3.Icon
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.res.painterResource
import androidx.annotation.VisibleForTesting
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            First_UnitTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    //containerColor  = Color(0xFF073042)
                ) {innerPadding ->
                    ArtSpaceApp(
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

//@Composable
//fun CockSuck(modifier: Modifier = Modifier) {
//    Column(
//        modifier = Modifier
//            .background(Color.Red)
//    ){
//        Text(text="a")
//    }
//}
@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier){
    var currentArtwork by remember{ mutableStateOf(0)}
    val artworks = listOf(
        Artwork(R.drawable.art11, "Рай и ад", "Маэстро дель Авиценна", "1435"),
        Artwork(R.drawable.art2, "Ктулху", "Бенитто Дель Торро", "2004"),
        Artwork(R.drawable.art3, "Херувим", "Иоахим Втевал", "1578")
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id=artworks[currentArtwork].imageRes),
            contentDescription = artworks[currentArtwork].title,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)

        )

        Text(text = artworks[currentArtwork].title, fontSize = 24.sp, fontWeight = FontWeight.Normal)
        Text(text = artworks[currentArtwork].artist, fontSize = 18.sp, fontStyle = FontStyle.Italic)
        Text(text = artworks[currentArtwork].year, fontSize = 16.sp)
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(onClick={
                if(currentArtwork > 0) currentArtwork--
            }){
                Text("Previous")
            }
            Button(onClick={
                if(currentArtwork < artworks.size - 1) currentArtwork++
            }){
                Text("Next")
            }
        }
    }
}

data class Artwork(val imageRes: Int, val title: String, val artist: String, val year: String)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    First_UnitTheme {
        ArtSpaceApp(
            modifier = Modifier.fillMaxSize().
            wrapContentSize(Alignment.Center))
    }
}