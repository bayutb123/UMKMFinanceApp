package com.bayutb123.umkmfinanceapp.ui.utils

class CurrencyUtils {
    companion object {
        fun convertToCurrency(value: Long): String {
            return "Rp ${value.toString().replace("\\B(?=(\\d{3})+(?!\\d))".toRegex(), ".")}"
        }
    }
}