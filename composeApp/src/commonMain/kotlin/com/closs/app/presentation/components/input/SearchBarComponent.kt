package com.closs.app.presentation.components.input

import accloss_kmp.composeapp.generated.resources.Res
import accloss_kmp.composeapp.generated.resources.ic_search
import accloss_kmp.composeapp.generated.resources.ic_x
import accloss_kmp.composeapp.generated.resources.search
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.ImeAction
import com.closs.app.presentation.components.display.CustomText
import com.closs.app.presentation.components.icons.IconComponent
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SearchBarComponent(
    modifier: Modifier = Modifier.fillMaxWidth(),
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    placeholder: @Composable (() -> Unit)? = {
        CustomText(text = stringResource(Res.string.search))
    },
    leadingIcon: @Composable (() -> Unit)? = {
        IconComponent(
            painter = painterResource(Res.drawable.ic_search),
            contentDescription = "search"
        )
    },
    trailingIcon: @Composable (() -> Unit)? = {
        AnimatedVisibility(
            visible = query.isNotEmpty(),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            IconButton(
                onClick = {
                    onQueryChange("")
                }
            ) {
                IconComponent(
                    painter = painterResource(Res.drawable.ic_x),
                    contentDescription = "Cancel"
                )
            }
        }
    },
    shape: Shape = CircleShape,
    keyboardActions: KeyboardActions = KeyboardActions(onDone = { onSearch(query) }),
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
) {
    OutlinedTextFieldComponent(
        modifier = modifier,
        value = query,
        onValueChanged = onQueryChange,
        leadingIcon = leadingIcon,
        placeholder = placeholder,
        trailingIcon = trailingIcon,
        shape = shape,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions
    )
}
