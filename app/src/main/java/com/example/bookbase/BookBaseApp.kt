package com.example.bookbase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookbase.data.DummyData
import com.example.bookbase.navigation.NavigationItem
import com.example.bookbase.navigation.Route
import com.example.bookbase.ui.theme.BackgroundLight
import com.example.bookbase.ui.theme.BookBaseTheme
import com.example.bookbase.ui.theme.PrimaryColor
import com.example.bookbase.ui.theme.SurfaceLight
import com.example.bookbase.screen.AuthorDetails
import com.example.bookbase.screen.BookDetails
import com.example.bookbase.screen.BookReadingScreen

@Composable
fun BookBaseApp(
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val title = when {
        currentRoute == Route.HOME -> "BookBase"
        currentRoute == Route.SAVED -> "Saved"
        currentRoute == Route.PROFILE -> "Profile"
        currentRoute?.startsWith("details/author") == true -> "Author Details"
        currentRoute?.startsWith("details/book") == true -> "Book Details"
        currentRoute?.startsWith("details/read") == true -> {
            val bookId = navBackStackEntry?.arguments?.getInt("id")
            val book = DummyData.books.find { it.id == bookId }
            book?.title ?: "Reading"
        }
        else -> "Details"
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars),
        topBar = {
            TopBar(
                title = title,
                showBackButton = currentRoute?.startsWith("details") == true,
                onBackPressed = { navController.popBackStack() }
            )
        },
        bottomBar = {
            if (currentRoute != null && !currentRoute.startsWith("details")) {
                BottomBar(navController)
            }
        },
        containerColor = BackgroundLight
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(SurfaceLight)
        ) {
            NavHost(
                navController = navController,
                startDestination = Route.HOME,
                modifier = Modifier
            ) {
                composable(Route.HOME) {
                    HomeScreen(navController)
                }
                composable(Route.SAVED) {
                    SavedScreen(navController)
                }
                composable(Route.PROFILE) {
                    ProfileScreen()
                }

                composable(
                    route = "details/author/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType })
                ) { backStackEntry ->
                    val authorId = backStackEntry.arguments?.getInt("id")
                    if (authorId != null) {
                        AuthorDetails(authorId = authorId, navController = navController)
                    }
                }
                
                composable(
                    route = "details/book/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType })
                ) { backStackEntry ->
                    val bookId = backStackEntry.arguments?.getInt("id")
                    if (bookId != null) {
                        BookDetails(bookId = bookId, navController = navController)
                    }
                }

                composable(
                    route = "details/read/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType })
                ) { backStackEntry ->
                    val bookId = backStackEntry.arguments?.getInt("id")
                    if (bookId != null) {
                        BookReadingScreen(bookId = bookId, navController = navController)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    showBackButton: Boolean = false,
    onBackPressed: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            } else {
                Spacer(modifier = Modifier.size(48.dp))
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = PrimaryColor
        ),
        modifier = modifier
    )
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            image = R.drawable.ic_home,
            screen = Route.HOME
        ),
        NavigationItem(
            title = "Saved",
            image = R.drawable.ic_saved,
            screen = Route.SAVED
        ),
        NavigationItem(
            title = "Profile",
            image = R.drawable.ic_profile,
            screen = Route.PROFILE
        )
    )

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .height(65.dp),
        containerColor = PrimaryColor,
        tonalElevation = 4.dp
    ) {
        navigationItems.forEach { item ->
            val isSelected = currentRoute == item.screen

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(item.screen) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.image),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp),
                        tint = if (isSelected) Color.White else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) Color.White else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BookBaseAppPreview() {
    BookBaseTheme {
        BookBaseApp()
    }
}
