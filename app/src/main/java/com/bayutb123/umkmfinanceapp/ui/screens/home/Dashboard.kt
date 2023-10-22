package com.bayutb123.umkmfinanceapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.components.view.DashboardSummaryCard
import com.bayutb123.umkmfinanceapp.ui.components.view.DashboardTopBar
import com.bayutb123.umkmfinanceapp.ui.components.view.HighLightBox
import com.bayutb123.umkmfinanceapp.ui.components.view.TransactionItemColumn

@Composable
fun Dashboard(
    modifier: Modifier = Modifier,
    onNavigationClick: (String) -> Unit
) {
    DashboardContent(
        modifier = modifier,
        onNavigationClick = onNavigationClick
    )
}

@Composable
fun DashboardContent(
    modifier: Modifier,
    onNavigationClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            DashboardTopBar()
        }
    ) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            DashboardSummaryCard(onItemClick = { /*TODO*/ }, summaryValue = 12000000, modifier = modifier)
            Text(
                text = "Sorotan",
                modifier = modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(5) {
                    HighLightBox()
                }
            }
            Text(
                text = "Transaksi Terkini",
                modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            LazyColumn(verticalArrangement = Arrangement.spacedBy(0.dp), modifier = modifier.weight(1f)) {
                items(10) {
                    TransactionItemColumn() {}
                }
            }
        }
    }
}