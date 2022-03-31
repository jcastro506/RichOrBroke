package com.example.richorbroke.presenter.landingScreen.viewModel

import android.service.restrictions.RestrictionsReceiver
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.richorbroke.data.models.AllCoinsResponse
import com.example.richorbroke.data.models.AllCoinsResponseItem
import com.example.richorbroke.data.models.SingleCoin
import com.example.richorbroke.testingDoubles.CurrencyRepository
import com.example.richorbroke.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class LandingPageViewModel @Inject constructor(
    private val repository: CurrencyRepository
) : ViewModel() {

    val allCoins = mutableStateOf<List<AllCoinsResponseItem>>(emptyList())

    init {
        getAllCoins()
    }

    private fun getAllCoins() {
        invoke().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    allCoins.value = result.data!!
                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }

        }.launchIn(viewModelScope)
    }


    private fun invoke() : Flow<Resource<List<AllCoinsResponseItem>>> = flow {
        try {
            emit(Resource.Loading<List<AllCoinsResponseItem>>())
            allCoins.value = repository.getAllCoins()
            emit(Resource.Success<List<AllCoinsResponseItem>>(allCoins.value))
        } catch (e:HttpException) {
            emit(Resource.Error<List<AllCoinsResponseItem>>(e.localizedMessage ?: "Unknown Error"))
        } catch (e : IOException) {
            emit(Resource.Error<List<AllCoinsResponseItem>>("Couldn't Reach Server"))
        }
    }

}