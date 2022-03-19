package dev.tommywong.barcodebase.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.tommywong.barcodebase.R

@Composable
fun Logo(width: Dp = 100.dp) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = stringResource(R.string.logo_content_description),
        modifier = Modifier.width(width)
    )
}

@Preview
@Composable
fun PreviewLogo() {
    Logo()
}