package features.nearbyitems.model

import appfrw.ModelList
import com.example.nearme.R

class NearByModelList: ModelList() {

    fun load(){

        // URL
        var imageUrl: String = "https://www.gstatic.com/webp/gallery/1.jpg";

        //
        this.add(NearByItemsModel("C++", R.drawable.ic_launcher_background, imageUrl))
        this.add(NearByItemsModel("Java", R.drawable.ic_launcher_foreground, imageUrl))
        this.add(NearByItemsModel("Python", R.drawable.ic_launcher_foreground, imageUrl))
        this.add(NearByItemsModel("Javascript", R.drawable.ic_launcher_background, imageUrl))

    }
}