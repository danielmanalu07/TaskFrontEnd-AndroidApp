package com.example.taskfrontend.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskfrontend.presentation.model.Jenis_Makanan
import com.example.taskfrontend.presentation.repository.JenisMakananRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class JenisMakananVM: ViewModel() {
    val jenisMakananRepository = JenisMakananRepository()
    private val _jenisMakanan = MutableStateFlow<List<Jenis_Makanan>>(emptyList())
    val jenisMakanan: StateFlow<List<Jenis_Makanan>> get() = _jenisMakanan

    init {
        loadItems()
    }

    private fun loadItems(){
        viewModelScope.launch {
            _jenisMakanan.value = jenisMakananRepository.getJenisMakanan()
        }
    }
}