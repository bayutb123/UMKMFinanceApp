package com.bayutb123.umkmfinanceapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.components.view.HighLightBox
import com.bayutb123.umkmfinanceapp.ui.components.view.HomeBottomNavigationBar
import com.bayutb123.umkmfinanceapp.ui.components.view.HomeTopBar
import com.bayutb123.umkmfinanceapp.ui.components.view.TransactionItemColumn
import com.bayutb123.umkmfinanceapp.ui.screens.Screen
import com.bayutb123.umkmfinanceapp.ui.uiClass.NavigationItem

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
    Scaffold(
        topBar = {
            HomeTopBar()
        },
        bottomBar = {
            HomeBottomNavigationBar(
                item = listOf(
                    NavigationItem(
                        id = 0,
                        route = Screen.Home.route,
                        icon = Icons.Default.Home,
                        title = "Home"
                    ),
                    NavigationItem(
                        id = 0,
                        route = "home",
                        icon = Icons.Default.Money,
                        title = "Transactions"
                    ),
                    NavigationItem(
                        id = 0,
                        route = "home",
                        icon = Icons.Default.CalendarMonth,
                        title = "Report"
                    ),
                    NavigationItem(
                        id = 0,
                        route = "home",
                        icon = Icons.Default.AccountBalance,
                        title = "Accounts"
                    )
                ),
                onItemClick = {},
            )
        }
    ) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
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
            LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(25) {
                    TransactionItemColumn()
                }
            }
        }
    }
}
