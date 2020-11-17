package com.example.charttestapplication

data class ExString(
    var name:String,
    var checked: Boolean,
    var show: Boolean
)
fun getSamples(): ArrayList<ExString>{
    var list = arrayListOf<ExString>()
    list.add(ExString("apple",true,true))
    list.add(ExString("banana",false, true))
    list.add(ExString("grape",false, true))
    list.add(ExString("mango",false, false))
    list.add(ExString("peach",false, false))
    list.add(ExString("cherry",false, true))
    list.add(ExString("watermelon",false, true))
    list.add(ExString("blueberry",false, true))
    list.add(ExString("orange",false, true))
    list.add(ExString("tomato",false, true))
    return list
}