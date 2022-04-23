package com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.recycler

import android.app.Application
import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.R
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.repository.modelo.retrofit.Data
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.view.DetalleNoticia
import com.heltonbustos.viewmodelnoticiasapimvvmrecyclerview.view.MainActivity


class AdaptadorRecycler(var context: Context,
                        var listDatos: List<Data>,
                        var app: AppCompatActivity) :
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

        holder.itemView.setOnClickListener {
            //var detalle = Gson().toJson(listDatos[holder.layoutPosition])
            var detalle = listDatos[holder.layoutPosition].title

            Toast.makeText(context,
                detalle,
                Toast.LENGTH_SHORT)
                .show()

            //val intent = Intent(app, DetalleNoticia::class.java)
            //context.startActivity(intent)
        }
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