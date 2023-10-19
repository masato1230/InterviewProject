package com.example.interviewproject.data.repositories

import com.example.interviewproject.data.CatFactsService
import javax.inject.Inject

class CatFactRepository @Inject constructor(
    private val catFactsService: CatFactsService,
) {

    suspend fun getCatFacts() : List<String> {
        return catFactsService.getCatFacts().data?.mapNotNull { it?.fact } ?: emptyList()
    }
}
