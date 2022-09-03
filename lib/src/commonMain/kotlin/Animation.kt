import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.BiasAlignment

@Composable
fun animateBiasAlignmentAsState(
    targetValue: BiasAlignment,
    animationSpec: AnimationSpec<BiasAlignment> = spring(),
    finishedListener: ((BiasAlignment) -> Unit)? = null
): State<BiasAlignment> {
    return animateValueAsState(
        targetValue,
        typeConverter = TwoWayConverter(
            convertToVector = {
                AnimationVector(it.horizontalBias, it.verticalBias)
            },
            convertFromVector = {
                BiasAlignment(it.v1, it.v2)
            },
        ),
        animationSpec = animationSpec,
        finishedListener = finishedListener,
    )
}