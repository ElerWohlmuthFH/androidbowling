package com.example.androidbowling.ui.common

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidbowling.ui.rooms.PlayerListViewModel
import com.example.androidbowling.ui.rooms.PlayerListViewmodelFactory
import kotlin.math.round

//@Composable
//fun NumPad() {
//
//
////Box(){
//    val width = 0.33f // 33%
//    val height = width / 2
//
////Column(){
////    Column(
////        Modifier.weight(1f)
////    ) {
//        Row ( ){
//            Button(
//                onClick = { writeToTable("1") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("1", fontSize = 30.sp)
//            }
//            Button(
//                onClick = { writeToTable("2") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("2", fontSize = 30.sp)
//            }
//            Button(
//                onClick = { writeToTable("3") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("3", fontSize = 30.sp)
//            }
//        }
//        Row() {
//            Button(
//                onClick = { writeToTable("4") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("4", fontSize = 30.sp)
//            }
//            Button(
//                onClick = { writeToTable("5") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("5", fontSize = 30.sp)
//            }
//            Button(
//                onClick = { writeToTable("6") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("6", fontSize = 30.sp)
//            }
//        }
//        Row() {
//            Button(
//                onClick = { writeToTable("7") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("7", fontSize = 30.sp)
//            }
//            Button(
//                onClick = { writeToTable("8") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("8", fontSize = 30.sp)
//            }
//            Button(
//                onClick = { writeToTable("9") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("9", fontSize = 30.sp)
//            }
//        }
//        Row() {
//            Button(
//                onClick = { writeToTable("-") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("-", fontSize = 30.sp)
//            }
//            Button(
//                onClick = { writeToTable("/") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("/", fontSize = 30.sp)
//            }
//            Button(
//                onClick = { writeToTable("X") },
//                modifier = Modifier.size(width = 100.dp, height = 70.dp)
//            ) {
//                Text("X", fontSize = 30.sp)
//            }
//        }
////    }}
//}
//}

//fun writeToTable(string: String) {
//
//    val context = LocalContext.current
//    val model: PlayerListViewModel = viewModel(
//        factory = PlayerListViewmodelFactory(
//            context.applicationContext as Application
//        )
//    )
//
//    println("hohoho")
//    jumpToNextFrame()
//}

fun jumpToNextFrame() {
    //jumps to next entry in table (next frame)
}