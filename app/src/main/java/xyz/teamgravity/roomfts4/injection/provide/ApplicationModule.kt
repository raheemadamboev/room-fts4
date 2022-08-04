package xyz.teamgravity.roomfts4.injection.provide

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.teamgravity.roomfts4.data.local.constant.ParagraphConst
import xyz.teamgravity.roomfts4.data.local.dao.ParagraphDao
import xyz.teamgravity.roomfts4.data.local.database.ParagraphDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideParagraphDatabase(application: Application): ParagraphDatabase =
        Room.databaseBuilder(application, ParagraphDatabase::class.java, ParagraphConst.NAME)
            .createFromAsset("database/paragraphs.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideParagraphDao(paragraphDatabase: ParagraphDatabase): ParagraphDao = paragraphDatabase.paragraphDao()
}