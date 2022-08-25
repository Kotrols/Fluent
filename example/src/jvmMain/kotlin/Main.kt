import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.application

@Composable
fun App(
    isDark: Boolean,
    requestThemeChange: () -> Unit,
) {
    FluentExampleTheme(isDark = isDark) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ToggleButton(
                toggled = isDark,
                onToggle = { requestThemeChange() }
            ) {
                Text("Theme: ${if (isDark) "Dark" else "Light"}")
            }
        }
    }
}

fun main() = application {
    var isDark by remember { mutableStateOf(false) }
    MicaWindow(
        onCloseRequest = ::exitApplication,
        isDark = isDark,
        title = "Compose Window",
    ) {
        App(
            isDark = isDark,
            requestThemeChange = {
                isDark = !isDark
            }
        )
    }
}
