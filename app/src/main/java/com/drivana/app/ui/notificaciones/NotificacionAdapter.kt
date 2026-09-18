package com.drivana.app.ui.notificaciones

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drivana.app.databinding.ItemNotificacionBinding

class NotificacionAdapter(private val items: List<Notificacion>) :
    RecyclerView.Adapter<NotificacionAdapter.NotifViewHolder>() {

    inner class NotifViewHolder(val binding: ItemNotificacionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifViewHolder {
        val binding = ItemNotificacionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotifViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotifViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvTitulo.text = item.titulo
        holder.binding.tvDescripcion.text = item.descripcion
        holder.binding.tvDetalle.text = item.detalle
    }

    override fun getItemCount(): Int = items.size
}
