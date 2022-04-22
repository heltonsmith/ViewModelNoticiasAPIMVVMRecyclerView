package com.heltonbustos.viewmodel3noticiasapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.retrofit.Noticias
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.interactor.NoticiasInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {

    val noticias: MutableLiveData<Noticias> = MutableLiveData()
    private val interactor = NoticiasInteractor()

    fun obBtnTraerNoticias(){
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerRespuesta("es"))
        }
    }

}