package com.example.thais.demowebservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.thais.demowebservice.R.id.edit_id_demo
import com.example.thais.demowebservice.entidades.Producto
import kotlinx.android.synthetic.main.activity_demo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        val galaxyService = ProductoService.create()
        val respuestaCallback = galaxyService.obtenerProductos()

        respuestaCallback.enqueue(object: Callback<ArrayList<Producto>> {
            override fun onResponse(call: Call<ArrayList<Producto>>?, response: Response<ArrayList<Producto>>?) {
                val listaProductos = response?.body()
                Log.d("lista",""+listaProductos)
                Toast.makeText(this@DemoActivity,"lista productos cargada", Toast.LENGTH_LONG).show()
                edit_listademo.text = listaProductos.toString()
            }
            override fun onFailure(call: Call<ArrayList<Producto>>?, t: Throwable?) {
                Toast.makeText(this@DemoActivity,"errorrr", Toast.LENGTH_LONG).show()

            }
        })

        btn_registrardemo.setOnClickListener {
            val p = Producto(10,"phone hawe", 1001.00, 12, 12, "nuevo phone G8")
            val mandardatos = galaxyService.registrar(p)

            mandardatos.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    Toast.makeText(this@DemoActivity, "producto registrado ${response.code()}", Toast.LENGTH_LONG).show()

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(this@DemoActivity, "producto no registrado", Toast.LENGTH_LONG).show()
                    Log.d("errorregistar",""+t.toString())
                }
            })
        }
            button_buscar.setOnClickListener {




                val buscarProducto = galaxyService.obtenerProductoSegunId(edit_id_demo.text.toString().toInt())
                buscarProducto.enqueue(object : Callback<Producto> {
                    override fun onResponse(call: Call<Producto>?, response: Response<Producto>?) {
                        val producto = response?.body()
                        text_nombre_demo.text = producto?.nombre
                        text_precio_demo.text = producto?.precio.toString()

                    }

                    override fun onFailure(call: Call<Producto>?, t: Throwable?) {

                    }
                })
            }


                button_eliminar.setOnClickListener{

                    val eliminarProducto = galaxyService.eliminar(5)

                    eliminarProducto.enqueue(object :Callback<Producto>{
                        override fun onResponse(call: Call<Producto>?, response: Response<Producto>?) {
                            Toast.makeText(this@DemoActivity," producto eliminado", Toast.LENGTH_LONG).show()
                        }

                        override fun onFailure(call: Call<Producto>?, t: Throwable?) {

                        }
                    })

                }



    }
}
