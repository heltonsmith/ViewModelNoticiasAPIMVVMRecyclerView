package com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.recycler

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.R
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.retrofit.Data
import com.squareup.picasso.Picasso

class AdaptadorRecycler(var context: Context,
                        var listDatos: List<Data>) :
    RecyclerView.Adapter<AdaptadorRecycler.ViewHolderDatos>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDatos {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_recycler, null, false)
        return ViewHolderDatos(view)
    }

    override fun onBindViewHolder(holder: ViewHolderDatos, position: Int) {
        holder.itemView.animation =
            AnimationUtils.loadAnimation(context, R.anim.fade_transition)
        holder.titulo.text = Html.fromHtml(listDatos[position].title)
        holder.descripcion.text = Html.fromHtml(listDatos[position].description)

        Glide.with(context)
            .load(listDatos[position].image)
            .error(R.drawable.sinimagen)
            .into(holder.imagen);
    }

    override fun getItemCount(): Int {
        return listDatos.size
    }

    inner class ViewHolderDatos(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        var imagen: ImageView
        var titulo: TextView
        var descripcion: TextView

        init {
            imagen = itemView.findViewById(R.id.myImagen)
            titulo = itemView.findViewById(R.id.myTitulo)
            descripcion = itemView.findViewById(R.id.myDes)
        }


    }


}