package za.co.standardbank.standardbankbeerapp.ui

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_beer_list.*

import za.co.standardbank.standardbankbeerapp.R
import za.co.standardbank.standardbankbeerapp.model.Beer
import za.co.standardbank.standardbankbeerapp.ui.adapter.BeerAdapter
import za.co.standardbank.standardbankbeerapp.viewmodel.BeerViewmodel

class BeerListFragment : Fragment() {

    private lateinit var viemodel: BeerViewmodel
    private lateinit var beerAdapter: BeerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viemodel = ViewModelProvider(this).get(BeerViewmodel::class.java)
        beerAdapter = BeerAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beer_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemSeparator = DividerItemDecoration(activity, ClipDrawable.HORIZONTAL)

        beer_list.adapter = beerAdapter
        beer_list.layoutManager = LinearLayoutManager(activity)
        //beer_list.addItemDecoration(itemSeparator)
        observerDataChanges()
    }

    private fun observerDataChanges(){
        viemodel.beerList.observe(viewLifecycleOwner, Observer<List<Beer>>{
            beerAdapter.updateItems(ArrayList(it))
        })
    }
}
