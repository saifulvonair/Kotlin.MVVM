package appfrw

class Constant {

    //   location=23.810331,90.412521&radius=1500&type=restaurant&key=AIzaSyBLzNu8HIdVsLYVEnHS0cNgShjSCVXlOOA"
    companion object {
        @JvmStatic
        val mWebUrlRoot: String = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"
        @JvmStatic
        val mApiKey: String = "...."
        @JvmStatic
        val mGooglePhotoUrlRoot: String = "https://maps.googleapis.com/maps/api/place/photo"
        @JvmStatic
        val  mThumbnailWidth = 200
        @JvmStatic
        val  mMaxPhotoWidth = 500
        @JvmStatic
        var  mRadius = 5000
        @JvmStatic
        val mPlaceListFileName: String = "placetype.xml"
    }
}
