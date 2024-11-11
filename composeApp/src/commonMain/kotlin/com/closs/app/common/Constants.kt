package com.closs.app.common

import accloss_kmp.composeapp.generated.resources.Res
import accloss_kmp.composeapp.generated.resources.ic_avlogo
import accloss_kmp.composeapp.generated.resources.ic_wokin_logo
import androidx.compose.runtime.Composable
import com.closs.core.types.common.Constants.CLO
import com.closs.core.types.common.Constants.WOKIN
import org.jetbrains.compose.resources.painterResource

@Composable
fun selectAccountImage(company: String?) = when (company) {
    CLO -> painterResource(Res.drawable.ic_avlogo)
    WOKIN -> painterResource(Res.drawable.ic_wokin_logo)
    else -> painterResource(Res.drawable.ic_avlogo)
}
