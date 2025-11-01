package cl.lte.ae4_abpro

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

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

        // 4. Configurar el LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 5. Crear una instancia de nuestro ProductAdapter
        val adapter = ProductAdapter(productList)

        // 6. Asignar el adaptador al RecyclerView
        recyclerView.adapter = adapter

        // 7. Obtener la referencia a la BottomNavigationView
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // 8. Configurar un listener para manejar los clics en los items de la navegación
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                // Si se presiona el item "Productos"
                R.id.nav_products -> {
                    // Simulación de interacción: Mostrar un mensaje
                    Toast.makeText(this, "Mostrando Productos", Toast.LENGTH_SHORT).show()
                    // Devolver true para indicar que el evento ha sido manejado
                    true
                }
                // Si se presiona el item "Perfil"
                R.id.nav_profile -> {
                    // Simulación de interacción: Mostrar un mensaje
                    Toast.makeText(this, "Abriendo Perfil", Toast.LENGTH_SHORT).show()
                    true
                }
                // Si no es ninguno de los anteriores
                else -> false
            }
        }
    }
}
