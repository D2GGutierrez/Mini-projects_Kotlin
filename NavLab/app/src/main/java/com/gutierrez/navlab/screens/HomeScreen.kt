package com.gutierrez.navlab.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gutierrez.navlab.config.Screen


@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier
    ) {
        Text(
            text = "Bienvenido, Juan Gutierrez",
            modifier = Modifier.padding(top = 200.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "¿Qué deseas gestionar hoy?",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 10.sp,
        )
        Button(onClick = {navController.navigate(Screen.List.route)},
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp)) {
            Text(
                text = "Ver lista de elementos"
            )
        }
        Button(onClick = {navController.navigate(Screen.Profile.route)},
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp)) {
            Text(
                text = "Mi Perfil"
            )
        }
    }
}
