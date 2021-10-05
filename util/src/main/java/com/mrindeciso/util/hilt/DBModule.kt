package com.mrindeciso.util.hilt

import android.content.Context
import androidx.room.Room
import com.mrindeciso.util.db.AppDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext ctx: Context
    ) = Room.databaseBuilder(
        ctx,
        AppDB::class.java,
        "appdb"
    ).build()

    @Singleton
    @Provides
    fun provideBrushDao(db: AppDB) = db.brushDao()

}