import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun RadioGroupColumn(
    modifier: Modifier = Modifier,
    headerColor: Color = RadioGroupDefaults.HeaderColor,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    RadioGroupImpl(
        modifier = modifier,
        headerColor = headerColor,
        header = header
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}

@Composable
fun RadioGroupRow(
    modifier: Modifier = Modifier,
    headerColor: Color = RadioGroupDefaults.HeaderColor,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    RadioGroupImpl(
        modifier = modifier,
        headerColor = headerColor,
        header = header
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            content()
        }
    }
}

@Composable
private fun RadioGroupImpl(
    modifier: Modifier = Modifier,
    headerColor: Color = RadioGroupDefaults.HeaderColor,
    header: @Composable () -> Unit,
    layout: @Composable () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(7.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Box(modifier = Modifier.padding(start = 3.dp, top = 1.dp)) {
            CompositionLocalProvider(
                LocalTextStyle provides FluentTheme.typography.body,
                LocalContentColor provides headerColor
            ) {
                header()
            }
        }
        layout()
    }
}

@Composable
fun RadioButton(
    onSelect: () -> Unit,
    selected: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: RadioButtonColors = RadioButtonDefaults.radioButtonColors(),
    border: RadioButtonBorders = RadioButtonDefaults.radioButtonBorders(),
    focus: RadioButtonFocus = RadioButtonDefaults.radioButtonFocus(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: (@Composable () -> Unit)? = null,
) {
    val focusOuterStroke by focus.outerStroke(enabled, interactionSource)
    val focusInnerStroke by focus.innerStroke(enabled, interactionSource)
    val contentColor by colors.contentColor(enabled, interactionSource)

    val sharedModifiers = Modifier
        .selectable(
            onClick = onSelect,
            selected = selected,
            enabled = enabled,
            role = Role.RadioButton,
            indication = null,
            interactionSource = interactionSource,
        )
        .focusable(
            enabled = enabled,
            interactionSource = interactionSource
        )

    if (content == null) {
        RadioButtonImpl(
            modifier = modifier
                .focusStroke(
                    outer = focusOuterStroke,
                    inner = focusInnerStroke,
                    shape = CircleShape
                ).then(sharedModifiers),
            selected = selected,
            enabled = enabled,
            colors = colors,
            border = border,
            interactionSource = interactionSource,
        )
    } else {
        Row(
            modifier = modifier
                .focusStroke(
                    outer = focusOuterStroke,
                    inner = focusInnerStroke,
                    shape = FluentTheme.shapes.small
                )
                .padding(start = 4.dp, end = 8.dp)
                .defaultMinSize(
                    minWidth = RadioButtonDefaults.ContainerMinWidth,
                    minHeight = RadioButtonDefaults.ContainerMinHeight
                )
                .then(sharedModifiers),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButtonImpl(
                modifier = Modifier,
                selected = selected,
                enabled = enabled,
                colors = colors,
                border = border,
                interactionSource = interactionSource,
            )
            CompositionLocalProvider(
                LocalContentColor provides contentColor,
                LocalTextStyle provides FluentTheme.typography.body
            ) {
                content()
            }
        }
    }
}

@Composable
private fun RadioButtonImpl(
    modifier: Modifier,
    selected: Boolean,
    enabled: Boolean,
    colors: RadioButtonColors,
    border: RadioButtonBorders,
    interactionSource: MutableInteractionSource,
) {
    val containerColor by colors.containerColor(enabled, selected, interactionSource)
    val bulletColor by colors.bulletColor(enabled, selected, interactionSource)
    val borderStroke by border.border(enabled, selected, interactionSource)

    val interaction by interactionSource.collectInteractionAsState()

    val bulletSize by animateDpAsState(
        when (selected) {
            true -> when {
                enabled && interaction is PressInteraction.Press -> 6.dp
                enabled && interaction is HoverInteraction.Enter -> 10.dp
                else -> 8.dp
            }
            false -> when {
                enabled && interaction is PressInteraction.Press -> {
                    when (FluentTheme.colorScheme.isDark) {
                        true -> 8.dp
                        else -> 6.dp
                    }
                }
                else -> 0.dp
            }
        },
    )
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(containerColor)
            .defaultMinSize(
                minWidth = RadioButtonDefaults.BulletMinSize,
                minHeight = RadioButtonDefaults.BulletMinSize
            )
            .then(if (borderStroke != null) Modifier.border(borderStroke!!, CircleShape) else Modifier),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(bulletSize)
                .clip(CircleShape)
                .background(bulletColor)
        )
    }
}

object RadioGroupDefaults {

    val HeaderColor
        @Composable
        @ReadOnlyComposable
        get() = FluentTheme.colorScheme.textPrimary

}

object RadioButtonDefaults {

    val BulletMinSize = 20.dp

    val ContainerMinHeight = 32.dp
    val ContainerMinWidth = 109.dp

