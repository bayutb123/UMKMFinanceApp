package com.bayutb123.umkmfinanceapp.ui.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bayutb123.umkmfinanceapp.ui.screens.Screen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigationRequested: (String) -> Unit,
) {
    HomeScreenContent(
        modifier = modifier,
        onNavigationClick = onNavigationRequested
    )
}


@Composable
fun HomeScreenContent(
    modifier: Modifier,
    onNavigationClick: (String) -> Unit
) {
    Text(text = "Home Screen")
}
