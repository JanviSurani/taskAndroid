package com.example.taskandroid.domain.mapper

import com.example.taskandroid.Model.Country
import com.example.taskandroid.Model.CountryItem
import com.example.taskandroid.domain.Mapper
import javax.inject.Inject

class CountryMapper @Inject constructor() : Mapper<Country?,List<CountryItem>?> {
    override fun mapFrom(from: Country?): List<CountryItem> ?{
        return from?.map {
            CountryItem(
                name=it?.name,
                region =it?.region
            )
        }

    }
}