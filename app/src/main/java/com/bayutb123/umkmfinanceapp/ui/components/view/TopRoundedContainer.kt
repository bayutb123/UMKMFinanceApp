package com.bayutb123.umkmfinanceapp.ui.components.view

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.components.input.CustomTextField
import com.bayutb123.umkmfinanceapp.ui.components.input.FullWidthButton
import com.bayutb123.umkmfinanceapp.ui.theme.UMKMFinanceAppTheme

@Composable
fun TopRoundedContainer(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.surface,
    content: @Composable (ColumnScope.() -> Unit),
    contentAlignment: Alignment = Alignment.TopStart
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(color = color)
            .padding(vertical = 32.dp, horizontal = 32.dp),
        contentAlignment = contentAlignment
    ) {
        Column(content = content)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewTopRoundedContainer() {
    UMKMFinanceAppTheme {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.primary,
            topBar = {
                TopAppBar(
                    title = { Text(text = "App") },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                )
            }
        ) {
            TopRoundedContainer(modifier = Modifier
                .fillMaxSize()
                .padding(it),
                contentAlignment = Alignment.BottomCenter,
                content = {
                    Text(
                        text = "Container",
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    CustomTextField(onTextChanged = {}, placeholder = "Email address")
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomTextField(onTextChanged = {}, placeholder = "Email address")
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomTextField(onTextChanged = {}, placeholder = "Email address")
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomTextField(onTextChanged = {}, placeholder = "Email address")
                    Spacer(modifier = Modifier.height(32.dp))
                    FullWidthButton(
                        onClick = { /*TODO*/ }, text = "Login",
                    )
                }
            )
        }
    }
}