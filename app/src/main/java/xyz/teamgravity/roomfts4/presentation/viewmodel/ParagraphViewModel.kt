package xyz.teamgravity.roomfts4.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import xyz.teamgravity.roomfts4.data.repository.ParagraphRepository
import javax.inject.Inject

@HiltViewModel
class ParagraphViewModel @Inject constructor(
    private val repository: ParagraphRepository,
) : ViewModel() {

    var paragraphs: List<String> by mutableStateOf(emptyList())
        private set

    var searchExpanded: Boolean by mutableStateOf(false)
        private set

    init {
        observe()
    }

    fun onSearchExpanded() {
        searchExpanded = true
    }

    fun onSearchCollapsed() {
        searchExpanded = false
    }

    private fun observe() {
        observeParagraphs()
    }

    private fun observeParagraphs() {
        viewModelScope.launch {
            repository.getParagraphs().collectLatest { paragraphs ->
                this@ParagraphViewModel.paragraphs = paragraphs.map { it.paragraph }
            }
        }
    }
}