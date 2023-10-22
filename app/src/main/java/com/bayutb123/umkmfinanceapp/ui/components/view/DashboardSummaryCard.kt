package com.bayutb123.umkmfinanceapp.ui.components.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.theme.UMKMFinanceAppTheme
import com.bayutb123.umkmfinanceapp.ui.utils.CurrencyUtils.Companion.convertToCurrency

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardSummaryCard(
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit,
    summaryValue: Long
) {
    val textColor =
        if (summaryValue > 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ,
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Ringkasan transaksi hari ini",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Pengeluaran - pemasukan", style = MaterialTheme.typography.bodySmall, fontStyle = FontStyle.Italic, color = Color.Gray)
            Text(
                text = convertToCurrency(summaryValue),
                style = MaterialTheme.typography.displaySmall,
                color = textColor
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeSummaryCardPreview() {
    UMKMFinanceAppTheme {
        DashboardSummaryCard(summaryValue = -1200000, onItemClick = { /*TODO*/ })
    }
}