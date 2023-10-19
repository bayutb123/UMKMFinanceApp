package com.bayutb123.umkmfinanceapp.ui.screens.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bayutb123.umkmfinanceapp.ui.components.input.CustomTextField
import com.bayutb123.umkmfinanceapp.ui.components.input.FullWidthButton
import com.bayutb123.umkmfinanceapp.ui.components.view.TopRoundedContainer
import com.bayutb123.umkmfinanceapp.ui.screens.Screen

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onNavigationRequested: (String) -> Unit,
) {
    LoginScreenContent(
        modifier = modifier,
        onLoginAuthorized = onNavigationRequested,
        onRegisterClick = onNavigationRequested
    )
}

@Composable
fun LoginScreenContent(
    modifier: Modifier,
    onLoginAuthorized: (String) -> Unit,
    onRegisterClick: (String) -> Unit
) {
    var emailAddress by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
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
                modifier = modifier.height(400.dp),
                content = {
                    Text(
                        text = "Login Screen",
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.headlineLarge.fontSize
                    )
                    Spacer(modifier = Modifier.height(24.dp))
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
                    Text(
                        text = "Register",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                            .clickable {
                                onRegisterClick(Screen.Register.route)
                            },
                        textAlign = TextAlign.End,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    FullWidthButton(onClick = { /*TODO*/ }, text = "Login")
                }
            )
        }
    }
}