    @Composable
    fun radioButtonColors(
        containerColor: Color = FluentTheme.colorScheme.fillControlAltSecondary,
        containerHoverColor: Color = FluentTheme.colorScheme.fillControlAltTertiary,
        containerPressedColor: Color = FluentTheme.colorScheme.fillControlAltQuarternary,
        containerDisabledColor: Color = FluentTheme.colorScheme.fillControlAltDisabled,
        containerFocusedColor: Color = containerColor,
        selectedContainerColor: Color = FluentTheme.colorScheme.fillAccentDefault,
        selectedContainerHoverColor: Color = FluentTheme.colorScheme.fillAccentSecondary,
        selectedContainerPressedColor: Color = FluentTheme.colorScheme.fillAccentTertiary,
        selectedContainerDisabledColor: Color = FluentTheme.colorScheme.fillAccentDisabled,
        selectedContainerFocusedColor: Color = selectedContainerColor,
        bulletColor: Color = FluentTheme.colorScheme.textSecondary,
        bulletHoverColor: Color = FluentTheme.colorScheme.textSecondary,
        bulletPressedColor: Color = FluentTheme.colorScheme.textSecondary,
        bulletDisabledColor: Color = FluentTheme.colorScheme.textDisabled,
        bulletFocusedColor: Color = bulletColor,
        selectedThumbColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        selectedThumbHoverColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        selectedThumbPressedColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        selectedThumbDisabledColor: Color = FluentTheme.colorScheme.textOnAccentDisabled,
        selectedThumbFocusedColor: Color = selectedThumbColor,
        contentColor: Color = FluentTheme.colorScheme.textPrimary,
        contentHoverColor: Color = FluentTheme.colorScheme.textPrimary,
        contentPressedColor: Color = FluentTheme.colorScheme.textPrimary,
        contentDisabledColor: Color = FluentTheme.colorScheme.textDisabled,
        contentFocusedColor: Color = FluentTheme.colorScheme.textPrimary,
    ): RadioButtonColors {
        return DefaultRadioButtonColors(
            containerColor = containerColor,
            containerHoverColor = containerHoverColor,
            containerPressedColor = containerPressedColor,
            containerDisabledColor = containerDisabledColor,
            containerFocusedColor = containerFocusedColor,
            selectedContainerColor = selectedContainerColor,
            selectedContainerHoverColor = selectedContainerHoverColor,
            selectedContainerPressedColor = selectedContainerPressedColor,
            selectedContainerDisabledColor = selectedContainerDisabledColor,
            selectedContainerFocusedColor = selectedContainerFocusedColor,
            bulletColor = bulletColor,
            bulletHoverColor = bulletHoverColor,
            bulletPressedColor = bulletPressedColor,
            bulletDisabledColor = bulletDisabledColor,
            bulletFocusedColor = bulletFocusedColor,
            selectedThumbColor = selectedThumbColor,
            selectedThumbHoverColor = selectedThumbHoverColor,
            selectedThumbPressedColor = selectedThumbPressedColor,
            selectedThumbDisabledColor = selectedThumbDisabledColor,
            selectedThumbFocusedColor = selectedThumbFocusedColor,
            contentColor = contentColor,
            contentHoverColor = contentHoverColor,
            contentPressedColor = contentPressedColor,
            contentDisabledColor = contentDisabledColor,
            contentFocusedColor = contentFocusedColor
        )
    }

    @Composable
    fun radioButtonBorders(
        stroke: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.strokeControlStrong
        ),
        selectedStroke: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.fillAccentTertiary
        ),
        strokeHover: BorderStroke? = stroke,
        selectedStrokeHover: BorderStroke? = selectedStroke,
        strokePressed: BorderStroke? = stroke,
        selectedStrokePressed: BorderStroke? = selectedStroke,
        strokeDisabled: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.strokeControlStrongDisabled
        ),
        selectedStrokeDisabled: BorderStroke? = null,
        strokeFocused: BorderStroke? = stroke,
        selectedStrokeFocused: BorderStroke? = selectedStroke,
    ): RadioButtonBorders {
        return DefaultRadioButtonBorders(
            stroke = stroke,
            selectedStroke = selectedStroke,
            strokeHover = strokeHover,
            selectedStrokeHover = selectedStrokeHover,
            strokePressed = strokePressed,
            selectedStrokePressed = selectedStrokePressed,
            strokeDisabled = strokeDisabled,
            selectedStrokeDisabled = selectedStrokeDisabled,
            strokeFocused = strokeFocused,
            selectedStrokeFocused = selectedStrokeFocused
        )
    }

    @Composable
    fun radioButtonFocus(
        innerStroke: Color = FluentTheme.colorScheme.strokeFocusInner,
        outerStroke: Color = FluentTheme.colorScheme.strokeFocusOuter
    ): RadioButtonFocus {
        return DefaultRadioButtonFocus(
            innerStroke = innerStroke,
            outerStroke = outerStroke
        )
    }

}

interface RadioButtonColors {

