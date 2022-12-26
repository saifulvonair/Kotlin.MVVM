package features.nearbyspecificitems.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import appfrw.BaseFragment
import appfrw.ModelList
import com.example.nearme.R
import com.example.nearme.databinding.NearbyItemsFragmentBinding
import com.example.nearme.databinding.NearbySpecificItemsFragmentBinding
import features.base.SelectedItemModel
import features.nearbyitems.model.NearByItemModel
import features.nearbyspecificitems.adapter.NearbySpecificItemsAdapter
import features.nearbyspecificitems.model.NearBySpecificItemsModel
import features.nearbyspecificitems.model.NearBySpecificModelList
import features.specicifitemdetails.model.SpecificItemDetailsModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NearbySpecificItemsFragment : BaseFragment() , ModelList.IModelObserver{

    private var _binding: NearbySpecificItemsFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var courseGRV: GridView
    lateinit var nearbyItemsAdapter: NearbySpecificItemsAdapter
    lateinit var nearByModelList: NearBySpecificModelList
    override fun loadData() {

        nearByModelList = NearBySpecificModelList.Instance()
        nearByModelList.setObserver(this)
        nearByModelList.load()
        // initializing variables of grid view with their ids.
        courseGRV = binding.idGRV;
        //progressBar.visibility = View.GONE
        val courseAdapter =
            this@NearbySpecificItemsFragment.activity?.let { NearbySpecificItemsAdapter(nearByModelList, it.baseContext) }
        // on below line we are setting adapter to our grid view.
        courseGRV.adapter = courseAdapter
        nearbyItemsAdapter = courseAdapter as NearbySpecificItemsAdapter

        courseGRV.setOnItemClickListener(OnItemClickListener { parent, v, position, id ->
            Toast.makeText(
                context,
                "" + position,
                Toast.LENGTH_SHORT
            ).show()

            var nearByItemsModel = nearByModelList.get(position) as NearBySpecificItemsModel
            SpecificItemDetailsModel.Instance().imageUrl = nearByItemsModel.imageUrl
            SpecificItemDetailsModel.Instance().setJSONProperty(nearByItemsModel.getJSONProperty())

            findNavController().navigate(R.id.action_NearbyItemsFragment_to_SecondFragment)

        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = NearbySpecificItemsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ViewModelProviders

        //binding.buttonFirst.setOnClickListener {
        //    findNavController().navigate(R.id.action_NearbyItemsFragment_to_SecondFragment)
       // }


        // on below line we are initializing our course adapter
        // and passing course list and context.

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun update() {

        var activity: Activity = this.context as Activity
        activity.runOnUiThread(java.lang.Runnable {
            nearbyItemsAdapter.notifyDataSetChanged()
        })
    }
}