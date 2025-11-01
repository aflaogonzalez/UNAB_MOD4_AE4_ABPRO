package cl.lte.ae4_abpro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import cl.lte.ae4_abpro.databinding.ActivityMainBinding

/**
 * Actividad principal que aloja la navegación por fragmentos.
 * Mejorada con View Binding y estrategia de navegación show/hide para preservar el estado.
 */
class MainActivity : AppCompatActivity() {

    // Mejora: Usar View Binding en la Activity.
    private lateinit var binding: ActivityMainBinding

    // Instancias de los fragmentos.
    private val productsFragment = ProductsFragment()
    private val profileFragment = ProfileFragment()

    // Referencia al fragmento actualmente visible.
    private var activeFragment: Fragment = productsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Inflar el layout usando View Binding.
        binding = ActivityMainBinding.inflate(layoutInflater)
        // 2. Establecer la vista de contenido a la raíz del binding.
        setContentView(binding.root)

        // 3. Configurar la Toolbar.
        setSupportActionBar(binding.toolbar)

        // 4. Mejora: Configurar los fragmentos solo la primera vez.
        //    Esto evita que se vuelvan a crear en cambios de configuración (ej: rotar pantalla).
        if (savedInstanceState == null) {
            // Se añaden ambos fragmentos. Se oculta el de perfil y se muestra el de productos.
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, profileFragment, "2").hide(profileFragment)
                .add(R.id.fragment_container, productsFragment, "1")
                .commit()
            supportActionBar?.title = "Productos" // Poner título inicial
        }

        // 5. Configurar el listener de la BottomNavigationView.
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_products -> {
                    // Mostrar el fragmento de productos.
                    showFragment(productsFragment, "Productos")
                    true
                }
                R.id.nav_profile -> {
                    // Mostrar el fragmento de perfil.
                    showFragment(profileFragment, "Perfil")
                    true
                }
                else -> false
            }
        }
    }

    /**
     * Función de ayuda para mostrar un fragmento y ocultar el que estaba activo.
     * @param fragment El fragmento que se quiere mostrar.
     * @param title    El título para la ActionBar.
     */
    private fun showFragment(fragment: Fragment, title: String) {
        // Solo actuar si el fragmento a mostrar es diferente del que ya está activo.
        if (fragment != activeFragment) {
            supportFragmentManager.beginTransaction()
                .hide(activeFragment) // Ocultar el fragmento actual.
                .show(fragment)      // Mostrar el nuevo fragmento.
                .commit()
            activeFragment = fragment // Actualizar la referencia al fragmento activo.
            supportActionBar?.title = title // Actualizar el título.
        }
    }
}
