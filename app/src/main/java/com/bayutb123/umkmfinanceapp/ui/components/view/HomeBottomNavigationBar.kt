package com.bayutb123.umkmfinanceapp.ui.components.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bayutb123.umkmfinanceapp.ui.screens.Screen
import com.bayutb123.umkmfinanceapp.ui.uiClass.NavigationItem

@Composable
fun HomeBottomNavigationBar(
    modifier: Modifier = Modifier,
    item: List<NavigationItem>,
    onItemClick: (String) -> Unit,
    selectedRoute: String,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        tonalElevation = 8.dp
    ) {
        item.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = {
                    Text(text = item.title)
                },
                selected = item.route == selectedRoute,
                onClick = {
                    onItemClick(item.route)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primary,
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    }
}

@Composable
@Preview
fun PreviewHomeBottomNavigationBar() {
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
        selectedRoute = Screen.Home.route
    )
}