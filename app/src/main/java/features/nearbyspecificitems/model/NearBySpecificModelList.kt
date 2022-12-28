package features.nearbyspecificitems.model

import android.content.res.Resources
import android.util.Log
import appfrw.ModelList
import com.example.nearme.R
import appfrw.WebApiCall
import features.base.BaseNearbyModelList
import org.json.JSONArray
import org.json.JSONObject


class NearBySpecificModelList: BaseNearbyModelList(), WebApiCall.WebApiCalObserver {

    companion object {
        var specificItemDetailsModel: NearBySpecificModelList? = null
        @JvmStatic
        fun Instance(): NearBySpecificModelList {
            if(specificItemDetailsModel == null){
                specificItemDetailsModel = NearBySpecificModelList()
            }
            return specificItemDetailsModel as NearBySpecificModelList
        }
    }

    override fun  doLoad(){

        if(mQueryParam == null){
            return
        }
        if(mQueryParam!!.length() == 0){
            return
        }
        // Need to reset when location changed.
        // Need to reset when force refresh.
        if (mDataLoaded){
            return
        }

        var keyword: String = mQueryParam!!.getString("mType")//"fuel%20station%20&"
        var url : String// = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=23.810331,90.412521&radius=1500&type=restaurant&key=AIzaSyBLzNu8HIdVsLYVEnHS0cNgShjSCVXlOOA"
        //
        url = mQueryParam!!.getString("mWebUrlRoot") + "?" + "keyword="+keyword+
                "&location=" + mQueryParam!!.getString("mLat") +
                "," + mQueryParam!!.getString("mLong") + "&radius="+ mQueryParam!!.getInt("mRadius") +
                "&type="+ mQueryParam!!.getString("mType") + "&key="+ mQueryParam!!.getString("mApiKey")
        var webApiCall: WebApiCall = WebApiCall()
        webApiCall.getAsync(this,url )
    }

    override fun update(responseObject: WebApiCall.WebResponseObject) {

        if (responseObject != null){
            // Parse Data from String as JSON
            var jsonObject: JSONObject = JSONObject(responseObject.responseBody);
            var results = jsonObject.get("results") as JSONArray

            var sizeOfResult: Int = results.length()-1

            for (i in 0..sizeOfResult) {
                // body of loop
                var resultJSONObject = results[i] as JSONObject
                var bs = resultJSONObject.getString("business_status")
                var icon = resultJSONObject.get("icon") as String
                var name = resultJSONObject.get("name") as String
                var place_id = resultJSONObject.get("place_id") as String
                var imageUrl: String = ""

                try {

                    var photo = resultJSONObject.get("photos") as JSONArray

                    if(photo != null){
                        var photo_root = photo.get(0) as JSONObject
                        var photo_reference = photo_root.get("photo_reference") as String
                        //
                        imageUrl = mQueryParam!!.getString("mGooglePhotoUrlRoot") + "?maxwidth=" +
                                mQueryParam!!.getInt("mThumbnailWidth")+
                                "&photo_reference="+ photo_reference + "&key="+ mQueryParam!!.get("mApiKey")
                    }

                }catch (e: java.lang.Exception){
                    Log.d("if(photo != null)", "No value for photos")
                }

                // TODO test code..
                if(imageUrl == "" || imageUrl.isEmpty()){
                   // imageUrl = "https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg"
                }
                var basePlaceModel = this.addItem(NearBySpecificItemsModel(name, R.drawable.ic_launcher_background, imageUrl))

                //var basePlaceModel = this.addItem(NearBySpecificItemsModel(i.toString(), R.drawable.ic_launcher_background, "https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg"))
                resultJSONObject.put("mMaxPhotoWidth",this.mQueryParam!!.getString("mMaxPhotoWidth"))
                resultJSONObject.put("mThumbnailWidth",this.mQueryParam!!.getString("mThumbnailWidth"))
                basePlaceModel.setJSONProperty(resultJSONObject)
                //Log.d("resultJSONObject=>",name+" =>" + imageUrl)



            }
            notifyUpdate();
            mDataLoaded = true;
        }
    }
}