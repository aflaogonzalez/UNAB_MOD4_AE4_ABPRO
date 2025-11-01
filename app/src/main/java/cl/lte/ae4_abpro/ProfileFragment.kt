package cl.lte.ae4_abpro

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import cl.lte.ae4_abpro.databinding.FragmentProfileBinding

/**
 * Fragment que muestra la pantalla de perfil del usuario,
 * mejorado con View Binding.
 */
class ProfileFragment : Fragment() {

    // Mejora: Usar View Binding para evitar findViewById y manejar el ciclo de vida de la vista.
    private var _binding: FragmentProfileBinding? = null
    // Esta propiedad solo es válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 1. Inflar el layout y crear el objeto de binding.
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        // 2. Devolver la vista raíz del binding.
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 3. Configurar el listener para el botón de guardar usando el objeto de binding.
        binding.buttonSave.setOnClickListener {
            // Mostrar el indicador de progreso.
            binding.progressIndicator.isVisible = true

            // Simular una operación de red que dura 2 segundos.
            Handler(Looper.getMainLooper()).postDelayed({
                // Ocultar el indicador de progreso después del retraso.
                // Es importante comprobar que el binding todavía existe,
                // por si el usuario navega fuera del fragmento antes de que termine el retraso.
                _binding?.progressIndicator?.isVisible = false
            }, 2000) // 2000 milisegundos = 2 segundos
        }
    }

    /**
     * Mejora: Limpiar la referencia al binding para evitar memory leaks.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
