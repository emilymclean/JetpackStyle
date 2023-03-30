package cl.emilym.jetpack.style.widget.text

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.LocalContentColor
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import cl.emilym.jetpack.style.LocalStyle
import cl.emilym.jetpack.style.style.TextFieldStyle

@Composable
fun StyledTextFieldBox(
    modifier: Modifier = Modifier,
    style: TextFieldStyle = LocalStyle.current.textFieldStyle,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    border: BorderStroke? = null,
    shape: Shape? = null,
    content: @Composable () -> Unit
) {
    Box(modifier = Modifier
        .heightIn(min = 0.dp)
        .clip(shape ?: style.containerStyle.shape)
        .background(backgroundColor ?: style.containerStyle.background)
        .then(when {
            border != null -> Modifier.border(border, shape ?: style.containerStyle.shape)
            style.containerStyle.stroke != null ->
                Modifier.border(style.containerStyle.stroke, shape ?: style.containerStyle.shape)
            else -> Modifier
        })
        .defaultMinSize(
            minWidth = TextFieldDefaults.MinWidth,
            minHeight = TextFieldDefaults.MinHeight
        )
        .then(modifier),) {
        CompositionLocalProvider(LocalContentColor provides (contentColor ?: style.containerStyle.background)) {
            content()
        }
    }
}