package com.example.richorbroke.di

import com.example.richorbroke.data.repository.CurrencyRepositoryImpl
import com.example.richorbroke.remote.api.CoinbaseApi
import com.example.richorbroke.testingDoubles.CurrencyRepository
import com.example.richorbroke.utils.Contants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinbaseApi() : CoinbaseApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinbaseApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api : CoinbaseApi) : CurrencyRepository {
        return CurrencyRepositoryImpl(api)
    }

}