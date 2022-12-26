package features.base

import android.content.Context
import appfrw.Constant
import appfrw.ModelList
import appfrw.model.BaseModel
import features.nearbyitems.model.NearByItemModel
import org.json.JSONObject

open abstract class BaseNearbyModelList() : ModelList() {

    override fun load() {
        var queryParam: JSONObject = mQueryParam
        //
        queryParam.put("mWebUrlRoot", Constant.mWebUrlRoot)
        queryParam.put("mApiKey", Constant.mApiKey)
        // TODO need to get from service
        queryParam.put("mLat", "23.810331")
        queryParam.put("mLong", "90.412521")
        queryParam.put("mRadius", Constant.mRadius)
        // End TODO
        //fillSelectedType();
        //
        queryParam.put("mGooglePhotoUrlRoot", Constant.mGooglePhotoUrlRoot)
        queryParam.put("mThumbnailWidth", Constant.mThumbnailWidth)
        queryParam.put("mMaxPhotoWidth", Constant.mMaxPhotoWidth)
        queryParam.put("mPlaceListFileName", Constant.mPlaceListFileName)
        //location=23.810331,90.412521
        // Now we are ready to load/fatch data
        //TODO need to fix me
        resetDataLoaded()
        //
        this.clear()
        doLoad()
    }

    private fun fillSelectedType(){
        if(SelectedItemModel.Instance().getSelectedObject() != null){
            var nearByItemModel = SelectedItemModel.Instance().getSelectedObject() as NearByItemModel
            mQueryParam?.put("mType", nearByItemModel.itemName)
        }

        if(SelectedItemModel.Instance().needToRefresh()){
            //this.resetDataLoaded()
        }
    }

    abstract fun doLoad()
}