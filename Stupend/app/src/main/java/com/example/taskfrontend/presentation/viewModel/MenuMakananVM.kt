package com.example.taskfrontend.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskfrontend.presentation.model.Menu_Makanan
import com.example.taskfrontend.presentation.repository.MenuMakananRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MenuMakananVM: ViewModel() {
    val menuMakananRepository = MenuMakananRepository()
    private val _menuMakanan = MutableStateFlow<List<Menu_Makanan>>(emptyList())
    val menuMakanan: StateFlow<List<Menu_Makanan>> get() = _menuMakanan

    init {
        loadItems()
    }

    fun loadItems(){
        viewModelScope.launch {
            _menuMakanan.value = menuMakananRepository.getMenuMakanan()
        }
    }
}