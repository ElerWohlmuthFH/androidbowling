package com.example.androidbowling.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androidbowling.ui.theme.PrimaryGrey
import com.example.androidbowling.ui.theme.SecondaryGrey
import java.util.*

val normalWidth = 36.5.dp
val wideWidth = 55.dp

@Composable
fun FrameIndicator(frame: String, width: Dp) {
    Text(
        text = frame, Modifier
            .background(Color.Transparent, RoundedCornerShape(percent = 0))
            .height(22.dp)
            .width(width)
            .border(1.dp, Color.Black)
            .background(SecondaryGrey),
        textAlign = TextAlign.Center
    )
}

@Composable
fun cell(previousCell: String, isSecondPitch: Boolean): String {

    var value by rememberSaveable { mutableStateOf("") }
    val pattern = remember { Regex("[0-9-xX/]*") }


    BasicTextField(
        value = value,

        onValueChange = {
            if (it.matches(pattern) && it.length <= 1) {

                if (previousCell == "X" || it.uppercase(Locale.getDefault()) == "X" && isSecondPitch) {
                    value = ""
                } else if (previousCell == "") {
                    value = if (it == "/") {
                        ""
                    } else if (it == "0") {
                        "-"
                    } else {
                        it
                            .uppercase(Locale.getDefault())
                    }
                } else {
                    if (it == "0") {
                        value = "-"
                    } else {
                        value = it
                            .uppercase(Locale.getDefault())
                    }

                }


            }
        },
        decorationBox = { innerTextField ->
            Row(
                Modifier
                    .background(Color.Transparent, RoundedCornerShape(percent = 0))
                    .width(18.dp)
                    .height(22.dp)
                    .border(1.dp, Color.Black)
                    .background(PrimaryGrey)
            ) {
                innerTextField()
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
    )

    return value
}

@Composable
fun ScoreCell(score: Int, width: Dp) {

    Text(
        text = score.toString(), Modifier
            .background(Color.Transparent, RoundedCornerShape(percent = 0))
            .width(width)
            .height(normalWidth)
            .border(1.dp, Color.Black)
            .background(PrimaryGrey),
        textAlign = TextAlign.Center
    )
}


@Composable
fun Player(name: String) {


    Text(text = name)

    Row() {
        FrameIndicator(frame = "1", normalWidth)
        FrameIndicator(frame = "2", normalWidth)
        FrameIndicator(frame = "3", normalWidth)
        FrameIndicator(frame = "4", normalWidth)
        FrameIndicator(frame = "5", normalWidth)
        FrameIndicator(frame = "6", normalWidth)
        FrameIndicator(frame = "7", normalWidth)
        FrameIndicator(frame = "8", normalWidth)
        FrameIndicator(frame = "9", normalWidth)
        FrameIndicator(frame = "10", wideWidth)
    }


    var cell1 = ""
    var cell2 = ""
    var cell3 = ""
    var cell4 = ""
    var cell5 = ""
    var cell6 = ""
    var cell7 = ""
    var cell8 = ""
    var cell9 = ""
    var cell10 = ""
    var cell11 = ""
    var cell12 = ""
    var cell13 = ""
    var cell14 = ""
    var cell15 = ""
    var cell16 = ""
    var cell17 = ""
    var cell18 = ""
    var cell19 = ""
    var cell20 = ""
    var cell21 = ""

    Row() {
        cell1 = cell("", false)
        cell2 = cell(cell1, true)
        cell3 = cell("", false)
        cell4 = cell(cell3, true)
        cell5 = cell("", false)
        cell6 = cell(cell5, true)
        cell7 = cell("", false)
        cell8 = cell(cell7, true)
        cell9 = cell("", false)
        cell10 = cell(cell9, true)
        cell11 = cell("", false)
        cell12 = cell(cell11, true)
        cell13 = cell("", false)
        cell14 = cell(cell13, true)
        cell15 = cell("", false)
        cell16 = cell(cell15, true)
        cell17 = cell("", false)
        cell18 = cell(cell17, true)
        cell19 = cell("", false)
        cell20 = cell("", false)
        cell21 = cell("", false)
    }


    val frame1 = createFrame(null, cell1, cell2)
    val frame2 = createFrame(frame1, cell3, cell4)
    val frame3 = createFrame(frame2, cell5, cell6)
    val frame4 = createFrame(frame3, cell7, cell8)
    val frame5 = createFrame(frame4, cell9, cell10)
    val frame6 = createFrame(frame5, cell11, cell12)
    val frame7 = createFrame(frame6, cell13, cell14)
    val frame8 = createFrame(frame7, cell15, cell16)
    val frame9 = createFrame(frame8, cell17, cell18)
    val frame10 = createFrame(frame9, cell19, cell20, cell21, true)

    val sum1 = frame1.total
    val sum2 = frame2.total
    val sum3 = frame3.total
    val sum4 = frame4.total
    val sum5 = frame5.total
    val sum6 = frame6.total
    val sum7 = frame7.total
    val sum8 = frame8.total
    val sum9 = frame9.total
    val sum10 = frame10.total

    Row {
        ScoreCell(sum1, normalWidth)
        ScoreCell(sum2, normalWidth)
        ScoreCell(sum3, normalWidth)
        ScoreCell(sum4, normalWidth)
        ScoreCell(sum5, normalWidth)
        ScoreCell(sum6, normalWidth)
        ScoreCell(sum7, normalWidth)
        ScoreCell(sum8, normalWidth)
        ScoreCell(sum9, normalWidth)
        ScoreCell(sum10, wideWidth)
    }
}

fun createFrame(previousFrame: Frame?, firstPitch: String, secondPitch: String): Frame {
    return createFrame(previousFrame, firstPitch, secondPitch, null, false)
}

fun createFrame(
    previousFrame: Frame?,
    firstPitch: String,
    secondPitch: String,
    thirdPitch: String?,
    lastFrame: Boolean
): Frame {
    val frame = Frame(previousFrame)

    if (firstPitch == "X") {
        frame.frameType = FrameType.STRIKE
        frame.firstPitch = 10
        frame.secondPitch = if (lastFrame) {
            if (secondPitch == "X") {
                10
            } else if (secondPitch.toIntOrNull() != null) {
                secondPitch.toInt()
            } else {
                0
            }
        } else {
            0
        }

    } else if (secondPitch == "/") {
        frame.frameType = FrameType.SPARE
        frame.secondPitch = 10 - frame.firstPitch
    } else if (firstPitch == "-") {
        frame.firstPitch = 0
    } else if (secondPitch == "-") {
        frame.secondPitch = 0
    } else {
        if (firstPitch.toIntOrNull() != null) {
            frame.firstPitch = firstPitch.toInt()
        }
        if (secondPitch.toIntOrNull() != null) {
            frame.secondPitch = secondPitch.toInt()
        }

    }

    val previousTotal = previousFrame?.total ?: 0

    var computedFirstPitch = frame.firstPitch
    var computedSecondPitch = frame.secondPitch
    val computedThirdPitch = if (lastFrame) {
        if (thirdPitch != null) {
            if (thirdPitch == "X") {
                10
            } else if (thirdPitch.toIntOrNull() != null) {
                thirdPitch.toInt()
            } else {
                0
            }

        } else {
            0
        }
    } else {
        0
    }

    if (previousFrame != null) {
        if (previousFrame.frameType == FrameType.SPARE) {
            computedFirstPitch = frame.firstPitch * 2
        } else if (previousFrame.frameType == FrameType.STRIKE) {

            val previouspreviousFrame = previousFrame.previousFrame

            if (previouspreviousFrame != null) {
                if (lastFrame) {
                    if (previouspreviousFrame.frameType == FrameType.STRIKE) {
                        computedFirstPitch = frame.firstPitch * 3
                        computedSecondPitch = frame.secondPitch * 2

                    } else {
                        computedFirstPitch = frame.firstPitch * 2
                        computedSecondPitch = frame.secondPitch * 2
                    }
                } else {

                    if (previouspreviousFrame.frameType == FrameType.STRIKE) {
                        computedFirstPitch = frame.firstPitch * 3
                        computedSecondPitch = frame.secondPitch * 2

                    } else {
                        computedFirstPitch = frame.firstPitch * 2
                        computedSecondPitch = frame.secondPitch
                    }

                }

            } else {
                computedFirstPitch = frame.firstPitch * 2
                computedSecondPitch = frame.secondPitch * 2
            }
        }

    }

    frame.total = previousTotal + computedFirstPitch + computedSecondPitch + computedThirdPitch

    return frame
}
