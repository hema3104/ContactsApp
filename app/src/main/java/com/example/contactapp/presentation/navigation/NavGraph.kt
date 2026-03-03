package com.example.contactapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import com.example.contactapp.presentation.ContactViewModel
import com.example.contactapp.presentation.Screen.AddEditScreen
import com.example.contactapp.presentation.Screen.HomeScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ContactViewModel
) {

    NavHost(
        navController = navHostController,
        startDestination = Routes.Home.route,
        modifier = modifier
    ) {

        composable(Routes.Home.route) {

            val viewModel: ContactViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()

            HomeScreen(
                navHostController = navHostController,
                state = state,
                viewModel = viewModel
            )
        }

        composable(Routes.AddEdit.route) {

            val viewModel: ContactViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()

            AddEditScreen(
                navHostController = navHostController,
                state = state,
                onEvent = { viewModel.saveContact() }
            )
        }
    }
}