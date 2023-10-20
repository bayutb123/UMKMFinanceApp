package com.bayutb123.umkmfinanceapp.ui.components.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.elevatedCardColors
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.theme.UMKMFinanceAppTheme

@Composable
fun HighLightBox(
    modifier: Modifier = Modifier,
    boxColor: Color = MaterialTheme.colorScheme.primaryContainer
) {
    ElevatedCard(
        modifier = modifier
            .size(height = 200.dp, width = 180.dp),
        shape = RoundedCornerShape(MaterialTheme.shapes.medium.topStart),
        colors = elevatedCardColors(
            containerColor = boxColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            draggedElevation = 0.dp
        )
    ) {
        Column(modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Text(
                text = "Piutang terkini",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = modifier.weight(1f))
            Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                Text(
                    text = "Masyarakat Umum",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Rp. 1.000.000",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewHighLightBox() {
    UMKMFinanceAppTheme {
        HighLightBox()
    }
}