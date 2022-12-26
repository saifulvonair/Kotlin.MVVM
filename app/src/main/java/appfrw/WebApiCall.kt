package appfrw

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class WebApiCall {
    private val client = OkHttpClient()
    lateinit var thread: Thread

    class WebResponseObject(
        var responseBody: String,
        var responseHeader: String,
        var response: Response
    )

    interface WebApiCalObserver{
        fun update(responseObject: WebResponseObject)
    }

    fun getAsync(webApiCalObserver: WebApiCalObserver, url: String){
        thread = Thread(Runnable {
            try {
                get(webApiCalObserver, url)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        })
        thread.start()
    }

    fun get(webApiCalObserver: WebApiCalObserver, url: String) {
       // var url : String = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=23.810331,90.412521&radius=1500&type=restaurant&key=AIzaSyBLzNu8HIdVsLYVEnHS0cNgShjSCVXlOOA"
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            var responseBody: String = response.body!!.string()
            var responseHeader: String = response.headers.toString()
            //
            var responseObject: WebResponseObject = WebResponseObject(responseBody, responseHeader, response)

            webApiCalObserver.update(responseObject)

            /*
            //for ((name, value) in response.headers) {
            // println("$name: $value")
            //Log.d("NearBySearch",value)
            //}
            //println(response.body!!.string())
            //Log.d("NearBySearch",response.body!!.string())

            //Log.d("responsedata-NearBySearch",responsedata)

            var ii: Int = 10
            */
        }
    }
}