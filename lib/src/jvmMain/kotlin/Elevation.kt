import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import org.jetbrains.skia.ImageFilter

actual fun Modifier.shadows(shadows: List<Shadow>, shape: Shape): Modifier {
    return if (shadows.isNotEmpty()) {
        val filter = if (shadows.size == 1) {
            val shadow = shadows.first()
            shadow.toImageFilterShadow()
        } else {
            ImageFilter.makeMerge(
                filters = shadows.map {
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
//                frameworkPaint.imageFilter = filter
//            }
//        }
    } else Modifier
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
