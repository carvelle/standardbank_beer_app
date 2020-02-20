package za.co.standardbank.standardbankbeerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_beer_deatils.*

import za.co.standardbank.standardbankbeerapp.R
import za.co.standardbank.standardbankbeerapp.model.Beer


class BeerDeatilsFragment : Fragment() {

    var beer: Beer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            beer = it.getSerializable("beer") as Beer
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beer_deatils, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        page_title_tv.text = beer?.name
        description_tv.text = beer?.description
        description_title_tv.text = "Description"
        brewer_title_tv.text = "Brewer"
        brewer_tv.text = beer?.contributed_by
        Picasso.get().load(beer?.image_url).into(beer_imgv)
    }
}
