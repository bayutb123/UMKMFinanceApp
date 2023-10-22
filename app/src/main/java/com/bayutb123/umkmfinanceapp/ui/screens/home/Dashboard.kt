package com.bayutb123.umkmfinanceapp.ui.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Money
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.components.view.DashboardSummaryCard
import com.bayutb123.umkmfinanceapp.ui.components.view.DashboardTopBar
import com.bayutb123.umkmfinanceapp.ui.components.view.HighLightBox
import com.bayutb123.umkmfinanceapp.ui.components.view.TransactionItemColumn

@Composable
fun DashboardScreen(
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
    var isVisible by remember {
        mutableStateOf(false)
    }
    // add multidimensional list for add transaction
    val sortList = listOf("Pemasukan", "Pengeluaran", "Pembelian", "Penjualan")
    Scaffold(
        topBar = {
            DashboardTopBar()
        },
        floatingActionButton = {
            Column(horizontalAlignment = Alignment.End) {
                AnimatedVisibility(visible = isVisible) {
                    Column(horizontalAlignment = Alignment.End) {
                        sortList.forEach {
                            ExtendedFloatingActionButton(
                                text = { Text(text = it) },
                                onClick = {
                                    isVisible = !isVisible
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.AssignmentTurnedIn,
                                        contentDescription = "Add Transaction"
                                    )
                                },
                                modifier = modifier.padding(8.dp),
                            )
                        }
                    }
                }
                FloatingActionButton(onClick = {
                    isVisible = !isVisible
                }) {
                    Icon(
                        imageVector = if (isVisible) {
                            Icons.Default.Close
                        } else {
                            Icons.Default.Add
                        }, contentDescription = "Add Transaction"
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            DashboardSummaryCard(
                onItemClick = { /*TODO*/ },
                summaryValue = 120000,
                modifier = modifier
            )
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
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(0.dp),
                modifier = modifier.weight(1f)
            ) {
                items(10) {
                    TransactionItemColumn() {}
                }
            }
        }
    }
}