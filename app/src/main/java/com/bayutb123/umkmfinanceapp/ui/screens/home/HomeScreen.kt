package com.bayutb123.umkmfinanceapp.ui.screens.home

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bayutb123.umkmfinanceapp.ui.components.view.HomeBottomNavigationBar
import com.bayutb123.umkmfinanceapp.ui.screens.Screen
import com.bayutb123.umkmfinanceapp.ui.screens.finance.AddRecordScreen
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
    val items = listOf(
        NavigationItem(
            id = 1,
            route = Screen.Dashboard.route,
            icon = Icons.Default.Home,
            title = "Dasbor",
        ),
        NavigationItem(
            id = 0,
            route = Screen.Add.route,
            icon = Icons.Default.AddCircle,
            title = "Tambah",
        ),
        NavigationItem(
            id = 0,
            route = Screen.Transaction.route,
            icon = Icons.Default.Money,
            title = "Transaksi"
        ),
//        NavigationItem(
//            id = 0,
//            route = "home",
//            icon = Icons.Default.AccountBalance,
//            title = "Accounts"
//        )
    )
    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = modifier.height(64.dp),
            ) {
                val navBackStackEntry by bottomBarNavController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(text = screen.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            if (screen.route == Screen.Add.route) {
                                onNavigationClick(screen.route)
                            } else {
                                bottomBarNavController.navigate(screen.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(bottomBarNavController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
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
