package com.bayutb123.umkmfinanceapp.ui.components.input

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bayutb123.umkmfinanceapp.ui.theme.UMKMFinanceAppTheme
import com.bayutb123.umkmfinanceapp.ui.utils.DatePickerConverter.Companion.convertMillisToDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(
    modifier: Modifier = Modifier,
    onDateSelected: (String) -> Unit,
    onDismiss: () -> Unit,
) {
    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            return utcTimeMillis <= System.currentTimeMillis()
        }
    })

    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = {
                onDateSelected(selectedDate)
                onDismiss()
            }) {
                Text(text = "Select")
            }
        },
        dismissButton = {
            Button(onClick = {
                onDismiss()
            }) {
                Text(text = "Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewCustomDatePicker() {
    UMKMFinanceAppTheme {
        var dateSelected by remember {
            mutableStateOf("")
        }
        var isDatePicking by remember {
            mutableStateOf(false)
        }
        Column {
            Text(text = dateSelected)
            Button(onClick = { isDatePicking = true }) {
                Text(text = "Pick a date")
            }
        }
        AnimatedVisibility(visible = isDatePicking) {
            CustomDatePicker(
                onDateSelected = {
                    dateSelected = it
                    isDatePicking = false
                },
                onDismiss = {
                    isDatePicking = false
                }
            )
        }
    }
}