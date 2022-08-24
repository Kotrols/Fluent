import androidx.compose.foundation.border
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import org.jetbrains.skia.ImageFilter

fun lightElevation(
    level0: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x0F000000))
    ),
    level2: ElevationData = ElevationData(
        stroke = Brush.linearGradient(
            0.82f to Color(0x0F000000),
            0.91f to Color(0x0F000000),
            1f to Color(0x29000000),
            start = Offset.Zero,
            end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
        )
    ),
    level8: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x0F000000)),
        shadows = listOf(
            Shadow(
                color = Color(0x0A000000),
                offset = Offset(x = 0f, y = 2f),
                blurRadius = 4f
            )
        )
    ),
    level16: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x0F000000)),
        shadows = listOf(
            Shadow(
                color = Color(0x24000000),
                offset = Offset(x = 0f, y = 4f),
                blurRadius = 8f
            )
        )
    ),
    level32: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x0F000000)),
        shadows = listOf(
            Shadow(
                color = Color(0x24000000),
                offset = Offset(x = 0f, y = 8f),
                blurRadius = 16f
            )
        )
    ),
    level64: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x0F000000)),
        shadows = listOf(
            Shadow(
                color = Color(0x26000000),
                offset = Offset(x = 0f, y = 2f),
                blurRadius = 10.67f
            ),
            Shadow(
                color = Color(0x30000000),
                offset = Offset(x = 0f, y = 16f),
                blurRadius = 32f
            ),
        )
    ),
    level128: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x0F000000)),
        shadows = listOf(
            Shadow(
                color = Color(0x26000000),
                offset = Offset(x = 0f, y = 2f),
                blurRadius = 21f
            ),
            Shadow(
                color = Color(0x30000000),
                offset = Offset(x = 0f, y = 32f),
                blurRadius = 64f
            ),
        )
    ),
): Elevation {
    return Elevation(
        level0 = level0,
        level2 = level2,
        level8 = level8,
        level16 = level16,
        level32 = level32,
        level64 = level64,
        level128 = level128
    )
}

fun darkElevation(
    level0: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x1A000000))
    ),
    level2: ElevationData = ElevationData(
        stroke = Brush.linearGradient(
            0f to Color(0x18FFFFFF),
            0.5f to Color(0x12FFFFFF),
            start = Offset.Zero,
            end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
        )
    ),
    level8: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x33000000)),
        shadows = listOf(
            Shadow(
                color = Color(0x21000000),
                offset = Offset(x = 0f, y = 2f),
                blurRadius = 4f
            )
        )
    ),
    level16: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x33000000)),
        shadows = listOf(
            Shadow(
                color = Color(0x42000000),
                offset = Offset(x = 0f, y = 4f),
                blurRadius = 8f
            )
        )
    ),
    level32: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x33000000)),
        shadows = listOf(
            Shadow(
                color = Color(0x24000000),
                offset = Offset(x = 0f, y = 8f),
                blurRadius = 16f
            )
        )
    ),
    level64: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x33000000)),
        shadows = listOf(
            Shadow(
                color = Color(0x5E000000),
                offset = Offset(x = 0f, y = 2f),
                blurRadius = 10.67f
            ),
            Shadow(
                color = Color(0x5E000000),
                offset = Offset(x = 0f, y = 16f),
                blurRadius = 32f
            ),
        )
    ),
    level128: ElevationData = ElevationData(
        stroke = SolidColor(Color(0x33000000)),
        shadows = listOf(
            Shadow(
                color = Color(0x5E000000),
                offset = Offset(x = 0f, y = 2f),
                blurRadius = 21f
            ),
            Shadow(
                color = Color(0x5E000000),
                offset = Offset(x = 0f, y = 32f),
                blurRadius = 64f
            ),
        )
    ),
): Elevation {
    return Elevation(
        level0 = level0,
        level2 = level2,
        level8 = level8,
        level16 = level16,
        level32 = level32,
        level64 = level64,
        level128 = level128
    )
}

@Immutable
data class Elevation(
    val level0: ElevationData,
    val level2: ElevationData,
    val level8: ElevationData,
    val level16: ElevationData,
    val level32: ElevationData,
    val level64: ElevationData,
    val level128: ElevationData,
)

@Immutable
data class ElevationData(
    val stroke: Brush = SolidColor(Color.Black),
    val shadows: List<Shadow> = emptyList()
)

fun Modifier.elevation(
    data: ElevationData,
    shape: Shape,
) = border(width = 1.dp, brush = data.stroke, shape).also {
    if (data.shadows.isNotEmpty()) {
        val filter = if (data.shadows.size == 1) {
            val shadow = data.shadows.first()
            shadow.toImageFilterShadow()
        } else {
            ImageFilter.makeMerge(
                filters = data.shadows.map {
                    it.toImageFilterShadow()
                }.toTypedArray(),
                crop = null
            )
        }
        graphicsLayer(
            renderEffect = filter.asComposeRenderEffect()
        )
//        drawBehind {
//            val irect = when (val outline = shape.createOutline(size, layoutDirection, this)) {
//                is Outline.Generic -> {
//                    IRect.makeLTRB(
//                        l = outline.bounds.left.roundToInt(),
//                        r = outline.bounds.right.roundToInt(),
//                        t = outline.bounds.top.roundToInt(),
//                        b = outline.bounds.bottom.roundToInt()
//                    )
//                }
//                is Outline.Rectangle -> {
//                    RRect
//                    IRect.makeLTRB(
//                        l = outline.rect.left.roundToInt(),
//                        r = outline.rect.right.roundToInt(),
//                        t = outline.rect.top.roundToInt(),
//                        b = outline.rect.bottom.roundToInt()
//                    )
//                }
//                is Outline.Rounded -> {
//                    IRect.makeLTRB(
//                        l = outline.roundRect.left.roundToInt(),
//                        r = outline.roundRect.right.roundToInt(),
//                        t = outline.roundRect.top.roundToInt(),
//                        b = outline.roundRect.bottom.roundToInt()
//                    )
//                }
//            }
//            drawIntoCanvas {
//                val frameworkPaint = Paint().asFrameworkPaint()
//                frameworkPaint.imageFilter = ImageFilter.makeMerge(
//                    data.shadows.map { shadow ->
//                        ImageFilter.makeDropShadow(
//                            dx = shadow.offset.x,
//                            dy = shadow.offset.y,
//                            sigmaX = 0f,
//                            sigmaY = 0f,
//                            color = shadow.color.toArgb(),
//                            crop = irect
//                        )
//                    }.toTypedArray(),
//                    crop = irect
//                )
//            }
//        }
    }
}

private fun Shadow.toImageFilterShadow(): ImageFilter {
    return ImageFilter.makeDropShadow(
        dx = this.offset.x,
        dy = this.offset.y,
        sigmaX = blurRadius,
        sigmaY = blurRadius,
        color = this.color.toArgb(),
    )
}

internal val LocalElevation = staticCompositionLocalOf { lightElevation() }