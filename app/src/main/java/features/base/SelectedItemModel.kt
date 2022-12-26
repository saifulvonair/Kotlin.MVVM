package features.base


class SelectedItemModel {
    companion object {
        var mInstance: SelectedItemModel? = null
        @JvmStatic
        fun Instance(): SelectedItemModel {
            if(mInstance == null){
                mInstance = SelectedItemModel()
            }
            return mInstance as SelectedItemModel
        }
    }

    fun updateSelection(selectionObject: BasePlaceModel){

        if(mSelectedItemModel == null){
            mNeedRefresh = true
            mSelectedItemModel = selectionObject
            return
        }

        if(mSelectedItemModel!!.getPropertyValue("mType") == selectionObject.getPropertyValue("mType") ){
            mNeedRefresh = false;
        }

        mNeedRefresh = true
    }

    public fun getSelectedObject(): BasePlaceModel? {
        return mSelectedItemModel
    }

    public fun needToRefresh(): Boolean{
        return mNeedRefresh
    }

    private var mNeedRefresh: Boolean = false
    private var mSelectedItemModel: BasePlaceModel? = null

}