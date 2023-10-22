package com.bayutb123.umkmfinanceapp.ui.screens.finance

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddRecordScreen(
    modifier: Modifier = Modifier,
    onNavigationClick: (String) -> Unit
) {
    AddRecordScreenContent(
        modifier = modifier,
        onNavigationClick = onNavigationClick
    )
}

@Composable
fun AddRecordScreenContent(modifier: Modifier, onNavigationClick: (String) -> Unit) {
    Text(text = "Add Record")
}
