import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun FluentTheme(
    colorScheme: ColorScheme = lightColorScheme(),
    typography: Typography = Typography(),
    elevation: Elevation = lightElevation(),
    shapes: Shapes = Shapes(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
        LocalTypography provides typography,
        LocalElevation provides elevation,
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

    val elevation
        @Composable
        @ReadOnlyComposable
        get() = LocalElevation.current

    val shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

}