import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class Shapes(
    val extraSmall: RoundedCornerShape = RoundedCornerShape(3.dp),
    val small: RoundedCornerShape = RoundedCornerShape(4.dp),
    val medium: RoundedCornerShape = RoundedCornerShape(7.dp),
    val large: RoundedCornerShape = RoundedCornerShape(8.dp)
)

internal val LocalShapes = staticCompositionLocalOf { Shapes() }