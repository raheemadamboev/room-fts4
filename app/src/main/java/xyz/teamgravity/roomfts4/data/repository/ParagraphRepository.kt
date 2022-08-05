package xyz.teamgravity.roomfts4.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import xyz.teamgravity.roomfts4.core.util.Helper
import xyz.teamgravity.roomfts4.data.local.dao.ParagraphDao
import xyz.teamgravity.roomfts4.data.mapper.toModel
import xyz.teamgravity.roomfts4.data.model.ParagraphModel

class ParagraphRepository(
    private val dao: ParagraphDao,
) {

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    fun getParagraphs(): Flow<List<ParagraphModel>> {
        return dao.getParagraphs().map { entities -> entities.map { it.toModel() } }
    }

    fun searchParagraph(query: String): Flow<List<String>> {
        return dao.searchParagraph(Helper.ftsQuery(query))
    }

    fun searchParagraphRanked(query: String): Flow<List<String>> {
        return dao.searchParagraphRanked(Helper.ftsQuery(query))
            .flowOn(Dispatchers.IO)
            .map { entities ->
                entities
                    .sortedByDescending { Helper.calculateScore(it.matchInfo) }
                    .map { it.paragraph.paragraph }
            }
    }
}