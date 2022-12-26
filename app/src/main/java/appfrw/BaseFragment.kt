package appfrw

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

open abstract class BaseFragment: Fragment() {
    abstract fun loadData()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }
}