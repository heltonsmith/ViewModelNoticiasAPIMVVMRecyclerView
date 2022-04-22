package com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.interactor

import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.retrofit.Noticias
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.retrofit.RestEngine
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.retrofit.NoticiasAPIService
import retrofit2.Call

class NoticiasInteractor {

    fun traerRespuesta(languages: String): Noticias? {
        val llamada: NoticiasAPIService =
            RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
        val resultado: Call<Noticias> = llamada.obtenerNoticias(languages)
        val p: Noticias? = resultado.execute().body()

        return p
    }

}