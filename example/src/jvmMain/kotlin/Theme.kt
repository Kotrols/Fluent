import androidx.compose.runtime.Composable

@Composable
fun FluentExampleTheme(
    isDark: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when (isDark) {
        true -> darkColorScheme()
        false -> lightColorScheme()
    }
    val borderElevation = when (isDark) {
        true -> darkBorderElevation()
        false -> lightBorderElevation()
    }
    val shadowElevation = when (isDark) {
        true -> darkShadowElevation()
        false -> lightShadowElevation()
    }
    FluentTheme(
        colorScheme = colorScheme,
        borderElevation = borderElevation,
        shadowElevation = shadowElevation,
        content = content
    )
}