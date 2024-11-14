package com.example.taskfrontend.presentation.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.taskfrontend.presentation.component.TopAppBarUI
import com.example.taskfrontend.presentation.viewModel.KategoriMakananVM

@Composable
fun DetailKategoriScreen(navController: NavController, id:Int) {
    val kategoriMakananVM = KategoriMakananVM()
    val kategoriMakananList = kategoriMakananVM.kategoriMakanan.collectAsState().value
    val kategoriMakanan = kategoriMakananList.find { it.id == id }

    Scaffold(
        topBar = {
            TopAppBarUI("Detail Kategori Makanan", true, navController = navController)
        }
    ) { paddingValues ->
        if (kategoriMakanan != null) {
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
                        model = kategoriMakanan.gambar,
                        contentDescription = kategoriMakanan.nama,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = kategoriMakanan.nama,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = kategoriMakanan.deskripsi,
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
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
private fun PreviewDetailKategori() {
    val navController = rememberNavController()
    val kategoriMakananVM = KategoriMakananVM()
    val kategoriMakanan = kategoriMakananVM.kategoriMakanan.collectAsState()
    if (kategoriMakanan.value.isNotEmpty()){
        DetailKategoriScreen(navController = navController, id = kategoriMakanan.value[0].id)
    }
}