package com.example.android.dboard.ui.theme

import android.content.res.Resources
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Suppress("UnnecessaryAbstractClass")
abstract class AppDimensions {
    abstract val baseline: Dp
}

@Suppress("UnnecessaryAbstractClass")
abstract class AppDimensionsCardExtended(height: Dp, width: Dp, innerDivideGuideLine: Dp) {
    abstract val height: Dp
    abstract val width: Dp
    abstract val innerDivideGuideLine: Dp
    abstract val paddingHeight: Dp
    abstract val paddingWidth: Dp
    abstract val paddingOuter: Dp
    abstract val paddingInner: Dp
    abstract val widthChannelLogo: Dp
    abstract val heightChannelLogo: Dp
    abstract val heightBrandingLogo: Dp
}

/**
 * Easy method for converting the pixel values to Dp values to be used in the Dimensions classes. Simply add .pxToDp to the end
 * of the Int value that represents your pixel value. eg > 16.pxToDp
 */
val Int.pxToDp: Dp get() = (this / Resources.getSystem().displayMetrics.density).dp

val Dp.dpToPx: Int get() = (value * Resources.getSystem().displayMetrics.density).toInt()

/**
 * Figma designs also don't make use of SP values, until this is fixed, this helper method can be used to convert Px to Sp
 */
val Int.pxToSp: TextUnit get() = (this / Resources.getSystem().displayMetrics.scaledDensity).sp
