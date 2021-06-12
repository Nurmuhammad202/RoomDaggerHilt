package com.tsm.roomdaggerhilt.di

import android.app.Application
import android.content.Context
import com.tsm.roomdaggerhilt.db.AppDao
import com.tsm.roomdaggerhilt.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APPModele {

    @Singleton
    @Provides
    fun getAppDB(context: Application): AppDatabase{
        return AppDatabase.getDataDB(context)
    }

    @Singleton
    @Provides
    fun getDao(appDB:AppDatabase):AppDao{
        return appDB.getDAO()
    }
}