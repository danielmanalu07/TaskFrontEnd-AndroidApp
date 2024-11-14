package com.example.taskfrontend.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskfrontend.presentation.model.Person
import com.example.taskfrontend.presentation.repository.PersonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PersonVM: ViewModel() {
    val personRepository = PersonRepository()
    private val _person = MutableStateFlow<List<Person>>(emptyList())
    val person: StateFlow<List<Person>> get() = _person

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _person.value = personRepository.getPerson()
        }
    }
}