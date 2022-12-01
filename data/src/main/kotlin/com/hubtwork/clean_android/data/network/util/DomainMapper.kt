package com.hubtwork.clean_android.data.network.util

import com.hubtwork.clean_android.data.network.model.ResponseModel
import com.hubtwork.clean_android.domain.util.io.DataException

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

@Throws(DataException.JSONParseException::class, DataException.UnknownException::class)
fun <Domain> ResponseModel<Domain>.toDomainSafe(): Domain {
    try {
        if (!isValid) throw IllegalArgumentException()
        return toDomain()
    } catch (e: Throwable) {
        when(e) {
            is IllegalArgumentException,
            is NullPointerException -> {
                throw DataException.JSONParseException
            }
            else -> throw DataException.UnknownException(cause = e)
        }
    }
}