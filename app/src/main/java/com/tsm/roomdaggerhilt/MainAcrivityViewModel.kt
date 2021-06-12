package com.tsm.roomdaggerhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsm.roomdaggerhilt.db.RoomRepository
import com.tsm.roomdaggerhilt.db.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainAcrivityViewModel @Inject constructor(private val repository: RoomRepository) :
    ViewModel() {

    var userData: MutableLiveData<List<UserEntity>> = MutableLiveData()

    fun getRecordsObserver(): LiveData<List<UserEntity>> {
        return repository.getRecords()
    }

    fun insertRecord(userEntity: UserEntity){
        repository.insertRecord(userEntity)
    }

}