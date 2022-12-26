package features.specicifitemdetails.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import appfrw.BaseFragment
import com.example.nearme.R
import com.example.nearme.databinding.SpecificItemDetatailFragmentBinding
import features.specicifitemdetails.model.SpecificItemDetailsModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SpecificItemDetailsFragment : BaseFragment() {

    private var _binding: SpecificItemDetatailFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = SpecificItemDetatailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun loadData() {
        //binding.idIVNearbyItemDetails
        var imageUrl: String =  SpecificItemDetailsModel.Instance().imageUrl

        // TODO need device Width  here....

        var thumWidth: String ="maxwidth="+ SpecificItemDetailsModel.Instance().getPropertyValue("mThumbnailWidth")
        var maxPhotoWidth: String ="maxwidth="+ SpecificItemDetailsModel.Instance().getPropertyValue("mMaxPhotoWidth")

        imageUrl = imageUrl.replace(thumWidth, maxPhotoWidth)

        var place_id = SpecificItemDetailsModel.Instance().getPropertyValue("place_id")

        SpecificItemDetailsModel.Instance().loadImageNoResize(binding.idIVNearbyItemDetails, imageUrl)
        binding.idTVNearbyItemAddress.text = SpecificItemDetailsModel.Instance().getPropertyValue("vicinity") as String
        binding.idTVNearbyItemName.text = SpecificItemDetailsModel.Instance().getPropertyValue("name") as String

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.buttonSecond.setOnClickListener {
        //    findNavController().navigate(R.id.action_SecondFragment_to_NearbyItemsFragment)
        //}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}