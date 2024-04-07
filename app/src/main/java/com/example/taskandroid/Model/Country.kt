package com.example.taskandroid.Model

class Country: ArrayList<CountryItem>()
data class CountryItem(
    val capital: String?="",
    val currency: String?="",
    val flag: String?="",
    val language: String?="",
    val name: String?="",
    val region: String?=""
)