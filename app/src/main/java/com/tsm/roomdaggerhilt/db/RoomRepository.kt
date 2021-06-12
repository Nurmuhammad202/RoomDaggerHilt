package com.tsm.roomdaggerhilt.db

import androidx.lifecycle.LiveData
import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: AppDao){

    fun getRecords():LiveData<List<UserEntity>>{
        return appDao.getRecord()
    }

    fun insertRecord(userEntity: UserEntity){
        appDao.insertRecord(userEntity)
    }
}

