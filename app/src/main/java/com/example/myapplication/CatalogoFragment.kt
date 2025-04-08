package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CatalogoFragment : Fragment() {

        private lateinit var recyclerView: RecyclerView
        private lateinit var headerRecyclerView: RecyclerView
        private lateinit var productAdapter: ProductAdapter
        private lateinit var headerAdapter: HeaderAdapter
        private val productList = listOf(
            Product("Mouse Gamer Vertical Inalámbrico", 60000, R.drawable.mouse1),
            Product("Logitech G305 Light Speed Inalámbrico", 80000, R.drawable.mouse2),
            Product("Logitech G502 Mouse Gamer Inalámbrico", 100000, R.drawable.mouse3),
            Product("Mouse Gamer RGB Óptico USB", 40000, R.drawable.mouse4)
        )

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_catalogo, container, false)

            // Configurar el RecyclerView de productos
            recyclerView = view.findViewById(R.id.recyclerViewProducts)
            recyclerView.layoutManager = GridLayoutManager(context, 2)
            productAdapter = ProductAdapter(productList)
            recyclerView.adapter = productAdapter

            // Configurar el RecyclerView del encabezado
            headerRecyclerView = view.findViewById(R.id.recyclerViewHeader)
            headerRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            headerAdapter = HeaderAdapter()
            headerRecyclerView.adapter = headerAdapter

            return view
        }
    }