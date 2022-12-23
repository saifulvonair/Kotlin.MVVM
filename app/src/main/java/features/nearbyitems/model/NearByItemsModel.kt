package features.nearbyitems.model

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import appfrw.model.BaseModel
import com.squareup.picasso.Picasso

//class NearByItemsModel(name: String, Img: Int, ImgUrl: String)
class NearByItemsModel(name: String, Img: Int, ImgUrl: String): BaseModel()
 {
     //ERROR: The expression cannot be inverted, so it cannot be used in a two-way binding
     var itemName: String = name;
     var itemImg: Int = Img// We have place URL....
     var imageUrl: String = ImgUrl

 }
