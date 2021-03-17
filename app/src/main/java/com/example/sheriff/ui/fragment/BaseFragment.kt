package com.example.sheriff.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.sheriff.ui.viewmodel.BaseViewModel
import com.example.sheriff.ui.viewstate.ViewState

/**
 * Base class for all fragment classes
 * @param VS view state class type
 */
abstract class BaseFragment<VS : ViewState> : Fragment(), Observer<VS> {

    /**
     * Content view to set to current fragment
     */
    protected abstract val contentView: FragmentContentView

    /**
     * The current fragment view model instance
     */
    protected lateinit var viewModel: BaseViewModel<VS>
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = container?.let { contentView.get(it, false) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = initializeViewModel()
        viewModel.liveData.observe(viewLifecycleOwner, this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.liveData.removeObserver(this)
    }

    /**
     * @return view model of the current fragment
     */
    protected abstract fun initializeViewModel(): BaseViewModel<VS>

    /**
     * Called when view state is changed by [viewModel]
     */
    protected abstract fun onViewStateChanged(state: VS)

    /**
     * Called when view state is changed by [viewModel]
     */
    override fun onChanged(t: VS) {
        onViewStateChanged(t)
    }
}