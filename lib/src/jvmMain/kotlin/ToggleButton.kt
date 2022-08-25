import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun ToggleButton(
    onToggle: (Boolean) -> Unit,
    toggled: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ToggleButtonColors = ToggleButtonDefaults.toggleButtonColors(),
    border: ToggleButtonBorders = ToggleButtonDefaults.toggleButtonBorders(),
    focus: ToggleButtonFocus = ToggleButtonDefaults.buttonFocus(),
    shape: Shape = ToggleButtonDefaults.Shape,
    contentPadding: PaddingValues = ToggleButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    val backgroundColor by colors.backgroundColor(enabled, toggled, interactionSource)
    val contentColor by colors.contentColor(enabled, toggled, interactionSource)
    val focusOuterStroke by focus.outerStroke(enabled, interactionSource)
    val focusInnerStroke by focus.innerStroke(enabled, interactionSource)
    val borderStroke by border.border(enabled, toggled, interactionSource)
    Box(
        modifier = modifier
            .focusStroke(
                outer = focusOuterStroke,
                inner = focusInnerStroke,
                shape = shape
            )
            .clip(shape)
            .background(backgroundColor)
            .toggleable(
                onValueChange = onToggle,
                value = toggled,
                indication = null,
                interactionSource = interactionSource,
                enabled = enabled,
                role = Role.Button
            )
            .focusable(
                enabled = enabled,
                interactionSource = interactionSource
            )
            .then(if (borderStroke != null) Modifier.border(borderStroke!!, shape) else Modifier)
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides FluentTheme.typography.body
        ) {
            Row(
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = ToggleButtonDefaults.MinWidth,
                        minHeight = ToggleButtonDefaults.MinHeight
                    )
                    .padding(contentPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                content = content
            )
        }
    }
}

object ToggleButtonDefaults {

    val MinWidth = 120.dp
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
    fun toggleButtonColors(
        backgroundColor: Color = FluentTheme.colorScheme.fillControlDefault,
        backgroundToggledColor: Color = FluentTheme.colorScheme.fillAccentDefault,
        backgroundHoverColor: Color = FluentTheme.colorScheme.fillControlSecondary,
        backgroundToggledHoverColor: Color = FluentTheme.colorScheme.fillAccentSecondary,
        backgroundPressedColor: Color = FluentTheme.colorScheme.fillControlTertiary,
        backgroundToggledPressedColor: Color = FluentTheme.colorScheme.fillAccentTertiary,
        backgroundDisabledColor: Color = FluentTheme.colorScheme.fillControlDisabled,
        backgroundToggledDisabledColor: Color = FluentTheme.colorScheme.fillAccentDisabled,
        backgroundFocusedColor: Color = backgroundColor,
        backgroundToggledFocusedColor: Color = backgroundToggledColor,
        contentColor: Color = FluentTheme.colorScheme.textPrimary,
        contentToggledColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        contentHoverColor: Color = FluentTheme.colorScheme.textPrimary,
        contentToggledHoverColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        contentPressedColor: Color = FluentTheme.colorScheme.textSecondary,
        contentToggledPressedColor: Color = FluentTheme.colorScheme.textOnAccentSecondary,
        contentDisabledColor: Color = FluentTheme.colorScheme.textDisabled,
        contentToggledDisabledColor: Color = FluentTheme.colorScheme.textOnAccentDisabled,
        contentFocusedColor: Color = contentColor,
        contentToggledFocusedColor: Color = contentToggledColor,
    ): ToggleButtonColors {
        return DefaultToggleButtonColors(
            backgroundColor = backgroundColor,
            backgroundToggledColor = backgroundToggledColor,
            backgroundHoverColor = backgroundHoverColor,
            backgroundToggledHoverColor = backgroundToggledHoverColor,
            backgroundPressedColor = backgroundPressedColor,
            backgroundToggledPressedColor = backgroundToggledPressedColor,
            backgroundDisabledColor = backgroundDisabledColor,
            backgroundToggledDisabledColor = backgroundToggledDisabledColor,
            backgroundFocusedColor = backgroundFocusedColor,
            backgroundToggledFocusedColor = backgroundToggledFocusedColor,
            contentColor = contentColor,
            contentToggledColor = contentToggledColor,
            contentHoverColor = contentHoverColor,
            contentToggledHoverColor = contentToggledHoverColor,
            contentPressedColor = contentPressedColor,
            contentToggledPressedColor = contentToggledPressedColor,
            contentDisabledColor = contentDisabledColor,
            contentToggledDisabledColor = contentToggledDisabledColor,
            contentFocusedColor = contentFocusedColor,
            contentToggledFocusedColor = contentToggledFocusedColor
        )
    }

    @Composable
    fun toggleButtonBorders(
        stroke: BorderStroke? = BorderStroke(
            width = 1.dp,
            brush = FluentTheme.borderElevation.control
        ),
        strokeToggled: BorderStroke? = BorderStroke(
            width = 1.dp,
            brush = FluentTheme.borderElevation.accentControl
        ),
        strokeHover: BorderStroke? = stroke,
        strokeToggledHover: BorderStroke? = strokeToggled,
        strokePressed: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.strokeControlDefault
        ),
        strokeToggledPressed: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.strokeControlOnAccentDefault
        ),
        strokeDisabled: BorderStroke? = strokePressed,
        strokeToggledDisabled: BorderStroke? = strokeToggledPressed,
        strokeFocused: BorderStroke? = stroke,
        strokeToggledFocused: BorderStroke? = strokeToggled,
    ): ToggleButtonBorders {
        return DefaultToggleButtonBorders(
            stroke = stroke,
            strokeToggled = strokeToggled,
            strokeHover = strokeHover,
            strokeToggledHover = strokeToggledHover,
            strokePressed = strokePressed,
            strokeToggledPressed = strokeToggledPressed,
            strokeDisabled = strokeDisabled,
            strokeToggledDisabled = strokeToggledDisabled,
            strokeFocused = strokeFocused,
            strokeToggledFocused = strokeToggledFocused
        )
    }

    @Composable
    fun buttonFocus(
        innerStroke: Color = FluentTheme.colorScheme.strokeFocusInner,
        outerStroke: Color = FluentTheme.colorScheme.strokeFocusOuter
    ): ToggleButtonFocus {
        return DefaultToggleButtonFocus(
            innerStroke = innerStroke,
            outerStroke = outerStroke
        )
    }

}

