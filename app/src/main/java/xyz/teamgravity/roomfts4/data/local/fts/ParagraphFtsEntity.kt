package xyz.teamgravity.roomfts4.data.local.fts

import androidx.room.Entity
import androidx.room.Fts4
import xyz.teamgravity.roomfts4.data.local.constant.ParagraphConst
import xyz.teamgravity.roomfts4.data.local.entity.ParagraphEntity

@Fts4(contentEntity = ParagraphEntity::class)
@Entity(tableName = ParagraphConst.FTS_PARAGRAPH)
data class ParagraphFtsEntity(
    val paragraph: String,
)
