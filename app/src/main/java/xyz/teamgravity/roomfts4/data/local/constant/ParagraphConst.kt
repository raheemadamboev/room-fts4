package xyz.teamgravity.roomfts4.data.local.constant

object ParagraphConst {

    /**
     * Database name
     */
    const val NAME = "paragraph_database"


    /**
     * Database version
     */
    const val VERSION = 1

    /**
     * Paragraphs table
     * Entity -> [xyz.teamgravity.roomfts4.data.local.entity.ParagraphEntity]
     * Model -> [xyz.teamgravity.roomfts4.data.model.ParagraphModel]
     */
    const val TABLE_PARAGRAPH = "table_paragraph"

    /**
     * Paragraphs FTS table
     * Entity -> [xyz.teamgravity.roomfts4.data.local.fts.ParagraphFtsEntity]
     */
    const val FTS_PARAGRAPH = "fts_paragraph"
}