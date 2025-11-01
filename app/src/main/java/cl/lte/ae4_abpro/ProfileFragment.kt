package cl.lte.ae4_abpro

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.progressindicator.CircularProgressIndicator

/**
 * Fragment que muestra la pantalla de perfil del usuario.
 * Contiene campos para editar el perfil y un botón para guardar los cambios.
 */
class ProfileFragment : Fragment() {

    /**
     * Se llama para crear la vista del fragmento.
     * Aquí se "infla" el layout y se configuran los listeners de los botones.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Obtener referencias a las vistas
        val saveButton: Button = view.findViewById(R.id.button_save)
        val progressIndicator: CircularProgressIndicator = view.findViewById(R.id.progress_indicator)

        // Configurar el listener para el botón de guardar
        saveButton.setOnClickListener {
            // 1. Mostrar el indicador de progreso
            progressIndicator.isVisible = true

            // 2. Simular una operación de red (guardar datos) que dura 2 segundos
            Handler(Looper.getMainLooper()).postDelayed({
                // 3. Ocultar el indicador de progreso después del retraso
                progressIndicator.isVisible = false
            }, 2000) // 2000 milisegundos = 2 segundos
        }

        return view
    }
}
