package com.example.androidbowling.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbowling.ui.common.StartGameButton
import com.example.androidbowling.ui.theme.AndroidBowlingTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AboutScreen(
    popBackStack: () -> Unit,
) {

    Column(
        modifier = Modifier.padding(6.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Rules",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )


        Text(
            "A game of bowling consists of ten frames.\n" +
                    "\nIn each frame, the bowler will have two chances to knock down as many pins as possible with their bowling ball.\n" +
                    "\nIn games with more than one bowler, as is common, every bowler will take their frame in a predetermined order before the next frame begins.\n" +
                    "\nIf a bowler is able to knock down all ten pins with their first ball, he is awarded a strike.\n" +
                    "\nIf the bowler is able to knock down all 10 pins with the two balls of a frame, it is known as a spare.\n" +
                    "\nBonus points are awarded for both of these, depending on what is scored in the next 2 balls (for a strike) or 1 ball (for a spare).\n" +
                    "\nIf the bowler knocks down all 10 pins in the tenth frame, the bowler is allowed to throw 3 balls for that frame.\n" +
                    "\nThis allows for a potential of 12 strikes in a single game, and a maximum score of 300 points, a perfect game.",
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        StartGameButton(
            text = "Back",
            onClick = popBackStack
        )
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