package za.co.standardbank.standardbankbeerapp.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

fun getOkHttpClient(writeTimeout: Long = 15, readTimeout: Long = 15, connectionTimeout: Long = 15) : OkHttpClient{

    return OkHttpClient.Builder()
        .connectTimeout(connectionTimeout, TimeUnit.SECONDS)
        .writeTimeout(writeTimeout, TimeUnit.SECONDS)
        .readTimeout(readTimeout, TimeUnit.SECONDS)
        .build()

}