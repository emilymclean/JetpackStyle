package cl.emilym.jetpack.style.widget.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cl.emilym.jetpack.style.LocalStyle
import cl.emilym.jetpack.style.style.ButtonStyle

@Composable
fun StyledTextButton(
    onClick: () -> Unit,
    style: ButtonStyle,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape? = null,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    padding: PaddingValues? = null,
    stroke: BorderStroke? = null,
    elevation: ButtonElevation? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val actualPadding = padding ?: style.containerStyle.padding

    TextButton(
        onClick = onClick,
        shape = shape ?: style.containerStyle.shape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor ?: style.containerStyle.background,
            contentColor = contentColor ?: style.containerStyle.onBackground
        ),
        enabled = enabled,
        contentPadding = actualPadding,
        border = stroke ?: style.containerStyle.stroke,
        elevation = elevation ?: style.elevation,
        modifier = Modifier
            .defaultMinSize(minHeight = 24.dp + (actualPadding.calculateTopPadding() + actualPadding.calculateBottomPadding()))
            .then(modifier)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Row(horizontalArrangement = Arrangement.spacedBy(style.contentSpacing), verticalAlignment = Alignment.CenterVertically) {
                content()
            }
        }
    }
}

@Composable
fun StyledButton(
    onClick: () -> Unit,
    style: ButtonStyle,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape? = null,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    padding: PaddingValues? = null,
    stroke: BorderStroke? = null,
    elevation: ButtonElevation? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val actualPadding = padding ?: style.containerStyle.padding

    Button(
        onClick = onClick,
        shape = shape ?: style.containerStyle.shape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor ?: style.containerStyle.background,
            contentColor = contentColor ?: style.containerStyle.onBackground
        ),
        enabled = enabled,
        contentPadding = actualPadding,
        border = stroke ?: style.containerStyle.stroke,
        elevation = elevation ?: style.elevation,
        modifier = Modifier
            .defaultMinSize(minHeight = 24.dp + (actualPadding.calculateTopPadding() + actualPadding.calculateBottomPadding()))
            .then(modifier)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Row(horizontalArrangement = Arrangement.spacedBy(style.contentSpacing), verticalAlignment = Alignment.CenterVertically) {
                content()
            }
        }
    }
}