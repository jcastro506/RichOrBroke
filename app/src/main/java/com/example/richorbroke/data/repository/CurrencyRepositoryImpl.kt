package com.example.richorbroke.data.repository

import com.example.richorbroke.data.models.AllCoinsResponse
import com.example.richorbroke.data.models.AllCoinsResponseItem
import com.example.richorbroke.data.models.SingleCoin
import com.example.richorbroke.remote.api.CoinbaseApi
import com.example.richorbroke.testingDoubles.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor (
    private val api : CoinbaseApi
        ) : CurrencyRepository {

    override suspend fun getAllCoins(): List<AllCoinsResponseItem> {
        return api.getTop100Coins()
    }

    override suspend fun getSingleCoinInfo(coinId: String): SingleCoin {
        return api.getSingleCoinInfo(coinId)
    }
}