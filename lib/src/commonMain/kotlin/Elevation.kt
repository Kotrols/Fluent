import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*

fun lightBorderElevation(
    control: Brush = Brush.linearGradient(
        0.82f to Color(0x0F000000),
        0.91f to Color(0x0F000000),
        1f to Color(0x29000000),
        start = Offset.Zero,
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
    ),
    circle: Brush = Brush.linearGradient(
        0.5f to Color(0x0F000000),
        0.95f to Color(0x29000000),
        start = Offset.Zero,
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
    ),
    textControl: Brush = Brush.linearGradient(
        1f to Color(0x0F000000),
        1f to Color(0x72000000),
        start = Offset.Zero,
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
    ),
    textControlFocused: Brush = Brush.linearGradient(
        0.97f to Color(0x0F000000),
        0.97f to Color(0xFF0067C0),
        start = Offset.Zero,
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
    ),
    accentControl: Brush = Brush.linearGradient(
        0.91f to Color(0x14FFFFFF),
        1f to Color(0x66000000),
        start = Offset.Zero,
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
    )
): BorderElevation {
    return BorderElevation(
        control = control,
        circle = circle,
        textControl = textControl,
        textControlFocused = textControlFocused,
        accentControl = accentControl
    )
}

fun darkBorderElevation(
    control: Brush = Brush.linearGradient(
        0f to Color(0x18FFFFFF),
        0.1f to Color(0x12FFFFFF),
        start = Offset.Zero,
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
    ),
    circle: Brush = Brush.linearGradient(
        0f to Color(0x18FFFFFF),
        0.5f to Color(0x12FFFFFF),
        start = Offset.Zero,
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
    ),
    textControl: Brush = Brush.linearGradient(
        1f to Color(0x14FFFFFF),
        1f to Color(0x8BFFFFFF),
        1f to Color(0x8BFFFFFF),
        start = Offset.Zero,
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
    ),
    textControlFocused: Brush = Brush.linearGradient(
        0.97f to Color(0x14FFFFFF),
        0.97f to Color(0xFF4CC2FF),
        start = Offset.Zero,
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
    ),
    accentControl: Brush = Brush.linearGradient(
        0.91f to Color(0x14FFFFFF),
        1f to Color(0x24000000),
        start = Offset.Zero,
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
    )
): BorderElevation {
    return BorderElevation(
        control = control,
        circle = circle,
        textControl = textControl,
        textControlFocused = textControlFocused,
        accentControl = accentControl
    )
}

@Immutable
data class BorderElevation(
    val control: Brush,
    val circle: Brush,
    val textControl: Brush,
    val textControlFocused: Brush,
    val accentControl: Brush
)

fun lightShadowElevation(
    cardRest: List<Shadow> = listOf(
        Shadow(
            color = Color(0x0A000000),
            offset = Offset(x = 0f, y = 2f),
            blurRadius = 4f
        )
    ),
    cardHover: List<Shadow> = listOf(
        Shadow(
            color = Color(0x1A000000),
            offset = Offset(x = 0f, y = 2f),
            blurRadius = 4f
        )
    ),
    tooltip: List<Shadow> = listOf(
        Shadow(
            color = Color(0x24000000),
            offset = Offset(x = 0f, y = 4f),
            blurRadius = 8f
        )
    ),
    flyout: List<Shadow> = listOf(
        Shadow(
            color = Color(0x24000000),
            offset = Offset(x = 0f, y = 8f),
            blurRadius = 16f
        )
    ),
    dialog: List<Shadow> = listOf(
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
    ),
    inactiveWindow: List<Shadow> = listOf(
        Shadow(
            color = Color(0x26000000),
            offset = Offset(x = 10.67f, y = 2f),
            blurRadius = 21f
        ),
        Shadow(
            color = Color(0x30000000),
            offset = Offset(x = 0f, y = 16f),
            blurRadius = 32f
        ),
    ),
    activeWindow: List<Shadow> = listOf(
        Shadow(
            color = Color(0x38000000),
            offset = Offset(x = 0f, y = 2f),
            blurRadius = 21f
        ),
        Shadow(
            color = Color(0x47000000),
            offset = Offset(x = 0f, y = 32f),
            blurRadius = 64f
        ),
    )
): ShadowElevation {
    return ShadowElevation(
        cardRest = cardRest,
        cardHover = cardHover,
        tooltip = tooltip,
        flyout = flyout,
        dialog = dialog,
        inactiveWindow = inactiveWindow,
        activeWindow = activeWindow
    )
}

fun darkShadowElevation(
    cardRest: List<Shadow> = listOf(
        Shadow(
            color = Color(0x21000000),
            offset = Offset(x = 0f, y = 2f),
            blurRadius = 4f
        )
    ),
    cardHover: List<Shadow> = listOf(
        Shadow(
            color = Color(0x42000000),
            offset = Offset(x = 0f, y = 2f),
            blurRadius = 4f
        )
    ),
    tooltip: List<Shadow> = listOf(
        Shadow(
            color = Color(0x42000000),
            offset = Offset(x = 0f, y = 4f),
            blurRadius = 8f
        )
    ),
    flyout: List<Shadow> = listOf(
        Shadow(
            color = Color(0x42000000),
            offset = Offset(x = 0f, y = 8f),
            blurRadius = 16f
        )
    ),
    dialog: List<Shadow> = listOf(
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
    ),
    inactiveWindow: List<Shadow> = listOf(
        Shadow(
            color = Color(0x5E000000),
            offset = Offset(x = 10.67f, y = 2f),
            blurRadius = 21f
        ),
        Shadow(
            color = Color(0x5E000000),
            offset = Offset(x = 0f, y = 16f),
            blurRadius = 32f
        ),
    ),
    activeWindow: List<Shadow> = listOf(
        Shadow(
            color = Color(0x8C000000),
            offset = Offset(x = 0f, y = 2f),
            blurRadius = 21f
        ),
        Shadow(
            color = Color(0x8F000000),
            offset = Offset(x = 0f, y = 32f),
            blurRadius = 64f
        ),
    )
): ShadowElevation {
    return ShadowElevation(
        cardRest = cardRest,
        cardHover = cardHover,
        tooltip = tooltip,
        flyout = flyout,
        dialog = dialog,
        inactiveWindow = inactiveWindow,
        activeWindow = activeWindow
    )
}

@Immutable
data class ShadowElevation(
    val cardRest: List<Shadow>,
    val cardHover: List<Shadow>,
    val tooltip: List<Shadow>,
    val flyout: List<Shadow>,
    val dialog: List<Shadow>,
    val inactiveWindow: List<Shadow>,
    val activeWindow: List<Shadow>
)

expect fun Modifier.shadows(shadows: List<Shadow>, shape: Shape): Modifier

internal val LocalBorderElevation = staticCompositionLocalOf { lightBorderElevation() }
internal val LocalShadowElevation = staticCompositionLocalOf { lightShadowElevation() }