package com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.R
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.databinding.ActivityMainBinding
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.recycler.AdaptadorRecycler

class DetalleNoticia : AppCompatActivity() {
    //viewbinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}