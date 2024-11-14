package com.example.taskfrontend.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.taskfrontend.R
import com.example.taskfrontend.presentation.route.Route

@Composable
fun BottomNavUI(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""

    Surface(
        shadowElevation = 8.dp,
    ) {
        BottomAppBar(
            containerColor = colorResource(id = R.color.hijau),
            modifier = Modifier.height(70.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                NavigationItem(
                    title = "Home",
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home,
                    selected = currentRoute == Route.Home.route,
                    onClick = {
                        navController.navigate(Route.Home.route) {
                            popUpTo(Route.Home.route) { inclusive = true }
                        }
                    }
                )

                NavigationItem(
                    title = "Explore",
                    selectedIcon = Icons.Filled.Search,
                    unselectedIcon = Icons.Outlined.Search,
                    selected = currentRoute == Route.Search.route,
                    onClick = {
                        navController.navigate(Route.Search.route) {
                            popUpTo(Route.Search.route) { inclusive = true }
                        }
                    }
                )

                NavigationItem(
                    title = "About",
                    selectedIcon = Icons.Filled.Person,
                    unselectedIcon = Icons.Outlined.Person,
                    selected = currentRoute == Route.About.route,
                    onClick = {
                        navController.navigate(Route.About.route) {
                            popUpTo(Route.About.route) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun NavigationItem(
    title: String,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = if (selected) selectedIcon else unselectedIcon,
                contentDescription = title,
                modifier = Modifier.size(30.dp),
                tint = if (selected) colorResource(id = R.color.black) else colorResource(id = R.color.black)
            )
        }
        Text(
            text = title,
            color = if (selected) colorResource(id = R.color.black) else colorResource(id = R.color.black),
            fontSize = 12.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomNavUI() {
    val navController = rememberNavController()
    BottomNavUI(navController = navController)
}