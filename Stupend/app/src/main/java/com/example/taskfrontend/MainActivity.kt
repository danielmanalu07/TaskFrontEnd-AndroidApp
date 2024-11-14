package com.example.taskfrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.taskfrontend.presentation.route.Route
import com.example.taskfrontend.presentation.view.AboutScreen
import com.example.taskfrontend.presentation.view.DetailKategoriScreen
import com.example.taskfrontend.presentation.view.HomeScreen
import com.example.taskfrontend.presentation.view.JenisMakananDetailScreen
import com.example.taskfrontend.presentation.view.MenuMakananDetailScreen
import com.example.taskfrontend.presentation.view.SearchScreen
import com.example.taskfrontend.presentation.viewModel.JenisMakananVM
import com.example.taskfrontend.presentation.viewModel.KategoriMakananVM
import com.example.taskfrontend.presentation.viewModel.MenuMakananVM
import com.example.taskfrontend.presentation.viewModel.PersonVM
import com.example.taskfrontend.ui.theme.TaskFrontEndTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            TaskFrontEndTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainNavigation()
                }
            }
        }
    }

    @Composable
    fun MainNavigation() {
        val navController = rememberNavController()
        val startPage = Route.Home.route


        NavHost(
            navController = navController,
            startDestination = startPage,
        ){
            composable(Route.Home.route){
                val jenisMakananVM = JenisMakananVM()
                val personVM = PersonVM()
                val menuMakananVM = MenuMakananVM()
                HomeScreen(navController = navController, viewModel = jenisMakananVM, personVM = personVM, menuMakananVM = menuMakananVM)
            }
            composable(Route.Search.route){
                val kategoriMakananVM = KategoriMakananVM()
                SearchScreen(navController = navController, kategoriMakananVM = kategoriMakananVM)
            }
            composable(Route.About.route){
                AboutScreen(navController = navController)
            }

            composable(
                route = Route.DetailJenisMakanan.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                val jenisMakananId = backStackEntry.arguments?.getInt("id")
                jenisMakananId?.let {
                    JenisMakananDetailScreen(navController = navController, id = it)
                }
            }

            composable(
                route = Route.DetailMenuMakanan.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                val menuMakananId = backStackEntry.arguments?.getInt("id")
                menuMakananId?.let {
                    MenuMakananDetailScreen(navController = navController, id = it)
                }
            }

            composable(
                route = Route.DetailKategoriMakanan.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                val kategoriMakananId = backStackEntry.arguments?.getInt("id")
                kategoriMakananId?.let {
                    DetailKategoriScreen(navController = navController, id = it)
                }
            }
        }
    }

}
