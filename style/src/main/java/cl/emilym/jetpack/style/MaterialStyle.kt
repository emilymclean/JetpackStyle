package cl.emilym.jetpack.style

import androidx.compose.runtime.staticCompositionLocalOf
import cl.emilym.jetpack.style.style.ButtonStyle
import cl.emilym.jetpack.style.style.TextFieldStyle

open class MaterialStyle(
    val primaryButtonStyle: ButtonStyle,
    val secondaryButtonStyle: ButtonStyle,
    val tertiaryButtonStyle: ButtonStyle,
    val textFieldStyle: TextFieldStyle
)

val LocalStyle = staticCompositionLocalOf<MaterialStyle> { error("No MaterialStyle has been provided") }