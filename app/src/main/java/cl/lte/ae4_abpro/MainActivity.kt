package cl.lte.ae4_abpro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val productsFragment = ProductsFragment()
    private val profileFragment = ProfileFragment()

    // Mejora: Guardar una referencia al fragmento que está activo actualmente.
    // Lo inicializamos con el fragmento de productos, que es el primero que se muestra.
    private var activeFragment: Fragment = productsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Configurar la Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 2. Configurar el listener de la BottomNavigationView
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_products -> {
                    // Mejora: Solo cambiar de fragmento si no es el que ya está activo.
                    if (activeFragment != productsFragment) {
                        replaceFragment(productsFragment, "Productos")
                    }
                    true // Indicar que el evento fue manejado
                }
                R.id.nav_profile -> {
                    // Mejora: Solo cambiar de fragmento si no es el que ya está activo.
                    if (activeFragment != profileFragment) {
                        replaceFragment(profileFragment, "Perfil")
                    }
                    true // Indicar que el evento fue manejado
                }
                else -> false
            }
        }

        // 3. Cargar el fragmento inicial solo si la app se inicia por primera vez.
        //    (savedInstanceState es nulo al inicio).
        if (savedInstanceState == null) {
            replaceFragment(productsFragment, "Productos")
        }
    }

    /**
     * Función de ayuda mejorada para reemplazar el fragmento actual y actualizar el título.
     * @param fragment El nuevo fragmento a mostrar.
     * @param title    El título que se mostrará en la ActionBar.
     */
    private fun replaceFragment(fragment: Fragment, title: String) {
        // Actualizar la referencia al fragmento activo.
        activeFragment = fragment

        // Iniciar la transacción para reemplazar el fragmento.
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

        // Mejora: Actualizar el título en la ActionBar.
        supportActionBar?.title = title
    }
}
