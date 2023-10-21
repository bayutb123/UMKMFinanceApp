package com.bayutb123.umkmfinanceapp.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bayutb123.umkmfinanceapp.ui.components.view.HomeBottomNavigationBar
import com.bayutb123.umkmfinanceapp.ui.screens.Screen
import com.bayutb123.umkmfinanceapp.ui.uiClass.NavigationItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigationRequested: (String) -> Unit,
) {
    val bottomBarNavController = rememberNavController()
    HomeScreenContent(
        modifier = modifier,
        onNavigationClick = onNavigationRequested,
        bottomBarNavController = bottomBarNavController
    )
}


@Composable
fun HomeScreenContent(
    modifier: Modifier,
    onNavigationClick: (String) -> Unit,
    bottomBarNavController: NavHostController
) {
    Scaffold(

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
        NavHost(
            navController = bottomBarNavController,
            startDestination = Screen.Dashboard.route,
            route = Screen.Home.route,
            modifier = modifier.padding(paddingValues)
        ) {
            composable(Screen.Dashboard.route) {
                Dashboard(
                    modifier = modifier,
                    onNavigationClick = onNavigationClick,
                )
            }
            composable(Screen.Transaction.route) {
                TransactionScreen(
                    modifier = modifier,
                    onNavigationClick = onNavigationClick,
                )
            }
        }
    }
}
