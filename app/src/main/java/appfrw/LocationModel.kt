package appfrw

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.util.Log
import android.widget.Toast
import java.util.*


class LocationModel: ModelList() {

    companion object {
        var locationModel: LocationModel? = null
        @JvmStatic
        fun Instance(): LocationModel {
            if(locationModel == null){
                locationModel = LocationModel()
            }
            return locationModel as LocationModel
        }
    }

    fun setLocation(location: Location, context: Context){
        //
        val location = location//: Location? = task.result
        if (location != null) {
            val geocoder = Geocoder(context, Locale.getDefault())
            val list: List<Address> =
                geocoder.getFromLocation(location.latitude, location.longitude, 1)
            var latitude: String = "${list[0].latitude}"
            var longitude: String = "${list[0].longitude}"
            var address: String = list[0].getAddressLine(0)

            this.updateQueryParam("mLat", latitude)
            this.updateQueryParam("mLong", longitude)

            Log.d("setLocation", latitude+longitude)
           // Toast.makeText(this, latitude+longitude, Toast.LENGTH_LONG).show()
        }
    }

    fun getLongitude(): String{

        try {
          return  this.mQueryParam.getString("mLong")
        }catch ( e: Exception){
            Log.d("", e.toString())
        }
        return ""
    }

    fun getLatitude(): String{
        try {
           return this.mQueryParam.getString("mLat")
        }catch (e: Exception){
            Log.d("", e.toString())
        }
        return ""
    }

    override fun load() {
        TODO("Not yet implemented")
    }
}