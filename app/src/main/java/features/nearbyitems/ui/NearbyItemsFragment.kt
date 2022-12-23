package features.nearbyitems.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.navigation.fragment.findNavController
import com.example.nearme.R
import com.example.nearme.databinding.NearbyItemsFragmentBinding
import features.nearbyitems.adapter.NearbyItemsAdapter
import features.nearbyitems.model.NearByItemsModel

import com.example.nearme.MainActivity
import features.nearbyitems.model.NearByModelList

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NearbyItemsFragment : Fragment() {

    private var _binding: NearbyItemsFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var courseGRV: GridView
    lateinit var courseList: List<NearByItemsModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = NearbyItemsFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ViewModelProviders

        //binding.buttonFirst.setOnClickListener {
        //    findNavController().navigate(R.id.action_NearbyItemsFragment_to_SecondFragment)
       // }

        // initializing variables of grid view with their ids.
        courseGRV = binding.idGRV;

        var nearByModelList: NearByModelList = NearByModelList()
        nearByModelList.load()

        // on below line we are initializing our course adapter
        // and passing course list and context.
        val courseAdapter =
            this@NearbyItemsFragment.activity?.let { NearbyItemsAdapter(nearByModelList, it.baseContext) }


        // on below line we are setting adapter to our grid view.
        courseGRV.adapter = courseAdapter


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}