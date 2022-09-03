import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

fun lightColorScheme(
    textPrimary: Color = Color(0xE4000000),
    textSecondary: Color = Color(0x9B000000),
    textTertiary: Color = Color(0x72000000),
    textDisabled: Color = Color(0x5C000000),
    textAccentPrimary: Color = Color(0xFF003E92),
    textAccentSecondary: Color = Color(0xFF001A68),
    textAccentTertiary: Color = Color(0xFF005FB8),
    textAccentDisabled: Color = Color(0x5C000000),
    textOnAccentPrimary: Color = Color(0xFFFFFFFF),
    textOnAccentSecondary: Color = Color(0xB2FFFFFF),
    textOnAccentDisabled: Color = Color(0xFFFFFFFF),
    textOnAccentSelected: Color = Color(0xFFFFFFFF),
    fillControlDefault: Color = Color(0xB2FFFFFF),
    fillControlSecondary: Color = Color(0x80F9F9F9),
    fillControlTertiary: Color = Color(0x4DF9F9F9),
    fillControlDisabled: Color = Color(0x4DF9F9F9),
    fillControlTransparent: Color = Color.Transparent,
    fillControlInputActive: Color = Color(0xFFFFFFFF),
    fillControlAltTransparent: Color = Color.Transparent,
    fillControlAltSecondary: Color = Color(0x06000000),
    fillControlAltTertiary: Color = Color(0x0F000000),
    fillControlAltQuarternary: Color = Color(0x18000000),
    fillControlAltDisabled: Color = Color.Transparent,
    fillControlStrongDefault: Color = Color(0x72000000),
    fillControlStrongDisabled: Color = Color(0x51000000),
    fillControlOnImageDefault: Color = Color(0xC9FFFFFF),
    fillControlOnImageSecondary: Color = Color(0xFFF3F3F3),
    fillControlOnImageTertiary: Color = Color(0xFFEBEBEB),
    fillControlOnImageDisabled: Color = Color.Transparent,
    fillSubtleTransparent: Color = Color.Transparent,
    fillSubtleSecondary: Color = Color(0x0A000000),
    fillSubtleTertiary: Color = Color(0x06000000),
    fillSubtleDisabled: Color = Color.Transparent,
    fillAccentDefault: Color = Color(0xFF005FB8),
    fillAccentSecondary: Color = Color(0xE5005FB8),
    fillAccentTertiary: Color = Color(0xCC005FB8),
    fillAccentDisabled: Color = Color(0x37000000),
    fillAccentSelectedTextBackground: Color = Color(0xFF0078D4),
    strokeControlDefault: Color = Color(0x0F000000),
    strokeControlSecondary: Color = Color(0x29000000),
    strokeControlOnAccentDefault: Color = Color(0x14FFFFFF),
    strokeControlOnAccentSecondary: Color = Color(0x66000000),
    strokeControlOnAccentTertiary: Color = Color(0x37000000),
    strokeControlOnAccentDisabled: Color = Color(0x0F000000),
    strokeControlForStrongFillWhenOnImage: Color = Color(0x59FFFFFF),
    strokeCardDefault: Color = Color(0x0F000000),
    strokeCardDefaultSolid: Color = Color(0xFFEBEBEB),
    strokeControlStrongDefault: Color = Color(0x72000000),
    strokeControlStrongDisabled: Color = Color(0x37000000),
    strokeSurfaceDefault: Color = Color(0x66757575),
    strokeSurfaceFlyout: Color = Color(0x0F000000),
    strokeDivider: Color = Color(0x14000000),
    strokeFocusOuter: Color = Color(0xE4000000),
    strokeFocusInner: Color = Color(0xFFFFFFFF),
    backgroundCardDefault: Color = Color(0xB2FFFFFF),
    backgroundCardSecondary: Color = Color(0x80F6F6F6),
    backgroundSmoke: Color = Color(0x4D000000),
    backgroundLayerDefault: Color = Color(0x80FFFFFF),
    backgroundLayerAlt: Color = Color(0xFFFFFFFF),
    backgroundLayerOnAcrylic: Color = Color(0x40FFFFFF),
    backgroundSolidBase: Color = Color(0xFFF3F3F3),
    backgroundSolidSecondary: Color = Color(0xFFEEEEEE),
    backgroundSolidTertiary: Color = Color(0xFFF9F9F9),
    backgroundSolidQuarternary: Color = Color(0xFFFFFFFF),
    backgroundMicaBase: Color = Color(0xFFF3F3F3),
    backgroundAcrylicDefault: Color = Color(0xD9FCFCFC),
    backgroundAcrylicBase: Color = Color(0xE5F3F3F3),
    backgroundAcrylicAccentDefault: Color = Color(0xE599EBFF),
    backgroundAcrylicAccentBase: Color = Color(0xE599EBFF),
    systemAttention: Color = Color(0xFF005FB7),
    systemAttentionBackground: Color = Color(0x80F6F6F6),
    systemAttentionSolidBackground: Color = Color(0xFFF7F7F7),
    systemSuccess: Color = Color(0xFF0F7B0F),
    systemSuccessBackground: Color = Color(0xFFDFF6DD),
    systemCaution: Color = Color(0xFF9D5D00),
    systemCautionBackground: Color = Color(0xFFDFF6DD),
    systemCritical: Color = Color(0xFFC42B1C),
    systemCriticalBackground: Color = Color(0xFFFDE7E9),
    systemNeutral: Color = Color(0x72000000),
    systemNeutralBackground: Color = Color(0x06000000),
    systemNeutralSolid: Color = Color(0xFF8A8A8A),
    systemNeutralSolidBackground: Color = Color(0xFFF3F3F3),
): ColorScheme {
    return ColorScheme(
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        textTertiary = textTertiary,
        textDisabled = textDisabled,
        textAccentPrimary = textAccentPrimary,
        textAccentSecondary = textAccentSecondary,
        textAccentTertiary = textAccentTertiary,
        textAccentDisabled = textAccentDisabled,
        textOnAccentPrimary = textOnAccentPrimary,
        textOnAccentSecondary = textOnAccentSecondary,
        textOnAccentDisabled = textOnAccentDisabled,
        textOnAccentSelected = textOnAccentSelected,
        fillControlDefault = fillControlDefault,
        fillControlSecondary = fillControlSecondary,
        fillControlTertiary = fillControlTertiary,
        fillControlDisabled = fillControlDisabled,
        fillControlTransparent = fillControlTransparent,
        fillControlInputActive = fillControlInputActive,
        fillControlAltTransparent = fillControlAltTransparent,
        fillControlAltSecondary = fillControlAltSecondary,
        fillControlAltTertiary = fillControlAltTertiary,
        fillControlAltQuarternary = fillControlAltQuarternary,
        fillControlAltDisabled = fillControlAltDisabled,
        fillControlStrongDefault = fillControlStrongDefault,
        fillControlStrongDisabled = fillControlStrongDisabled,
        fillControlOnImageDefault = fillControlOnImageDefault,
        fillControlOnImageSecondary = fillControlOnImageSecondary,
        fillControlOnImageTertiary = fillControlOnImageTertiary,
        fillControlOnImageDisabled = fillControlOnImageDisabled,
        fillSubtleTransparent = fillSubtleTransparent,
        fillSubtleSecondary = fillSubtleSecondary,
        fillSubtleTertiary = fillSubtleTertiary,
        fillSubtleDisabled = fillSubtleDisabled,
        fillAccentDefault = fillAccentDefault,
        fillAccentSecondary = fillAccentSecondary,
        fillAccentTertiary = fillAccentTertiary,
        fillAccentDisabled = fillAccentDisabled,
        fillAccentSelectedTextBackground = fillAccentSelectedTextBackground,
        strokeControlDefault = strokeControlDefault,
        strokeControlSecondary = strokeControlSecondary,
        strokeControlOnAccentDefault = strokeControlOnAccentDefault,
        strokeControlOnAccentSecondary = strokeControlOnAccentSecondary,
        strokeControlOnAccentTertiary = strokeControlOnAccentTertiary,
        strokeControlOnAccentDisabled = strokeControlOnAccentDisabled,
        strokeControlForStrongFillWhenOnImage = strokeControlForStrongFillWhenOnImage,
        strokeCardDefault = strokeCardDefault,
        strokeCardDefaultSolid = strokeCardDefaultSolid,
        strokeControlStrongDefault = strokeControlStrongDefault,
        strokeControlStrongDisabled = strokeControlStrongDisabled,
        strokeSurfaceDefault = strokeSurfaceDefault,
        strokeSurfaceFlyout = strokeSurfaceFlyout,
        strokeDivider = strokeDivider,
        strokeFocusOuter = strokeFocusOuter,
        strokeFocusInner = strokeFocusInner,
        backgroundCardDefault = backgroundCardDefault,
        backgroundCardSecondary = backgroundCardSecondary,
        backgroundSmoke = backgroundSmoke,
        backgroundLayerDefault = backgroundLayerDefault,
        backgroundLayerAlt = backgroundLayerAlt,
        backgroundLayerOnAcrylic = backgroundLayerOnAcrylic,
        backgroundSolidBase = backgroundSolidBase,
        backgroundSolidSecondary = backgroundSolidSecondary,
        backgroundSolidTertiary = backgroundSolidTertiary,
        backgroundSolidQuarternary = backgroundSolidQuarternary,
        backgroundMicaBase = backgroundMicaBase,
        backgroundAcrylicDefault = backgroundAcrylicDefault,
        backgroundAcrylicBase = backgroundAcrylicBase,
        backgroundAcrylicAccentDefault = backgroundAcrylicAccentDefault,
        backgroundAcrylicAccentBase = backgroundAcrylicAccentBase,
        systemAttention = systemAttention,
        systemAttentionBackground = systemAttentionBackground,
        systemAttentionSolidBackground = systemAttentionSolidBackground,
        systemSuccess = systemSuccess,
        systemSuccessBackground = systemSuccessBackground,
        systemCaution = systemCaution,
        systemCautionBackground = systemCautionBackground,
        systemCritical = systemCritical,
        systemCriticalBackground = systemCriticalBackground,
        systemNeutral = systemNeutral,
        systemNeutralBackground = systemNeutralBackground,
        systemNeutralSolid = systemNeutralSolid,
        systemNeutralSolidBackground = systemNeutralSolidBackground,
        isDark = false
    )
}

