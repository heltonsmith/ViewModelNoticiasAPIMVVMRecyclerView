package com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.retrofit

data class Noticias(
    val data: List<Data>,
    val pagination: Pagination
)

data class Data(
    val author: String,
    val category: String,
    val country: String,
    val description: String,
    val image: String,
    val language: String,
    val published_at: String,
    val source: String,
    val title: String,
    val url: String
)

data class Pagination(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val total: Int
)