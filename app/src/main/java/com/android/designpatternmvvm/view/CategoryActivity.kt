package com.android.designpatternmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.designpatternmvvm.R

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
    }
}