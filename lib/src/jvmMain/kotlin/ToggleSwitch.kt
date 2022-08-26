import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun ToggleSwitch(
    onToggle: (Boolean) -> Unit,
    toggled: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ToggleSwitchColors = ToggleSwitchDefaults.toggleSwitchColors(),
    border: ToggleSwitchBorders = ToggleSwitchDefaults.toggleSwitchBorders(),
    focus: ToggleSwitchFocus = ToggleSwitchDefaults.toggleSwitchFocus(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    header: (@Composable () -> Unit)? = null,
    textBefore: (@Composable () -> Unit)? = null,
    textAfter: (@Composable () -> Unit)? = null,
) {
    val focusOuterStroke by focus.outerStroke(enabled, interactionSource)
    val focusInnerStroke by focus.innerStroke(enabled, interactionSource)
    val textColor by colors.textColor(enabled, interactionSource)
    if (header == null && textBefore == null && textAfter == null) {
        ToggleSwitchImpl(
            toggled = toggled,
            modifier = modifier
                .focusStroke(
                    outer = focusOuterStroke,
                    inner = focusInnerStroke,
                    shape = CircleShape
                )
                .toggleable(
                    onValueChange = onToggle,
                    value = toggled,
                    enabled = enabled,
                    role = Role.Switch,
                    indication = null,
                    interactionSource = interactionSource,
                )
                .focusable(
                    enabled = enabled,
                    interactionSource = interactionSource
                ),
            enabled = enabled,
            colors = colors,
            border = border,
            interactionSource = interactionSource
        )
    } else {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            var headerOffset by remember { mutableStateOf(0.dp) }
            if (header != null) {
                CompositionLocalProvider(
                    LocalTextStyle provides FluentTheme.typography.body,
                    LocalContentColor provides FluentTheme.colorScheme.textPrimary
                ) {
                    Box(modifier = Modifier.padding(horizontal = 4.dp).offset(x = headerOffset)) {
                        header()
                    }
                }
            }
            Row(
                modifier = Modifier
                    .focusStroke(
                        outer = focusOuterStroke,
                        inner = focusInnerStroke,
                        shape = FluentTheme.shapes.small
                    )
                    .padding(horizontal = 4.dp)
                    .toggleable(
                        onValueChange = onToggle,
                        value = toggled,
                        enabled = enabled,
                        role = Role.Switch,
                        indication = null,
                        interactionSource = interactionSource,
                    )
                    .focusable(
                        enabled = enabled,
                        interactionSource = interactionSource
                    ),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (textBefore != null) {
                    Box(modifier = Modifier.padding(start = 6.dp, top = 5.dp, bottom = 7.dp)) {
                        CompositionLocalProvider(
                            LocalTextStyle provides FluentTheme.typography.body,
                            LocalContentColor provides textColor
                        ) {
                            textBefore()
                        }
                    }
                }
                ToggleSwitchImpl(
                    modifier = modifier.onGloballyPositioned {
                        headerOffset = it.positionInParent().x.dp
                    },
                    toggled = toggled,
                    enabled = enabled,
                    colors = colors,
                    border = border,
                    interactionSource = interactionSource
                )
                if (textAfter != null) {
                    Box(modifier = Modifier.padding(top = 5.dp, bottom = 7.dp, end = 6.dp)) {
                        CompositionLocalProvider(
                            LocalTextStyle provides FluentTheme.typography.body,
                            LocalContentColor provides textColor
                        ) {
                            textAfter()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ToggleSwitchImpl(
    toggled: Boolean,
    modifier: Modifier,
    enabled: Boolean,
    colors: ToggleSwitchColors,
    border: ToggleSwitchBorders,
    interactionSource: MutableInteractionSource,
) {
    val containerColor by colors.containerColor(enabled, toggled, interactionSource)
    val thumbColor by colors.thumbColor(enabled, toggled, interactionSource)
    val borderStroke by border.border(enabled, toggled, interactionSource)

    val interaction by interactionSource.collectInteractionAsState()

    val thumbWidth = when {
        enabled && interaction is PressInteraction.Press -> 17.dp
        enabled && interaction is HoverInteraction.Enter -> 14.dp
        else -> 12.dp
    }
    val thumbHeight = when {
        enabled && (interaction is PressInteraction.Press || interaction is HoverInteraction.Enter) -> 14.dp
        else -> 12.dp
    }

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(containerColor)
            .defaultMinSize(
                minWidth = ToggleSwitchDefaults.MinWidth,
                minHeight = ToggleSwitchDefaults.MinHeight
            )
            .then(if (borderStroke != null) Modifier.border(borderStroke!!, CircleShape) else Modifier)
    ) {
        val padding = when {
            enabled && (interaction is PressInteraction.Press || interaction is HoverInteraction.Enter) -> 2.dp
            else -> 4.dp
        }
        val alignment by animateBiasAlignmentAsState(
            (if (toggled) Alignment.CenterEnd else Alignment.CenterStart) as BiasAlignment
        )
        Box(modifier = Modifier
            .padding(padding)
            .align(alignment)
            .clip(CircleShape)
            .background(thumbColor)
            .width(thumbWidth)
            .height(thumbHeight)
        )
    }
}



object ToggleSwitchDefaults {

    val MinWidth = 40.dp
    val MinHeight = 20.dp

    @Composable
    fun toggleSwitchColors(
        containerColor: Color = FluentTheme.colorScheme.fillControlAltSecondary,
        containerToggledColor: Color = FluentTheme.colorScheme.fillAccentDefault,
        containerHoverColor: Color = FluentTheme.colorScheme.fillControlAltTertiary,
        containerToggledHoverColor: Color = FluentTheme.colorScheme.fillAccentSecondary,
        containerPressedColor: Color = FluentTheme.colorScheme.fillControlAltQuarternary,
        containerToggledPressedColor: Color = FluentTheme.colorScheme.fillAccentTertiary,
        containerDisabledColor: Color = FluentTheme.colorScheme.fillControlAltDisabled,
        containerToggledDisabledColor: Color = FluentTheme.colorScheme.fillAccentDisabled,
        containerFocusedColor: Color = containerColor,
        containerToggledFocusedColor: Color = containerToggledColor,
        thumbColor: Color = FluentTheme.colorScheme.textSecondary,
        thumbToggledColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        thumbHoverColor: Color = FluentTheme.colorScheme.textSecondary,
        thumbToggledHoverColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        thumbPressedColor: Color = FluentTheme.colorScheme.textSecondary,
        thumbToggledPressedColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        thumbDisabledColor: Color = FluentTheme.colorScheme.textDisabled,
        thumbToggledDisabledColor: Color = FluentTheme.colorScheme.textOnAccentDisabled,
        thumbFocusedColor: Color = thumbColor,
        thumbToggledFocusedColor: Color = thumbToggledColor,
        textColor: Color = FluentTheme.colorScheme.textPrimary,
        textHoverColor: Color = FluentTheme.colorScheme.textPrimary,
        textPressedColor: Color = FluentTheme.colorScheme.textPrimary,
        textDisabledColor: Color = FluentTheme.colorScheme.textDisabled,
        textFocusedColor: Color = FluentTheme.colorScheme.textPrimary,
    ): ToggleSwitchColors {
        return DefaultToggleSwitchColors(
            containerColor = containerColor,
            containerToggledColor = containerToggledColor,
            containerHoverColor = containerHoverColor,
            containerToggledHoverColor = containerToggledHoverColor,
            containerPressedColor = containerPressedColor,
            containerToggledPressedColor = containerToggledPressedColor,
            containerDisabledColor = containerDisabledColor,
            containerToggledDisabledColor = containerToggledDisabledColor,
            containerFocusedColor = containerFocusedColor,
            containerToggledFocusedColor = containerToggledFocusedColor,
            thumbColor = thumbColor,
            thumbToggledColor = thumbToggledColor,
            thumbHoverColor = thumbHoverColor,
            thumbToggledHoverColor = thumbToggledHoverColor,
            thumbPressedColor = thumbPressedColor,
            thumbToggledPressedColor = thumbToggledPressedColor,
            thumbDisabledColor = thumbDisabledColor,
            thumbToggledDisabledColor = thumbToggledDisabledColor,
            thumbFocusedColor = thumbFocusedColor,
            thumbToggledFocusedColor = thumbToggledFocusedColor,
            textColor = textColor,
            textHoverColor = textHoverColor,
            textPressedColor = textPressedColor,
            textDisabledColor = textDisabledColor,
            textFocusedColor = textFocusedColor
        )
    }

    @Composable
    fun toggleSwitchBorders(
        stroke: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.strokeControlStrong
        ),
        strokeToggled: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.fillAccentTertiary
        ),
        strokeHover: BorderStroke? = stroke,
        strokeToggledHover: BorderStroke? = strokeToggled,
        strokePressed: BorderStroke? = stroke,
        strokeToggledPressed: BorderStroke? = strokeToggled,
        strokeDisabled: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.strokeControlStrongDisabled
        ),
        strokeToggledDisabled: BorderStroke? = null,
        strokeFocused: BorderStroke? = stroke,
        strokeToggledFocused: BorderStroke? = strokeToggled,
    ): ToggleSwitchBorders {
        return DefaultToggleSwitchBorders(
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
    fun toggleSwitchFocus(
        innerStroke: Color = FluentTheme.colorScheme.strokeFocusInner,
        outerStroke: Color = FluentTheme.colorScheme.strokeFocusOuter
    ): ToggleSwitchFocus {
        return DefaultToggleSwitchFocus(
            innerStroke = innerStroke,
            outerStroke = outerStroke
        )
    }

}

interface ToggleSwitchColors {

    @Composable
    fun containerColor(enabled: Boolean, toggled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun thumbColor(enabled: Boolean, toggled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun textColor(enabled: Boolean, interactionSource: InteractionSource): State<Color>

}

interface ToggleSwitchBorders {

    @Composable
    fun border(enabled: Boolean, toggled: Boolean, interactionSource: InteractionSource): State<BorderStroke?>

}

interface ToggleSwitchFocus {

    @Composable
    fun innerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun outerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

}

@Immutable
data class DefaultToggleSwitchColors(
    private val containerColor: Color,
    private val containerToggledColor: Color,
    private val containerHoverColor: Color,
    private val containerToggledHoverColor: Color,
    private val containerPressedColor: Color,
    private val containerToggledPressedColor: Color,
    private val containerDisabledColor: Color,
    private val containerToggledDisabledColor: Color,
    private val containerFocusedColor: Color,
    private val containerToggledFocusedColor: Color,
    private val thumbColor: Color,
    private val thumbToggledColor: Color,
    private val thumbHoverColor: Color,
    private val thumbToggledHoverColor: Color,
    private val thumbPressedColor: Color,
    private val thumbToggledPressedColor: Color,
    private val thumbDisabledColor: Color,
    private val thumbToggledDisabledColor: Color,
    private val thumbFocusedColor: Color,
    private val thumbToggledFocusedColor: Color,
    private val textColor: Color,
    private val textHoverColor: Color,
    private val textPressedColor: Color,
    private val textDisabledColor: Color,
    private val textFocusedColor: Color,
) : ToggleSwitchColors {

    @Composable
    override fun containerColor(enabled: Boolean, toggled: Boolean, interactionSource: InteractionSource): State<Color> {
        val interaction by interactionSource.collectInteractionAsState()
        val target = if (!enabled) {
            when (toggled) {
                true -> containerToggledDisabledColor
                false -> containerDisabledColor
            }
        } else {
            when (interaction) {
                is PressInteraction.Press -> when (toggled) {
                    true -> containerToggledPressedColor
                    false -> containerPressedColor
                }
                is HoverInteraction.Enter -> when (toggled) {
                    true -> containerToggledHoverColor
                    false -> containerHoverColor
                }
                is FocusInteraction.Focus -> when (toggled) {
                    true -> containerToggledFocusedColor
                    false -> containerFocusedColor
                }
                else -> when (toggled) {
                    true -> containerToggledColor
                    false -> containerColor
                }
            }
        }
        return rememberUpdatedState(target)
    }

    @Composable
    override fun thumbColor(enabled: Boolean, toggled: Boolean, interactionSource: InteractionSource): State<Color> {
        val interaction by interactionSource.collectInteractionAsState()
        val target = if (!enabled) {
            when (toggled) {
                true -> thumbToggledDisabledColor
                false -> thumbDisabledColor
            }
        } else {
            when (interaction) {
                is PressInteraction.Press -> when (toggled) {
                    true -> thumbToggledPressedColor
                    false -> thumbPressedColor
                }
                is HoverInteraction.Enter -> when (toggled) {
                    true -> thumbToggledHoverColor
                    false -> thumbHoverColor
                }
                is FocusInteraction.Focus -> when (toggled) {
                    true -> thumbToggledFocusedColor
                    false -> thumbFocusedColor
                }
                else -> when (toggled) {
                    true -> thumbToggledColor
                    false -> thumbColor
                }
            }
        }
        return rememberUpdatedState(target)
    }

    @Composable
    override fun textColor(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
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
data class DefaultToggleSwitchBorders(
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
) : ToggleSwitchBorders {

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
data class DefaultToggleSwitchFocus(
    private val innerStroke: Color,
    private val outerStroke: Color,
) : ToggleSwitchFocus {

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