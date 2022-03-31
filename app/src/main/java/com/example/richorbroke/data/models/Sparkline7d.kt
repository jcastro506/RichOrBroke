package com.example.richorbroke.data.models


import com.google.gson.annotations.SerializedName

data class Sparkline7d(
    @SerializedName("price")
    val price: List<Double>
)