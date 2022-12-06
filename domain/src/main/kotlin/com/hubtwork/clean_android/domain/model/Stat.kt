package com.hubtwork.clean_android.domain.model

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

typealias StatParam = Pair<Int,Int>
data class Stat(
    val base: Int = 0,
    val effort: Int = 0,
    private val max: Int = 300,
) {
    val percentage: Double get() = base.toDouble().div(max)

    constructor(param: StatParam) : this(param.first, param.second)
}