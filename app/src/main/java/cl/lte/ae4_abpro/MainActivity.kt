package cl.lte.ae4_abpro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // 1. Crear instancias de nuestros fragmentos para reutilizarlas
    private val productsFragment = ProductsFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. Configurar la Toolbar (esto no cambia)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 3. Cargar el fragmento inicial (la lista de productos) solo la primera vez
        if (savedInstanceState == null) {
            replaceFragment(productsFragment)
        }

        // 4. Configurar el listener de la BottomNavigationView para cambiar de fragmento
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                // Si se presiona "Productos", mostrar el ProductsFragment
                R.id.nav_products -> {
                    replaceFragment(productsFragment)
                    true // Indicar que el evento fue manejado
                }
                // Si se presiona "Perfil", mostrar el ProfileFragment
                R.id.nav_profile -> {
                    replaceFragment(profileFragment)
                    true // Indicar que el evento fue manejado
                }
                else -> false
            }
        }
    }

    /**
     * Función de ayuda para reemplazar el fragmento actual en el contenedor.
     * @param fragment El nuevo fragmento a mostrar.
     */
    private fun replaceFragment(fragment: Fragment) {
        // Iniciar una transacción para modificar los fragmentos
        supportFragmentManager.beginTransaction()
            // Reemplazar el contenido del FrameLayout 'fragment_container' por el nuevo fragmento
            .replace(R.id.fragment_container, fragment)
            // Aplicar los cambios
            .commit()
    }
}
