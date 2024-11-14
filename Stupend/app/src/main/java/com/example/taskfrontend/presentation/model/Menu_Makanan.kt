package com.example.taskfrontend.presentation.model

data class Menu_Makanan(
    val id: Int,
    val gambar: String,
    val nama: String,
    val deskripsi: String,
    val harga: Double,
    val type: String,
    val rating: Double
)
