package za.co.standardbank.standardbankbeerapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_beer_list.view.*
import za.co.standardbank.standardbankbeerapp.R
import za.co.standardbank.standardbankbeerapp.model.Beer

class BeerAdapter: RecyclerView.Adapter<BeerAdapter.BeerViewHolder>() {

    private var beerList : ArrayList<Beer>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_beer_list, parent, false)
        return BeerViewHolder(view)
    }

    override fun getItemCount() = beerList?.size ?: 0

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {

        val beer = beerList?.get(position)
        holder.item.name_tv.text = beer?.name

        val bundle = bundleOf("beer" to beer)
        Picasso.get().load(beer!!.image_url).into(holder.item.image_imgv)

        holder.item.setOnClickListener{
            it.findNavController().navigate(R.id.action_beerListFragment_to_beerDeatilsFragment, bundle)
        }
    }

    fun updateItems(items: ArrayList<Beer>){
        beerList = items
        notifyDataSetChanged()
    }

    class BeerViewHolder(val item: View): RecyclerView.ViewHolder(item)
}