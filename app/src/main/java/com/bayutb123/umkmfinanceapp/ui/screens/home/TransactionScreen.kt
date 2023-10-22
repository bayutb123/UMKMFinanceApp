package com.bayutb123.umkmfinanceapp.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TransactionScreen(
    modifier: Modifier = Modifier,
    onNavigationClick: (String) -> Unit
) {
    TransactionScreenContent(
        modifier = modifier,
        onNavigationClick = onNavigationClick
    )
}

@Composable
fun TransactionScreenContent(
    modifier: Modifier,
    onNavigationClick: (String) -> Unit
) {
    Scaffold(

    ) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Transaction Screen")
            }
        }
    }
}
