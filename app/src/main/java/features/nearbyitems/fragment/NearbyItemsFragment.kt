package features.nearbyitems.fragment

import NearbyItemsAdapter
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
import features.base.SelectedItemModel
import features.nearbyitems.model.NearByItemModel
import features.nearbyitems.model.NearByModelList
import features.nearbyspecificitems.model.NearBySpecificModelList


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NearbyItemsFragment : BaseFragment() , ModelList.IModelObserver{

    private var _binding: NearbyItemsFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var courseGRV: GridView
    lateinit var nearbyItemsAdapter: NearbyItemsAdapter
    lateinit var nearByModelList: NearByModelList
    override fun loadData() {

        nearByModelList = NearByModelList.Instance()
        this!!.context?.let { nearByModelList.setContext(it) }
        nearByModelList.setObserver(this)
        nearByModelList.load()
        // initializing variables of grid view with their ids.
        courseGRV = binding.idGRV;
        //progressBar.visibility = View.GONE
        val courseAdapter =
            this@NearbyItemsFragment.activity?.let { NearbyItemsAdapter(nearByModelList, it.baseContext) }
        // on below line we are setting adapter to our grid view.
        courseGRV.adapter = courseAdapter
        nearbyItemsAdapter = courseAdapter as NearbyItemsAdapter

        courseGRV.setOnItemClickListener(OnItemClickListener { parent, v, position, id ->
            Toast.makeText(
                context,
                "" + position,
                Toast.LENGTH_SHORT
            ).show()

            var nearByItemModel = nearByModelList.get(position) as NearByItemModel
            //SelectedItemModel.Instance().updateSelection( nearByItemModel)
            NearBySpecificModelList.Instance().updateQueryParam("mType", nearByItemModel.getPropertyValue("name") as String)

            findNavController().navigate(R.id.action_NearbyItemsFragment_to_SecondFragment)

        })

    }

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