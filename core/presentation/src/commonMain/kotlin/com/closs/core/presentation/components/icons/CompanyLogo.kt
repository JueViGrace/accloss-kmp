package com.closs.core.shared.presentation.components.icons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.closs.core.shared.common.Constants.WOKIN
import com.closs.core.shared.common.Constants.selectAccountImage
import com.closs.core.shared.presentation.components.display.ImageComponent

@Composable
fun CompanyLogo(
    company: String?,
) {
    ImageComponent(
        modifier = if (company == WOKIN) {
            Modifier
                .sizeIn(
                    minWidth = 24.dp,
                    minHeight = 24.dp,
                    maxWidth = 32.dp,
                    maxHeight = 32.dp
                )
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
                .clip(CircleShape)
                .padding(4.dp)
        } else {
            Modifier
                .sizeIn(
                    minWidth = 24.dp,
                    minHeight = 24.dp,
                    maxWidth = 32.dp,
                    maxHeight = 32.dp
                )
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = CircleShape
                )
                .clip(CircleShape)
                .padding(4.dp)
        },
        painter = selectAccountImage(company),
        contentDescription = "User picture"
    )
}
