package com.example.taskfrontend.presentation.repository

import com.example.taskfrontend.R
import com.example.taskfrontend.presentation.model.Person

class PersonRepository {
    private val person = listOf(
        Person(1, R.drawable.foto_daman,"Daniel Pandapotan Manalu", "danielmanalu101@gmail.com", "Institut Teknologi Del", "Teknologi Informasi")
    )

    fun getPerson() : List<Person>{
        return person
    }
}