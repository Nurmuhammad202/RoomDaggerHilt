package com.tsm.roomdaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tsm.roomdaggerhilt.db.UserEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainAcrivityViewModel
    private lateinit var item: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_submit.setOnClickListener {
            var userEntity = UserEntity(name = edit_name.text.toString())
            viewModel.insertRecord(userEntity)
            edit_name.setText("")
        }
        initVM()

        viewModel.getRecordsObserver().observe(this, Observer {
            item = ""
            for (i in 0..it.lastIndex) {
                item += it[i].name + "\n"
            }
            tx_db.text = item
        })

    }

    private fun initVM() {
        viewModel = ViewModelProvider(this).get(MainAcrivityViewModel::class.java)
    }
}