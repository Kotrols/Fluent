import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AcrylicSurface(
    modifier: Modifier = Modifier,
    color: Color = FluentTheme.colorScheme.backgroundAcrylicDefault,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier,
        propagateMinConstraints = true
    ) {
        Canvas(modifier.matchParentSize().blur(60.dp)) {
            drawRect(
                color = color,
                blendMode = BlendMode.Luminosity
            )
        }
        content()
    }
}

@Composable
fun MicaSurface(
    modifier: Modifier = Modifier,
    color: Color = FluentTheme.colorScheme.backgroundMicaBase,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier,
        propagateMinConstraints = true
    ) {
        Canvas(modifier.matchParentSize().blur(240.dp)) {
            drawRect(
                color = color,
                blendMode = BlendMode.Luminosity
            )
        }
        content()
    }
}