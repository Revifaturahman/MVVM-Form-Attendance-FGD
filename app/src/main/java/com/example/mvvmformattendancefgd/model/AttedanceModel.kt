package com.example.mvvmformattendancefgd.model

data class AttedanceModel(
    val name: String = "",
    val noTlp: String= "",
    val email: String= "",
    val gender: String= "",
    val kategori: String="",
    val skillSet: List<String> = emptyList()
)
