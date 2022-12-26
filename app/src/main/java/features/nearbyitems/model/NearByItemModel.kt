package features.nearbyitems.model

import features.base.BasePlaceModel

//class NearByItemsModel(name: String, Img: Int, ImgUrl: String)
class NearByItemModel(name: String, Img: Int, ImgUrl: String): BasePlaceModel()
 {
     //ERROR: The expression cannot be inverted, so it cannot be used in a two-way binding
     var itemName: String = name;
     var itemImg: Int = Img// We have place URL....
     var imageUrl: String = ImgUrl
 }
