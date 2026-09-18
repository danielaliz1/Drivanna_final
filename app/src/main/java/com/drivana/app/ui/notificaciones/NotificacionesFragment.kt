package com.drivana.app.ui.notificaciones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.drivana.app.databinding.FragmentNotificacionesBinding

class NotificacionesFragment : Fragment() {

    private var _binding: FragmentNotificacionesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificacionesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Datos de ejemplo basados en el mockup; en una siguiente iteración vendrán de Room.
        val notificaciones = listOf(
            Notificacion("Mantenimiento", "Cambio de aceite", "En 5 días"),
            Notificacion("Revisión", "Revisión programada", "En 19 días"),
            Notificacion("Mantenimiento Frenos", "Chequeo de frenos", "En 17 días"),
            Notificacion("Mantenimiento Llantas", "Chequeo de frenos", "En 3 meses")
        )

        binding.rvNotificaciones.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotificaciones.adapter = NotificacionAdapter(notificaciones)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
