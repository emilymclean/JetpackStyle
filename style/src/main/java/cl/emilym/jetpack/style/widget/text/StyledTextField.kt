package cl.emilym.jetpack.style.widget.text

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cl.emilym.jetpack.style.LocalStyle
import cl.emilym.jetpack.style.style.TextFieldStyle

@Composable
fun DCJTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String?,
    modifier: Modifier = Modifier,
    style: TextFieldStyle = LocalStyle.current.textFieldStyle,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    backgroundColor: Color? = null,
    hintColor: Color? = null,
    contentColor: Color? = null,
    accentColor: Color? = null,
    border: BorderStroke? = null,
    shape: Shape? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    maxLines: Int = Int.MAX_VALUE,
    singleLine: Boolean = false,
    enabled: Boolean = true
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(
            hint ?: "",
            color = hintColor ?: style.hintColor
        ) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = backgroundColor ?: style.containerStyle.background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            textColor = contentColor ?: style.containerStyle.onBackground,
        ),
        shape = shape ?: style.containerStyle.shape,
        leadingIcon = leadingIcon?.let { {
            CompositionLocalProvider(LocalContentColor provides (accentColor ?: style.accentColor)) {
                leadingIcon()
            }
        } },
        trailingIcon = trailingIcon?.let { {
            CompositionLocalProvider(LocalContentColor provides (accentColor ?: style.accentColor)) {
                trailingIcon()
            }
        } },
        modifier = Modifier
            .heightIn(min = 0.dp)
            .then(when {
                border != null -> Modifier.border(border, shape ?: style.containerStyle.shape)
                style.containerStyle.stroke != null ->
                    Modifier.border(style.containerStyle.stroke, shape ?: style.containerStyle.shape)
                else -> Modifier
            })
            .then(modifier),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        maxLines = maxLines,
        singleLine = singleLine,
        enabled = enabled
    )
}