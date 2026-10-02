package com.gutierrez.navlab.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.gutierrez.navlab.config.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavController){
    val lista = (1..8).map { "Elemento numero $it" }
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de elementos") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {  expanded = true  }){
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = "Perfil"
                        )
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(onClick = { expanded = false },
                            leadingIcon = {Icon(imageVector = Icons.Filled.Bluetooth,
                                contentDescription = "Bluetooth")},
                            text = {Text("Bluetooth")})

                        DropdownMenuItem(
                            onClick = { navController.navigate(Screen.Home.route) },
                            leadingIcon = {Icon(imageVector = Icons.Filled.Home, contentDescription = "Bluetooth")},
                                    text = {Text("Home")}
                        )
                    }
                }
            )
        }
    ){ padding ->
        LazyColumn(contentPadding = padding){
            items(lista.size){ index ->
                ListItem(
                    headlineContent = { Text(text = lista[index]) },
                    supportingContent = { Text(text = "Toca para ver el detalle")},
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.Detail.createRoute(index + 1))
                    }
                )
                HorizontalDivider()
            }
        }
    }
}
