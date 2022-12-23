package appfrw.model

import android.content.Context
import android.widget.BaseAdapter
import appfrw.ModelList


abstract class AppBaseAdapter(context: Context, modelList: ModelList): BaseAdapter() {

    protected var mListModel: ModelList = modelList
    //private val mListModel: ArrayList<BaseModel>  = ArrayList()
    private var mContext: Context = context

    fun setModel(modelList: ModelList){
        this.mListModel = modelList
    }
    override fun getCount(): Int {
        return mListModel.size
    }

    override fun getItem(position: Int): Any? {
        return mListModel.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }
}