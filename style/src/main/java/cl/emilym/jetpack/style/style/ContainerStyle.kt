package cl.emilym.jetpack.style.style

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

class ContainerStyle(
    val shape: Shape,
    val background: Color,
    val onBackground: Color,
    val padding: PaddingValues,
    val stroke: BorderStroke?
)