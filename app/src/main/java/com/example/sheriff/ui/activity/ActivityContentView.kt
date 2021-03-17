package com.example.sheriff.ui.activity

import android.view.View
import androidx.annotation.LayoutRes

/**
 * Includes all possible types of activity content views
 */
sealed class ActivityContentView {

    abstract fun setToActivity(activity: BaseActivity)

    data class FromRes(
        @LayoutRes val res: Int
    ) : ActivityContentView() {

        override fun setToActivity(activity: BaseActivity) {
            activity.setContentView(res)
        }
    }

    data class FromViewClass(
        val view: View
    ) : ActivityContentView() {

        override fun setToActivity(activity: BaseActivity) {
            activity.setContentView(view)
        }
    }
}