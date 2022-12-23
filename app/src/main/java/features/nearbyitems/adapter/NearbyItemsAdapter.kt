package features.nearbyitems.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import appfrw.ModelList
import appfrw.model.AppBaseAdapter
import com.example.nearme.R
import com.example.nearme.databinding.NearbyItemsViewBinding
import com.squareup.picasso.Picasso

import features.nearbyitems.model.NearByItemsModel

// on below line we are creating an
// adapter class for our grid view.
class NearbyItemsAdapter(
    // on below line we are creating two
    // variables for course list and context
    private val modelList: ModelList,
    private val context: Context,
) :
    AppBaseAdapter(context, modelList) {
    // in base adapter class we are creating variables
    // for layout inflater, course image view and course text view.
    private var layoutInflater: LayoutInflater? = null
    lateinit var dataBinding: NearbyItemsViewBinding

    // in below function we are getting individual item of grid view.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView

        // If it is null we are initializing it.
        if (convertView == null) {
            var  layoutInflater =     context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            dataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.nearby_items_view, null, false);
            convertView = dataBinding.root;
        }
        dataBinding.model =   this.mListModel[position] as NearByItemsModel

        return convertView
    }
}
