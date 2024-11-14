package com.closs.contact.presentation.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.boundsInParent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import closs_kmp.core.resources.generated.resources.Res
import closs_kmp.core.resources.generated.resources.end_of_list
import com.closs.core.presentation.components.display.CustomText
import com.closs.core.presentation.components.display.ListFooter
import com.closs.core.presentation.components.display.ListStickyHeader
import com.closs.core.presentation.components.layout.LazyColumnComponent
import com.closs.core.types.data.salesman.Salesman
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import kotlin.math.abs

@Composable
fun ContactsContent(
    salesmen: List<Salesman>,
    onSalesmanSelected: (String) -> Unit,
) {
    val listState = rememberLazyListState()
    val offsets = remember { mutableStateMapOf<Int, Float>() }
    var selectedHeaderIndex by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    val headers = remember {
        salesmen.map { it.nombre.first().uppercase() }.toSet().toList()
    }

    Row {
        LazyColumnComponent(
            modifier = Modifier.weight(1f),
            lazyListState = listState,
            items = salesmen,
            grouped = salesmen.groupBy { it.nombre.first().toString() },
            stickyHeader = { char ->
                char?.let {
                    ListStickyHeader(
                        textModifier = Modifier.padding(horizontal = 14.dp),
                        text = it
                    )
                }
            },
            content = { salesman ->
                ContactListComponent(
                    salesman = salesman,
                    onSelect = onSalesmanSelected,
                )
            },
            footer = {
                ListFooter(text = stringResource(Res.string.end_of_list))
            },
        )

        fun updateSelectedIndexIfNeeded(offset: Float) {
            val index = offsets
                .mapValues { abs(it.value - offset) }
                .entries
                .minByOrNull { it.value }
                ?.key ?: return
            if (selectedHeaderIndex == index) return
            selectedHeaderIndex = index
            val selectedItemIndex = salesmen.indexOfFirst {
                it.nombre.first().uppercase() == headers[selectedHeaderIndex]
            }
            scope.launch {
                listState.scrollToItem(
                    index = selectedItemIndex,
                    scrollOffset = offset.toInt()
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .pointerInput(Unit) {
                    detectTapGestures {
                        updateSelectedIndexIfNeeded(it.y)
                    }
                }
                .pointerInput(Unit) {
                    detectVerticalDragGestures { change, _ ->
                        updateSelectedIndexIfNeeded(change.position.y)
                    }
                }
                .padding(5.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            headers.forEachIndexed { i, header ->
                CustomText(
                    text = header,
                    modifier = Modifier.onGloballyPositioned {
                        offsets[i] = it.boundsInParent().center.y
                    }
                )
            }
        }
    }
}
