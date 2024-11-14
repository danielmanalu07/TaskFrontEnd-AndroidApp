package com.example.taskfrontend.presentation.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.taskfrontend.presentation.component.BottomNavUI
import com.example.taskfrontend.presentation.component.TopAppBarUI
import com.example.taskfrontend.presentation.model.Jenis_Makanan
import com.example.taskfrontend.presentation.model.Menu_Makanan
import com.example.taskfrontend.presentation.route.Route
import com.example.taskfrontend.presentation.viewModel.JenisMakananVM
import com.example.taskfrontend.presentation.viewModel.MenuMakananVM
import com.example.taskfrontend.presentation.viewModel.PersonVM

@Composable
fun HomeScreen(navController: NavController, viewModel: JenisMakananVM = viewModel(), personVM: PersonVM = viewModel(), menuMakananVM: MenuMakananVM = viewModel()) {
    val person = personVM.person.collectAsState()
    val jenisMakanan = viewModel.jenisMakanan.collectAsState()
    val menuMakanan = menuMakananVM.menuMakanan.collectAsState()
    val context = LocalContext.current
    Scaffold (
        topBar = {
            TopAppBarUI("Home", false, navController=navController)
        },
        bottomBar = {
            BottomNavUI(navController = navController)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ){
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
            ) {
                item{
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = "Selamat Datang, ",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        if (person.value.isNotEmpty()) {
                            Text(
                                text = person.value[0].nama,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                            )
                        } else {
                            Text(
                                text = "Loading...",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                            )
                        }
                    }
                }

                item {
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Top Picks",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            modifier = Modifier.padding(16.dp)
                        )

                        Text(
                            text = "See All",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(16.dp),
                            color = Color.DarkGray
                        )
                    }

                    Spacer(modifier = Modifier.size(10.dp))

                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(jenisMakanan.value) { makanan ->
                            JenisMakananCard(jenisMakanan = makanan) {
                                navController.navigate(Route.DetailJenisMakanan.detailJenisMakanan(id = makanan.id)){
                                    popUpTo(Route.DetailJenisMakanan.route) {inclusive = true}
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.size(20.dp))

                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Our Recommendation",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            modifier = Modifier.padding(16.dp)
                        )

                        Text(
                            text = "See All",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(16.dp),
                            color = Color.DarkGray
                        )
                    }

                    Spacer(modifier = Modifier.size(10.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        menuMakanan.value.forEach { makanan ->
                            MenuMakananCard(menuMakanan = makanan) {
                                navController.navigate(Route.DetailMenuMakanan.detailMenuMakanan(id = makanan.id)){
                                    popUpTo(Route.DetailJenisMakanan.route) {inclusive = true}
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun JenisMakananCard(jenisMakanan: Jenis_Makanan, onClick: () -> Unit) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .width(200.dp)
            .height(250.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Box(modifier = Modifier.height(140.dp)) {
                AsyncImage(
                    model = jenisMakanan.gambar,
                    contentDescription = jenisMakanan.nama,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(color = Color.White.copy(alpha = 0.9f), CircleShape)
                        .align(Alignment.TopEnd)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = Color(0xFFFFD700),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${jenisMakanan.rating}",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = jenisMakanan.nama,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = jenisMakanan.type,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Rp ${jenisMakanan.harga}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    IconButton(
                        onClick = { Toast.makeText(context, "Add To Cart", Toast.LENGTH_SHORT).show() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add To Cart",
                            tint = Color.Black,
                            modifier = Modifier
                                .size(20.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.Green),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MenuMakananCard(menuMakanan: Menu_Makanan, onClick: () -> Unit){
    val context = LocalContext.current

    Card (
        modifier = Modifier.fillMaxWidth().height(120.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
    ) {
        Row (
            modifier = Modifier.fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier.size(104.dp)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    AsyncImage(
                        model = menuMakanan.gambar,
                        contentDescription = menuMakanan.nama,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    if (menuMakanan.rating >= 4.7) {
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .background(
                                    color = Color(0xFF4CAF50),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .align(Alignment.TopStart)
                        ){
                            Text(
                                text = "Best Seller",
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))


                Column (
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = menuMakanan.nama,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.ThumbUp,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )

                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = menuMakanan.type,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }

                    Text(
                        text = "Rp ${menuMakanan.harga}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4CAF50)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(bottom = 8.dp)
            ) {
                IconButton(
                    onClick = {Toast.makeText(context,"Added To Cart", Toast.LENGTH_SHORT).show()},
                    modifier = Modifier
                        .size(36.dp)
                        .background(
                            color = Color(0xFF4CAF50),
                            shape = RoundedCornerShape(8.dp),
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add to Cart",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    val navController = rememberNavController()
    val jenisMakananVM = JenisMakananVM()
    val personVM = PersonVM()
    val menuMakananVM = MenuMakananVM()
    HomeScreen(navController = navController, viewModel = jenisMakananVM, personVM = personVM, menuMakananVM = menuMakananVM)
}