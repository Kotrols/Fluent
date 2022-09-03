import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.sp

val SegoeUIText = retrieveFontFamily("text")
val SegoeUIDisplay = retrieveFontFamily("display")
val SegoeUISmall = retrieveFontFamily("small")

@Immutable
data class Typography(
    val caption: TextStyle = TextStyle(
        fontFamily = SegoeUISmall,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    val body: TextStyle = TextStyle(
        fontFamily = SegoeUIText,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    val bodyStrong: TextStyle = TextStyle(
        fontFamily = SegoeUIText,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    val bodyLarge: TextStyle = TextStyle(
        fontFamily = SegoeUIText,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),
    val subtitle: TextStyle = TextStyle(
        fontFamily = SegoeUIDisplay,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp,
        lineHeight = 28.sp
    ),
    val title: TextStyle = TextStyle(
        fontFamily = SegoeUIDisplay,
        fontWeight = FontWeight.W600,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    val titleLarge: TextStyle = TextStyle(
        fontFamily = SegoeUIDisplay,
        fontWeight = FontWeight.W600,
        fontSize = 40.sp,
        lineHeight = 52.sp
    ),
    val display: TextStyle = TextStyle(
        fontFamily = SegoeUIDisplay,
        fontWeight = FontWeight.W600,
        fontSize = 68.sp,
        lineHeight = 92.sp
    ),
)

internal val LocalTypography = staticCompositionLocalOf { Typography() }

private fun retrieveFontFamily(fontType: String): FontFamily {
    return FontFamily(
        Font(
            resource = "font/segoe_${fontType}_light.ttf",
            weight = FontWeight.Light
        ),
        Font(
            resource = "font/segoe_${fontType}_semilight.ttf",
            weight = FontWeight(350)
        ),
        Font(
            resource = "font/segoe_${fontType}.ttf",
            weight = FontWeight.Normal
        ),
        Font(
            resource = "font/segoe_${fontType}_semibold.ttf",
            weight = FontWeight.SemiBold
        ),
        Font(
            resource = "font/segoe_${fontType}_bold.ttf",
            weight = FontWeight.Bold
        ),
    )
}