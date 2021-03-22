package perez.alfredo.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_comprar_boleto.*
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*
import kotlinx.android.synthetic.main.activity_detalle_pelicula.pelicula_imagen
import kotlinx.android.synthetic.main.activity_detalle_pelicula.pelicula_nombre

class ComprarBoletoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprar_boleto)

        val bundle = intent.extras;
        var pelicula_pos = -1;
        var titulo = "";
        var header = -1;
        var asientoID = -1;
        var arregloClientes:ArrayList<Cliente> = ArrayList();

        if(bundle != null){
            pelicula_pos = bundle.getInt("pelicula_pos")
            titulo = bundle.getString("titulo")!!;
            header = bundle.getInt("header");
            asientoID = bundle.getInt("asiento_id")
            arregloClientes = bundle.getParcelableArrayList<Cliente>("arregloClientes") as ArrayList<Cliente>;

            pelicula_imagen.setImageResource(header);
            pelicula_nombre.setText(titulo);
            numero_asiento.setText("Seat: ${bundle.getString("asiento")}")
        }

        boton_buyTicket.setOnClickListener {

            if((cliente_nombre.text.toString() != "") && (grupo_metodoPago.checkedRadioButtonId !=-1)){
                Toast.makeText(this, "Enjoy the movie!", Toast.LENGTH_LONG).show();

                var metodoPago:RadioButton = findViewById(grupo_metodoPago.checkedRadioButtonId);
                var cliente:Cliente = Cliente(cliente_nombre.text.toString(), metodoPago.text.toString() ,asientoID);
                arregloClientes.add(cliente);

                var intent:Intent = Intent(this, CatalagoPeliculasActivity::class.java);
                intent.putExtra("pelicula_pos", pelicula_pos);
                intent.putParcelableArrayListExtra("arregloClientes",arregloClientes);
                startActivity(intent);
            }else{Toast.makeText(this, "You need to fill all the fields!", Toast.LENGTH_SHORT).show();}
        }
    }
}