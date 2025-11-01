package cl.lte.ae4_abpro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Configurar la Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 2. Crear datos de ejemplo para la lista de productos
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

        // 3. Obtener la referencia al RecyclerView del layout
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_products)

        // 4. Configurar el LayoutManager.
        //    Esto le dice al RecyclerView cómo posicionar los items.
        //    LinearLayoutManager los muestra en una lista vertical.
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 5. Crear una instancia de nuestro ProductAdapter
        val adapter = ProductAdapter(productList)

        // 6. Asignar el adaptador al RecyclerView.
        //    Esto conecta nuestros datos y el diseño del item con la lista.
        recyclerView.adapter = adapter
    }
}
