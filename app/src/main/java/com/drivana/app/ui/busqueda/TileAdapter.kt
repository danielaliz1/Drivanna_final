package com.drivana.app.ui.busqueda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drivana.app.databinding.ItemTileBinding

/**
 * Adaptador de relleno visual (placeholders) para la cuadrícula de resultados,
 * tal como se ve en el mockup de "Búsqueda".
 */
class TileAdapter(private val cantidad: Int) : RecyclerView.Adapter<TileAdapter.TileViewHolder>() {

    inner class TileViewHolder(val binding: ItemTileBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TileViewHolder {
        val binding = ItemTileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TileViewHolder, position: Int) {
        // Placeholder visual; se conectará a datos reales de vehículos/servicios más adelante.
    }

    override fun getItemCount(): Int = cantidad
}
