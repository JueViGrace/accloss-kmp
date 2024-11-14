package com.closs.contact.detail.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.closs.core.types.data.salesman.Salesman

@Composable
expect fun ContactComponent(
    modifier: Modifier = Modifier,
    salesman: Salesman
)
