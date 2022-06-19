package com.example.androidbowling.ui.common

enum class FrameType {
    STRIKE, SPARE, OPEN
}

class Frame(var previousFrame: Frame?){
    var total = 0
    var lastFrame = previousFrame
    var firstPitch = 0
    var secondPitch = 0
    var thirdPitch = 0
    var frameType = FrameType.OPEN

}

fun main(){
    var frame = Frame(null);

    var test = frame.firstPitch

    var frame2 = Frame(frame);
    println(frame2.lastFrame?.firstPitch)
}