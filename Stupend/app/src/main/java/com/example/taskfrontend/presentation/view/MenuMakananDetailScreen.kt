package com.example.taskfrontend.presentation.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.taskfrontend.presentation.component.TopAppBarUI
import com.example.taskfrontend.presentation.viewModel.MenuMakananVM

@Composable
fun MenuMakananDetailScreen(navController: NavController, id: Int) {
    val menuMakananVM = MenuMakananVM()
    val menuMakananList = menuMakananVM.menuMakanan.collectAsState().value
    val menuMakanan = menuMakananList.find { it.id == id }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBarUI("Detail Menu Makanan", true, navController = navController)
        }
    ) { paddingValues ->
        if (menuMakanan != null) {
            Box(
                modifier = Modifier.fillMaxSize().padding(paddingValues)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = menuMakanan.gambar,
                        contentDescription = menuMakanan.nama,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = menuMakanan.nama,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = menuMakanan.deskripsi,
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Harga: Rp ${menuMakanan.harga}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Rating: ${menuMakanan.rating}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFD700)
                        )
                    }

                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "${menuMakanan.nama} ditambahkan ke keranjang",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4CAF50),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Tambah ke Keranjang")
                    }
                }
            }
        } else {
            Text(
                text = "Item tidak ditemukan atau sedang dimuat...",
                fontSize = 16.sp,
                color = Color.Red,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailScreen() {
    val navController = rememberNavController()
    val menuMakananVM = MenuMakananVM()
    val menuMakanan = menuMakananVM.menuMakanan.collectAsState()
    if (menuMakanan.value.isNotEmpty()){
        MenuMakananDetailScreen(navController= navController, id = menuMakanan.value[0].id)
    }
}