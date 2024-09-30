package com.example.travel.presentation.sign_in_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.travel.R
import com.example.travel.presentation.nav_graph.Route
import com.example.travel.presentation.account_center.AuthenticationButton
import com.example.travel.presentation.account_center.SignInWithEmail
import com.example.travel.ui.theme.tripsansFontFamily
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun SignIn(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(200.dp))

        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            stringResource(id = R.string.sign_in_title),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontFamily = tripsansFontFamily
        )

        Spacer(modifier = Modifier.height(12.dp))

        //
        AuthenticationButton(R.string.sign_in_gg) { credential ->
            viewModel.onSignInWithGoogle(credential, openAndPopUp)
            
        }

        Spacer(modifier = Modifier.height(12.dp))

        SignInWithEmail(buttonText = R.string.sign_in_email, openAndPopUp)
    }
}

/*
@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    SignIn(navController = n)
}*/
