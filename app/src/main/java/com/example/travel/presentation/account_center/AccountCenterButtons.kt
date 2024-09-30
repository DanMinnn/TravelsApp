package com.example.travel.presentation.account_center

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travel.ERROR_TAG
import com.example.travel.R
import com.example.travel.presentation.sign_in_screen.SignInViewModel
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@Composable
fun AuthenticationButton(
    buttonText: Int,
    onGetCredentialResponse: (Credential) -> Unit
){
    val context = LocalContext.current
    val coroutinScope = rememberCoroutineScope()
    val credentialManager = CredentialManager.create(context)
    Button(
        onClick = {
            val googleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(context.getString(R.string.default_web_client_id))
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            coroutinScope.launch {
                try{
                    val result = credentialManager.getCredential(
                        request = request,
                        context = context
                    )
                    onGetCredentialResponse(result.credential)
                }catch (e: GetCredentialException){
                    Log.d(ERROR_TAG, e.message.orEmpty())
                }
            }
        },
        modifier = Modifier.size(width = 300.dp, height = 48.dp),
        border = BorderStroke(width = 1.dp, color = Color.Black),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(24.dp),

        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),

            ) {
            Image(
                painterResource(id = R.drawable.google_ic),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(45.dp))

            Text(
                stringResource(buttonText),
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun SignInWithEmail(
    buttonText: Int,
    openAndUp: (String, String) -> Unit,
    viewModel: SignInViewModel = hiltViewModel()
){
    Button(
        onClick = { viewModel.onSignInWithEmailClick(openAndUp) },
        modifier = Modifier.size(width = 300.dp, height = 48.dp),
        border = BorderStroke(width = 1.dp, color = Color.Black),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(24.dp),

        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),

            ) {
            Image(
                painterResource(id = R.drawable.email_ic),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(45.dp))

            Text(
                stringResource(id = R.string.sign_in_email),
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}