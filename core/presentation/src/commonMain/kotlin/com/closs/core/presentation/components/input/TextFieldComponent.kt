package com.closs.core.presentation.components.input

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.closs.core.presentation.components.display.CustomText
import com.closs.core.presentation.components.icons.IconComponent
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    value: String,
    onChange: (String) -> Unit,
    label: String = "",
    placeholder: String = "",
    supportingText: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done,
        keyboardType = KeyboardType.Text
    ),
    leadingIcon: DrawableResource,
    trailingIcon: DrawableResource? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    errorStatus: Boolean = false,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    val focus = LocalFocusManager.current
    OutlinedTextFieldComponent(
        modifier = modifier,
        value = value,
        onValueChanged = {
            onChange(it)
        },
        label = {
            CustomText(text = label)
        },
        readOnly = readOnly,
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        placeholder = {
            CustomText(text = placeholder)
        },
        supportingText = if (supportingText != null) {
            { CustomText(text = supportingText) }
        } else {
            null
        },
        keyboardActions = KeyboardActions(
            onNext = {
                focus.moveFocus(FocusDirection.Down)
            },
            onDone = {
                focus.clearFocus()
            }
        ),
        leadingIcon = {
            IconComponent(painter = painterResource(leadingIcon), contentDescription = null)
        },
        trailingIcon = if (trailingIcon != null) {
            {
                IconButton(
                    onClick = { onTrailingIconClick?.invoke() },
                    enabled = enabled
                ) {
                    IconComponent(painter = painterResource(trailingIcon), contentDescription = null)
                }
            }
        } else {
            null
        },
        isError = errorStatus,
        visualTransformation = visualTransformation
    )
}
