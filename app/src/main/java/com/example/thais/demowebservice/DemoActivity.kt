package com.example.thais.demowebservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

        btn_registrardemo?.setOnClickListener {
            val p = Producto(11, "phone hawei", 1000.00, 10, 10, "nuevo phone G8")
            val mandardatos = galaxyService.registrar(p)
            mandardatos.enqueue(object : Callback<Producto> {
                override fun onResponse(call: Call<Producto>?, response: Response<Producto>?) {
                    val respuesta = response?.body()
                    Toast.makeText(this@DemoActivity, "producto registrado", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<Producto>?, t: Throwable?) {

                }
            })

            button_buscar.setOnClickListener{
                val x=edit_id_demo.toString()
                val y= x.toInt()


                val buscarProducto = galaxyService.obtenerProductoSegunId(y)
                buscarProducto.enqueue(object :Callback<Producto>{
                    override fun onResponse(call: Call<Producto>?, response: Response<Producto>?) {
                     val producto = response?.body()
                        text_nombre_demo.text = producto?.nombre
                        text_precio_demo.text = producto?.precio.toString()

                    }
                    override fun onFailure(call: Call<Producto>?, t: Throwable?) {

                    }
                })


                button_eliminar.setOnClickListener{

                    val a=edit_eliminar.toString()
                    val b= a.toInt()
                    val eliminarProducto = galaxyService.eliminar(b)

                    eliminarProducto.enqueue(object :Callback<Producto>{
                        override fun onResponse(call: Call<Producto>?, response: Response<Producto>?) {
                            Toast.makeText(this@DemoActivity," producto eliminado", Toast.LENGTH_LONG).show()
                        }

                        override fun onFailure(call: Call<Producto>?, t: Throwable?) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }
                    })

                }

            }
        }
    }
}
