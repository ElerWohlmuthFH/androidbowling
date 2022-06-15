package com.example.androidbowling.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.FrameNumberCell(string: String, weight: Float) {
    Text(
        text = string, Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}

const val frameWeight = .1f // 10%
const val frame10Weight = .14f // 14%

@Composable
fun Frames(){
    Row(
        Modifier
            .background(color = Color(0xFF003E57))
    ) {
        FrameNumberCell(string = "1", weight = frameWeight)
        FrameNumberCell(string = "2", weight = frameWeight)
        FrameNumberCell(string = "3", weight = frameWeight)
        FrameNumberCell(string = "4", weight = frameWeight)
        FrameNumberCell(string = "5", weight = frameWeight)
        FrameNumberCell(string = "6", weight = frameWeight)
        FrameNumberCell(string = "7", weight = frameWeight)
        FrameNumberCell(string = "8", weight = frameWeight)
        FrameNumberCell(string = "9", weight = frameWeight)
        FrameNumberCell(string = "10", weight = frame10Weight)
    }
}


@Composable
fun Player(name: String) {



    Row() {
        Text(text = name)
    }

    Row(
        Modifier.background(color = Color(0xFF003E57))
    ) {
        FrameNumberCell(string = "-7", weight = frameWeight)
        FrameNumberCell(string = "8/", weight = frameWeight)
        FrameNumberCell(string = "X", weight = frameWeight)
        FrameNumberCell(string = "9-", weight = frameWeight)
        FrameNumberCell(string = "8-", weight = frameWeight)
        FrameNumberCell(string = "81", weight = frameWeight)
        FrameNumberCell(string = "--", weight = frameWeight)
        FrameNumberCell(string = "X", weight = frameWeight)
        FrameNumberCell(string = "4-", weight = frameWeight)
        FrameNumberCell(string = "91X", weight = frame10Weight)

    }
    Row(
        Modifier.background(color = Color(0xFF00719E))
    ) {
        FrameNumberCell(string = "7", weight = frameWeight)
        FrameNumberCell(string = "27", weight = frameWeight)
        FrameNumberCell(string = "46", weight = frameWeight)
        FrameNumberCell(string = "55", weight = frameWeight)
        FrameNumberCell(string = "63", weight = frameWeight)
        FrameNumberCell(string = "72", weight = frameWeight)
        FrameNumberCell(string = "72", weight = frameWeight)
        FrameNumberCell(string = "86", weight = frameWeight)
        FrameNumberCell(string = "90", weight = frameWeight)
        FrameNumberCell(string = "110", weight = frame10Weight)

    }

}