package cl.lte.ae4_abpro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.lte.ae4_abpro.databinding.ItemProductBinding

/**
 * Adaptador para el RecyclerView que muestra la lista de productos,
 * mejorado con View Binding.
 *
 * @param productList La lista de productos a mostrar.
 */
class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    /**
     * ViewHolder que contiene una instancia de ItemProductBinding.
     * Esta clase de binding nos da acceso directo y seguro a todas las vistas del layout.
     */
    inner class ProductViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    /**
     * Se llama cuando RecyclerView necesita un nuevo ViewHolder.
     * Aquí inflamos el layout usando la clase de binding generada.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // 1. Inflar el layout y crear el objeto de binding. Es más limpio y seguro.
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // 2. Crear y devolver un ViewHolder con el objeto de binding.
        return ProductViewHolder(binding)
    }

    /**
     * Se llama para mostrar los datos en una posición específica.
     * Aquí vinculamos los datos directamente a través del objeto binding del holder.
     */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        // 1. Obtener el producto actual de la lista.
        val currentProduct = productList[position]

        // 2. Asignar los datos del producto a las vistas a través del binding.
        //    No más findViewById, ahora es holder.binding.idDeLaVista.
        holder.binding.textViewProductName.text = currentProduct.name
        holder.binding.textViewProductPrice.text = currentProduct.price
    }

    /**
     * Devuelve el número total de items en la lista.
     */
    override fun getItemCount() = productList.size
}