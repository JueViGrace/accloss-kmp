package com.closs.core.presentation.components.display

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.closs.core.types.common.capitalizeString

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    fontWeight: FontWeight? = MaterialTheme.typography.bodyMedium.fontWeight,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = 2,
    color: Color = LocalContentColor.current,
    textDecoration: TextDecoration = TextDecoration.None,
    softWrap: Boolean = true,
    overflow: TextOverflow = TextOverflow.Clip
) {
    // todo: remove capitalization
    Text(
        text = text.capitalizeString(),
        fontSize = fontSize,
        fontWeight = fontWeight,
        textAlign = textAlign,
        maxLines = maxLines,
        color = color,
        modifier = modifier,
        textDecoration = textDecoration,
        softWrap = softWrap,
        overflow = overflow
    )
}