fun darkColorScheme(
    textPrimary: Color = Color(0xFFFFFFFF),
    textSecondary: Color = Color(0xC8FFFFFF),
    textTertiary: Color = Color(0x8BFFFFFF),
    textDisabled: Color = Color(0x5DFFFFFF),
    textAccentPrimary: Color = Color(0xFF99EBFF),
    textAccentSecondary: Color = Color(0xFF99EBFF),
    textAccentTertiary: Color = Color(0xFF60CDFF),
    textAccentDisabled: Color = Color(0x5DFFFFFF),
    textOnAccentPrimary: Color = Color(0xFF000000),
    textOnAccentSecondary: Color = Color(0x80000000),
    textOnAccentDisabled: Color = Color(0x87FFFFFF),
    textOnAccentSelected: Color = Color(0xFFFFFFFF),
    fillControlDefault: Color = Color(0x0FFFFFFF),
    fillControlSecondary: Color = Color(0x15FFFFFF),
    fillControlTertiary: Color = Color(0x08FFFFFF),
    fillControlDisabled: Color = Color(0x0BFFFFFF),
    fillControlTransparent: Color = Color.Transparent,
    fillControlInputActive: Color = Color(0xB21E1E1E),
    fillControlAltTransparent: Color = Color.Transparent,
    fillControlAltSecondary: Color = Color(0x1A000000),
    fillControlAltTertiary: Color = Color(0x0BFFFFFF),
    fillControlAltQuarternary: Color = Color(0x12FFFFFF),
    fillControlAltDisabled: Color = Color.Transparent,
    fillControlStrongDefault: Color = Color(0x8BFFFFFF),
    fillControlStrongDisabled: Color = Color(0x3FFFFFFF),
    fillControlOnImageDefault: Color = Color(0xB21C1C1C),
    fillControlOnImageSecondary: Color = Color(0xFF1A1A1A),
    fillControlOnImageTertiary: Color = Color(0xFF131313),
    fillControlOnImageDisabled: Color = Color.Transparent,
    fillSubtleTransparent: Color = Color.Transparent,
    fillSubtleSecondary: Color = Color(0x0FFFFFFF),
    fillSubtleTertiary: Color = Color(0x0BFFFFFF),
    fillSubtleDisabled: Color = Color.Transparent,
    fillAccentDefault: Color = Color(0xFF60CDFF),
    fillAccentSecondary: Color = Color(0xE560CDFF),
    fillAccentTertiary: Color = Color(0xCC60CDFF),
    fillAccentDisabled: Color = Color(0x28FFFFFF),
    fillAccentSelectedTextBackground: Color = Color(0xFF0078D4),
    strokeControlDefault: Color = Color(0x12FFFFFF),
    strokeControlSecondary: Color = Color(0x18FFFFFF),
    strokeControlOnAccentDefault: Color = Color(0x14FFFFFF),
    strokeControlOnAccentSecondary: Color = Color(0x24000000),
    strokeControlOnAccentTertiary: Color = Color(0x37000000),
    strokeControlOnAccentDisabled: Color = Color(0x33000000),
    strokeControlForStrongFillWhenOnImage: Color = Color(0x6B000000),
    strokeCardDefault: Color = Color(0x1A000000),
    strokeCardDefaultSolid: Color = Color(0xFF1C1C1C),
    strokeControlStrongDefault: Color = Color(0x8BFFFFFF),
    strokeControlStrongDisabled: Color = Color(0x28FFFFFF),
    strokeSurfaceDefault: Color = Color(0x66757575),
    strokeSurfaceFlyout: Color = Color(0x33000000),
    strokeDivider: Color = Color(0x15FFFFFF),
    strokeFocusOuter: Color = Color(0xFFFFFFFF),
    strokeFocusInner: Color = Color(0xB2000000),
    backgroundCardDefault: Color = Color(0x0DFFFFFF),
    backgroundCardSecondary: Color = Color(0x08FFFFFF),
    backgroundSmoke: Color = Color(0x4D000000),
    backgroundLayerDefault: Color = Color(0x4D3A3A3A),
    backgroundLayerAlt: Color = Color(0x0EFFFFFF),
    backgroundLayerOnAcrylic: Color = Color(0x09FFFFFF),
    backgroundSolidBase: Color = Color(0xFF202020),
    backgroundSolidSecondary: Color = Color(0xFF1C1C1C),
    backgroundSolidTertiary: Color = Color(0xFF282828),
    backgroundSolidQuarternary: Color = Color(0xFF2C2C2C),
    backgroundMicaBase: Color = Color(0xFF202020),
    backgroundAcrylicDefault: Color = Color(0xF52C2C2C),
    backgroundAcrylicBase: Color = Color(0xF5202020),
    backgroundAcrylicAccentDefault: Color = Color(0xCC003F92),
    backgroundAcrylicAccentBase: Color = Color(0xCC0078D4),
    systemAttention: Color = Color(0xFF60CDFF),
    systemAttentionBackground: Color = Color(0x08FFFFFF),
    systemAttentionSolidBackground: Color = Color(0xFF2E2E2E),
    systemSuccess: Color = Color(0xFF6CCB5F),
    systemSuccessBackground: Color = Color(0xFF393D1B),
    systemCaution: Color = Color(0xFFFCE100),
    systemCautionBackground: Color = Color(0xFF433519),
    systemCritical: Color = Color(0xFFFF99A4),
    systemCriticalBackground: Color = Color(0xFF442726),
    systemNeutral: Color = Color(0x8BFFFFFF),
    systemNeutralBackground: Color = Color(0x08FFFFFF),
    systemNeutralSolid: Color = Color(0xFF9D9D9D),
    systemNeutralSolidBackground: Color = Color(0xFF2E2E2E),
): ColorScheme {
    return ColorScheme(
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        textTertiary = textTertiary,
        textDisabled = textDisabled,
        textAccentPrimary = textAccentPrimary,
        textAccentSecondary = textAccentSecondary,
        textAccentTertiary = textAccentTertiary,
        textAccentDisabled = textAccentDisabled,
        textOnAccentPrimary = textOnAccentPrimary,
        textOnAccentSecondary = textOnAccentSecondary,
        textOnAccentDisabled = textOnAccentDisabled,
        textOnAccentSelected = textOnAccentSelected,
        fillControlDefault = fillControlDefault,
        fillControlSecondary = fillControlSecondary,
        fillControlTertiary = fillControlTertiary,
        fillControlDisabled = fillControlDisabled,
        fillControlTransparent = fillControlTransparent,
        fillControlInputActive = fillControlInputActive,
        fillControlAltTransparent = fillControlAltTransparent,
        fillControlAltSecondary = fillControlAltSecondary,
        fillControlAltTertiary = fillControlAltTertiary,
        fillControlAltQuarternary = fillControlAltQuarternary,
        fillControlAltDisabled = fillControlAltDisabled,
        fillControlStrongDefault = fillControlStrongDefault,
        fillControlStrongDisabled = fillControlStrongDisabled,
        fillControlOnImageDefault = fillControlOnImageDefault,
        fillControlOnImageSecondary = fillControlOnImageSecondary,
        fillControlOnImageTertiary = fillControlOnImageTertiary,
        fillControlOnImageDisabled = fillControlOnImageDisabled,
        fillSubtleTransparent = fillSubtleTransparent,
        fillSubtleSecondary = fillSubtleSecondary,
        fillSubtleTertiary = fillSubtleTertiary,
        fillSubtleDisabled = fillSubtleDisabled,
        fillAccentDefault = fillAccentDefault,
        fillAccentSecondary = fillAccentSecondary,
        fillAccentTertiary = fillAccentTertiary,
        fillAccentDisabled = fillAccentDisabled,
        fillAccentSelectedTextBackground = fillAccentSelectedTextBackground,
        strokeControlDefault = strokeControlDefault,
        strokeControlSecondary = strokeControlSecondary,
        strokeControlOnAccentDefault = strokeControlOnAccentDefault,
        strokeControlOnAccentSecondary = strokeControlOnAccentSecondary,
        strokeControlOnAccentTertiary = strokeControlOnAccentTertiary,
        strokeControlOnAccentDisabled = strokeControlOnAccentDisabled,
        strokeControlForStrongFillWhenOnImage = strokeControlForStrongFillWhenOnImage,
        strokeCardDefault = strokeCardDefault,
        strokeCardDefaultSolid = strokeCardDefaultSolid,
        strokeControlStrongDefault = strokeControlStrongDefault,
        strokeControlStrongDisabled = strokeControlStrongDisabled,
        strokeSurfaceDefault = strokeSurfaceDefault,
        strokeSurfaceFlyout = strokeSurfaceFlyout,
        strokeDivider = strokeDivider,
        strokeFocusOuter = strokeFocusOuter,
        strokeFocusInner = strokeFocusInner,
        backgroundCardDefault = backgroundCardDefault,
        backgroundCardSecondary = backgroundCardSecondary,
        backgroundSmoke = backgroundSmoke,
        backgroundLayerDefault = backgroundLayerDefault,
        backgroundLayerAlt = backgroundLayerAlt,
        backgroundLayerOnAcrylic = backgroundLayerOnAcrylic,
        backgroundSolidBase = backgroundSolidBase,
        backgroundSolidSecondary = backgroundSolidSecondary,
        backgroundSolidTertiary = backgroundSolidTertiary,
        backgroundSolidQuarternary = backgroundSolidQuarternary,
        backgroundMicaBase = backgroundMicaBase,
        backgroundAcrylicDefault = backgroundAcrylicDefault,
        backgroundAcrylicBase = backgroundAcrylicBase,
        backgroundAcrylicAccentDefault = backgroundAcrylicAccentDefault,
        backgroundAcrylicAccentBase = backgroundAcrylicAccentBase,
        systemAttention = systemAttention,
        systemAttentionBackground = systemAttentionBackground,
        systemAttentionSolidBackground = systemAttentionSolidBackground,
        systemSuccess = systemSuccess,
        systemSuccessBackground = systemSuccessBackground,
        systemCaution = systemCaution,
        systemCautionBackground = systemCautionBackground,
        systemCritical = systemCritical,
        systemCriticalBackground = systemCriticalBackground,
        systemNeutral = systemNeutral,
        systemNeutralBackground = systemNeutralBackground,
        systemNeutralSolid = systemNeutralSolid,
        systemNeutralSolidBackground = systemNeutralSolidBackground,
        isDark = true
    )
}

