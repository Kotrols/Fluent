import androidx.compose.foundation.interaction.*
import androidx.compose.runtime.*
import kotlinx.coroutines.flow.collect

@Composable
fun InteractionSource.collectInteractionAsState(): State<Interaction?> {
    val interactions = remember { mutableStateListOf<Interaction>() }
    LaunchedEffect(this) {
        this@collectInteractionAsState.interactions.collect { interaction ->
            when (interaction) {
                is HoverInteraction.Enter -> {
                    interactions.add(interaction)
                }

                is HoverInteraction.Exit -> {
                    interactions.remove(interaction.enter)
                }

                is FocusInteraction.Focus -> {
                    interactions.add(interaction)
                }

                is FocusInteraction.Unfocus -> {
                    interactions.remove(interaction.focus)
                }

                is PressInteraction.Press -> {
                    interactions.add(interaction)
                }

                is PressInteraction.Release -> {
                    interactions.remove(interaction.press)
                }

                is PressInteraction.Cancel -> {
                    interactions.remove(interaction.press)
                }

                is DragInteraction.Start -> {
                    interactions.add(interaction)
                }

                is DragInteraction.Stop -> {
                    interactions.remove(interaction.start)
                }

                is DragInteraction.Cancel -> {
                    interactions.remove(interaction.start)
                }
            }
        }
    }
    return rememberUpdatedState(interactions.lastOrNull())
}