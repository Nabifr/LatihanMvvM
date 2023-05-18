package com.android.designpatternmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.android.designpatternmvvm.R
import com.android.designpatternmvvm.view.adapter.UserAdapter
import com.android.designpatternmvvm.databinding.ActivityMainBinding
import com.android.designpatternmvvm.viewmodel.UserViewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmAdapter()

    }

    fun setVmAdapter(){
        val vModel =ViewModelProvider(this).get(UserViewModel::class.java)
        vModel.getLDatUsr().observe(this, Observer {
            userAdapter = UserAdapter(it)
            val layoutmanager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvHome.layoutManager = layoutmanager
            binding.rvHome.adapter = UserAdapter(it)
        })
        vModel.getDataUser()
    }
}