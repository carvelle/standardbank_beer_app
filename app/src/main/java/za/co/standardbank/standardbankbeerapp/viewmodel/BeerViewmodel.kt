package za.co.standardbank.standardbankbeerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import za.co.standardbank.standardbankbeerapp.repository.BeerRepository

class BeerViewmodel: ViewModel() {

    val repository = BeerRepository()

    val beerList = liveData(Dispatchers.IO){
        val beers = repository.getAllBeers()
        emit(beers)
    }
}