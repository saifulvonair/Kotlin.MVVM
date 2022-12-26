package features.nearbyitems.model

import android.util.Log
import com.example.nearme.R
import appfrw.WebApiCall
import features.base.BaseNearbyModelList
import org.json.JSONArray
import org.json.JSONObject
import javax.xml.parsers.DocumentBuilderFactory


class NearByModelList: BaseNearbyModelList() {

    companion object {
        var specificItemDetailsModel: NearByModelList? = null
        @JvmStatic
        fun Instance(): NearByModelList {
            if(specificItemDetailsModel == null){
                specificItemDetailsModel = NearByModelList()
            }
            return specificItemDetailsModel as NearByModelList
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

        val istream = mContext.assets.open(mQueryParam!!.getString("mPlaceListFileName"))
        val builderFactory = DocumentBuilderFactory.newInstance()
        val docBuilder = builderFactory.newDocumentBuilder()
        val doc = docBuilder.parse(istream)

        val nodeList = doc.getElementsByTagName("place")

        if(nodeList != null ){

           // var size: Int = nodeList.length-1
            for (i in 0 until nodeList.length){
                var node = nodeList.item(i)
                var nearByItemModel =this.addItem(NearByItemModel("", -1, "")) as NearByItemModel
                var jsonObject: JSONObject = JSONObject()
                for (j in 0 until  node.attributes.length){

                    var attributes = node.attributes.item(j)
                    //this.setJSONProperty()
                    if(attributes.nodeName == "name"){
                        jsonObject.put("name",attributes.nodeValue)
                        nearByItemModel.itemName = attributes.nodeValue as String
                    }
                    else if(attributes.nodeName == "image"){
                        jsonObject.put("image",attributes.nodeValue)
                        nearByItemModel.imageUrl =  attributes.nodeValue
                    }
                    // We may need to use many property.....
                    nearByItemModel.setJSONProperty(jsonObject)
                }
            }
            //nearByItemModel.setJSONProperty(jsonObject);

        }

        mDataLoaded = true

        //notifyUpdate();
        Log.d(" NearByModelList = true","mDataLoaded")
    }

}