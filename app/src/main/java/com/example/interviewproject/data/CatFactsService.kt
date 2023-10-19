package com.example.interviewproject.data

import com.example.interviewproject.data.entities.CatFactsEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface CatFactsService {
    @GET("facts")
    suspend fun getCatFacts(
        @Query("limit") limit: Int = 100,
    ) : CatFactsEntity
}
