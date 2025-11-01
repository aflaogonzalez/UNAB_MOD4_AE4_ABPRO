package cl.lte.ae4_abpro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adaptador para el RecyclerView que muestra la lista de productos.
 *
 * @param productList La lista de productos a mostrar.
 */
class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    /**
     * ViewHolder que contiene las vistas para un solo item de producto.
     * Es como un "contenedor" para los elementos de la interfaz de cada fila.
     */
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.text_view_product_name)
        val priceTextView: TextView = itemView.findViewById(R.id.text_view_product_price)
    }

    /**
     * Se llama cuando RecyclerView necesita un nuevo ViewHolder.
     * Aquí inflamos (creamos) el layout para un item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // 1. Inflar (crear) la vista para un item de producto usando nuestro layout item_product.xml
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        // 2. Crear y devolver un nuevo ViewHolder con la vista del item.
        return ProductViewHolder(itemView)
    }

    /**
     * Se llama para mostrar los datos en una posición específica.
     * Aquí vinculamos los datos del producto con las vistas del ViewHolder.
     */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        // 1. Obtener el producto actual de nuestra lista según la posición.
        val currentProduct = productList[position]

        // 2. Asignar los datos del producto a los TextViews del ViewHolder.
        holder.nameTextView.text = currentProduct.name
        holder.priceTextView.text = currentProduct.price
    }

    /**
     * Devuelve el número total de items en la lista.
     * RecyclerView necesita saber cuántos elementos hay para poder dibujarlos.
     */
    override fun getItemCount() = productList.size
}