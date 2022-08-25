import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIconDefaults
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Hyperlink(
    onClick: () -> Unit,
    text: String,
    style: TextStyle = FluentTheme.typography.body,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: HyperlinkColors = HyperlinkDefaults.hyperlinkColors(),
    focus: HyperlinkFocus = HyperlinkDefaults.hyperlinkFocus(),
    decoration: HyperlinkDecoration = HyperlinkDefaults.hyperlinkDecoration(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val textColor by colors.color(enabled, interactionSource)
    val focusOuterStroke by focus.outerStroke(enabled, interactionSource)
    val focusInnerStroke by focus.innerStroke(enabled, interactionSource)
    val textDecoration by decoration.decoration(enabled, interactionSource)
    val textStyle = style.copy(textDecoration = textDecoration)
    Text(
        modifier = modifier
            .focusStroke(
                outer = focusOuterStroke,
                inner = focusInnerStroke,
                shape = FluentTheme.shapes.small
            )
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = interactionSource,
                enabled = enabled,
                role = Role.Button
            )
            .focusable(
                enabled = enabled,
                interactionSource = interactionSource
            )
            .pointerHoverIcon(PointerIconDefaults.Hand),
        text = text,
        style = textStyle,
        color = textColor
    )
}

object HyperlinkDefaults {

    @Composable
    fun hyperlinkColors(
        textColor: Color = FluentTheme.colorScheme.textAccentPrimary,
        textHoverColor: Color = FluentTheme.colorScheme.textAccentSecondary,
        textPressedColor: Color = FluentTheme.colorScheme.textAccentTertiary,
        textDisabledColor: Color = FluentTheme.colorScheme.textAccentDisabled,
        textFocusedColor: Color = textColor,
    ): HyperlinkColors {
        return DefaultHyperlinkColors(
            textColor = textColor,
            textHoverColor = textHoverColor,
            textPressedColor = textPressedColor,
            textDisabledColor = textDisabledColor,
            textFocusedColor = textFocusedColor
        )
    }
    
    @Composable
    fun hyperlinkDecoration(
        decoration: TextDecoration? = TextDecoration.Underline,
        decorationHover: TextDecoration? = null,
        decorationPressed: TextDecoration? = null,
        decorationDisabled: TextDecoration? = decoration,
        decorationFocused: TextDecoration? = decoration
    ): HyperlinkDecoration {
        return DefaultHyperlinkDecoration(
            decoration = decoration,
            decorationHover = decorationHover,
            decorationPressed = decorationPressed,
            decorationDisabled = decorationDisabled,
            decorationFocused = decorationFocused
        )
    }

    @Composable
    fun hyperlinkFocus(
        innerStroke: Color = FluentTheme.colorScheme.strokeFocusInner,
        outerStroke: Color = FluentTheme.colorScheme.strokeFocusOuter
    ): HyperlinkFocus {
        return DefaultHyperlinkFocus(
            innerStroke = innerStroke,
            outerStroke = outerStroke
        )
    }

}

interface HyperlinkColors {

    @Composable
    fun color(enabled: Boolean, interactionSource: InteractionSource): State<Color>

}

interface HyperlinkDecoration {

    @Composable
    fun decoration(enabled: Boolean, interactionSource: InteractionSource): State<TextDecoration?>

}

interface HyperlinkFocus {

    @Composable
    fun innerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun outerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

}

@Immutable
data class DefaultHyperlinkColors(
    private val textColor: Color,
    private val textHoverColor: Color,
    private val textPressedColor: Color,
    private val textDisabledColor: Color,
    private val textFocusedColor: Color
) : HyperlinkColors {

    @Composable
    override fun color(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
        val interaction by interactionSource.collectInteractionAsState()

        val target = if (!enabled) {
            textDisabledColor
        } else {
            when (interaction) {
                is PressInteraction.Press -> textPressedColor
                is HoverInteraction.Enter -> textHoverColor
                is FocusInteraction.Focus -> textFocusedColor
                else -> textColor
            }
        }
        return rememberUpdatedState(target)
    }
}

@Immutable
data class DefaultHyperlinkDecoration(
    private val decoration: TextDecoration?,
    private val decorationHover: TextDecoration?,
    private val decorationPressed: TextDecoration?,
    private val decorationDisabled: TextDecoration?,
    private val decorationFocused: TextDecoration?
): HyperlinkDecoration {

    @Composable
    override fun decoration(enabled: Boolean, interactionSource: InteractionSource): State<TextDecoration?> {
        val interaction by interactionSource.collectInteractionAsState()

        val target = if (!enabled) {
            decorationDisabled
        } else {
            when (interaction) {
                is PressInteraction.Press -> decorationPressed
                is HoverInteraction.Enter -> decorationHover
                is FocusInteraction.Focus -> decorationFocused
                else -> decoration
            }
        }
        return rememberUpdatedState(target)
    }
}

@Immutable
data class DefaultHyperlinkFocus(
    private val innerStroke: Color,
    private val outerStroke: Color,
) : HyperlinkFocus {

    @Composable
    override fun innerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
        val isFocused by interactionSource.collectIsFocusedAsState()
        return rememberUpdatedState(if (isFocused && enabled) innerStroke else Color.Transparent)
    }

    @Composable
    override fun outerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
        val isFocused by interactionSource.collectIsFocusedAsState()
        return rememberUpdatedState(if (isFocused && enabled) outerStroke else Color.Transparent)
    }

}