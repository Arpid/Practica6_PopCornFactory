package encinas.manuel.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class detalle_pelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)


        val bundle = intent.extras
        var ns  = 0;
        var id = 1;
        var title= ""

        if(bundle != null)
        {
            ns = bundle.getInt("numberseats")
            title = bundle.getString("titulo")!!

            iv_pelicula_imagen.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("nombre"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
            seatleft.setText("$ns seats available")
            id = bundle.getInt("pos")

        }



            buyTickets.setOnClickListener {
                var intent: Intent = Intent(this,SeatsSelection::class.java)
                intent.putExtra("id", id)
                intent.putExtra("name",title)

                this.startActivity(intent)
            }
        }
    }
