package com.hubtwork.clean_android.presentation.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hubtwork.clean_android.presentation.R
import com.hubtwork.clean_android.presentation.databinding.ActivitySampleBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

@AndroidEntryPoint
class SampleActivity: AppCompatActivity(R.layout.activity_sample) {
    private lateinit var binding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sample)
    }
}