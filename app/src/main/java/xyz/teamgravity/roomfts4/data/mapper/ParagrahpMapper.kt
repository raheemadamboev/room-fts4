package xyz.teamgravity.roomfts4.data.mapper

import xyz.teamgravity.roomfts4.data.local.entity.ParagraphEntity
import xyz.teamgravity.roomfts4.data.model.ParagraphModel

fun ParagraphEntity.toModel(): ParagraphModel {
    return ParagraphModel(
        id = id,
        paragraph = paragraph
    )
}