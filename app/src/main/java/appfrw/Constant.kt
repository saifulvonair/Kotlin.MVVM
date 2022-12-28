package appfrw

import android.content.res.Resources

class Constant {

    //   location=23.810331,90.412521&radius=1500&type=restaurant&key=AIzaSyBLzNu8HIdVsLYVEnHS0cNgShjSCVXlOOA"
    companion object {

        /*
        var width: Int = Resources.getSystem().displayMetrics.widthPixels
        var height: Int = Resources.getSystem().displayMetrics.heightPixels
        var wd = width/2
        var ht = wd * 0.67
       */
        @JvmStatic
        val mWebUrlRoot: String = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"
        @JvmStatic
        val mApiKey: String = "AIzaSyBLzNu8HIdVsLYVEnHS0cNgShjSCVXlOOA"
        @JvmStatic
        val mGooglePhotoUrlRoot: String = "https://maps.googleapis.com/maps/api/place/photo"
        @JvmStatic
        val  mThumbnailWidth = Resources.getSystem().displayMetrics.widthPixels/2
        @JvmStatic
        val  mMaxPhotoWidth = Resources.getSystem().displayMetrics.widthPixels
        @JvmStatic
        var  mRadius = 5000
        @JvmStatic
        val mPlaceListFileName: String = "placetype.xml"
    }
}