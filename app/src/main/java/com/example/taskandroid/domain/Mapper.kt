package com.example.taskandroid.domain

interface Mapper <F,T>{

    fun mapFrom(from:F):T
}