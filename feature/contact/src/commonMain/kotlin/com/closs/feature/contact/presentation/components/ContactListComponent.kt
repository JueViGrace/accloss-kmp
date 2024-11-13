package com.closs.feature.contact.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.closs.core.presentation.components.display.CustomText
import com.closs.core.presentation.components.display.LetterComponent
import com.closs.core.types.data.salesman.Salesman

@Composable
fun ContactListComponent(
    modifier: Modifier = Modifier,
    salesman: Salesman,
    onSelect: (String) -> Unit
) {
    val letter: String by remember {
        mutableStateOf(salesman.nombre.first().uppercase())
    }

    Row(
        modifier = modifier
            .clickable {
                onSelect(salesman.vendedor)
            }
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start)
    ) {
        LetterComponent(letter = letter)

        Column {
            CustomText(
                text = salesman.nombre,
                overflow = TextOverflow.Ellipsis,
                softWrap = true
            )

            CustomText(
                text = salesman.vendedor,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )
        }
    }
}
