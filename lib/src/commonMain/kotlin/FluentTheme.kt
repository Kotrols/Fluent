import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun FluentTheme(
    colorScheme: ColorScheme = lightColorScheme(),
    typography: Typography = Typography(),
    borderElevation: BorderElevation = lightBorderElevation(),
    shadowElevation: ShadowElevation = lightShadowElevation(),
    shapes: Shapes = Shapes(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
        LocalTypography provides typography,
        LocalBorderElevation provides borderElevation,
        LocalShadowElevation provides shadowElevation,
        LocalShapes provides shapes,
    ) {
        content()
    }
}

object FluentTheme {

    val colorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current

    val typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val borderElevation
        @Composable
        @ReadOnlyComposable
        get() = LocalBorderElevation.current

    val shadowElevation
        @Composable
        @ReadOnlyComposable
        get() = LocalShadowElevation.current

    val shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

}