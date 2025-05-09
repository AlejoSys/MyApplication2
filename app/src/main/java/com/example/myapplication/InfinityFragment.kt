package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class InfinityFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_infinity, container, false)
        
        // Configurar el botón de inicio de sesión
        val btnInicioSesion = view.findViewById<android.widget.Button>(R.id.button2)
        btnInicioSesion.setOnClickListener {
            // Navegar al fragmento de catálogo
            val catalogoFragment = CatalogoFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, catalogoFragment)
                .addToBackStack(null)
                .commit()
        }
        
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InfinityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
