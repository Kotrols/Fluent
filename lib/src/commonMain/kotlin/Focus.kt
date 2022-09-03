import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

//TODO make sure stroke is an overlay so that it doesn't affect the layout
fun Modifier.focusStroke(
    outer: Color,
    inner: Color,
    shape: Shape
) = this
    .border(width = 3.dp, outer, shape)
    .padding(3.dp)
    .border(width = 2.dp, inner, shape)
    .padding(2.dp)