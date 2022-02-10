@file:Suppress("MagicNumber")
package com.example.android.dboard.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

/*
 DTC Color system
 Global Design System WIP tokens as defined in
 https://docs.google.com/spreadsheets/d/1UmYpt-7YrV9103H8aKBnDeq-3OJcSRBUmdjZigofbig/edit#gid=920609416
 */
val appColors = appColors()

// Default fall-back colours
@Suppress("LongParameterList")
fun appColors(
    primary: Color = BrandPrimary,
    primaryVariant: Color = BrandPrimary,
    secondary: Color = BrandLight,
    secondaryVariant: Color = BrandMedium,
    background: Color = BrandDark,
    surface: Color = BrandLight,
    error: Color = AlertDim,
    onPrimary: Color = Neutral10,
    onSecondary: Color =  Neutral4_50,
    onBackground: Color = Neutral7,
    onSurface: Color = Neutral8,
    onError: Color = Neutral10,
    isLight: Boolean = false
): Colors = Colors(
    primary,
    primaryVariant,
    secondary,
    secondaryVariant,
    background,
    surface,
    error,
    onPrimary,
    onSecondary,
    onBackground,
    onSurface,
    onError,
    isLight
)

const val COLOR_BRAND_PRIMARY = 0xFF2175D9
const val COLOR_BRAND_HIGHLIGHT = 0xFF2789FF
const val COLOR_BRAND_HOVER = 0xFF1968C7
const val COLOR_BRAND_LIGHT = 0xFF262931
const val COLOR_BRAND_MEDIUM = 0xFF1A1C21
const val COLOR_BRAND_DARK = 0xFF121317

// BrandColors
val BrandPrimary = Color(COLOR_BRAND_PRIMARY)
val BrandHighlight = Color(COLOR_BRAND_HIGHLIGHT)
val BrandHover = Color(COLOR_BRAND_HOVER)
val BrandLight = Color(COLOR_BRAND_LIGHT)
val BrandMedium = Color(COLOR_BRAND_MEDIUM)
val BrandDark = Color(COLOR_BRAND_DARK)

// UtilityColors
val AlertBright = Color(0xFFFF405D)
val AlertDim = Color(0xFFD9203C)
val Success = Color(0xFF78C54A)
val Warning = Color(0xFFFFA424)

// Neutral
val Neutral1 = Color(0xFF000000)
val Neutral2 = Color(0xFF282D33)
val Neutral3 = Color(0xFF383E47)
val Neutral4 = Color(0xFF545A62)
val Neutral5 = Color(0xFF6C727A)
val Neutral6 = Color(0xFF838991)
val Neutral7 = Color(0xFF9BA1A9)
val Neutral8 = Color(0xFFBFC5CD)
val Neutral9 = Color(0xFFD6DCE4)
val Neutral10 = Color(0xFFFFFFFF)

// Alpha
val Neutral1_60 = Color(0x66000000)
val Neutral2_70 = Color(0xB3282D33)
val Neutral3_80 = Color(0xCC383E47)
val Neutral4_50 = Color(0x80807A7E)
val Neutral5_50 = Color(0x806C727A)
val Neutral6_30 = Color(0x4D838991)
val Neutral9_50 = Color(0x80D6DCE4)
val Neutral10_80 = Color(0xCCFFFFFF)
val Neutral10_70 = Color(0xB3FFFFFF)
val Neutral10_60 = Color(0x99FFFFFF)
val Neutral10_50 = Color(0x80FFFFFF)
val Neutral10_40 = Color(0x66FFFFFF)
val Neutral10_30 = Color(0x4DFFFFFF)
val Neutral10_20 = Color(0x33FFFFFF)

// Dplus Theme colours
val textColors = appColors(
    background = BrandDark,
    onBackground = Neutral10,
    surface = BrandLight,
    onSurface = Neutral10
)

// Debug Theme
val debugColors = appColors(
    // TODO Move to debug / testing module
    primary = AlertDim,
    primaryVariant = AlertDim,
    secondary = Success,
    secondaryVariant = Success,
    background = Neutral1,
    surface = Success,
    error = Warning,
    onPrimary = Neutral10,
    onSecondary = Neutral10,
    onBackground = Neutral10,
    onSurface = Neutral10,
    onError = Neutral10,
)
