package features.specicifitemdetails.model

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import appfrw.model.BaseModel
import com.squareup.picasso.Picasso

//class NearByItemsModel(name: String, Img: Int, ImgUrl: String)
class SpecificItemDetailsModel(name: String, Img: Int, ImgUrl: String): BaseModel()
 {
     //ERROR: The expression cannot be inverted, so it cannot be used in a two-way binding
     var itemName: String = name;
     var itemImg: Int = Img// We have place URL....
     var imageUrl: String = ImgUrl



     companion object {
         var specificItemDetailsModel: SpecificItemDetailsModel? = null
         @JvmStatic
         fun Instance(): SpecificItemDetailsModel{
             if(specificItemDetailsModel == null){
                 specificItemDetailsModel = SpecificItemDetailsModel("",-1, "")
             }
             return specificItemDetailsModel as SpecificItemDetailsModel
         }
     }

 }
