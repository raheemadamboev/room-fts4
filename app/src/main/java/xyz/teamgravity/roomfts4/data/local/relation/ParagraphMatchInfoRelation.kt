package xyz.teamgravity.roomfts4.data.local.relation

import androidx.room.Embedded
import xyz.teamgravity.roomfts4.data.local.entity.ParagraphEntity

data class ParagraphMatchInfoRelation(
    @Embedded
    val paragraph: ParagraphEntity,

    val matchInfo: ByteArray,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ParagraphMatchInfoRelation

        if (paragraph != other.paragraph) return false
        if (!matchInfo.contentEquals(other.matchInfo)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = paragraph.hashCode()
        result = 31 * result + matchInfo.contentHashCode()
        return result
    }
}
