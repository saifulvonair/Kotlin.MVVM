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

     companion object {
         @BindingAdapter("loadImage")
         @JvmStatic//Use this to Solve ERROR : Companion is not static and requires an object to use, retrieved from the DataBindingComponent
         fun loadImage(view: ImageView, imageUrl: String?) {
             Picasso.with(view.context).load(imageUrl).into(view)
             //Picasso.with(view.context).load(url).error(R.drawable.error).into(view)
         }
     }
 }
