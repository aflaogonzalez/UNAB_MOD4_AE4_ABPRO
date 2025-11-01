package cl.lte.ae4_abpro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cl.lte.ae4_abpro.databinding.FragmentProductsBinding

/**
 * Fragment que muestra la lista de productos del supermercado,
 * mejorado con View Binding.
 */
class ProductsFragment : Fragment() {

    // Mejora: Usar View Binding para evitar findViewById y manejar el ciclo de vida de la vista.
    private var _binding: FragmentProductsBinding? = null
    // Esta propiedad solo es válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 1. Inflar el layout y crear el objeto de binding.
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        // 2. Devolver la vista raíz del binding.
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 3. Crear datos de ejemplo para la lista de productos.
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

        // 4. Configurar el RecyclerView usando el objeto de binding.
        //    Es más seguro y limpio.
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewProducts.adapter = ProductAdapter(productList)
    }

    /**
     * Mejora: Limpiar la referencia al binding para evitar memory leaks.
     * Este método se llama cuando la vista del fragmento se va a destruir.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
