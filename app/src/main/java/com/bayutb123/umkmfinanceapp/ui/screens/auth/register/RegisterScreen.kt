package com.bayutb123.umkmfinanceapp.ui.screens.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.components.input.CustomTextField
import com.bayutb123.umkmfinanceapp.ui.components.input.FullWidthButton
import com.bayutb123.umkmfinanceapp.ui.components.view.TopRoundedContainer
import com.bayutb123.umkmfinanceapp.ui.screens.Screen

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onNavigationRequested: (String) -> Unit,
) {
    RegisterScreenContent(
        modifier = modifier,
        onRegisterAuthorized = onNavigationRequested,
        onLoginClick = onNavigationRequested
    )
}

@Composable
fun RegisterScreenContent(
    modifier: Modifier,
    onRegisterAuthorized: (String) -> Unit,
    onLoginClick: (String) -> Unit
) {
    var fullName by rememberSaveable {
        mutableStateOf("")
    }
    var emailAddress by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var confirmPassword by rememberSaveable {
        mutableStateOf("")
    }
    Scaffold { paddingValues ->
        Box(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 50.dp)
            ) {
                Text(
                    text = "UMKM FINANCE APP",
                    modifier = modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
            TopRoundedContainer(
                modifier = modifier.height(IntrinsicSize.Min),
                content = {
                    Text(
                        text = "Daftar Akun",
                        modifier =modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.headlineLarge.fontSize
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    CustomTextField(onTextChanged = { emailAddress = it },
                        placeholder = "Full name",
                        keyboardType = KeyboardType.Text,
                        modifier = modifier.padding(top = 16.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Email address"
                            )
                        })
                    CustomTextField(onTextChanged = { emailAddress = it },
                        placeholder = "Email address",
                        keyboardType = KeyboardType.Email,
                        modifier = modifier.padding(top = 16.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email address"
                            )
                        })
                    CustomTextField(
                        onTextChanged = { password = it },
                        placeholder = "Password",
                        keyboardType = KeyboardType.Password,
                        modifier = modifier.padding(top = 16.dp),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
                        },
                        ishidden = true
                    )
                    CustomTextField(
                        onTextChanged = { confirmPassword = it },
                        placeholder = "Password",
                        keyboardType = KeyboardType.Password,
                        modifier = modifier.padding(top = 16.dp),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
                        },
                        ishidden = true
                    )
                    Text(
                        text = "Login",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                            .clickable {
                            },
                        textAlign = TextAlign.End,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    FullWidthButton(onClick = { /*TODO*/ }, text = "Login")
                }
            )
        }
    }
}
