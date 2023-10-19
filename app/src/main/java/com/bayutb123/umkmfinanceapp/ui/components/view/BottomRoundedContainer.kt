package com.bayutb123.umkmfinanceapp.ui.components.view

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.theme.UMKMFinanceAppTheme

@Composable
fun BottomRoundedContainer(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.surface,
    content: @Composable (ColumnScope.() -> Unit),
    contentAlignment: Alignment = Alignment.TopStart
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
            .background(color = color)
            .padding(start = 32.dp, end = 32.dp, top = 8.dp, bottom = 32.dp),
        contentAlignment = contentAlignment
    ) {
        Column(content = content)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewBottomRoundedContainer() {
    UMKMFinanceAppTheme {
        Scaffold(
            topBar = {
                Column {
                    TopAppBar(
                        title = { Text(text = "App", color = MaterialTheme.colorScheme.onPrimary) },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }
                    )
                    BottomRoundedContainer(
                        color = MaterialTheme.colorScheme.primary,
                        content = {
                            Column {
                                Text(
                                    text = "We think you’re gonna like it here.",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = MaterialTheme.typography.displaySmall.fontSize,
                                    lineHeight = TextUnit(value = 40f, type = TextUnitType.Sp),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }
                    )
                }
            }
        ) {
            Column(
                Modifier.padding(it)
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    text = "We’ve suggested some tasks here in your organization's overview to help you get started.",
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
    }
}