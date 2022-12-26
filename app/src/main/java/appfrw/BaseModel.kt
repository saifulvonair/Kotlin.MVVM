package appfrw.model

import android.widget.ImageView
import com.squareup.picasso.Picasso
import org.json.JSONObject

abstract class BaseModel {
    var mImageWith: Int = 300
    var mImageHeight: Int = 200
    var mDataInfoPropertyKeyVsValue: JSONObject? = null

    fun setJSONProperty(property: JSONObject?){
        this.mDataInfoPropertyKeyVsValue = property
    }

    fun  getJSONProperty(): JSONObject? {
        return this.mDataInfoPropertyKeyVsValue
    }

    fun getPropertyValue(name: String): Any {
        return this.mDataInfoPropertyKeyVsValue!!.get(name)
    }

    fun loadImage(view: ImageView, imageUrl: String) {
        if(imageUrl != ""){
            //https://futurestud.io/tutorials/picasso-image-resizing-scaling-and-fit
            Picasso.with(view.context).load(imageUrl).resize(mImageWith, mImageHeight).into(view)
        }
    }

    fun loadImageNoResize(view: ImageView, imageUrl: String) {
        if(imageUrl != ""){
            //https://futurestud.io/tutorials/picasso-image-resizing-scaling-and-fit
            Picasso.with(view.context).load(imageUrl).into(view)
        }
    }
}