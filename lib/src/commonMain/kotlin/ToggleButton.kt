import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
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
    focus: ToggleButtonFocus = ToggleButtonDefaults.toggleButtonFocus(),
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
        backgroundHoverColor: Color = FluentTheme.colorScheme.fillControlSecondary,
        backgroundPressedColor: Color = FluentTheme.colorScheme.fillControlTertiary,
        backgroundDisabledColor: Color = FluentTheme.colorScheme.fillControlDisabled,
        backgroundFocusedColor: Color = backgroundColor,
        toggledBackgroundColor: Color = FluentTheme.colorScheme.fillAccentDefault,
        toggledBackgroundHoverColor: Color = FluentTheme.colorScheme.fillAccentSecondary,
        toggledBackgroundPressedColor: Color = FluentTheme.colorScheme.fillAccentTertiary,
        toggledBackgroundDisabledColor: Color = FluentTheme.colorScheme.fillAccentDisabled,
        toggledBackgroundFocusedColor: Color = toggledBackgroundColor,
        contentColor: Color = FluentTheme.colorScheme.textPrimary,
        contentHoverColor: Color = FluentTheme.colorScheme.textPrimary,
        contentPressedColor: Color = FluentTheme.colorScheme.textSecondary,
        contentDisabledColor: Color = FluentTheme.colorScheme.textDisabled,
        contentFocusedColor: Color = contentColor,
        toggledContentColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        toggledContentHoverColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        toggledContentPressedColor: Color = FluentTheme.colorScheme.textOnAccentSecondary,
        toggledContentDisabledColor: Color = FluentTheme.colorScheme.textOnAccentDisabled,
        toggledContentFocusedColor: Color = toggledContentColor,
    ): ToggleButtonColors {
        return DefaultToggleButtonColors(
            backgroundColor = backgroundColor,
            backgroundHoverColor = backgroundHoverColor,
            backgroundPressedColor = backgroundPressedColor,
            backgroundDisabledColor = backgroundDisabledColor,
            backgroundFocusedColor = backgroundFocusedColor,
            toggledBackgroundColor = toggledBackgroundColor,
            toggledBackgroundHoverColor = toggledBackgroundHoverColor,
            toggledBackgroundPressedColor = toggledBackgroundPressedColor,
            toggledBackgroundDisabledColor = toggledBackgroundDisabledColor,
            toggledBackgroundFocusedColor = toggledBackgroundFocusedColor,
            contentColor = contentColor,
            contentHoverColor = contentHoverColor,
            contentPressedColor = contentPressedColor,
            contentDisabledColor = contentDisabledColor,
            contentFocusedColor = contentFocusedColor,
            toggledContentColor = toggledContentColor,
            toggledContentHoverColor = toggledContentHoverColor,
            toggledContentPressedColor = toggledContentPressedColor,
            toggledContentDisabledColor = toggledContentDisabledColor,
            toggledContentFocusedColor = toggledContentFocusedColor
        )
    }

    @Composable
    fun toggleButtonBorders(
        stroke: BorderStroke? = BorderStroke(
            width = 1.dp,
            brush = FluentTheme.borderElevation.control
        ),
        strokeHover: BorderStroke? = stroke,
        strokePressed: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.strokeControlDefault
        ),
        strokeDisabled: BorderStroke? = strokePressed,
        strokeFocused: BorderStroke? = stroke,
        toggledStroke: BorderStroke? = BorderStroke(
            width = 1.dp,
            brush = FluentTheme.borderElevation.accentControl
        ),
        toggledStrokeHover: BorderStroke? = toggledStroke,
        toggledStrokePressed: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.strokeControlOnAccentDefault
        ),
        toggledStrokeDisabled: BorderStroke? = null,
        toggledStrokeFocused: BorderStroke? = toggledStroke,
    ): ToggleButtonBorders {
        return DefaultToggleButtonBorders(
            stroke = stroke,
            strokeHover = strokeHover,
            strokePressed = strokePressed,
            strokeDisabled = strokeDisabled,
            strokeFocused = strokeFocused,
            toggledStroke = toggledStroke,
            toggledStrokeHover = toggledStrokeHover,
            toggledStrokePressed = toggledStrokePressed,
            toggledStrokeDisabled = toggledStrokeDisabled,
            toggledStrokeFocused = toggledStrokeFocused
        )
    }

    @Composable
    fun toggleButtonFocus(
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
    private val backgroundHoverColor: Color,
    private val backgroundPressedColor: Color,
    private val backgroundDisabledColor: Color,
    private val backgroundFocusedColor: Color,
    private val toggledBackgroundColor: Color,
    private val toggledBackgroundHoverColor: Color,
    private val toggledBackgroundPressedColor: Color,
    private val toggledBackgroundDisabledColor: Color,
    private val toggledBackgroundFocusedColor: Color,
    private val contentColor: Color,
    private val contentHoverColor: Color,
    private val contentPressedColor: Color,
    private val contentDisabledColor: Color,
    private val contentFocusedColor: Color,
    private val toggledContentColor: Color,
    private val toggledContentHoverColor: Color,
    private val toggledContentPressedColor: Color,
    private val toggledContentDisabledColor: Color,
    private val toggledContentFocusedColor: Color,
) : ToggleButtonColors {

    @Composable
    override fun backgroundColor(
        enabled: Boolean,
        toggled: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val interaction by interactionSource.collectInteractionAsState()
        val target = if (!enabled) {
            when (toggled) {
                true -> toggledBackgroundDisabledColor
                false -> backgroundDisabledColor
            }
        } else {
            when (interaction) {
                is PressInteraction.Press -> when (toggled) {
                    true -> toggledBackgroundPressedColor
                    false -> backgroundPressedColor
                }

                is HoverInteraction.Enter -> when (toggled) {
                    true -> toggledBackgroundHoverColor
                    false -> backgroundHoverColor
                }

                is FocusInteraction.Focus -> when (toggled) {
                    true -> toggledBackgroundFocusedColor
                    false -> backgroundFocusedColor
                }

                else -> when (toggled) {
                    true -> toggledBackgroundColor
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
                true -> toggledContentDisabledColor
                false -> contentDisabledColor
            }
        } else {
            when (interaction) {
                is PressInteraction.Press -> when (toggled) {
                    true -> toggledContentPressedColor
                    false -> contentPressedColor
                }

                is HoverInteraction.Enter -> when (toggled) {
                    true -> toggledContentHoverColor
                    false -> contentHoverColor
                }

                is FocusInteraction.Focus -> when (toggled) {
                    true -> toggledContentFocusedColor
                    false -> contentFocusedColor
                }

                else -> when (toggled) {
                    true -> toggledContentColor
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
    private val strokeHover: BorderStroke?,
    private val strokePressed: BorderStroke?,
    private val strokeDisabled: BorderStroke?,
    private val strokeFocused: BorderStroke?,
    private val toggledStroke: BorderStroke?,
    private val toggledStrokeHover: BorderStroke?,
    private val toggledStrokePressed: BorderStroke?,
    private val toggledStrokeDisabled: BorderStroke?,
    private val toggledStrokeFocused: BorderStroke?,
) : ToggleButtonBorders {

    @Composable
    override fun border(
        enabled: Boolean,
        toggled: Boolean,
        interactionSource: InteractionSource
    ): State<BorderStroke?> {
        val interaction by interactionSource.collectInteractionAsState()

        val target = if (!enabled) {
            when (toggled) {
                true -> toggledStrokeDisabled
                false -> strokeDisabled
            }
        } else {
            when (interaction) {
                is PressInteraction.Press -> when (toggled) {
                    true -> toggledStrokePressed
                    false -> strokePressed
                }

                is HoverInteraction.Enter -> when (toggled) {
                    true -> toggledStrokeHover
                    false -> strokeHover
                }

                is FocusInteraction.Focus -> when (toggled) {
                    true -> toggledStrokeFocused
                    false -> strokeFocused
                }

                else -> when (toggled) {
                    true -> toggledStroke
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