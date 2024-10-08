package com.fahad.fetchandroidassignment.ui.component


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.fahad.fetchandroidassignment.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    appbarTitle: String = stringResource(id = R.string.app_name),
    onBackPressed: (() -> Unit)? = null,
    imageButtonOneRes: Int = 0,
    imageButtonOneContentDescription: String = "",
    imageButtonOneClicked: () -> Unit = {},
    imageButtonOneColor: Color = Color.Unspecified
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.Unspecified,
            actionIconContentColor = imageButtonOneColor
        ),
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = appbarTitle,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
            )
        },
        navigationIcon = {
            if (onBackPressed != null) {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = stringResource(R.string.back),
                        tint = Color.White
                    )
                }
            }
        },
        actions = {
            if (imageButtonOneRes != 0) {
                IconButton(onClick = { imageButtonOneClicked.invoke() }) {
                    Icon(
                        painter = painterResource(id = imageButtonOneRes),
                        contentDescription = imageButtonOneContentDescription,
                    )
                }
            }
        }
    )
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun TopAppBarPreview() {
    TopAppBar(
        appbarTitle = "Home"
    )
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun TopAppBarDetailPreview() {
    TopAppBar(
        appbarTitle = "Home",
        onBackPressed = {},
        imageButtonOneRes = android.R.drawable.ic_menu_save,
        imageButtonOneContentDescription = "Favorite",
        imageButtonOneClicked = {},
        imageButtonOneColor = Color.Black
    )
}