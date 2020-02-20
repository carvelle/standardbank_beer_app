package za.co.standardbank.standardbankbeerapp.model

import java.io.Serializable

data class Beer(val name: String,
                val image_url: String,
                val description: String,
                val contributed_by: String
) : Serializable