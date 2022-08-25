import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerIconDefaults
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HyperlinkButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: HyperlinkButtonColors = HyperlinkButtonDefaults.hyperlinkButtonColors(),
    focus: HyperlinkButtonFocus = HyperlinkButtonDefaults.hyperlinkButtonFocus(),
    shape: Shape = HyperlinkButtonDefaults.Shape,
    contentPadding: PaddingValues = HyperlinkButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    val backgroundColor by colors.backgroundColor(enabled, interactionSource)
    val contentColor by colors.contentColor(enabled, interactionSource)
    val focusOuterStroke by focus.outerStroke(enabled, interactionSource)
    val focusInnerStroke by focus.innerStroke(enabled, interactionSource)
    Box(
        modifier = modifier
            .focusStroke(
                outer = focusOuterStroke,
                inner = focusInnerStroke,
                shape = shape
            )
            .clip(shape)
            .background(backgroundColor)
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
            .pointerHoverIcon(PointerIconDefaults.Hand)
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides FluentTheme.typography.body
        ) {
            Row(
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = HyperlinkButtonDefaults.MinWidth,
                        minHeight = HyperlinkButtonDefaults.MinHeight
                    )
                    .padding(contentPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                content = content
            )
        }
    }
}

object HyperlinkButtonDefaults {

    val MinWidth = 50.dp
    val MinHeight = 32.dp

    val ContentPadding = PaddingValues(
        start = 12.dp,
        end = 12.dp,
        top = 5.dp,
        bottom = 7.dp
    )

    val Shape
        @Composable
        @ReadOnlyComposable
        get() = FluentTheme.shapes.small

    @Composable
    fun hyperlinkButtonColors(
        backgroundColor: Color = FluentTheme.colorScheme.fillSubtleTransparent,
        backgroundHoverColor: Color = FluentTheme.colorScheme.fillSubtleSecondary,
        backgroundPressedColor: Color = FluentTheme.colorScheme.fillSubtleTertiary,
        backgroundDisabledColor: Color = FluentTheme.colorScheme.fillSubtleDisabled,
        backgroundFocusedColor: Color = backgroundColor,
        contentColor: Color = FluentTheme.colorScheme.textAccentPrimary,
        contentHoverColor: Color = FluentTheme.colorScheme.textAccentSecondary,
        contentPressedColor: Color = FluentTheme.colorScheme.textAccentTertiary,
        contentDisabledColor: Color = FluentTheme.colorScheme.textAccentDisabled,
        contentFocusedColor: Color = contentColor,
    ): HyperlinkButtonColors {
        return DefaultHyperlinkButtonColors(
            backgroundColor = backgroundColor,
            backgroundHoverColor = backgroundHoverColor,
            backgroundPressedColor = backgroundPressedColor,
            backgroundDisabledColor = backgroundDisabledColor,
            backgroundFocusedColor = backgroundFocusedColor,
            contentColor = contentColor,
            contentHoverColor = contentHoverColor,
            contentPressedColor = contentPressedColor,
            contentDisabledColor = contentDisabledColor,
            contentFocusedColor = contentFocusedColor,
        )
    }

    @Composable
    fun hyperlinkButtonFocus(
        innerStroke: Color = FluentTheme.colorScheme.strokeFocusInner,
        outerStroke: Color = FluentTheme.colorScheme.strokeFocusOuter
    ): HyperlinkButtonFocus {
        return DefaultHyperlinkButtonFocus(
            innerStroke = innerStroke,
            outerStroke = outerStroke
        )
    }

}

interface HyperlinkButtonColors {

    @Composable
    fun backgroundColor(enabled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun contentColor(enabled: Boolean, interactionSource: InteractionSource): State<Color>

}

interface HyperlinkButtonFocus {

    @Composable
    fun innerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun outerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

}

@Immutable
data class DefaultHyperlinkButtonColors(
    private val backgroundColor: Color,
    private val backgroundHoverColor: Color,
    private val backgroundPressedColor: Color,
    private val backgroundDisabledColor: Color,
    private val backgroundFocusedColor: Color,
    private val contentColor: Color,
    private val contentHoverColor: Color,
    private val contentPressedColor: Color,
    private val contentDisabledColor: Color,
    private val contentFocusedColor: Color,
) : HyperlinkButtonColors {

    @Composable
    override fun backgroundColor(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
        val interaction by interactionSource.collectInteractionAsState()

        val target = if (!enabled) {
            backgroundDisabledColor
        } else {
            when (interaction) {
                is PressInteraction.Press -> backgroundPressedColor
                is HoverInteraction.Enter -> backgroundHoverColor
                is FocusInteraction.Focus -> backgroundFocusedColor
                else -> backgroundColor
            }
        }
        return rememberUpdatedState(target)
    }

    @Composable
    override fun contentColor(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
        val interaction by interactionSource.collectInteractionAsState()

        val target = if (!enabled) {
            contentDisabledColor
        } else {
            when (interaction) {
                is PressInteraction.Press -> contentPressedColor
                is HoverInteraction.Enter -> contentHoverColor
                is FocusInteraction.Focus -> contentFocusedColor
                else -> contentColor
            }
        }
        return rememberUpdatedState(target)
    }
}

@Immutable
data class DefaultHyperlinkButtonFocus(
    private val innerStroke: Color,
    private val outerStroke: Color,
) : HyperlinkButtonFocus {

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