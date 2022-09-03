import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp

internal fun Modifier.focusStroke(
    outerColor: Color,
    innerColor: Color,
    shape: Shape
) = drawBehind {
    val innerStrokeWidth = 2.dp.toPx()
    val outerStrokeWidth = 3.dp.toPx()

    val innerStrokeOffset = 1.dp.toPx()
    val innerStrokeTranslateOffset = -(innerStrokeOffset / 2)
    val outerStrokeOffset = innerStrokeWidth + (outerStrokeWidth / 2)
    val outerStrokeTranslateOffset = -(outerStrokeOffset / 2)

    translateEvenly(innerStrokeTranslateOffset) {
        drawOutline(
            outline = shape.createOutline(
                size = size + Size(innerStrokeOffset),
                layoutDirection = layoutDirection,
                density = this
            ),
            color = innerColor,
            style = Stroke(innerStrokeWidth),
        )
    }
    translateEvenly(outerStrokeTranslateOffset + innerStrokeTranslateOffset) {
        drawOutline(
            outline = shape.createOutline(
                size = size + Size(outerStrokeOffset + innerStrokeOffset),
                layoutDirection = layoutDirection,
                density = this
            ),
            color = outerColor,
            style = Stroke(outerStrokeWidth),
        )
    }
}

private inline fun DrawScope.translateEvenly(
    topLeft: Float,
    block: DrawScope.() -> Unit,
) {
    translate(
        top = topLeft,
        left = topLeft,
        block = block
    )
}

private fun Size(size: Float): Size = Size(width = size, height = size)

private operator fun Size.plus(other: Size): Size {
    return Size(this.width + other.width, this.height + other.height)
}