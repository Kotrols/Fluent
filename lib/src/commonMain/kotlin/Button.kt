import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.standardButtonColors(),
    border: ButtonBorders = ButtonDefaults.standardButtonBorders(),
    focus: ButtonFocus = ButtonDefaults.buttonFocus(),
    shape: Shape = ButtonDefaults.Shape,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    val backgroundColor by colors.backgroundColor(enabled, interactionSource)
    val contentColor by colors.contentColor(enabled, interactionSource)
    val focusOuterStroke by focus.outerStroke(enabled, interactionSource)
    val focusInnerStroke by focus.innerStroke(enabled, interactionSource)
    val borderStroke by border.border(enabled, interactionSource)
    Box(
        modifier = modifier
            .focusStroke(
                outerColor = focusOuterStroke,
                innerColor = focusInnerStroke,
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
            .then(if (borderStroke != null) Modifier.border(borderStroke!!, shape) else Modifier)
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides FluentTheme.typography.body
        ) {
            Row(
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = ButtonDefaults.MinWidth,
                        minHeight = ButtonDefaults.MinHeight
                    )
                    .padding(contentPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                content = content
            )
        }
    }
}


@Composable
fun AccentButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.accentButtonColors(),
    border: ButtonBorders = ButtonDefaults.accentButtonBorders(),
    focus: ButtonFocus = ButtonDefaults.buttonFocus(),
    shape: Shape = ButtonDefaults.Shape,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    colors = colors,
    border = border,
    focus = focus,
    shape = shape,
    contentPadding = contentPadding,
    interactionSource = interactionSource,
    content = content
)

object ButtonDefaults {

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
    fun standardButtonColors(
        backgroundColor: Color = FluentTheme.colorScheme.fillControlDefault,
        backgroundHoverColor: Color = FluentTheme.colorScheme.fillControlSecondary,
        backgroundPressedColor: Color = FluentTheme.colorScheme.fillControlTertiary,
        backgroundDisabledColor: Color = FluentTheme.colorScheme.fillControlDisabled,
        backgroundFocusedColor: Color = backgroundColor,
        contentColor: Color = FluentTheme.colorScheme.textPrimary,
        contentHoverColor: Color = FluentTheme.colorScheme.textPrimary,
        contentPressedColor: Color = FluentTheme.colorScheme.textSecondary,
        contentDisabledColor: Color = FluentTheme.colorScheme.textDisabled,
        contentFocusedColor: Color = contentColor,
    ): ButtonColors {
        return DefaultButtonColors(
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
    fun accentButtonColors(
        backgroundColor: Color = FluentTheme.colorScheme.fillAccentDefault,
        backgroundHoverColor: Color = FluentTheme.colorScheme.fillAccentSecondary,
        backgroundPressedColor: Color = FluentTheme.colorScheme.fillAccentTertiary,
        backgroundDisabledColor: Color = FluentTheme.colorScheme.fillAccentDisabled,
        backgroundFocusedColor: Color = backgroundColor,
        contentColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        contentHoverColor: Color = FluentTheme.colorScheme.textOnAccentPrimary,
        contentPressedColor: Color = FluentTheme.colorScheme.textOnAccentSecondary,
        contentDisabledColor: Color = FluentTheme.colorScheme.textOnAccentDisabled,
        contentFocusedColor: Color = contentColor,
    ): ButtonColors {
        return DefaultButtonColors(
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
    fun standardButtonBorders(
        stroke: BorderStroke? = BorderStroke(
            width = 1.dp,
            brush = FluentTheme.borderElevation.control
        ),
        strokeHover: BorderStroke? = stroke,
        strokePressed: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.strokeControlDefault
        ),
        strokeDisabled: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.strokeControlDefault
        ),
        strokeFocused: BorderStroke? = stroke,
    ): ButtonBorders {
        return DefaultButtonBorders(
            stroke = stroke,
            strokeHover = strokeHover,
            strokePressed = strokePressed,
            strokeDisabled = strokeDisabled,
            strokeFocused = strokeFocused
        )
    }

    @Composable
    fun accentButtonBorders(
        stroke: BorderStroke? = BorderStroke(
            width = 1.dp,
            brush = FluentTheme.borderElevation.accentControl
        ),
        strokeHover: BorderStroke? = stroke,
        strokePressed: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = FluentTheme.colorScheme.strokeControlOnAccentDefault
        ),
        strokeDisabled: BorderStroke? = null,
        strokeFocused: BorderStroke? = stroke,
    ): ButtonBorders {
        return DefaultButtonBorders(
            stroke = stroke,
            strokeHover = strokeHover,
            strokePressed = strokePressed,
            strokeDisabled = strokeDisabled,
            strokeFocused = strokeFocused
        )
    }

    @Composable
    fun buttonFocus(
        innerStroke: Color = FluentTheme.colorScheme.strokeFocusInner,
        outerStroke: Color = FluentTheme.colorScheme.strokeFocusOuter
    ): ButtonFocus {
        return DefaultButtonFocus(
            innerStroke = innerStroke,
            outerStroke = outerStroke
        )
    }

}

interface ButtonColors {

    @Composable
    fun backgroundColor(enabled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun contentColor(enabled: Boolean, interactionSource: InteractionSource): State<Color>

}

interface ButtonBorders {

    @Composable
    fun border(enabled: Boolean, interactionSource: InteractionSource): State<BorderStroke?>

}

interface ButtonFocus {

    @Composable
    fun innerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun outerStroke(enabled: Boolean, interactionSource: InteractionSource): State<Color>

}

@Immutable
data class DefaultButtonColors(
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
) : ButtonColors {

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
data class DefaultButtonBorders(
    private val stroke: BorderStroke?,
    private val strokeHover: BorderStroke?,
    private val strokePressed: BorderStroke?,
    private val strokeDisabled: BorderStroke?,
    private val strokeFocused: BorderStroke?,
) : ButtonBorders {

    @Composable
    override fun border(enabled: Boolean, interactionSource: InteractionSource): State<BorderStroke?> {
        val interaction by interactionSource.collectInteractionAsState()

        val target = if (!enabled) {
            strokeDisabled
        } else {
            when (interaction) {
                is PressInteraction.Press -> strokePressed
                is HoverInteraction.Enter -> strokeHover
                is FocusInteraction.Focus -> strokeFocused
                else -> stroke
            }
        }
        return rememberUpdatedState(target)
    }

}

@Immutable
data class DefaultButtonFocus(
    private val innerStroke: Color,
    private val outerStroke: Color,
) : ButtonFocus {

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