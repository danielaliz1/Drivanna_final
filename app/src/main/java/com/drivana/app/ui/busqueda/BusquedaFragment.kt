package com.drivana.app.ui.busqueda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.drivana.app.databinding.FragmentBusquedaBinding

class BusquedaFragment : Fragment() {

    private var _binding: FragmentBusquedaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBusquedaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvResultados.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvResultados.adapter = TileAdapter(6)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
