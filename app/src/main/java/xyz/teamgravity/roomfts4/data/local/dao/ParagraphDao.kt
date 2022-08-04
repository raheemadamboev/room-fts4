package xyz.teamgravity.roomfts4.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.roomfts4.data.local.constant.ParagraphConst.FTS_PARAGRAPH
import xyz.teamgravity.roomfts4.data.local.constant.ParagraphConst.TABLE_PARAGRAPH
import xyz.teamgravity.roomfts4.data.local.entity.ParagraphEntity

@Dao
interface ParagraphDao {

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    @Query("SELECT * FROM $TABLE_PARAGRAPH ORDER BY id ASC")
    fun getParagraphs(): Flow<List<ParagraphEntity>>

    @Query("SELECT SNIPPET($FTS_PARAGRAPH) FROM $TABLE_PARAGRAPH JOIN $FTS_PARAGRAPH ON $TABLE_PARAGRAPH.id = $FTS_PARAGRAPH.rowid WHERE $FTS_PARAGRAPH MATCH :query")
    fun searchParagraph(query: String): Flow<List<String>>
}