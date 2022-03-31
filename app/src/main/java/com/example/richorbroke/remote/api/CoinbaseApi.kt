package com.example.richorbroke.remote.api

import com.example.richorbroke.data.models.AllCoinsResponse
import com.example.richorbroke.data.models.AllCoinsResponseItem
import com.example.richorbroke.data.models.SingleCoin
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinbaseApi {

    @GET(
        "coins/markets?vs_currency=usd&order=market_cap_desc" +
                "&per_page=100&page=1&sparkline=false"
    )
    suspend fun getTop100Coins(): List<AllCoinsResponseItem>


    @GET("coins/{coin_name}?localization=false&tickers=true&market_data=true" +
            "&community_data=false&developer_data=false&sparkline=true")
    suspend fun getSingleCoinInfo(
        @Query("coin_name") coinName : String
    ) : SingleCoin

}