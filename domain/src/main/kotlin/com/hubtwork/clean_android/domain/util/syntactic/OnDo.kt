package com.hubtwork.clean_android.domain.util.syntactic

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

@JvmSynthetic
@OnDoInlineOnly
inline fun <T> T.on(
    condition: Boolean?,
    doIf: () -> Unit,
): T {
    contract {
        callsInPlace(doIf, InvocationKind.AT_MOST_ONCE)
    }
    if (condition == true) this.apply { doIf() }
    return this
}

@JvmSynthetic
@OnDoInlineOnly
inline fun <T> T.on(
    condition: (T) -> Boolean?,
    doIf: () -> Unit,
): T {
    contract {
        callsInPlace(doIf, InvocationKind.AT_MOST_ONCE)
    }
    if (condition(this) == true) this.apply { doIf() }
    return this
}
