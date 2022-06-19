package com.example.androidbowling.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbowling.ui.theme.PrimaryRed
import com.example.androidbowling.ui.theme.SecondaryRed

@Composable
fun StartGameButton(
    text: String,
    onClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(6.dp))
    Button(
        onClick = onClick,
        modifier = Modifier.size(width = 200.dp, height = 70.dp),
        colors = ButtonDefaults.buttonColors(PrimaryRed),
        shape = RoundedCornerShape(4.dp,),
    ) {
        Text(text, fontSize = 30.sp,
        color = Color.White)
    }
}

@Composable
fun PlayerListButton(
    text: String,
    onClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(6.dp))
    Button(
        onClick = onClick,
        modifier = Modifier.size(width = 150.dp, height = 40.dp),
        colors = ButtonDefaults.buttonColors(SecondaryRed),
        shape = RoundedCornerShape(4.dp,),
    ) {
        Text(text, fontSize = 15.sp,
            color = Color.White)
    }
}