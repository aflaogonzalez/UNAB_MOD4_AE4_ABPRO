package cl.lte.ae4_abpro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Fragment que muestra la lista de productos del supermercado.
 */
class ProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        // 1. Crear datos de ejemplo para la lista de productos
        val productList = listOf(
            Product("Leche Entera", "$1.200"),
            Product("Pan de Molde", "$2.100"),
            Product("Huevos (docena)", "$3.500"),
            Product("Queso Gauda", "$4.800"),
            Product("Jamón de Pavo", "$3.200"),
            Product("Manzanas (kilo)", "$1.500"),
            Product("Yogurt Natural", "$850"),
            Product("Cereal de Maíz", "$3.990")
        )

        // 2. Obtener la referencia al RecyclerView del layout del fragmento
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_products)

        // 3. Configurar el LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(context)

        // 4. Crear y asignar el adaptador
        recyclerView.adapter = ProductAdapter(productList)

        return view
    }
}
