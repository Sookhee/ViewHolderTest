package com.example.viewholdertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewholdertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.shortRecyclerView.apply {
            adapter = HorizontalAdapter().apply {
                items = listOf("AA", "BB", "CC", "DD", "EE", "FF")
            }

            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.longRecyclerView.apply {
            adapter = HorizontalAdapter().apply {
                items = listOf("APPLE PIE", "BANANA BREAD", "CUP CAKE", "DONUT", "ECLAIR", "FROYO")
            }

            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}