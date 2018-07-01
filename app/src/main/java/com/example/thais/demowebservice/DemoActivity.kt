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

        respuestaCallback.enqueue(object: Callback<ArrayList<Producto>>{

            override fun onResponse(call: Call<ArrayList<Producto>>?, response: Response<ArrayList<Producto>>?) {

                val listaProductos = response?.body()

                Log.d("listausuarios",""+listaProductos)
                edit_listademo.text = listaProductos.toString()


            }

            override fun onFailure(call: Call<ArrayList<Producto>>?, t: Throwable?) {

                Toast.makeText(this@DemoActivity,"errorrr",Toast.LENGTH_LONG).show()

            }
        })


    }
}