interface ToggleButtonColors {

    @Composable
    fun backgroundColor(enabled: Boolean, toggled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun contentColor(enabled: Boolean, toggled: Boolean, interactionSource: InteractionSource): State<Color>

}

interface ToggleButtonBorders {

    @Composable
    fun border(enabled: Boolean, toggled: Boolean, interactionSource: InteractionSource): State<BorderStroke?>

}

interface ToggleButtonFocus {

    @Composable
    fun innerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun outerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

}

@Immutable
data class DefaultToggleButtonColors(
    private val backgroundColor: Color,
    private val backgroundToggledColor: Color,
    private val backgroundHoverColor: Color,
    private val backgroundToggledHoverColor: Color,
    private val backgroundPressedColor: Color,
    private val backgroundToggledPressedColor: Color,
    private val backgroundDisabledColor: Color,
    private val backgroundToggledDisabledColor: Color,
    private val backgroundFocusedColor: Color,
    private val backgroundToggledFocusedColor: Color,
    private val contentColor: Color,
    private val contentToggledColor: Color,
    private val contentHoverColor: Color,
    private val contentToggledHoverColor: Color,
    private val contentPressedColor: Color,
    private val contentToggledPressedColor: Color,
    private val contentDisabledColor: Color,
    private val contentToggledDisabledColor: Color,
    private val contentFocusedColor: Color,
    private val contentToggledFocusedColor: Color,
) : ToggleButtonColors {

    @Composable
    override fun backgroundColor(enabled: Boolean, toggled: Boolean, interactionSource: InteractionSource): State<Color> {
        val interaction by interactionSource.collectInteractionAsState()
        val target = if (!enabled) {
            when (toggled) {
                true -> backgroundToggledDisabledColor
                false -> backgroundDisabledColor
            }
        } else {
            when (interaction) {
                is PressInteraction.Press -> when (toggled) {
                    true -> backgroundToggledPressedColor
                    false -> backgroundPressedColor
                }
                is HoverInteraction.Enter -> when (toggled) {
                    true -> backgroundToggledHoverColor
                    false -> backgroundHoverColor
                }
                is FocusInteraction.Focus -> when (toggled) {
                    true -> backgroundToggledFocusedColor
                    false -> backgroundFocusedColor
                }
                else -> when (toggled) {
                    true -> backgroundToggledColor
                    false -> backgroundColor
                }
            }
        }
        return rememberUpdatedState(target)
    }

    @Composable
    override fun contentColor(enabled: Boolean, toggled: Boolean, interactionSource: InteractionSource): State<Color> {
        val interaction by interactionSource.collectInteractionAsState()
        val target = if (!enabled) {
            when (toggled) {
                true -> contentToggledDisabledColor
                false -> contentDisabledColor
            }
        } else {
            when (interaction) {
                is PressInteraction.Press -> when (toggled) {
                    true -> contentToggledPressedColor
                    false -> contentPressedColor
                }
                is HoverInteraction.Enter -> when (toggled) {
                    true -> contentToggledHoverColor
                    false -> contentHoverColor
                }
                is FocusInteraction.Focus -> when (toggled) {
                    true -> contentToggledFocusedColor
                    false -> contentFocusedColor
                }
                else -> when (toggled) {
                    true -> contentToggledColor
                    false -> contentColor
                }
            }
        }
        return rememberUpdatedState(target)
    }
}

@Immutable
data class DefaultToggleButtonBorders(
    private val stroke: BorderStroke?,
    private val strokeToggled: BorderStroke?,
    private val strokeHover: BorderStroke?,
    private val strokeToggledHover: BorderStroke?,
    private val strokePressed: BorderStroke?,
    private val strokeToggledPressed: BorderStroke?,
    private val strokeDisabled: BorderStroke?,
    private val strokeToggledDisabled: BorderStroke?,
    private val strokeFocused: BorderStroke?,
    private val strokeToggledFocused: BorderStroke?,
) : ToggleButtonBorders {

    @Composable
    override fun border(enabled: Boolean, toggled: Boolean, interactionSource: InteractionSource): State<BorderStroke?> {
        val interaction by interactionSource.collectInteractionAsState()

        val target = if (!enabled) {
            when (toggled) {
                true -> strokeToggledDisabled
                false -> strokeDisabled
            }
        } else {
            when (interaction) {
                is PressInteraction.Press -> when (toggled) {
                    true -> strokeToggledPressed
                    false -> strokePressed
                }
                is HoverInteraction.Enter -> when (toggled) {
                    true -> strokeToggledHover
                    false -> strokeHover
                }
                is FocusInteraction.Focus -> when (toggled) {
                    true -> strokeToggledFocused
                    false -> strokeFocused
                }
                else -> when (toggled) {
                    true -> strokeToggled
                    false -> stroke
                }
            }
        }
        return rememberUpdatedState(target)
    }

}

@Immutable
data class DefaultToggleButtonFocus(
    private val innerStroke: Color,
    private val outerStroke: Color,
) : ToggleButtonFocus {

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