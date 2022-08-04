package xyz.teamgravity.roomfts4.data.local.callback

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import xyz.teamgravity.roomfts4.data.local.constant.ParagraphConst.FTS_PARAGRAPH

class ParagraphCallback : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        db.execSQL("INSERT INTO $FTS_PARAGRAPH($FTS_PARAGRAPH) VALUES ('rebuild')")
    }
}