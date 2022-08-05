package xyz.teamgravity.roomfts4.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import xyz.teamgravity.roomfts4.data.repository.ParagraphRepository
import javax.inject.Inject

@HiltViewModel
class ParagraphViewModel @Inject constructor(
    private val repository: ParagraphRepository,
) : ViewModel() {

    companion object {
        private const val DELAY_SEARCH = 1_000L
    }

    var paragraphs: List<String> by mutableStateOf(emptyList())
        private set

    var query: String by mutableStateOf("")
        private set

    var searchExpanded: Boolean by mutableStateOf(false)
        private set

    private var searchJob: Job? = null

    init {
        viewModelScope.launch { getParagraphs() }
    }

    fun onSearchExpanded() {
        searchExpanded = true
    }

    fun onSearchCollapsed() {
        searchExpanded = false
        onQueryChange("")
    }

    fun onQueryChange(value: String) {
        query = value
        searchParagraph()
    }

    private suspend fun getParagraphs() {
        paragraphs = repository.getParagraphs().first().map { it.paragraph }
    }

    private fun searchParagraph() {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            if (query.isBlank()) {
                getParagraphs()
                cancel()
            }
            delay(DELAY_SEARCH)
            paragraphs = repository.searchParagraphRanked(query).first()
        }
    }
}