package com.hubtwork.clean_android.domain.util.io

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

sealed interface DataErrorType {
    data class HTTP(val statusCode: Int): DataErrorType

    object Unknown: DataErrorType
}