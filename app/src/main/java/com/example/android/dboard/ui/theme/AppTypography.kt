package com.example.android.dboard.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Design System is WIP, but, these are the current Typography styles as defined by Design
 * https://www.figma.com/file/yKTYfH9LB4sMC7PkaQjRNM/discovery-Design-System-Guide-WIP?node-id=0%3A1
 */

val appTypography = AppTypography()

@Immutable
@Suppress("LongParameterList")
class AppTypography internal constructor(
    val titleExtraLarge: TextStyle,
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,

    val sectionExtraLarge: TextStyle,
    val sectionExtraLargeLight: TextStyle,
    val sectionLarge: TextStyle,
    val sectionLargeLight: TextStyle,
    val sectionSmall: TextStyle,

    val subTitleExtraLarge: TextStyle,
    val subTitleLarge: TextStyle,
    val subTitleMedium: TextStyle,
    val subTitleSmall: TextStyle,

    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val bodyMediumLight: TextStyle,
    val bodySmall: TextStyle,
    val bodySmallLight: TextStyle,
    val bodyMicro: TextStyle,

    val button: TextStyle,
    val badge: TextStyle,
) {
    constructor(
        defaultFontFamily: FontFamily = FontFamily.Default,
        titleExtraLarge: TextStyle = TextStyle(
            fontWeight = FontWeight.Black,
            fontSize = 36.sp,
            lineHeight = 40.sp,
            color = textColors.onBackground
        ),
        titleLarge: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            lineHeight = 36.sp,
            color = textColors.onBackground
        ),
        titleMedium: TextStyle = TextStyle(
            fontWeight = FontWeight.Black,
            fontSize = 28.sp,
            lineHeight = 32.sp,
            color = textColors.onBackground
        ),
        titleSmall: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = textColors.onBackground
        ),
        sectionExtraLarge: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            color = textColors.onBackground
        ),
        sectionExtraLargeLight: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            lineHeight = 32.sp,
            color = textColors.onBackground
        ),
        sectionLarge: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            lineHeight = 21.sp,
            color = textColors.onBackground
        ),
        sectionLargeLight: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = 21.sp,
            color = textColors.onBackground
        ),
        sectionSmall: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = textColors.onBackground
        ),
        subTitleExtraLarge: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            lineHeight = 20.sp,
            color = textColors.onBackground
        ),
        subTitleLarge: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = textColors.onBackground
        ),
        subTitleMedium: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = textColors.onBackground
        ),
        subTitleSmall: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = textColors.onBackground
        ),
        bodyLarge: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = textColors.onSurface
        ),
        bodyMedium: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = textColors.onSurface
        ),
        bodyMediumLight: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = textColors.onSurface
        ),
        bodySmall: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            color = textColors.onSurface
        ),
        bodySmallLight: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            color = textColors.onSurface
        ),
        bodyMicro: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = 16.sp,
            color = textColors.onSurface
        ),
        button: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 19.sp,
            letterSpacing = 1.sp,
            color = textColors.onBackground
        ),
        badge: TextStyle = TextStyle(
            fontWeight = FontWeight.Black,
            fontSize = 12.sp,
            lineHeight = 12.sp,
            letterSpacing = 1.5.sp,
            color = textColors.onBackground
        )

    ) : this(
        titleExtraLarge = titleExtraLarge.withDefaultFontFamily(defaultFontFamily),
        titleLarge = titleLarge.withDefaultFontFamily(defaultFontFamily),
        titleMedium = titleMedium.withDefaultFontFamily(defaultFontFamily),
        titleSmall = titleSmall.withDefaultFontFamily(defaultFontFamily),
        sectionExtraLarge = sectionExtraLarge.withDefaultFontFamily(defaultFontFamily),
        sectionExtraLargeLight = sectionExtraLargeLight.withDefaultFontFamily(defaultFontFamily),
        sectionLarge = sectionLarge.withDefaultFontFamily(defaultFontFamily),
        sectionLargeLight = sectionLargeLight.withDefaultFontFamily(defaultFontFamily),
        sectionSmall = sectionSmall.withDefaultFontFamily(defaultFontFamily),
        subTitleMedium = subTitleMedium.withDefaultFontFamily(defaultFontFamily),
        subTitleExtraLarge = subTitleExtraLarge.withDefaultFontFamily(defaultFontFamily),
        subTitleLarge = subTitleLarge.withDefaultFontFamily(defaultFontFamily),
        subTitleSmall = subTitleSmall.withDefaultFontFamily(defaultFontFamily),
        bodyLarge = bodyLarge.withDefaultFontFamily(defaultFontFamily),
        bodyMedium = bodyMedium.withDefaultFontFamily(defaultFontFamily),
        bodyMediumLight = bodyMediumLight.withDefaultFontFamily(defaultFontFamily),
        bodySmall = bodySmall.withDefaultFontFamily(defaultFontFamily),
        bodySmallLight = bodySmallLight.withDefaultFontFamily(defaultFontFamily),
        bodyMicro = bodyMicro.withDefaultFontFamily(defaultFontFamily),
        button = button.withDefaultFontFamily(defaultFontFamily),
        badge = badge.withDefaultFontFamily(defaultFontFamily),
    )

    /**
     * Returns a copy of this DiscoveryTypeScale, optionally overriding some of the values.
     */
    fun copy(
        titleExtraLarge: TextStyle = this.titleExtraLarge,
        titleLarge: TextStyle = this.titleLarge,
        titleMedium: TextStyle = this.titleMedium,
        titleSmall: TextStyle = this.titleSmall,
        sectionExtraLarge: TextStyle = this.sectionExtraLarge,
        sectionExtraLargeLight: TextStyle = this.sectionExtraLargeLight,
        sectionLarge: TextStyle = this.sectionLarge,
        sectionLargeLight: TextStyle = this.sectionLargeLight,
        sectionSmall: TextStyle = this.sectionSmall,
        subTitleExtraLarge: TextStyle = this.subTitleExtraLarge,
        subTitleLarge: TextStyle = this.subTitleLarge,
        subTitleMedium: TextStyle = this.subTitleMedium,
        subTitleSmall: TextStyle = this.subTitleSmall,
        bodyLarge: TextStyle = this.bodyLarge,
        bodyMedium: TextStyle = this.bodyMedium,
        bodyMediumLight: TextStyle = this.bodyMediumLight,
        bodySmall: TextStyle = this.bodySmall,
        bodySmallLight: TextStyle = this.bodySmallLight,
        bodyMicro: TextStyle = this.bodyMicro,
        button: TextStyle = this.button,
        badge: TextStyle = this.badge,
    ): AppTypography = AppTypography(
        titleExtraLarge = titleExtraLarge,
        titleLarge = titleLarge,
        titleMedium = titleMedium,
        titleSmall = titleSmall,
        sectionExtraLarge = sectionExtraLarge,
        sectionExtraLargeLight = sectionExtraLargeLight,
        sectionLarge = sectionLarge,
        sectionLargeLight = sectionLargeLight,
        sectionSmall = sectionSmall,
        subTitleExtraLarge = subTitleExtraLarge,
        subTitleLarge = subTitleLarge,
        subTitleMedium = subTitleMedium,
        subTitleSmall = subTitleSmall,
        bodyLarge = bodyLarge,
        bodyMedium = bodyMedium,
        bodyMediumLight = bodyMediumLight,
        bodySmall = bodySmall,
        bodySmallLight = bodySmallLight,
        bodyMicro = bodyMicro,
        button = button,
        badge = badge
    )
}

private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}

val DebugTypography = AppTypography(FontFamily.Default)
