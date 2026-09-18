package com.drivana.app.ui.cuenta

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.drivana.app.R
import com.drivana.app.data.SessionManager
import com.drivana.app.databinding.FragmentCuentaBinding
import com.drivana.app.ui.entrada.EntradaActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CuentaFragment : Fragment() {

    private var _binding: FragmentCuentaBinding? = null
    private val binding get() = _binding!!
    private var usuario: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuario = arguments?.getString(ARG_USUARIO) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCuentaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSaludo.text = if (usuario.isEmpty()) "Hola !" else "Hola, $usuario !"

        binding.optAyuda.setOnClickListener {
            startActivity(Intent(requireContext(), AyudaActivity::class.java))
        }
        binding.optPrivacidad.setOnClickListener {
            startActivity(Intent(requireContext(), PrivacidadActivity::class.java))
        }
        binding.optConfiguracion.setOnClickListener {
            startActivity(Intent(requireContext(), ConfiguracionActivity::class.java))
        }
        binding.optCerrarSesion.setOnClickListener { mostrarDialogoCerrarSesion() }
    }

    private fun mostrarDialogoCerrarSesion() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.confirmar_cerrar_sesion)
            .setPositiveButton(R.string.cerrar_sesion) { _, _ -> cerrarSesion() }
            .setNegativeButton(R.string.cancelar, null)
            .show()
    }

    private fun cerrarSesion() {
        SessionManager(requireContext()).cerrarSesion()
        val intent = Intent(requireContext(), EntradaActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_USUARIO = "arg_usuario"

        fun newInstance(usuario: String) = CuentaFragment().apply {
            arguments = Bundle().apply { putString(ARG_USUARIO, usuario) }
        }
    }
}
