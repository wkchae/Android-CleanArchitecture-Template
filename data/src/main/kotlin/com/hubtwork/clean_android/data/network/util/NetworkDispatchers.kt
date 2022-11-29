package com.hubtwork.clean_android.data.network.util

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */


@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatchers: NetworkDispatchers)
enum class NetworkDispatchers {
    Default, IO
}