@Stable
class ColorScheme(
    textPrimary: Color,
    textSecondary: Color,
    textTertiary: Color,
    textDisabled: Color,
    textAccentPrimary: Color,
    textAccentSecondary: Color,
    textAccentTertiary: Color,
    textAccentDisabled: Color,
    textOnAccentPrimary: Color,
    textOnAccentSecondary: Color,
    textOnAccentDisabled: Color,
    textOnAccentSelected: Color,
    fillControlDefault: Color,
    fillControlSecondary: Color,
    fillControlTertiary: Color,
    fillControlDisabled: Color,
    fillControlTransparent: Color,
    fillControlInputActive: Color,
    fillControlAltTransparent: Color,
    fillControlAltSecondary: Color,
    fillControlAltTertiary: Color,
    fillControlAltQuarternary: Color,
    fillControlAltDisabled: Color,
    fillControlStrongDefault: Color,
    fillControlStrongDisabled: Color,
    fillControlOnImageDefault: Color,
    fillControlOnImageSecondary: Color,
    fillControlOnImageTertiary: Color,
    fillControlOnImageDisabled: Color,
    fillSubtleTransparent: Color,
    fillSubtleSecondary: Color,
    fillSubtleTertiary: Color,
    fillSubtleDisabled: Color,
    fillAccentDefault: Color,
    fillAccentSecondary: Color,
    fillAccentTertiary: Color,
    fillAccentDisabled: Color,
    fillAccentSelectedTextBackground: Color,
    strokeControlDefault: Color,
    strokeControlSecondary: Color,
    strokeControlOnAccentDefault: Color,
    strokeControlOnAccentSecondary: Color,
    strokeControlOnAccentTertiary: Color,
    strokeControlOnAccentDisabled: Color,
    strokeControlForStrongFillWhenOnImage: Color,
    strokeCardDefault: Color,
    strokeCardDefaultSolid: Color,
    strokeControlStrongDefault: Color,
    strokeControlStrongDisabled: Color,
    strokeSurfaceDefault: Color,
    strokeSurfaceFlyout: Color,
    strokeDivider: Color,
    strokeFocusOuter: Color,
    strokeFocusInner: Color,
    backgroundCardDefault: Color,
    backgroundCardSecondary: Color,
    backgroundSmoke: Color,
    backgroundLayerDefault: Color,
    backgroundLayerAlt: Color,
    backgroundLayerOnAcrylic: Color,
    backgroundSolidBase: Color,
    backgroundSolidSecondary: Color,
    backgroundSolidTertiary: Color,
    backgroundSolidQuarternary: Color,
    backgroundMicaBase: Color,
    backgroundAcrylicDefault: Color,
    backgroundAcrylicBase: Color,
    backgroundAcrylicAccentDefault: Color,
    backgroundAcrylicAccentBase: Color,
    systemAttention: Color,
    systemAttentionBackground: Color,
    systemAttentionSolidBackground: Color,
    systemSuccess: Color,
    systemSuccessBackground: Color,
    systemCaution: Color,
    systemCautionBackground: Color,
    systemCritical: Color,
    systemCriticalBackground: Color,
    systemNeutral: Color,
    systemNeutralBackground: Color,
    systemNeutralSolid: Color,
    systemNeutralSolidBackground: Color,
    isDark: Boolean
) {
    var textPrimary by mutableStateOf(textPrimary)
        internal set
    var textSecondary by mutableStateOf(textSecondary)
        internal set
    var textTertiary by mutableStateOf(textTertiary)
        internal set
    var textDisabled by mutableStateOf(textDisabled)
        internal set
    var textAccentPrimary by mutableStateOf(textAccentPrimary)
        internal set
    var textAccentSecondary by mutableStateOf(textAccentSecondary)
        internal set
    var textAccentTertiary by mutableStateOf(textAccentTertiary)
        internal set
    var textAccentDisabled by mutableStateOf(textAccentDisabled)
        internal set
    var textOnAccentPrimary by mutableStateOf(textOnAccentPrimary)
        internal set
    var textOnAccentSecondary by mutableStateOf(textOnAccentSecondary)
        internal set
    var textOnAccentDisabled by mutableStateOf(textOnAccentDisabled)
        internal set
    var textOnAccentSelected by mutableStateOf(textOnAccentSelected)
        internal set
    var fillControlDefault by mutableStateOf(fillControlDefault)
        internal set
    var fillControlSecondary by mutableStateOf(fillControlSecondary)
        internal set
    var fillControlTertiary by mutableStateOf(fillControlTertiary)
        internal set
    var fillControlDisabled by mutableStateOf(fillControlDisabled)
        internal set
    var fillControlTransparent by mutableStateOf(fillControlTransparent)
        internal set
    var fillControlInputActive by mutableStateOf(fillControlInputActive)
        internal set
    var fillControlAltTransparent by mutableStateOf(fillControlAltTransparent)
        internal set
    var fillControlAltSecondary by mutableStateOf(fillControlAltSecondary)
        internal set
    var fillControlAltTertiary by mutableStateOf(fillControlAltTertiary)
        internal set
    var fillControlAltQuarternary by mutableStateOf(fillControlAltQuarternary)
        internal set
    var fillControlAltDisabled by mutableStateOf(fillControlAltDisabled)
        internal set
    var fillControlStrongDefault by mutableStateOf(fillControlStrongDefault)
        internal set
    var fillControlStrongDisabled by mutableStateOf(fillControlStrongDisabled)
        internal set
    var fillControlOnImageDefault by mutableStateOf(fillControlOnImageDefault)
        internal set
    var fillControlOnImageSecondary by mutableStateOf(fillControlOnImageSecondary)
        internal set
    var fillControlOnImageTertiary by mutableStateOf(fillControlOnImageTertiary)
        internal set
    var fillControlOnImageDisabled by mutableStateOf(fillControlOnImageDisabled)
        internal set
    var fillSubtleTransparent by mutableStateOf(fillSubtleTransparent)
        internal set
    var fillSubtleSecondary by mutableStateOf(fillSubtleSecondary)
        internal set
    var fillSubtleTertiary by mutableStateOf(fillSubtleTertiary)
        internal set
    var fillSubtleDisabled by mutableStateOf(fillSubtleDisabled)
        internal set
    var fillAccentDefault by mutableStateOf(fillAccentDefault)
        internal set
    var fillAccentSecondary by mutableStateOf(fillAccentSecondary)
        internal set
    var fillAccentTertiary by mutableStateOf(fillAccentTertiary)
        internal set
    var fillAccentDisabled by mutableStateOf(fillAccentDisabled)
        internal set
    var fillAccentSelectedTextBackground by mutableStateOf(fillAccentSelectedTextBackground)
        internal set
    var strokeControlDefault by mutableStateOf(strokeControlDefault)
        internal set
    var strokeControlSecondary by mutableStateOf(strokeControlSecondary)
        internal set
    var strokeControlOnAccentDefault by mutableStateOf(strokeControlOnAccentDefault)
        internal set
    var strokeControlOnAccentSecondary by mutableStateOf(strokeControlOnAccentSecondary)
        internal set
    var strokeControlOnAccentTertiary by mutableStateOf(strokeControlOnAccentTertiary)
        internal set
    var strokeControlOnAccentDisabled by mutableStateOf(strokeControlOnAccentDisabled)
        internal set
    var strokeControlForStrongFillWhenOnImage by mutableStateOf(strokeControlForStrongFillWhenOnImage)
        internal set
    var strokeCardDefault by mutableStateOf(strokeCardDefault)
        internal set
    var strokeCardDefaultSolid by mutableStateOf(strokeCardDefaultSolid)
        internal set
    var strokeControlStrong by mutableStateOf(strokeControlStrongDefault)
        internal set
    var strokeControlStrongDisabled by mutableStateOf(strokeControlStrongDisabled)
        internal set
    var strokeSurfaceDefault by mutableStateOf(strokeSurfaceDefault)
        internal set
    var strokeSurfaceFlyout by mutableStateOf(strokeSurfaceFlyout)
        internal set
    var strokeDivider by mutableStateOf(strokeDivider)
        internal set
    var strokeFocusOuter by mutableStateOf(strokeFocusOuter)
        internal set
    var strokeFocusInner by mutableStateOf(strokeFocusInner)
        internal set
    var backgroundCardDefault by mutableStateOf(backgroundCardDefault)
        internal set
    var backgroundCardSecondary by mutableStateOf(backgroundCardSecondary)
        internal set
    var backgroundSmoke by mutableStateOf(backgroundSmoke)
        internal set
    var backgroundLayerDefault by mutableStateOf(backgroundLayerDefault)
        internal set
    var backgroundLayerAlt by mutableStateOf(backgroundLayerAlt)
        internal set
    var backgroundLayerOnAcrylic by mutableStateOf(backgroundLayerOnAcrylic)
        internal set
    var backgroundSolidBase by mutableStateOf(backgroundSolidBase)
        internal set
    var backgroundSolidSecondary by mutableStateOf(backgroundSolidSecondary)
        internal set
    var backgroundSolidTertiary by mutableStateOf(backgroundSolidTertiary)
        internal set
    var backgroundSolidQuarternary by mutableStateOf(backgroundSolidQuarternary)
        internal set
    var backgroundMicaBase by mutableStateOf(backgroundMicaBase)
        internal set
    var backgroundAcrylicDefault by mutableStateOf(backgroundAcrylicDefault)
        internal set
    var backgroundAcrylicBase by mutableStateOf(backgroundAcrylicBase)
        internal set
    var backgroundAcrylicAccentDefault by mutableStateOf(backgroundAcrylicAccentDefault)
        internal set
    var backgroundAcrylicAccentBase by mutableStateOf(backgroundAcrylicAccentBase)
        internal set
    var systemAttention by mutableStateOf(systemAttention)
        internal set
    var systemAttentionBackground by mutableStateOf(systemAttentionBackground)
        internal set
    var systemAttentionSolidBackground by mutableStateOf(systemAttentionSolidBackground)
        internal set
    var systemSuccess by mutableStateOf(systemSuccess)
        internal set
    var systemSuccessBackground by mutableStateOf(systemSuccessBackground)
        internal set
    var systemCaution by mutableStateOf(systemCaution)
        internal set
    var systemCautionBackground by mutableStateOf(systemCautionBackground)
        internal set
    var systemCritical by mutableStateOf(systemCritical)
        internal set
    var systemCriticalBackground by mutableStateOf(systemCriticalBackground)
        internal set
    var systemNeutral by mutableStateOf(systemNeutral)
        internal set
    var systemNeutralBackground by mutableStateOf(systemNeutralBackground)
        internal set
    var systemNeutralSolid by mutableStateOf(systemNeutralSolid)
        internal set
    var systemNeutralSolidBackground by mutableStateOf(systemNeutralSolidBackground)
        internal set
    var isDark by mutableStateOf(isDark)
        internal set
}

internal val LocalColorScheme = staticCompositionLocalOf { lightColorScheme() }