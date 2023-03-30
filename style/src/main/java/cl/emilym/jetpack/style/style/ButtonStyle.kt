package cl.emilym.jetpack.style.style

import androidx.compose.material.ButtonElevation
import androidx.compose.ui.unit.Dp

data class ButtonStyle(
    val containerStyle: ContainerStyle,
    val contentSpacing: Dp,
    val hintColor
    val elevation: ButtonElevation?,
)
