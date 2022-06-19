package com.example.androidbowling.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbowling.R
import com.example.androidbowling.ui.common.DefaultButton
import com.example.androidbowling.ui.theme.AndroidBowlingTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AboutScreen(
    popBackStack: () -> Unit,
) {
    BottomSheetScaffold(
        sheetContent = {
            // Sheet content
            Text("HIER STEHT IRGENDEIN TEXT AM UNTEREN ENDE DER SEITE", fontWeight = FontWeight.W700)

        }
    ) {
        // Screen content

        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Rules", fontSize = 40.sp)
            Icon(Icons.Rounded.Menu, contentDescription = "Localized description")

            Card() {
            }

            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Card{
                    Image(painter = painterResource(id = R.drawable.app_image), contentDescription = null )
                    Column(Modifier.padding(10.dp)) {
                        Text("AndroidBowling", fontWeight = FontWeight.W700)
                        Text("This app was made by Eler and Matthias")
                        Text("Top", color = Color.Gray)
                    }
                }

                DefaultButton(
                    text = "Back",
                    onClick = popBackStack
                )
                Divider(color = colorResource(R.color.purple_700))

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AndroidBowlingTheme(useSystemUiController = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
        }
    }
}