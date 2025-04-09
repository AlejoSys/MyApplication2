package com.example.myapplication
import kotlin.Triple
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import android.widget.LinearLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OfertasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OfertasFragment : Fragment(R.layout.fragment_ofertas) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contenedor = view.findViewById<LinearLayout>(R.id.contenedorOfertas)

        val ofertas = listOf(
            Triple("Descuento del 20%", "Solo por hoy", R.drawable.mouse1),
            Triple("2x1 en productos", "Válido hasta el domingo", R.drawable.mouse1),
            Triple("Entrega gratis", "En compras mayores a $50.000", R.drawable.mouse1)
        )

        for ((titulo, subtitulo, imagenRes) in ofertas) {
            val tarjeta = layoutInflater.inflate(R.layout.item_oferta, contenedor, false)

            val tituloView = tarjeta.findViewById<TextView>(R.id.tituloOferta)
            val subtituloView = tarjeta.findViewById<TextView>(R.id.subtituloOferta)
            val imagenView = tarjeta.findViewById<ImageView>(R.id.imagenOferta)

            tituloView.text = titulo
            subtituloView.text = subtitulo
            imagenView.setImageResource(imagenRes)

            contenedor.addView(tarjeta)

            val valorSubtotal = view.findViewById<TextView>(R.id.valorSubtotal)
            valorSubtotal.text = "$60,000 COP" // O el valor que tú calcules

        }
    }
}
