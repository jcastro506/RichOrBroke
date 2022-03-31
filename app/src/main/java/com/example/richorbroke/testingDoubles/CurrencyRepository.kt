package com.example.richorbroke.testingDoubles

import com.example.richorbroke.data.models.AllCoinsResponse
import com.example.richorbroke.data.models.AllCoinsResponseItem
import com.example.richorbroke.data.models.SingleCoin
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    suspend fun getAllCoins() : List<AllCoinsResponseItem>

    suspend fun getSingleCoinInfo(coinId : String) : SingleCoin

}