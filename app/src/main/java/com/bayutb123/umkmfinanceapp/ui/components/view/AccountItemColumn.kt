package com.bayutb123.umkmfinanceapp.ui.components.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AccountItemColumn(
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth().clickable { onItemClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.AttachMoney,
            contentDescription = "Account Name",
            modifier = modifier.padding(16.dp),
        )
        Text(text = "Account Name", color = MaterialTheme.colorScheme.onSurface, modifier = modifier.weight(1f))
        Text(text = "Rp. 1.000.000", color = MaterialTheme.colorScheme.onSurface, modifier = modifier.padding(end= 16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun AccountItemColumnPreview() {
    MaterialTheme {
        AccountItemColumn() {}
    }
}