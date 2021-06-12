package com.tsm.roomdaggerhilt.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM user")
    fun getRecord(): LiveData<List<UserEntity>>

    @Insert
    fun insertRecord(userEntity: UserEntity)
}