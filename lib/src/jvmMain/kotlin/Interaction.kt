import androidx.compose.foundation.interaction.*
import androidx.compose.runtime.*
import kotlinx.coroutines.flow.collect

@Composable
fun InteractionSource.collectInteractionAsState(): State<Interaction?> {
    val lastInteraction = remember { mutableStateOf<Interaction?>(null) }
    LaunchedEffect(this) {
        this@collectInteractionAsState.interactions.collect { interaction ->
            when (interaction) {
                is HoverInteraction.Enter -> {
                    lastInteraction.value = interaction
                }
                is HoverInteraction.Exit -> {
                    lastInteraction.value = null
                }
                is FocusInteraction.Focus -> {
                    lastInteraction.value = interaction
                }
                is FocusInteraction.Unfocus -> {
                    lastInteraction.value = null
                }
                is PressInteraction.Press -> {
                    lastInteraction.value = interaction
                }
                is PressInteraction.Release -> {
                    lastInteraction.value = null
                }
                is PressInteraction.Cancel -> {
                    lastInteraction.value = null
                }
            }
        }
    }
    return lastInteraction
}