package appfrw.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

abstract class BaseModel {

    //Define this in manifest
    //<uses-permission android:name="android.permission.INTERNET"/>
    companion object {
        @BindingAdapter("loadImage")
        @JvmStatic//Use this to Solve ERROR : Companion is not static and requires an object to use, retrieved from the DataBindingComponent
        fun loadImage(view: ImageView, imageUrl: String?) {
            Picasso.with(view.context).load(imageUrl).into(view)
            //Picasso.with(view.context).load(url).error(R.drawable.error).into(view)
        }
    }
}