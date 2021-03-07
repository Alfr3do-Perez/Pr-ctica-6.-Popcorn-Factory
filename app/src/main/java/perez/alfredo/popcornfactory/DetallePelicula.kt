package perez.alfredo.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras;

        if(bundle != null){
            pelicula_imagen.setImageResource(bundle.getInt("header"));
            pelicula_nombre.setText(bundle.getString("titulo"));
            pelicula_descripcion.setText(bundle.getString("sinopsis"));
        }
    }
}