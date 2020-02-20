package za.co.standardbank.standardbankbeerapp.repository

import za.co.standardbank.standardbankbeerapp.network.HttpClient

class BeerRepository {

    private val client = HttpClient().webService

    suspend fun getAllBeers() = client.getAllBeers()
}