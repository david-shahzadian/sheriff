package com.example.sheriff.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Base class for all the activity classes
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * Content view to be set to current activity
     */
    protected abstract val activityContentView: ActivityContentView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityContentView.setToActivity(this)
    }
}