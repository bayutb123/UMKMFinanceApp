package com.bayutb123.umkmfinanceapp.ui.components.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
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

@Composable
fun DashboardTopBar(
    modifier : Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(vertical = 8.dp)) {
        Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Rp.")
        Column(Modifier.weight(1f)) {
            Text(text = "Saldo", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Light)
            Text(text = "1.000.000", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold)
        }
        IconButton(onClick = { }) {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
        }
    }
}

@Preview
@Composable
fun PreviewHomeTopBar() {
    MaterialTheme {
        DashboardTopBar()
    }
}