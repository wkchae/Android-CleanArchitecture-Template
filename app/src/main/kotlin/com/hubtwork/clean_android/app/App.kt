package com.hubtwork.clean_android.app

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@HiltAndroidApp
class App: Application() {

    override fun getApplicationContext(): Context {
        return super.getApplicationContext()
    }

}