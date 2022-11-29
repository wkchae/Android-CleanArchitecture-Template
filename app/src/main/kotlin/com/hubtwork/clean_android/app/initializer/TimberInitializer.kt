package com.hubtwork.clean_android.app.initializer

import android.content.Context
import androidx.startup.Initializer
import com.hubtwork.clean_android.app.BuildConfig
import timber.log.Timber

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
class TimberInitializer: Initializer<Unit> {
    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.d("Timber Initialized.")
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}