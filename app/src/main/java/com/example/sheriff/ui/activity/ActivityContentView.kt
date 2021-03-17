package com.example.sheriff.ui.activity

import android.view.View
import androidx.annotation.LayoutRes

/**
 * Includes all possible types of activity content view
 */
sealed class ActivityContentView {

    /**
     * Sets content view to [activity]
     */
    abstract fun setToActivity(activity: BaseActivity)

    /**
     * Used when the content view is from resources
     * @param res layout resource file to set as content view
     */
    data class FromRes(
        @LayoutRes val res: Int
    ) : ActivityContentView() {

        override fun setToActivity(activity: BaseActivity) {
            activity.setContentView(res)
        }
    }

    /**
     * Used when the content view is from custom view class
     * @param view custom view class to set as content view
     */
    data class FromViewClass(
        val view: View
    ) : ActivityContentView() {

        override fun setToActivity(activity: BaseActivity) {
            activity.setContentView(view)
        }
    }
}