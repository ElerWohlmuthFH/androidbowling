package com.example.androidbowling.ui.common

import android.content.res.Configuration
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbowling.ui.theme.PrimaryGrey
import com.example.androidbowling.ui.theme.SecondaryGrey
import java.util.*

const val doubleWidth = .095238095238f
const val normalWidth = doubleWidth / 2
const val tripleWidth = doubleWidth * 1.5f

const val scoreCellRatioNormal = 1f
const val scoreCellRatioWide = 1.50f
const val frameIndicatorRatioNormal = 2f
const val frameIndicatorRatioWide = 3f

const val inputCellRatio = 1f
val defaultBorder = 0.5.dp
var primaryFontSize = 15.sp
var nameFontSize = 20.sp

@Composable
fun OrientationController() {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            primaryFontSize = 15.sp
            nameFontSize = 20.sp
        }
        else -> {
            primaryFontSize = 30.sp
            nameFontSize = 40.sp
        }
    }
}

@Composable
fun Player(name: String) {

    OrientationController()
    Text(
        text = name,
        fontSize = nameFontSize,
        modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp),
        textAlign = TextAlign.Left
    )

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        FrameIndicator(text = "1", weight = doubleWidth, frameIndicatorRatioNormal)
        FrameIndicator(text = "2", weight = doubleWidth, frameIndicatorRatioNormal)
        FrameIndicator(text = "3", weight = doubleWidth, frameIndicatorRatioNormal)
        FrameIndicator(text = "4", weight = doubleWidth, frameIndicatorRatioNormal)
        FrameIndicator(text = "5", weight = doubleWidth, frameIndicatorRatioNormal)
        FrameIndicator(text = "6", weight = doubleWidth, frameIndicatorRatioNormal)
        FrameIndicator(text = "7", weight = doubleWidth, frameIndicatorRatioNormal)
        FrameIndicator(text = "8", weight = doubleWidth, frameIndicatorRatioNormal)
        FrameIndicator(text = "9", weight = doubleWidth, frameIndicatorRatioNormal)
        FrameIndicator(text = "10", weight = tripleWidth, frameIndicatorRatioWide)
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

    Row(
        Modifier.fillMaxWidth()
    ) {
        cell1 = inputCell(normalWidth, "", false)
        cell2 = inputCell(normalWidth, cell1, true)
        cell3 = inputCell(normalWidth, "", false)
        cell4 = inputCell(normalWidth, cell3, true)
        cell5 = inputCell(normalWidth, "", false)
        cell6 = inputCell(normalWidth, cell5, true)
        cell7 = inputCell(normalWidth, "", false)
        cell8 = inputCell(normalWidth, cell7, true)
        cell9 = inputCell(normalWidth, "", false)
        cell10 = inputCell(normalWidth, cell9, true)
        cell11 = inputCell(normalWidth, "", false)
        cell12 = inputCell(normalWidth, cell11, true)
        cell13 = inputCell(normalWidth, "", false)
        cell14 = inputCell(normalWidth, cell13, true)
        cell15 = inputCell(normalWidth, "", false)
        cell16 = inputCell(normalWidth, cell15, true)
        cell17 = inputCell(normalWidth, "", false)
        cell18 = inputCell(normalWidth, cell17, true)
        cell19 = inputCell(normalWidth, "", false)
        cell20 = inputCell(normalWidth, "", false)
        cell21 = inputCell(normalWidth, "", false)
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

    Row(
        Modifier.fillMaxWidth()
    ) {
        ScoreCell(sum1, doubleWidth, scoreCellRatioNormal)
        ScoreCell(sum2, doubleWidth, scoreCellRatioNormal)
        ScoreCell(sum3, doubleWidth, scoreCellRatioNormal)
        ScoreCell(sum4, doubleWidth, scoreCellRatioNormal)
        ScoreCell(sum5, doubleWidth, scoreCellRatioNormal)
        ScoreCell(sum6, doubleWidth, scoreCellRatioNormal)
        ScoreCell(sum7, doubleWidth, scoreCellRatioNormal)
        ScoreCell(sum8, doubleWidth, scoreCellRatioNormal)
        ScoreCell(sum9, doubleWidth, scoreCellRatioNormal)
        ScoreCell(sum10, tripleWidth, scoreCellRatioWide)
    }
}

@Composable
fun RowScope.FrameIndicator(
    text: String,
    weight: Float,
    ratio: Float
) {

    Text(
        text = text,
        Modifier
            .border(defaultBorder, Color.Black)
            .weight(weight)
            .aspectRatio(ratio)
            .background(SecondaryGrey),
        textAlign = TextAlign.Center,
        fontSize = primaryFontSize,
    )
}


@Composable
fun RowScope.inputCell(
    weight: Float,
    previousCell: String,
    isSecondPitch: Boolean
): String {


    var value by rememberSaveable { mutableStateOf("") }
    val pattern = remember { Regex("[0-9-xX/]*") }


    BasicTextField(
        value = value,
        onValueChange = {
            if (it.matches(pattern) && it.length <= 1) {

                if (previousCell == "X" || it.uppercase(Locale.getDefault()) == "X" && isSecondPitch) {
                    value = ""
                } else if (previousCell == "") { // firstPitch
                    value = if (it == "/") {
                        ""
                    } else if (it == "0") {
                        "-"
                    } else {
                        it.uppercase(Locale.getDefault())
                    }
                } else { // secondPitch
                    if (it == "0") {
                        value = "-"
                    } else {
                        if (it.toIntOrNull() != null) {
                            var secondNumber = it.toInt()
                            var previousNumber = if (previousCell.toIntOrNull() != null) {
                                previousCell.toInt()
                            } else {
                                0
                            }
                            if (secondNumber + previousNumber >= 10) {
                                value = "/"
                            } else {
                                value = it.uppercase(Locale.getDefault())
                            }
                        } else {
                            value = it.uppercase(Locale.getDefault())
                        }
                    }
                }
            }
        },
        modifier = Modifier
            .background(Color.Transparent, RoundedCornerShape(percent = 0))
            .weight(weight)
            .border(defaultBorder, Color.Black)
            .background(PrimaryGrey)
            .aspectRatio(inputCellRatio),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
        textStyle = LocalTextStyle.current.copy(
            textAlign = TextAlign.Center,
            fontSize = primaryFontSize
        )
    )
    return value
}


@Composable
fun RowScope.ScoreCell(
    score: Int,
    weight: Float,
    ratio: Float
) {
    Text(
        text = score.toString(),
        Modifier
            .border(defaultBorder, Color.Black)
            .weight(weight)
            .aspectRatio(ratio)
            .background(PrimaryGrey),
        textAlign = TextAlign.Center,
        fontSize = primaryFontSize
    )
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