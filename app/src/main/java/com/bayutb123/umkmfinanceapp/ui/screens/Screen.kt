package com.bayutb123.umkmfinanceapp.ui.screens

sealed class Screen(val route: String) {
    object Register : Screen(REGISTER_ROUTE)
    object Login : Screen(LOGIN_ROUTE)
    object Home : Screen(HOME_ROUTE)
    object Dashboard : Screen(DASHBOARD_ROUTE)
    object Add : Screen(ADD_ROUTE)
    object Transaction : Screen(TRANSACTION_ROUTE)
    object Detail : Screen(DETAIL_ROUTE)
    object Edit : Screen(EDIT_ROUTE)

    companion object {
        private const val LOGIN_ROUTE = "login"
        private const val HOME_ROUTE = "home"
        private const val DETAIL_ROUTE = "detail"
        private const val ADD_ROUTE = "add"
        private const val EDIT_ROUTE = "edit"
        private const val REGISTER_ROUTE = "register"
        private const val DASHBOARD_ROUTE = "dashboard"
        private const val TRANSACTION_ROUTE = "transaction"
    }

}