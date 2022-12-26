package features.nearbyspecificitems.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import appfrw.ModelList
import appfrw.model.AppBaseAdapter
import com.example.nearme.R
import features.nearbyspecificitems.model.NearBySpecificItemsModel

// on below line we are creating an
// adapter class for our grid view.
class NearbySpecificItemsAdapter(
    // on below line we are creating two
    // variables for course list and context
    private val modelList: ModelList,
    private val context: Context,
) :
    AppBaseAdapter(context, modelList) {

    var  layoutInflater =     context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    // in below function we are getting individual item of grid view.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var convertView = convertView
        var nearByItemsModel = this.mListModel[position] as NearBySpecificItemsModel
        // If it is null we are initializing it.
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.nearby_items_view, null)
        }

        var imageview = convertView!!.findViewById<ImageView>(R.id.idIVNearbyItemImage)
        var textView = convertView!!.findViewById<TextView>(R.id.idTVNearbyItemName)
        textView.text = nearByItemsModel.itemName

        //Picasso.with(context).load(R.drawable.ic_default_image)
        nearByItemsModel.loadImage(imageview, nearByItemsModel.imageUrl)

        return convertView
    }
}
