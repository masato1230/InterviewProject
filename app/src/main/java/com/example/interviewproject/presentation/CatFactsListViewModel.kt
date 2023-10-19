package com.example.interviewproject.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewproject.data.repositories.CatFactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatFactsListViewModel @Inject constructor(
    private val repository: CatFactRepository,
) : ViewModel() {

    private val _catFacts = mutableStateOf<List<String>>(emptyList())
    val catFacts: State<List<String>> = _catFacts

    init {
        viewModelScope.launch {
            _catFacts.value = repository.getCatFacts()
        }
    }
}
