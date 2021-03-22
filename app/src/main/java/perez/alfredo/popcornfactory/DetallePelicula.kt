package perez.alfredo.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_comprar_boleto.*
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*
import kotlinx.android.synthetic.main.activity_detalle_pelicula.pelicula_imagen
import kotlinx.android.synthetic.main.activity_detalle_pelicula.pelicula_nombre

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras;
        var numeroAsientos =0;
        var pelicula_pos = -1;
        var titulo = "";
        var header = -1;
        var arregloClientes:ArrayList<Cliente> = ArrayList();

        if(bundle != null){
            numeroAsientos = bundle.getInt("numeroAsientos");
            titulo = bundle.getString("titulo")!!;
            header = bundle.getInt("header");
            arregloClientes = bundle.getParcelableArrayList<Cliente>("arregloAsientos") as ArrayList<Cliente>;

            pelicula_imagen.setImageResource(header);
            pelicula_nombre.setText(titulo);
            pelicula_descripcion.setText(bundle.getString("sinopsis"));
            seatsLeft.setText("$numeroAsientos seats available");
            pelicula_pos = bundle.getInt("posicion");
        }

        if(numeroAsientos == 0){
            buyTickets.isEnabled = false;
        }else{
            buyTickets.setOnClickListener {
                val intent:Intent = Intent(this, SeleccionDeAsientos::class.java);
                intent.putExtra("pelicula_pos", pelicula_pos);
                intent.putExtra("titulo", titulo);
                intent.putExtra("header", header);
                intent.putParcelableArrayListExtra("arregloClientes", arregloClientes);

                startActivity(intent);
            }
        }
    }

}