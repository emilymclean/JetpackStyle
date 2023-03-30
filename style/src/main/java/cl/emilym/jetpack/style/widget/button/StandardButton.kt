package cl.emilym.jetpack.style.widget.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import cl.emilym.jetpack.style.LocalStyle

enum class ButtonType {
    PRIMARY, SECONDARY, TERTIARY
}

@Composable
fun StandardButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.PRIMARY,
    enabled: Boolean = true,
    shape: Shape? = null,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    padding: PaddingValues? = null,
    stroke: BorderStroke? = null,
    elevation: ButtonElevation? = null,
    content: @Composable RowScope.() -> Unit,
) {
    when (type) {
        ButtonType.PRIMARY, ButtonType.SECONDARY -> StyledButton(
            onClick,
            if (type == ButtonType.PRIMARY)
                LocalStyle.current.primaryButtonStyle
            else
                LocalStyle.current.secondaryButtonStyle,
            modifier, enabled, shape, backgroundColor, contentColor, padding, stroke, elevation, content
        )
        ButtonType.TERTIARY -> StyledTextButton(
            onClick,
            LocalStyle.current.tertiaryButtonStyle,
            modifier, enabled, shape, backgroundColor, contentColor, padding, stroke, elevation, content
        )
    }
}