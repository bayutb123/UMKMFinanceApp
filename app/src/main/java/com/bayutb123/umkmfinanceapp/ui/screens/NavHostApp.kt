package com.bayutb123.umkmfinanceapp.ui.screens

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bayutb123.umkmfinanceapp.ui.screens.home.HomeScreen
import com.bayutb123.umkmfinanceapp.ui.screens.auth.login.LoginScreen
import com.bayutb123.umkmfinanceapp.ui.screens.auth.register.RegisterScreen
import com.bayutb123.umkmfinanceapp.ui.screens.finance.AddRecordScreen

@Composable
fun NavHostApp(
    modifier : Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route, modifier = modifier.systemBarsPadding()) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigationRequested = { route ->
                    navController.navigate(route)
                }
            )
        }
        composable(Screen.Login.route) {
            LoginScreen(
                onNavigationRequested = { route ->
                    navController.navigate(route)
                },
            )
        }
        composable(Screen.Register.route) {
            RegisterScreen(
                onNavigationRequested = { route ->
                    navController.navigate(route)
                },
            )
        }
        composable(Screen.Add.route) {
            AddRecordScreen(
                modifier = modifier,
                onNavigationClick = { route ->
                    navController.navigate(route)
                },
            )
        }
    }
}