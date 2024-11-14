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
import com.example.taskfrontend.presentation.model.Jenis_Makanan
import com.example.taskfrontend.presentation.viewModel.JenisMakananVM
import com.example.taskfrontend.presentation.viewModel.MenuMakananVM

@Composable
fun JenisMakananDetailScreen(navController: NavController, id: Int) {
    val jenisMakananVM = JenisMakananVM()
    val jenisMakananList = jenisMakananVM.jenisMakanan.collectAsState().value
    val context = LocalContext.current

    val jenisMakanan = jenisMakananList.find { it.id == id }

    Scaffold(
        topBar = {
            TopAppBarUI("Detail Jenis Makanan", true, navController = navController)
        }
    ) { paddingValues ->
        if (jenisMakanan != null) {
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
                        model = jenisMakanan.gambar,
                        contentDescription = jenisMakanan.nama,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = jenisMakanan.nama,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = jenisMakanan.deskripsi,
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
                            text = "Harga: Rp ${jenisMakanan.harga}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Rating: ${jenisMakanan.rating}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFD700)
                        )
                    }

                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "${jenisMakanan.nama} ditambahkan ke keranjang",
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
    // Sample data for preview
    val sampleMakanan = Jenis_Makanan(
        id = 1,
        nama = "Rendang",
        deskripsi = "Nasi goreng dengan bumbu spesial",
        harga = 20000.00,
        rating = 4.5,
        gambar = "https://rinaresep.com/wp-content/uploads/2022/05/Rendang.jpg",
        type = "Rendang Heaven"
    )

    JenisMakananDetailScreen(id = sampleMakanan.id, navController = navController)
}