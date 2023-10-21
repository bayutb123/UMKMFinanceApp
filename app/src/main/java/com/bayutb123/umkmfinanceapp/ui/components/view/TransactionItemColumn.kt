package com.bayutb123.umkmfinanceapp.ui.components.view

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.theme.UMKMFinanceAppTheme

@Composable
fun TransactionItemColumn(
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    val fillMaxWidth = Modifier.fillMaxWidth()
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = modifier
            .fillMaxWidth().clickable { onItemClick() }
    ) {
        Icon(
            imageVector = Icons.Default.MonetizationOn,
            contentDescription = "Settings",
            modifier = modifier.padding(16.dp)
        )
        Column(modifier = modifier.weight(1f).padding(vertical = 8.dp)) {
            Text(
                text = "10-10-2021",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Light,
                modifier = fillMaxWidth
            )
            Text(
                text = "Pembelian stok komputer A2 untuk pribadi",
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium,
                modifier = fillMaxWidth,
                maxLines = 1
            )
            Text(
                text = "Rp. 1.000.000",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Light,
                modifier = fillMaxWidth
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun PreviewTransactionItemColumn() {
    UMKMFinanceAppTheme {
        TransactionItemColumn() {}
    }
}