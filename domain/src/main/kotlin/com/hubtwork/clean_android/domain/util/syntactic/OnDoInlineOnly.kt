package com.hubtwork.clean_android.domain.util.syntactic

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

/**
 * InCase extensions will just allowed in launch
 */
@DslMarker
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
)
@Retention(AnnotationRetention.BINARY)
internal annotation class OnDoInlineOnly