package com.insecticidepls.iptodo.di

import android.content.Context
import androidx.room.Room
import com.insecticidepls.iptodo.data.models.ToDoDatabase
import com.insecticidepls.iptodo.util.Constants.DATA_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDB(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        DATA_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDAO(database: ToDoDatabase) = database.daoTD()
}
