package com.bayutb123.umkmfinanceapp.ui.components.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.theme.UMKMFinanceAppTheme

@Composable
fun TransactionItemColumn(
    modifier : Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier
        .fillMaxWidth()
    ) {
        Icon(imageVector = Icons.Default.MonetizationOn, contentDescription = "Settings", modifier = modifier.padding(16.dp))
        Column(modifier = modifier.weight(1f)) {
            Text(text = "10-10-2021", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Light)
            Text(text = "Pembelian", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Medium)
            Text(text = "Rp. 1.000.000", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Light)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
        }
    }
}

@Preview
@Composable
fun PreviewTransactionItemColumn() {
    UMKMFinanceAppTheme {
        TransactionItemColumn()
    }
}