    @Composable
    fun containerColor(enabled: Boolean, selected: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun bulletColor(enabled: Boolean, selected: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun contentColor(enabled: Boolean, interactionSource: InteractionSource): State<Color>

}

interface RadioButtonBorders {

    @Composable
    fun border(enabled: Boolean, selected: Boolean, interactionSource: InteractionSource): State<BorderStroke?>

}

interface RadioButtonFocus {

    @Composable
    fun innerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun outerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

}

@Immutable
data class DefaultRadioButtonColors(
    private val containerColor: Color,
    private val containerHoverColor: Color,
    private val containerPressedColor: Color,
    private val containerDisabledColor: Color,
    private val containerFocusedColor: Color,
    private val selectedContainerColor: Color,
    private val selectedContainerHoverColor: Color,
    private val selectedContainerPressedColor: Color,
    private val selectedContainerDisabledColor: Color,
    private val selectedContainerFocusedColor: Color,
    private val bulletColor: Color,
    private val bulletHoverColor: Color,
    private val bulletPressedColor: Color,
    private val bulletDisabledColor: Color,
    private val bulletFocusedColor: Color,
    private val selectedThumbColor: Color,
    private val selectedThumbHoverColor: Color,
    private val selectedThumbPressedColor: Color,
    private val selectedThumbDisabledColor: Color,
    private val selectedThumbFocusedColor: Color,
    private val contentColor: Color,
    private val contentHoverColor: Color,
    private val contentPressedColor: Color,
    private val contentDisabledColor: Color,
    private val contentFocusedColor: Color,
) : RadioButtonColors {

    @Composable
    override fun containerColor(
        enabled: Boolean,
        selected: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val interaction by interactionSource.collectInteractionAsState()
        val target = if (!enabled) {
            when (selected) {
                true -> selectedContainerDisabledColor
                false -> containerDisabledColor
            }
        } else {
            when (interaction) {
                is PressInteraction.Press -> when (selected) {
                    true -> selectedContainerPressedColor
                    false -> containerPressedColor
                }

                is HoverInteraction.Enter -> when (selected) {
                    true -> selectedContainerHoverColor
                    false -> containerHoverColor
                }

                is FocusInteraction.Focus -> when (selected) {
                    true -> selectedContainerFocusedColor
                    false -> containerFocusedColor
                }

                else -> when (selected) {
                    true -> selectedContainerColor
                    false -> containerColor
                }
            }
        }
        return rememberUpdatedState(target)
    }

    @Composable
    override fun bulletColor(enabled: Boolean, selected: Boolean, interactionSource: InteractionSource): State<Color> {
        val interaction by interactionSource.collectInteractionAsState()
        val target = if (!enabled) {
            when (selected) {
                true -> selectedThumbDisabledColor
                false -> bulletDisabledColor
            }
        } else {
            when (interaction) {
                is PressInteraction.Press -> when (selected) {
                    true -> selectedThumbPressedColor
                    false -> bulletPressedColor
                }

                is HoverInteraction.Enter -> when (selected) {
                    true -> selectedThumbHoverColor
                    false -> bulletHoverColor
                }

                is FocusInteraction.Focus -> when (selected) {
                    true -> selectedThumbFocusedColor
                    false -> bulletFocusedColor
                }

                else -> when (selected) {
                    true -> selectedThumbColor
                    false -> bulletColor
                }
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
data class DefaultRadioButtonBorders(
    private val stroke: BorderStroke?,
    private val selectedStroke: BorderStroke?,
    private val strokeHover: BorderStroke?,
    private val selectedStrokeHover: BorderStroke?,
    private val strokePressed: BorderStroke?,
    private val selectedStrokePressed: BorderStroke?,
    private val strokeDisabled: BorderStroke?,
    private val selectedStrokeDisabled: BorderStroke?,
    private val strokeFocused: BorderStroke?,
    private val selectedStrokeFocused: BorderStroke?,
) : RadioButtonBorders {

    @Composable
    override fun border(
        enabled: Boolean,
        selected: Boolean,
        interactionSource: InteractionSource
    ): State<BorderStroke?> {
        val interaction by interactionSource.collectInteractionAsState()

        val target = if (!enabled) {
            when (selected) {
                true -> selectedStrokeDisabled
                false -> strokeDisabled
            }
        } else {
            when (interaction) {
                is PressInteraction.Press -> when (selected) {
                    true -> selectedStrokePressed
                    false -> strokePressed
                }

                is HoverInteraction.Enter -> when (selected) {
                    true -> selectedStrokeHover
                    false -> strokeHover
                }

                is FocusInteraction.Focus -> when (selected) {
                    true -> selectedStrokeFocused
                    false -> strokeFocused
                }

                else -> when (selected) {
                    true -> selectedStroke
                    false -> stroke
                }
            }
        }
        return rememberUpdatedState(target)
    }

}

@Immutable
data class DefaultRadioButtonFocus(
    private val innerStroke: Color,
    private val outerStroke: Color,
) : RadioButtonFocus {

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