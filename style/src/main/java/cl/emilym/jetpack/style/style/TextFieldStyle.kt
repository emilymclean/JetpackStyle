package cl.emilym.jetpack.style.style

import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.graphics.Color

class TextFieldStyle(
    val containerStyle: ContainerStyle,
    val hintColor: Color,
    val accentColor: Color,
    val errorColor: Color,
    val errorBorder: BorderStroke? = null,
)