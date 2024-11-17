package com.example.first_unit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue

import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.first_unit.ui.theme.First_UnitTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


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
                    LemonadeApp(
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableStateOf(1) }
    var squeezeTapCount by remember { mutableStateOf(2) }

    val stepText = when (currentIndex) {
        1 -> R.string.step1_text
        2 -> R.string.step2_text
        3 -> R.string.step3_text
        4 -> R.string.step4_text
        else -> R.string.step1_text
    }
    val imageResource = when (currentIndex) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    Column(
        modifier = modifier
            .fillMaxSize() // Заполнение всего доступного пространства
            .wrapContentSize(Alignment.Center), // Выравнивание содержимого по центру экрана
        horizontalAlignment = Alignment.CenterHorizontally // Центрирование по горизонтали внутри Column
    ) {
        Image(
            painter = painterResource(id = imageResource),
            modifier = Modifier
                .size(150.dp) // Установите размер изображения
                .clickable {
                    when (currentIndex) {
                        1 -> {
                            squeezeTapCount = (1..6).random()
                            currentIndex += 1
                        }

                        2 -> {
                            if (squeezeTapCount == 0) {
                                currentIndex += 1
                            } else {
                                squeezeTapCount--
                            }
                        }

                        3 -> {
                            currentIndex += 1
                        }

                        4 -> {
                            currentIndex = 1
                        }
                    }
                },
            contentDescription = "Lemonade"
        )
        Spacer(modifier = Modifier.height(16.dp)) // Промежуток между изображением и текстом
        Text(text = stringResource(id = stepText))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    First_UnitTheme {
        LemonadeApp(
            modifier = Modifier.fillMaxSize().
            wrapContentSize(Alignment.Center))
    }
}