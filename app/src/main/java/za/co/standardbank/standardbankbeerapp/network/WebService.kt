package za.co.standardbank.standardbankbeerapp.network

import retrofit2.http.GET
import za.co.standardbank.standardbankbeerapp.model.Beer

interface WebService {

    @GET("/v2/beers")
    suspend fun getAllBeers() : List<Beer>
}