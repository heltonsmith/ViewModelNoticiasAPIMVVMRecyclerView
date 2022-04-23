package com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heltonbustos.viewmodel3noticiasapi.viewmodel.ViewModel
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.databinding.ActivityMainBinding
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.recycler.AdaptadorRecycler

class MainActivity : AppCompatActivity() {
    //viewmodel
    private lateinit var mainViewModel: ViewModel

    //viewbinding
    private lateinit var binding: ActivityMainBinding

    //recyclerview
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var adaptador: AdaptadorRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewmodel
        mainViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        observar() //viewmodel observer

        //recycler
        myRecyclerView = binding.myRecycler
        myRecyclerView.layoutManager =
            LinearLayoutManager(applicationContext,
                LinearLayoutManager.VERTICAL, false)

        //btnTraerNoticias
        binding.btnTraerNoticias.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            mainViewModel.obBtnTraerNoticias()
        }

    }

    /**
     * observar livedata
     */
    private fun observar() {
        mainViewModel.noticias.observe(this, Observer {
            //binding.txtNoticias.text = "Noticias: \n"
            //binding.txtNoticias.append("${Gson().toJson(it)}")
            binding.progressBar.visibility = View.GONE

            adaptador = AdaptadorRecycler(this, it.data, this);
            myRecyclerView.adapter = adaptador

        })
    }


}