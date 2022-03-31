package com.example.richorbroke.data.models


import com.google.gson.annotations.SerializedName

data class RoiX(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("percentage")
    val percentage: Double,
    @SerializedName("times")
    val times: Double
)