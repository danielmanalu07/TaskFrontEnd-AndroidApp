package com.example.taskfrontend.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskfrontend.presentation.model.Kategori_Makanan
import com.example.taskfrontend.presentation.repository.KategoriMakananRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class KategoriMakananVM: ViewModel() {
    val kategoriMakananRepository = KategoriMakananRepository()
    private val _kategoriMakanan = MutableStateFlow<List<Kategori_Makanan>>(emptyList())
    val kategoriMakanan: StateFlow<List<Kategori_Makanan>> get() = _kategoriMakanan

    init {
        loadItems()
    }

    fun loadItems(){
        viewModelScope.launch {
            _kategoriMakanan.value = kategoriMakananRepository.getKategoriMakanan()
        }
    }
}