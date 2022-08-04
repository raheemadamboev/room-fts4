package xyz.teamgravity.roomfts4.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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
        return dao.searchParagraph(query)
    }
}