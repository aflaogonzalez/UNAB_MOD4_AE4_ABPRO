package cl.lte.ae4_abpro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Encontrar la Toolbar que agregamos en el layout activity_main.xml
        val toolbar: Toolbar = findViewById(R.id.toolbar)

        // 2. Establecer la Toolbar como la ActionBar para esta Activity.
        //    Esto nos permite personalizarla y responder a sus eventos.
        setSupportActionBar(toolbar)
    }
}
