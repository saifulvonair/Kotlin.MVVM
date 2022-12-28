package appfrw.model

import android.util.Log
import android.widget.ImageView
import com.example.nearme.R
import com.squareup.picasso.Picasso
import org.json.JSONObject

abstract class BaseModel {
    var mImageWidth: Int = 300
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

    fun loadImage(view: ImageView, imageUrl: String?) {
        if(imageUrl != null){
            if(imageUrl.isNotEmpty()){
                //https://futurestud.io/tutorials/picasso-image-resizing-scaling-and-fit
                Picasso.with(view.context).load(imageUrl).resize(mImageWidth, mImageHeight).into(view)
            }
            else{
                //var imageUrl = "https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg"
                Picasso.with(view.context).load(R.drawable.ic_default_image).resize(mImageWidth, mImageHeight).into(view)
                Log.d("loadImage-image not found", "Loaded-ic_default_image")
            }
        }
    }

    fun loadImageNoResize(view: ImageView, imageUrl: String?) {
        if(imageUrl != null){
            if(imageUrl.isNotEmpty()){
                //https://futurestud.io/tutorials/picasso-image-resizing-scaling-and-fit
                Picasso.with(view.context).load(imageUrl).into(view)
            }
        }
    }
}