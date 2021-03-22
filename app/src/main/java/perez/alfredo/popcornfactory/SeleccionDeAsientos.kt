package perez.alfredo.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_seleccion_de_asientos.*

class SeleccionDeAsientos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccion_de_asientos)


        val row1:RadioGroup = findViewById(R.id.row1) as RadioGroup;
        val row2:RadioGroup = findViewById(R.id.row2) as RadioGroup;
        val row3:RadioGroup = findViewById(R.id.row3) as RadioGroup;
        val row4:RadioGroup = findViewById(R.id.row4) as RadioGroup;
        var radioButton:RadioButton;
        val titulo:TextView = findViewById(R.id.titulo_pelicula) as TextView;
        val bundle = intent.extras;
        var pelicula_pos = -1;
        var header = -1;
        var arregloAsientos:ArrayList<Cliente> = ArrayList()

        if(bundle != null){
            titulo.setText(bundle.getString("titulo"));
            pelicula_pos = bundle.getInt("pelicula_pos");
            header = bundle.getInt("header");
            arregloAsientos = bundle.getParcelableArrayList<Cliente>("arregloClientes") as ArrayList<Cliente>;
        }
        comprobarAsientosDisponibles(arregloAsientos);

        val boton_confirm:Button = findViewById(R.id.boton_confirm) as Button;

        boton_confirm.setOnClickListener {

            var asiento = -1;

            var intent:Intent = Intent(this, ComprarBoletoActivity::class.java);
            intent.putExtra("pelicula_pos", pelicula_pos);
            intent.putExtra("header", header);
            intent.putExtra("titulo", titulo.getText());
            intent.putParcelableArrayListExtra("arregloClientes", arregloAsientos);

            if (row1.getCheckedRadioButtonId() != -1){
                asiento = row1.getCheckedRadioButtonId();
                radioButton = findViewById(asiento);
                intent.putExtra("asiento", radioButton.text);
                intent.putExtra("asiento_id", radioButton.id);
                startActivity(intent);
            }
            else if (row2.getCheckedRadioButtonId() != -1){
                asiento = row2.getCheckedRadioButtonId();
                radioButton = findViewById(asiento);
                intent.putExtra("asiento", radioButton.getText());
                intent.putExtra("asiento_id", radioButton.id);
                startActivity(intent);
            }
            else if (row3.getCheckedRadioButtonId() != -1){
                asiento = row3.getCheckedRadioButtonId();
                radioButton = findViewById(asiento);
                intent.putExtra("asiento", radioButton.getText());
                intent.putExtra("asiento_id", radioButton.id);
                startActivity(intent);
            }
            else if (row4.getCheckedRadioButtonId() != -1){
                asiento = row4.getCheckedRadioButtonId();
                radioButton = findViewById(asiento);
                intent.putExtra("asiento", radioButton.getText());
                intent.putExtra("asiento_id", radioButton.id);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "You need to select your seat!", Toast.LENGTH_SHORT).show();
            }

        }

        row1.setOnCheckedChangeListener{group, checkedId ->
            if(checkedId > -1){
                row2.clearCheck();
                row3.clearCheck();
                row4.clearCheck();

                row1.check(checkedId);
            }
        }
        row2.setOnCheckedChangeListener{group, checkedId ->
            if(checkedId > -1){
                row1.clearCheck();
                row3.clearCheck();
                row4.clearCheck();

                row2.check(checkedId);
            }
        }
        row3.setOnCheckedChangeListener{group, checkedId ->
            if(checkedId > -1){
                row1.clearCheck();
                row2.clearCheck();
                row4.clearCheck();

                row3.check(checkedId);
            }
        }
        row4.setOnCheckedChangeListener{group, checkedId ->
            if(checkedId > -1){
                row1.clearCheck();
                row2.clearCheck();
                row3.clearCheck();

                row4.check(checkedId);
            }
        }


    }
    fun comprobarAsientosDisponibles(arregloClientes:ArrayList<Cliente>){
        for (cont:Int in 1..arregloClientes.size){
            var radioButton2:RadioButton = findViewById(arregloClientes[cont-1].asiento);
            radioButton2.isEnabled = false;
        }
    }
}