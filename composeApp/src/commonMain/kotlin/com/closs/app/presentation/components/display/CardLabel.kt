package com.clo.accloss.core.presentation.components.display

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun CardLabel(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(
        5.dp,
        Alignment.CenterVertically
    ),
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    colors: CardColors = CardDefaults.elevatedCardColors(),
    title: StringResource,
    value: String,
    softWrap: Boolean = true,
    maxLines: Int = 2,
    titleFontSize: TextUnit = MaterialTheme.typography.bodyLarge.fontSize,
    titleFontWeight: FontWeight? = MaterialTheme.typography.bodyLarge.fontWeight,
    valueFontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    valueFontWeight: FontWeight? = MaterialTheme.typography.titleLarge.fontWeight,
) {
    CardComponent(
        colors = colors
    ) {
        Column(
            modifier = modifier
                .padding(10.dp),
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment
        ) {
            CustomText(
                modifier = Modifier
                    .padding(horizontal = 5.dp),
                text = stringResource(resource = title),
                fontSize = titleFontSize,
                fontWeight = titleFontWeight,
                softWrap = softWrap,
                maxLines = maxLines
            )
            CustomText(
                modifier = Modifier
                    .padding(horizontal = 5.dp),
                text = value,
                fontSize = valueFontSize,
                fontWeight = valueFontWeight,
                softWrap = softWrap,
                maxLines = maxLines
            )
        }
    }
}
