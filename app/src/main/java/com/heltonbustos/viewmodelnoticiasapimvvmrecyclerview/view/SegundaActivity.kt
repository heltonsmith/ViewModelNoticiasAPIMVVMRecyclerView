package com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.R
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.databinding.ActivityMainBinding
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.databinding.ActivitySegundaBinding
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.retrofit.Data
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.recycler.AdaptadorRecycler

class SegundaActivity : AppCompatActivity() {
    //viewbinding
    private lateinit var binding: ActivitySegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val texto = intent.extras?.getString("data")
        val noticia: Data = Gson().fromJson(texto, Data::class.java)

        binding.txtTitulo2.text = noticia.title
        binding.txtNoticia2.text = noticia.description
    }
}