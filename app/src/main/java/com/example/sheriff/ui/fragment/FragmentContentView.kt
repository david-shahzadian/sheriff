package com.example.sheriff.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * Includes all possible types of fragment content view
 */
sealed class FragmentContentView {

    /**
     * Returns content view
     * @param container container to hold the view
     * @param shouldAttachToContainer true if the view should be attached to [container]
     * @return content view instance
     */
    abstract fun get(container: ViewGroup, shouldAttachToContainer: Boolean): View

    /**
     * Used when the content view is from resources
     * @param res layout resource file to set as content view
     */
    data class FromRes(
        @LayoutRes val res: Int
    ) : FragmentContentView() {

        override fun get(container: ViewGroup, shouldAttachToContainer: Boolean): View {
            return LayoutInflater
                .from(container.context)
                .inflate(res, container, shouldAttachToContainer)
        }
    }

    /**
     * Used when the content view is from custom view class
     * @param view custom view class to set as content view
     */
    data class FromViewClass(
        val view: View
    ) : FragmentContentView() {

        override fun get(container: ViewGroup, shouldAttachToContainer: Boolean): View {
            if (shouldAttachToContainer) {
                container.addView(view)
            }
            return view
        }
    }
}