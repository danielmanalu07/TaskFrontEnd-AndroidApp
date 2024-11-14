package com.example.taskfrontend.presentation.repository

import com.example.taskfrontend.presentation.model.Kategori_Makanan

class KategoriMakananRepository {
    private val kategoriMakanan = listOf(
        Kategori_Makanan(1, "https://tse1.mm.bing.net/th?id=OIP.u9S8uxKOVzVEnKkqTA8_7QHaEl&pid=Api&P=0&h=220", "Daging", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        Kategori_Makanan(2, "https://tse2.mm.bing.net/th?id=OIP.4dk0XeOy24h9Cehn4cXTqgHaD8&pid=Api&P=0&h=220", "Sayuran", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        Kategori_Makanan(3, "https://tse4.mm.bing.net/th?id=OIP.Xk1WHJ1DxHciP0EGh31rsAHaFj&pid=Api&P=0&h=220", "Buah-buahan", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        Kategori_Makanan(4, "https://tse4.mm.bing.net/th?id=OIP.Rp9vshlNLNYUg389zGZ4lQHaE8&pid=Api&P=0&h=220", "Minuman", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        Kategori_Makanan(5, "https://tse4.mm.bing.net/th?id=OIP.l_vJswel8UO7_w7zgkDU_gHaE8&pid=Api&P=0&h=220", "Seafood", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        Kategori_Makanan(6, "https://png.pngtree.com/png-clipart/20220603/original/pngtree-fast-food-menu-with-premium-quality-colorful-card-poster-png-image_7903796.png", "Makanan Cepat Saji", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        Kategori_Makanan(7, "https://tse3.mm.bing.net/th?id=OIP.NIdD6ZMmybsT2dyxSo7LHwHaE8&pid=Api&P=0&h=220", "Cemilan", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        Kategori_Makanan(8, "https://tse4.mm.bing.net/th?id=OIP.QXc7n-3I6YkaVDbiLgIDqAHaE7&pid=Api&P=0&h=220", "Roti & Pastry", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        Kategori_Makanan(9, "https://tse4.mm.bing.net/th?id=OIP.3YUymaqszGSeeoywB4j3KQHaE7&pid=Api&P=0&h=220", "Sup & Stew", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        Kategori_Makanan(10, "https://tse1.mm.bing.net/th?id=OIP.tWrTBdnjS_qH1QXXmJeLmQHaEZ&pid=Api&P=0&h=220", "Makanan Ringan", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
    )

    fun getKategoriMakanan() : List<Kategori_Makanan> {
        return kategoriMakanan
    }
}