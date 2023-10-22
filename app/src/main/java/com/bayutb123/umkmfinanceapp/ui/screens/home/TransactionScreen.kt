package com.bayutb123.umkmfinanceapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.components.view.TransactionItemColumn

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionScreenContent(
    modifier: Modifier,
    onNavigationClick: (String) -> Unit
) {
    val sortList = listOf("Semua", "Pemasukan", "Pengeluaran")
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Transaksi") })
        }
    ) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp , vertical = 8.dp)) {
                items(sortList) {
                    TextButton(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )) {
                        Text(text = it)
                    }
                }
            }
            LazyColumn() {
                items(30) {
                    TransactionItemColumn() {

                    }
                }
            }
        }
    }
}
