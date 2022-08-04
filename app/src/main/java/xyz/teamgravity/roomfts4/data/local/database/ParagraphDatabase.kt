package xyz.teamgravity.roomfts4.data.local.database

import androidx.room.Database
import xyz.teamgravity.roomfts4.data.local.constant.ParagraphConst
import xyz.teamgravity.roomfts4.data.local.dao.ParagraphDao
import xyz.teamgravity.roomfts4.data.local.entity.ParagraphEntity
import xyz.teamgravity.roomfts4.data.local.fts.ParagraphFtsEntity

@Database(
    entities = [ParagraphEntity::class, ParagraphFtsEntity::class],
    version = ParagraphConst.VERSION
)
abstract class ParagraphDatabase {

    abstract fun paragraphDao(): ParagraphDao
}