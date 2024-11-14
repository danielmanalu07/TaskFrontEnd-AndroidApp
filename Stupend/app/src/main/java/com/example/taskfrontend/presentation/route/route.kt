package com.example.taskfrontend.presentation.route

sealed class Route(val route: String) {
    object Home: Route("home")
    object Search: Route("search")
    object About: Route("about")
    object DetailJenisMakanan : Route("detailJenisMakanan/{id}") {
        fun detailJenisMakanan(id: Int) = "detailJenisMakanan/$id"
    }
    object DetailMenuMakanan : Route("detailMenuMakanan/{id}") {
        fun detailMenuMakanan(id: Int) = "detailMenuMakanan/$id"
    }
    object DetailKategoriMakanan : Route("detailKategoriMakanan/{id}") {
        fun detailKategoriMakanan(id: Int) = "detailKategoriMakanan/$id"
    }
}