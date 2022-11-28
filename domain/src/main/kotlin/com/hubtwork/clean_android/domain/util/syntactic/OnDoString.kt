package com.hubtwork.clean_android.domain.util.syntactic

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
/*
    All of On-Do Methods are inline and with contract, so only in kotlin ( @JvmSynthetic )
 */
@JvmSynthetic
@OnDoInlineOnly
inline fun String?.onNotNullOrEmpty(
    doIf: (String) -> Unit,
): String? {
    contract {
        callsInPlace(doIf, InvocationKind.AT_MOST_ONCE)
    }
    this.onNotNullOrEmpty(
        doIf = doIf,
        doIfNot = { }
    )
    return this
}

@JvmSynthetic
@OnDoInlineOnly
inline fun String?.onNotNullOrEmpty(
    doIf: (String) -> Unit,
    doIfNot: () -> Unit,
): String? {
    contract {
        callsInPlace(doIf, InvocationKind.AT_MOST_ONCE)
        callsInPlace(doIfNot, InvocationKind.AT_MOST_ONCE)
    }
    if (this.isNullOrEmpty()) doIfNot()
    else doIf(this)
    return this
}