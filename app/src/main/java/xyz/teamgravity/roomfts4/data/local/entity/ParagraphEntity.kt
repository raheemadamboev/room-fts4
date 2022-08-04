package xyz.teamgravity.roomfts4.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import xyz.teamgravity.roomfts4.data.local.constant.ParagraphConst

@Entity(tableName = ParagraphConst.TABLE_PARAGRAPH)
data class ParagraphEntity(

    @PrimaryKey
    val id: Long,
    val paragraph: String,
)
