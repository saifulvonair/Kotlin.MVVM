package appfrw

import android.content.Context
import android.content.res.Resources
import appfrw.model.BaseModel
import org.json.JSONObject

open abstract class ModelList : ArrayList<BaseModel>() {
    protected lateinit var mContext: Context
    protected lateinit var mObserver: IModelObserver
    protected  var mDataLoaded: Boolean = false
    protected var mQueryParam: JSONObject = JSONObject()


    interface IModelObserver {
        fun update()
    }

    fun setContext(context: Context){
        this.mContext = context
    }

    fun setObserver(observer: IModelObserver){
        this.mObserver = observer
    }

    fun notifyUpdate(){
        if(mObserver != null){
            mObserver.update()
        }
    }

    fun resetDataLoaded(){
        mDataLoaded = false
    }

    fun addItem(baseModel: BaseModel): BaseModel{
        this.add(baseModel)

        val width: Int = Resources.getSystem().displayMetrics.widthPixels
        val height: Int = Resources.getSystem().displayMetrics.heightPixels
        baseModel.mImageWidth = width/2
        var ht = baseModel.mImageWidth * 0.67
        baseModel.mImageHeight = ht.toInt()

        return baseModel
    }

    fun setQueryParam(queryParam: JSONObject) {
            this.mQueryParam = queryParam
    }

    fun updateQueryParam(key: String, value: String){
        this.mQueryParam!!.put(key, value)
    }

    abstract fun load()
}